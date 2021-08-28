package plus.jenkins.rest;

import org.junit.Test;
import plus.jenkins.rest.domain.user.BlueUser;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:58 下午
 */
public class BlueUserApiTest extends BaseBlueTest{

    @Test
    public void user(){
        BlueOceanApi blueOceanApi = client.api();
        BlueUser res = blueOceanApi.userApi().user("lanlanhappy");
        System.out.println(res.toString());
    }
}
