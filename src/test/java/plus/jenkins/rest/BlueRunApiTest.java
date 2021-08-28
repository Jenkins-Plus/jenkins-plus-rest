package plus.jenkins.rest;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
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
        System.out.println(JSONUtil.toJsonStr(res));
    }
}
