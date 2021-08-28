package plus.jenkins.rest.features;

import org.jclouds.rest.annotations.RequestFilters;
import plus.jenkins.rest.domain.queue.BlueQueueItem;
import plus.jenkins.rest.filters.BlueOceanAuthenticationFilter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:29 下午
 */
@Path("/blue/rest")
@SuppressWarnings("all")
@Consumes(MediaType.APPLICATION_JSON)
@RequestFilters(BlueOceanAuthenticationFilter.class)
public interface BlueQueueApi {

    /**
     * 根据 组织和流水线获取执行队列
     * @param userId
     * @return
     */
    @GET
    @Path("organizations/{organization}/pipelines/{pipeline}/queue")
    List<BlueQueueItem> queue(@PathParam("organization") String organization, @PathParam("pipeline") String pipeline);
}
