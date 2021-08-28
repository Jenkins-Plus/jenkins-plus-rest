package plus.jenkins.rest;

import com.google.common.collect.ImmutableSet;
import org.jclouds.apis.ApiMetadata;
import org.jclouds.rest.internal.BaseHttpApiMetadata;
import plus.jenkins.rest.config.BlueOceanHttpApiModule;

import java.net.URI;
import java.util.Properties;

/**
 * description
 *
 * @author pengzhenchen 2021/08/02 5:14 下午
 */
@SuppressWarnings("all")
public class BlueOceanApiMetadata extends BaseHttpApiMetadata<BlueOceanApi> {

    protected BlueOceanApiMetadata(Builder builder) {
        super(builder);
    }

    @Override
    public Builder toBuilder() {
        return new Builder().fromApiMetadata(this);
    }

    public static Properties defaultProperties() {
        return BaseHttpApiMetadata.defaultProperties();
    }

    public static class Builder extends BaseHttpApiMetadata.Builder<BlueOceanApi, BlueOceanApiMetadata.Builder> {

        protected Builder() {
            super(BlueOceanApi.class);
            id("jenkins-blue-ocean")
                    .name("Jenkins Blue Ocean Rest")
                    .identityName("Optional Username")
                    .credentialName("Optional Password")
                    .defaultIdentity("").defaultCredential("")
                    .documentation(URI.create("http://wiki.jenkins-ci.org/display/JENKINS/Remote+access+API"))
                    .defaultEndpoint("http://127.0.0.1:8080/")
                    .defaultProperties(BlueOceanApiMetadata.defaultProperties())
                    .defaultModules(ImmutableSet.of(BlueOceanHttpApiModule.class));
        }

        @Override
        public BlueOceanApiMetadata build() {
            return new BlueOceanApiMetadata(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Builder fromApiMetadata(ApiMetadata in) {
            return this;
        }
    }
}
