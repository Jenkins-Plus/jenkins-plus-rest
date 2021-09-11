package plus.jenkins.rest.domain.run;

import lombok.Data;
import org.jclouds.json.SerializedNames;
import plus.jenkins.rest.domain.BaseDomain;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 2:49 下午
 */
@Data
public class BlueRun implements BaseDomain {

    private String organization;
    private String id;
    private String pipeline;
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private String enQueueTime;
    private Long durationInMillis;
    private Long estimatedDurationInMillis;
    private String type;
    private String runSummary;
    private String result;
    private String state;
    private String causeOfBlockage;
    private String replayable;
    private String testSummary;
    private List<BlueRunCause> causes;

}
