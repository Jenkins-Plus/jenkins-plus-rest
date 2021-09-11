package plus.jenkins.rest;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import plus.jenkins.rest.domain.pipeline.BluePipeline;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:59 下午
 */
public class BluePipelineApiTest extends BaseBlueTest{

    @Test
    public void pipeline(){
        BlueOceanApi blueOceanApi = client.api();
//        BluePipeline res = blueOceanApi.pipelineApi().pipeline("jenkins","env-test");
        BluePipeline res = blueOceanApi.pipelineApi().pipeline("jenkins","jenkins-plus-doc");
        System.out.println(JSONUtil.toJsonPrettyStr(res));
    }

    @Test
    public void pipelines(){
        BlueOceanApi blueOceanApi = client.api();
        List<BluePipeline> res = blueOceanApi.pipelineApi().pipelines("jenkins");
        System.out.println(JSONUtil.toJsonPrettyStr(res));
    }

    @Test
    public void searchPipelines(){
        BlueOceanApi blueOceanApi = client.api();
        List<BluePipeline> res = blueOceanApi.pipelineApi().searhPipelines();
        System.out.println(JSONUtil.toJsonPrettyStr(res));
    }

}
