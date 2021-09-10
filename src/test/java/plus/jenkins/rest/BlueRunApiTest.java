package plus.jenkins.rest;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import plus.jenkins.rest.domain.run.BlueBuild;
import plus.jenkins.rest.domain.run.BlueRun;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:59 下午
 */
public class BlueRunApiTest extends BaseBlueTest{

    @Test
    public void runs(){
        BlueOceanApi blueOceanApi = client.api();
        List<BlueRun> res = blueOceanApi.runApi().runs("jenkins","env-test");
        System.out.println(JSONUtil.toJsonPrettyStr(res));
    }

    @Test
    public void runDetails(){
        BlueOceanApi blueOceanApi = client.api();
        BlueRun res = blueOceanApi.runApi().runDetails("jenkins","env-test", "3");
        System.out.println(JSONUtil.toJsonPrettyStr(res));
    }

    @Test
    public void build(){
        BlueOceanApi blueOceanApi = client.api();
        BlueBuild res = blueOceanApi.runApi().build("jenkins","env-test");
        System.out.println(JSONUtil.toJsonPrettyStr(res));
    }
}
