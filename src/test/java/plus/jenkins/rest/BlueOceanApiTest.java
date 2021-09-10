package plus.jenkins.rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * description
 *
 * @author pengzhenchen 2021/08/02 3:06 下午
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BlueUserApiTest.class, BluePipelineApiTest.class, BlueOrganizationApiTest.class,
        BlueQueueApiTest.class, JenkinsFileApiTest.class})
public class BlueOceanApiTest {


}
