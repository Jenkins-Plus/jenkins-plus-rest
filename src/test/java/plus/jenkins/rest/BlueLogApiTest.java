package plus.jenkins.rest;

import org.junit.Test;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:59 下午
 */
public class BlueLogApiTest extends BaseBlueTest{

    @Test
    public void stepLog(){
        BlueOceanApi blueOceanApi = client.api();
        for(int i = 9; i <12 ; i++) {
            String res = blueOceanApi.logApi().stepLog(
                    "jenkins","env-test",
                    "7","8",i+"");
            System.out.println(res);
        }

    }

    @Test
    public void fullLog(){
        BlueOceanApi blueOceanApi = client.api();
        String res = blueOceanApi.logApi().fullLog(
                "jenkins","env-test",
                "7");
        System.out.println(res);
    }

}
