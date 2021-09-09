package plus.jenkins.rest.domain;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 解析 jenkins rest 请求
 * 格式：
 * {
 *     "status":
 *     "data":{
 *
 *     }
 * }
 *
 * @author pengzhenchen 2021/08/19 4:02 下午
 */
@Data
@Slf4j
public class JenkinsResult implements Serializable {

    private String status;
    private JSONObject data;

    public static JenkinsResult of(String res){

        JSONObject jsonObject = JSONUtil.parseObj(res);
        String status = jsonObject.getStr("status");
        JSONObject data = jsonObject.getJSONObject("data");
        JenkinsResult jenkinsResult = new JenkinsResult();
        jenkinsResult.setStatus(status);
        jenkinsResult.setData(data);
        return jenkinsResult;
    }

    public boolean failure() {
        return ObjectUtil.isNull(data)
                || StrUtil.equalsAnyIgnoreCase("failure", data.getStr("result"));
    }

    public String jenkinsfile() {
        return !failure() ? data.getStr("jenkinsfile") : null;
    }

}
