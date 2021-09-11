package plus.jenkins.rest;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONUtil;
import org.junit.Test;
import plus.jenkins.rest.domain.JenkinsResult;

/**
 * description
 *
 * @author pengzhenchen 2021/08/19 3:41 下午
 */
public class JenkinsFileApiTest extends BaseBlueTest{
    @Test
    public void toJson(){
        String jenkins = Base64.decodeStr("cGlwZWxpbmUgewogIGFnZW50IGFueQogIHN0YWdlcyB7CiAgICBzdGFnZSgnYnVpbGQnKSB7CiAgICAgIHN0ZXBzIHsKICAgICAgICBzaCAnZWNobyBcJ2hlbGxvIHdvcmxkXCcnCiAgICAgIH0KICAgIH0KCiAgICBzdGFnZSgnc3RlcDInKSB7CiAgICAgIHN0ZXBzIHsKICAgICAgICBzaCAnZWNobyAic3RlcDIiJwogICAgICB9CiAgICB9CgogICAgc3RhZ2UoJ3N0ZXAzJykgewogICAgICBzdGVwcyB7CiAgICAgICAgZWNobyAnc3RlcDMnCiAgICAgIH0KICAgIH0KCiAgICBzdGFnZSgnc3RlcDQnKSB7CiAgICAgIHN0ZXBzIHsKICAgICAgICBzaCAnZWNobyAic3RlcDQiJwogICAgICB9CiAgICB9CgogICAgc3RhZ2UoJ3N0ZXA1JykgewogICAgICBzdGVwcyB7CiAgICAgICAgc2ggJ2VjaG8gInN0ZXA1IicKICAgICAgfQogICAgfQoKICB9Cn0=");
        JenkinsResult res = client.api().jenkinsFileApi().toJson(jenkins);
        System.out.println(res.getData().toString());
        System.out.println(JSONUtil.toJsonPrettyStr(res.getData().toString()));
    }

    @Test
    public void validateJson(){
//        String jenkins = "{\"pipeline\":{\"agent\":{\"type\":\"any\"},\"stages\":[{\"name\":\"build\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo 'hello world'\"}}]}]}]},{\"name\":\"step2\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step2\\\"\"}}]}]}]},{\"name\":\"step3\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"echo\",\"arguments\":[{\"key\":\"message\",\"value\":{\"isLiteral\":true,\"value\":\"step3\"}}]}]}]},{\"name\":\"step4\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step4\\\"\"}}]}]}]},{\"name\":\"step5\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step5\\\"\"}}]}]}]},{\"name\":\"step6\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[]}]}]}]}}";
        String jenkins = "{\"pipeline\":{\"agent\":{\"type\":\"any\"},\"stages\":[{\"name\":\"build\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo 'hello world'\"}}]}]}]},{\"name\":\"step2\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step2\\\"\"}}]}]}]},{\"name\":\"step3\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"echo\",\"arguments\":[{\"key\":\"message\",\"value\":{\"isLiteral\":true,\"value\":\"step3\"}}]}]}]},{\"name\":\"step4\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step4\\\"\"}}]}]}]},{\"name\":\"step5\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step5\\\"\"}}]}]}]},{\"name\":\"step6\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[]}]}]}]}}";
        JenkinsResult res = client.api().jenkinsFileApi().validateJson(jenkins);
        System.out.println(JSONUtil.toJsonPrettyStr(res.getData().toString()));
    }

    @Test
    public void toJenkinsfile(){
//        String json = "{\"pipeline\":{\"stages\":[{\"name\":\"build\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo 'hello world'\"}}]}]}]},{\"name\":\"step2\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step2\\\"\"}}]}]}]},{\"name\":\"step3\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"echo\",\"arguments\":[{\"key\":\"message\",\"value\":{\"isLiteral\":true,\"value\":\"step3\"}}]}]}]},{\"name\":\"step4\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step4\\\"\"}}]}]}]},{\"name\":\"step5\",\"branches\":[{\"name\":\"default\",\"steps\":[{\"name\":\"sh\",\"arguments\":[{\"key\":\"script\",\"value\":{\"isLiteral\":true,\"value\":\"echo \\\"step5\\\"\"}}]}]}]}],\"agent\":{\"type\":\"any\"}}}}";
        String json = "{\"pipName\":\"new pipeline\",\"pipDesc\":\"\",\"jenkinsFile\":\"{\\\"pipeline\\\":{\\\"stages\\\":[{\\\"name\\\":\\\"阶段\\\",\\\"branches\\\":[{\\\"name\\\":\\\"default\\\",\\\"steps\\\":[{\\\"name\\\":\\\"sh\\\",\\\"arguments\\\":[{\\\"key\\\":\\\"script\\\",\\\"value\\\":{\\\"value\\\":\\\"echo \\\\\\\"hello\\\\\\\"\\\"}}]}]}]}]}}\"}";
        JenkinsResult res = client.api().jenkinsFileApi().toJenkinsfile(json);
        System.out.println(JSONUtil.toJsonPrettyStr(res.getData().toString()));
    }
}
