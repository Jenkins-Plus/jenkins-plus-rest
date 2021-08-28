package plus.jenkins.rest.domain.pipeline;

import lombok.Builder;
import lombok.Data;
import plus.jenkins.rest.domain.BaseDomain;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 2:43 下午
 */
@Data
@Builder
public class BluePipeline implements BaseDomain {

    private String organization;
    private String name;
    private String displayName;
    private String fullName;
    private String weatherScore;
    private Long estimatedDurationInMillis;

}
