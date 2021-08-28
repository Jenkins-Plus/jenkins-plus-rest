package plus.jenkins.rest;

import com.cdancy.jenkins.rest.domain.system.SystemInfo;
import org.junit.Test;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 9:11 下午
 */
public class SystemApiTest extends BaseTest {

    @Test
    public void systemInfo(){
        SystemInfo systemInfo = client.api().systemApi().systemInfo();
        System.out.println(systemInfo.toString());
    }
}
