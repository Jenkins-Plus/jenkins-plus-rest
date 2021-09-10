package plus.jenkins.rest;

import com.cdancy.jenkins.rest.features.CrumbIssuerApi;
import org.jclouds.rest.annotations.Delegate;
import plus.jenkins.rest.features.*;

import java.io.Closeable;

/**
 * description
 *
 * @author pengzhenchen 2021/08/02 5:14 下午
 */
public interface BlueOceanApi extends Closeable {

    /**
     * 获取凭证信息
     * @return
     */
    @Delegate
    CrumbIssuerApi crumbIssuerApi();

    /**
     * 操作用户信息 api
     * @return
     */
    @Delegate
    BlueUserApi userApi();

    /**
     * 操作组织信息 api
     * @return
     */
    @Delegate
    BlueOrganizationApi organizationApi();

    /**
     * 操作流水线 api
     * @return
     */
    @Delegate
    BluePipelineApi pipelineApi();

    /**
     * 操作流水线执行队列 api
     * @return
     */
    @Delegate
    BlueQueueApi queueApi();

    /**
     * 获取执行 api
     * @return
     */
    @Delegate
    BlueRunApi runApi();

    /**
     * 获取执行 api
     * @return
     */
    @Delegate
    JenkinsFileApi jenkinsExtendApi();
}
