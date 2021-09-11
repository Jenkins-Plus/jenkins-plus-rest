package plus.jenkins.rest.features;

import org.jclouds.Fallbacks;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import plus.jenkins.rest.domain.pipeline.BluePipeline;
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
 * @author pengzhenchen 2021/08/02 5:23 下午
 */
@Path("/blue/rest")
@SuppressWarnings("all")
@Consumes(MediaType.APPLICATION_JSON)
@RequestFilters(BlueOceanAuthenticationFilter.class)
public interface BluePipelineApi {

    /**
     * 根据pipelineName 查询pipeline信息
     * @return
     */
    @GET
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Path("organizations/{organization}/pipelines/{pipelineName}")
    BluePipeline pipeline(@PathParam("organization") String organization, @PathParam("pipelineName") String pipelineName);

    /**
     * 根据organization 查询pipeline
     * @return
     */
    @GET
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Path("organizations/{organization}/pipelines")
    List<BluePipeline> pipelines(@PathParam("organization") String organization);

    /**
     * 查询跨组织pipeline信息
     * @return
     */
    @GET
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Path("search/")
    @QueryParams(
            keys = {"q"},
            values = {"type:pipeline"}
    )
    List<BluePipeline> searhPipelines();

}
