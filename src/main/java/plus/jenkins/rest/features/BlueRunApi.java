package plus.jenkins.rest.features;

import org.jclouds.Fallbacks;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;
import plus.jenkins.rest.domain.run.BlueBuild;
import plus.jenkins.rest.domain.run.BlueRun;
import plus.jenkins.rest.filters.BlueOceanAuthenticationFilter;

import javax.ws.rs.*;
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
public interface BlueRunApi {

    @GET
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Path("organizations/{organization}/pipelines/{pipelineName}/runs")
    List<BlueRun> runs(@PathParam("organization") String organization, @PathParam("pipelineName") String pipelineName);

    @GET
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Path("organizations/{organization}/pipelines/{pipelineName}/runs/{id}")
    BlueRun runDetails(@PathParam("organization") String organization, @PathParam("pipelineName") String pipelineName,  @PathParam("id") String id);

    @POST
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Produces({"application/json"})
    @Path("organizations/{organization}/pipelines/{pipelineName}/runs")
    BlueBuild build(@PathParam("organization") String organization, @PathParam("pipelineName") String pipelineName);
}
