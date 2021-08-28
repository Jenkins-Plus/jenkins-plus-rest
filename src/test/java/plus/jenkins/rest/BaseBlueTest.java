package plus.jenkins.rest;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:57 下午
 */
public class BaseBlueTest extends Base {
    protected static JenkinsPlusClient client;

//        @BeforeClass
    public static void initLocal(){
        client = JenkinsPlusClient
                .builder()
                .endPoint(LOCAL_JENKINS)
                .credentials(LOCAL_CRE)
                .build();
    }

    @BeforeClass
    public static void initRemote(){
        client = JenkinsPlusClient
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
