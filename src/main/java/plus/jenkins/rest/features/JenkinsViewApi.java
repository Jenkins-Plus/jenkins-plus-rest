package plus.jenkins.rest.features;

import com.cdancy.jenkins.rest.domain.common.RequestStatus;
import org.jclouds.Fallbacks;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;
import plus.jenkins.rest.filters.BlueOceanAuthenticationFilter;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * description
 *
 * @author pengzhenchen 2021/09/12 4:38 下午
 */
@Path("/")
@SuppressWarnings("all")
@RequestFilters(BlueOceanAuthenticationFilter.class)
public interface JenkinsViewApi {


    /**
     * 创建视图
     * @return RequestStatus
     */
    @POST
    @Path("createView")
    @Produces({MediaType.APPLICATION_JSON})
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    RequestStatus create();
}
