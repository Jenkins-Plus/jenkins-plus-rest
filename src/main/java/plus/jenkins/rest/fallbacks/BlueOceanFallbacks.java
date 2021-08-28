package plus.jenkins.rest.fallbacks;

import com.cdancy.jenkins.rest.domain.common.Error;
import com.cdancy.jenkins.rest.fallbacks.JenkinsFallbacks;
import org.jclouds.Fallback;
import plus.jenkins.rest.domain.user.BlueUser;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Throwables.propagate;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 2:22 下午
 */
public class BlueOceanFallbacks {

    public static final class BlueUserOnError implements Fallback<Object> {
        @Override
        public Object createOrPropagate(final Throwable throwable) throws Exception {
            if (checkNotNull(throwable, "throwable") != null) {
                return createBlueUserFromErrors(JenkinsFallbacks.getErrors(throwable));
            }
            throw propagate(throwable);
        }
    }

    public static BlueUser createBlueUserFromErrors(final List<Error> errors) {
        return BlueUser.fail(errors);
    }

}
