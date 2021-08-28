package plus.jenkins.rest.domain.queue;

import lombok.Builder;
import lombok.Data;
import org.jclouds.json.SerializedNames;
import plus.jenkins.rest.domain.BaseDomain;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:46 下午
 */
@Data
@Builder
public class BlueQueueItem implements BaseDomain {

    private String id;
    private String pipeline;
    private Long queueTime;
    private Integer expectedBuildNumber;

}
