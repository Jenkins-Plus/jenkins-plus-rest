package plus.jenkins.rest;

import com.cdancy.jenkins.rest.*;
import com.cdancy.jenkins.rest.auth.AuthenticationType;
import com.cdancy.jenkins.rest.config.JenkinsAuthenticationModule;
import com.google.common.collect.Lists;
import com.google.inject.Module;
import org.jclouds.ContextBuilder;
import org.jclouds.javax.annotation.Nullable;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * description
 *
 * @author pengzhenchen 2021/08/02 5:15 下午
 */
public class JenkinsPlusClient implements Closeable {

    private final String endPoint;
    private final JenkinsAuthentication credentials;
    private final BlueOceanApi blueOceanApi;
    private final Properties overrides;

    /**
     * Create a JenkinsPlusClient inferring endpoint and authentication from
     * environment and system properties.
     */
    public JenkinsPlusClient() {
        this(null, null, null, null);
    }

    /**
     * Create an JenkinsPlusClient. If any of the passed in variables are null we
     * will query System Properties and Environment Variables, in order, to
     * search for values that may be set in a devops/CI fashion. The only
     * difference is the `overrides` which gets merged, but takes precedence,
     * with those System Properties and Environment Variables found.
     *
     * @param endPoint URL of Jenkins instance.
     * @param authentication authentication used to connect to Jenkins instance.
     * @param overrides jclouds Properties to override defaults when creating a new JenkinsApi.
     * @param modules a list of modules to be passed to the Contextbuilder, e.g. for logging.
     */
    public JenkinsPlusClient(@Nullable final String endPoint,
                             @Nullable final JenkinsAuthentication authentication,
                             @Nullable final Properties overrides,
                             @Nullable final List<Module> modules) {
        this.endPoint = endPoint != null
                ? endPoint
                : JenkinsUtils.inferEndpoint();
        this.credentials = authentication != null
                ? authentication
                : JenkinsUtils.inferAuthentication();
        this.overrides = mergeOverrides(overrides);
        this.blueOceanApi = createApi(this.endPoint, this.credentials, this.overrides, modules);
    }

    private BlueOceanApi createApi(final String endPoint, final JenkinsAuthentication authentication, final Properties overrides, final List<Module> modules) {

        final List<Module> allModules = Lists.newArrayList(new JenkinsAuthenticationModule(authentication));

        if (modules != null) {
            allModules.addAll(modules);
        }

        return ContextBuilder
                .newBuilder(new BlueOceanApiMetadata.Builder().build())
                .endpoint(endPoint)
                .modules(allModules)
                .overrides(overrides)
                .buildApi(BlueOceanApi.class);
    }

    /**
     * Query System Properties and Environment Variables for overrides and merge
     * the potentially passed in overrides with those.
     *
     * @param possibleOverrides Optional passed in overrides.
     * @return Properties object.
     */
    private Properties mergeOverrides(final Properties possibleOverrides) {
        final Properties inferOverrides = JenkinsUtils.inferOverrides();
        if (possibleOverrides != null) {
            inferOverrides.putAll(possibleOverrides);
        }
        return inferOverrides;
    }

    public String endPoint() {
        return this.endPoint;
    }

    @Deprecated
    public String credentials() {
        return this.authValue();
    }

    public Properties overrides() {
        return this.overrides;
    }

    public String authValue() {
        return this.credentials.authValue();
    }

    public AuthenticationType authType() {
        return this.credentials.authType();
    }

    public BlueOceanApi api() {
        return this.blueOceanApi;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void close() throws IOException {
        if (this.api() != null) {
            this.api().close();
        }
    }

    public static class Builder {

        private String endPoint;
        private JenkinsAuthentication.Builder authBuilder;
        private Properties overrides;
        private List<Module> modules = Lists.newArrayList();

        /**
         * Define the base endpoint to connect to.
         *
         * @param endPoint Jenkins base endpoint.
         * @return this Builder.
         */
        public Builder endPoint(final String endPoint) {
            this.endPoint = endPoint;
            return this;
        }

        /**
         * Optional credentials to use for authentication. Must take the form of
         * `username:password` or its base64 encoded version.
         *
         * @param optionallyBase64EncodedCredentials authentication credentials.
         * @return this Builder.
         */
        public Builder credentials(final String optionallyBase64EncodedCredentials) {
            authBuilder = JenkinsAuthentication.builder()
                    .credentials(optionallyBase64EncodedCredentials);
            return this;
        }

        /**
         * Optional token to use for authentication.
         *
         * @param token authentication token.
         * @return this Builder.
         */
        public Builder token(final String token) {
            authBuilder = JenkinsAuthentication.builder()
                    .token(token);
            return this;
        }

        /**
         * Optional jclouds Properties to override. What can be overridden can
         * be found here:
         *
         * <p>https://github.com/jclouds/jclouds/blob/master/core/src/main/java/org/jclouds/Constants.java
         *
         * @param overrides optional jclouds Properties to override.
         * @return this Builder.
         */
        public Builder overrides(final Properties overrides) {
            this.overrides = overrides;
            return this;
        }

        /**
         * Optional List of Module to add. Modules can be added, for logging
         * for example.
         *
         * @param modules optional List of Module to add.
         * @return this Builder.
         */
        public Builder modules(final Module... modules) {
            this.modules.addAll(Arrays.asList(modules));
            return this;
        }

        /**
         * Build an instance of JenkinsPlusClient.
         *
         * @return JenkinsPlusClient
         */
        public JenkinsPlusClient build() {
            // 1.) If user passed in some auth use/build that.
            final JenkinsAuthentication authentication = authBuilder != null
                    ? authBuilder.build()
                    : null;
            return new JenkinsPlusClient(endPoint, authentication, overrides, modules);
        }
    }
}