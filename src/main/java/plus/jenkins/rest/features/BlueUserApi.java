package plus.jenkins.rest.features;

import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;
import plus.jenkins.rest.domain.user.BlueUser;
import plus.jenkins.rest.fallbacks.BlueOceanFallbacks;
import plus.jenkins.rest.filters.BlueOceanAuthenticationFilter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 10:00 上午
 */
@Path("/blue/rest")
@SuppressWarnings("all")
@Consumes(MediaType.APPLICATION_JSON)
@RequestFilters(BlueOceanAuthenticationFilter.class)
public interface BlueUserApi {

    /**
     * 根据userId 获取用户信息
     * @param userId
     * @return
     */
    @GET
    @Path("users/{userId}")
    @Fallback(BlueOceanFallbacks.BlueUserOnError.class)
    BlueUser user(@PathParam("userId") String userId);
}
