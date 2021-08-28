package plus.jenkins.rest;

import com.cdancy.jenkins.rest.JenkinsClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 9:00 下午
 */
public class BaseTest extends Base {

    protected static JenkinsClient client;

    //    @BeforeClass
    public static void initLocal(){
        client = JenkinsClient
                .builder()
                .endPoint(LOCAL_JENKINS)
                .credentials(LOCAL_CRE)
                .build();
    }

    @BeforeClass
    public static void initRemote(){
        client = JenkinsClient
                .builder()
                .endPoint(REMOTE_JENKINS)
                .credentials(REMOTE_CRE)
                .build();
    }

    @AfterClass
    public static void close() throws Exception{
        client.close();
    }
}
