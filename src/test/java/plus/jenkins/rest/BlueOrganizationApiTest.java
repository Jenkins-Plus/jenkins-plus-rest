package plus.jenkins.rest;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import plus.jenkins.rest.domain.org.BlueOrganization;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:57 下午
 */
public class BlueOrganizationApiTest extends BaseBlueTest{

    @Test
    public void org(){
        BlueOceanApi blueOceanApi = client.api();
        BlueOrganization res = blueOceanApi.organizationApi().organization("jenkins");
        System.out.println(res.toString());
    }

    @Test
    public void orgs(){
        BlueOceanApi blueOceanApi = client.api();
        List<BlueOrganization> res = blueOceanApi.organizationApi().organizations();
        System.out.println(JSONUtil.toJsonStr(res));
    }

}
