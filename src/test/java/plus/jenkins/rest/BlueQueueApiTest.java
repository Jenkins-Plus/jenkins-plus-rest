package plus.jenkins.rest;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import plus.jenkins.rest.domain.queue.BlueQueueItem;

import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:59 下午
 */
public class BlueQueueApiTest extends BaseBlueTest{

    @Test
    public void queue(){
        BlueOceanApi blueOceanApi = client.api();
        List<BlueQueueItem> res = blueOceanApi.queueApi().queue("jenkins","env-test");
        System.out.println(JSONUtil.toJsonPrettyStr(res));
    }
}
