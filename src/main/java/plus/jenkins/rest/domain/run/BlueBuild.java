package plus.jenkins.rest.domain.run;

import lombok.Data;
import plus.jenkins.rest.domain.BaseDomain;

/**
 * description
 *
 * @author pengzhenchen 2021/09/09 4:59 下午
 */
@Data
public class BlueBuild implements BaseDomain {

    private String id;
    private Integer expectedBuildNumber;
    private String pipeline;
    private String qeueudTime;

}
