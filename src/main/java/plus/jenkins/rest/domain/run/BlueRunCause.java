package plus.jenkins.rest.domain.run;

import lombok.Data;
import plus.jenkins.rest.domain.BaseDomain;

/**
 * description
 *
 * @author pengzhenchen 2021/09/11 11:13 上午
 */
@Data
public class BlueRunCause implements BaseDomain {

    private String shortDescription;
    private String userId;
    private String userName;

}
