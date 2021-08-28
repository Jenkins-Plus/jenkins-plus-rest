package plus.jenkins.rest.domain.org;

import lombok.Builder;
import lombok.Data;
import org.jclouds.json.SerializedNames;
import plus.jenkins.rest.domain.BaseDomain;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 2:36 下午
 */
@Data
@Builder
public class BlueOrganization implements BaseDomain {

    private String name;
    private String displayName;

}
