package plus.jenkins.rest;

import cn.hutool.json.JSONUtil;
import com.cdancy.jenkins.rest.domain.common.IntegerResponse;
import com.cdancy.jenkins.rest.domain.job.JobInfo;
import com.cdancy.jenkins.rest.domain.job.JobList;
import org.junit.Test;

/**
 * description
 *
 * @author pengzhenchen 2021/08/09 1:40 下午
 */
public class JenkinsJobsApiTest  extends BaseTest {

    @Test
    public void jobList(){
        JobList jobList = client.api().jobsApi().jobList("default");
        System.out.println(JSONUtil.toJsonPrettyStr(jobList));
    }

    @Test
    public void config(){
        String env = client.api().jobsApi().config(null,"env-test");
        System.out.println(env);
    }

    @Test
    public void build(){
        IntegerResponse response = client.api().jobsApi().build(null,"env-test");
        System.out.println(response);
    }

    @Test
    public void jobInfo(){
        JobInfo jobInfo = client.api().jobsApi().jobInfo(null,"env-test");
        System.out.println(JSONUtil.toJsonPrettyStr(jobInfo));
    }

}
