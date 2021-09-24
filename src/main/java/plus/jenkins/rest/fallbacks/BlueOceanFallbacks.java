package plus.jenkins.rest.fallbacks;

import com.cdancy.jenkins.rest.domain.common.Error;
import com.cdancy.jenkins.rest.fallbacks.JenkinsFallbacks;
import org.jclouds.Fallback;
import plus.jenkins.rest.domain.user.BlueUser;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 2:22 下午
 */
@SuppressWarnings("all")
public class BlueOceanFallbacks {

    private static final String ERROR_MSG = "throwable";

    public static final class BlueUserOnError implements Fallback<Object> {
        @Override
        public Object createOrPropagate(final Throwable throwable) throws Exception {
            if (throwable != null) {
                return createBlueUserFromErrors(JenkinsFallbacks.getErrors(throwable));
            }
            throw new RuntimeException(ERROR_MSG);
        }
    }

    public static BlueUser createBlueUserFromErrors(final List<Error> errors) {
        return BlueUser.fail(errors);
    }

}
