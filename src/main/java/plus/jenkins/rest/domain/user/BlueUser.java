package plus.jenkins.rest.domain.user;

import com.cdancy.jenkins.rest.JenkinsUtils;
import com.cdancy.jenkins.rest.domain.common.Error;
import lombok.Builder;
import lombok.Data;
import org.jclouds.json.SerializedNames;
import plus.jenkins.rest.domain.BaseDomain;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 10:22 上午
 */
@Data
@Builder
public class BlueUser implements BaseDomain {

    private  String id;
    private  String fullName;
    private  String email;
    private  String avatar;
    private  List<Error> errors;


    public static BlueUser fail(final List<Error> errors) {
        return BlueUser.builder()
                .errors(JenkinsUtils.nullToEmpty(errors))
                .build();
    }

}
