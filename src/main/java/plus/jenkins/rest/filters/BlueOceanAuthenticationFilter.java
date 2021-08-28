package plus.jenkins.rest.filters;

import com.cdancy.jenkins.rest.JenkinsAuthentication;
import com.cdancy.jenkins.rest.auth.AuthenticationType;
import com.cdancy.jenkins.rest.domain.crumb.Crumb;
import com.google.common.net.HttpHeaders;
import org.jclouds.http.HttpException;
import org.jclouds.http.HttpRequest;
import org.jclouds.http.HttpRequestFilter;
import org.jclouds.rest.ResourceNotFoundException;
import plus.jenkins.rest.BlueOceanApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 11:01 上午
 */
@Singleton
public class BlueOceanAuthenticationFilter implements HttpRequestFilter {
    private final JenkinsAuthentication creds;
    private final BlueOceanApi blueOceanApi;

    private volatile Pair<Crumb, Boolean> crumbPair = null;
    private static final String CRUMB_HEADER = "Jenkins-Crumb";

    @Inject
    BlueOceanAuthenticationFilter(final JenkinsAuthentication creds, final BlueOceanApi blueOceanApi) {
        this.creds = creds;
        this.blueOceanApi = blueOceanApi;
    }

    @Override
    public HttpRequest filter(final HttpRequest request) throws HttpException {
        if (creds.authType() == AuthenticationType.Anonymous) {
            return request;
        } else {
            final String authHeader = creds.authType() + " " + creds.authValue();
            final HttpRequest.Builder<? extends HttpRequest.Builder<?>> builder = request.toBuilder();
            builder.addHeader(HttpHeaders.AUTHORIZATION, authHeader);
            // whether to add crumb header or not
            final Pair<Crumb, Boolean> localCrumb = getCrumb();
            if (localCrumb.getKey().value() != null) {
                builder.addHeader(CRUMB_HEADER, localCrumb.getKey().value());
                Optional.ofNullable(localCrumb.getKey().sessionIdCookie())
                        .ifPresent(sessionId -> builder.addHeader(HttpHeaders.COOKIE, sessionId));
            } else {
                if (!localCrumb.getValue()) {
                    throw new RuntimeException("Unexpected exception being thrown: error=" + localCrumb.getKey().errors().get(0));
                }
            }
            return builder.build();
        }
    }

    private Pair<Crumb, Boolean> getCrumb() {
        Pair<Crumb, Boolean> crumbValueInit = this.crumbPair;
        if (crumbValueInit == null) {
            synchronized(this) {
                crumbValueInit = this.crumbPair;
                if (crumbValueInit == null) {
                    final Crumb crumb = blueOceanApi.crumbIssuerApi().crumb();
                    final Boolean isRnfe = isRnfe(crumb);
                    this.crumbPair = crumbValueInit = new Pair<>(crumb, isRnfe);
                }
            }
        }
        return crumbValueInit;
    }

    private boolean isRnfe(Crumb crumb) {
        return crumb.errors().isEmpty() || crumb.errors().get(0).exceptionName().endsWith(ResourceNotFoundException.class.getSimpleName());
    }

    private static class Pair<A, B> {
        private final A a;
        private final B b;
        public Pair(final A a, final B b) {
            this.a = a;
            this.b = b;
        }
        public A getKey() {
            return a;
        }
        public B getValue() {
            return b;
        }
    }
}
