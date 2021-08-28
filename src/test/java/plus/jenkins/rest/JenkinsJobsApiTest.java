package plus.jenkins.rest;

import org.junit.Test;

/**
 * description
 *
 * @author pengzhenchen 2021/08/09 1:40 下午
 */
public class JenkinsJobsApiTest  extends BaseTest {

    @Test
    public void config(){
        String env = client.api().jobsApi().config(null,"env-test");
        System.out.println(env);
    }

}
