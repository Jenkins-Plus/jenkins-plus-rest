package plus.jenkins.rest.domain.run;

import lombok.Data;
import plus.jenkins.rest.domain.BaseDomain;

/**
 * description
 *
 * @author pengzhenchen 2021/09/11 2:58 下午
 */
@Data
public class BlueRunNode implements BaseDomain {

    private String  id;
    private String  displayDescription;
    private String  displayName;
    private Long    durationInMillis;
    private String  input;
    private String  result;
    private String  startTime;
    private String  state;
    private String  type;
    private String  causeOfBlockage;
    private String  firstParent;
    private String  restartable;

}
