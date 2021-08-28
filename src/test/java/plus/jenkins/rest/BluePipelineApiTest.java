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
        BluePipeline res = blueOceanApi.pipelineApi().pipeline("jenkins","env-test");
        System.out.println(res.toString());
    }


    @Test
    public void pipelines(){
        BlueOceanApi blueOceanApi = client.api();
        List<BluePipeline> res = blueOceanApi.pipelineApi().pipelines("jenkins");
        System.out.println(JSONUtil.toJsonStr(res));
    }


    @Test
    public void searchPipelines(){
        BlueOceanApi blueOceanApi = client.api();
        List<BluePipeline> res = blueOceanApi.pipelineApi().searhPipelines();
        System.out.println(JSONUtil.toJsonStr(res));
    }

    @Test
    public void pipelineParams(){
        BlueOceanApi blueOceanApi = client.api();
        BluePipeline res = blueOceanApi.pipelineApi().pipelineParams("jenkins","env-test", "master");
        System.out.println(JSONUtil.toJsonStr(res));
    }

    @Test
    public void folder(){
        BlueOceanApi blueOceanApi = client.api();
        BluePipeline res = blueOceanApi.pipelineApi().folder("jenkins","folder-test");
        System.out.println(JSONUtil.toJsonStr(res));
    }

    @Test
    public void pipelineNestedFolder(){
        BlueOceanApi blueOceanApi = client.api();
        List<BluePipeline> res = blueOceanApi.pipelineApi().pipelineNestedFolder("jenkins","folder-test");
        System.out.println(JSONUtil.toJsonStr(res));
    }

    @Test
    public void multiBranchPipeline(){
        BlueOceanApi blueOceanApi = client.api();
        BluePipeline res = blueOceanApi.pipelineApi().multiBranchPipeline("jenkins","mutiBranch-test");
        System.out.println(JSONUtil.toJsonStr(res));
    }

    @Test
    public void multiBranchPipelineBranches(){
        BlueOceanApi blueOceanApi = client.api();
        List<BluePipeline> res = blueOceanApi.pipelineApi().multiBranchPipelineBranches("jenkins","mutiBranch-test");
        System.out.println(JSONUtil.toJsonStr(res));
    }


}
