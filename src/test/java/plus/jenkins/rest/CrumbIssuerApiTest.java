package plus.jenkins.rest;

import com.cdancy.jenkins.rest.domain.crumb.Crumb;
import org.junit.Test;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 9:10 下午
 */
public class CrumbIssuerApiTest extends BaseTest {

    @Test
    public void crumb(){
        Crumb crumb = client.api().crumbIssuerApi().crumb();
        System.out.println(crumb.toString());
    }


}
