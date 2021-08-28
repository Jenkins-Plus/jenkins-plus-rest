package plus.jenkins.rest.config;

import com.cdancy.jenkins.rest.handlers.JenkinsErrorHandler;
import org.jclouds.http.HttpErrorHandler;
import org.jclouds.http.annotation.ClientError;
import org.jclouds.http.annotation.Redirection;
import org.jclouds.http.annotation.ServerError;
import org.jclouds.rest.ConfiguresHttpApi;
import org.jclouds.rest.config.HttpApiModule;
import plus.jenkins.rest.BlueOceanApi;

/**
 * description
 *
 * @author pengzhenchen 2021/08/02 5:15 下午
 */
@ConfiguresHttpApi
public class BlueOceanHttpApiModule extends HttpApiModule<BlueOceanApi> {

    @Override
    protected void bindErrorHandlers() {
        bind(HttpErrorHandler.class).annotatedWith(Redirection.class).to(JenkinsErrorHandler.class);
        bind(HttpErrorHandler.class).annotatedWith(ClientError.class).to(JenkinsErrorHandler.class);
        bind(HttpErrorHandler.class).annotatedWith(ServerError.class).to(JenkinsErrorHandler.class);
    }
}