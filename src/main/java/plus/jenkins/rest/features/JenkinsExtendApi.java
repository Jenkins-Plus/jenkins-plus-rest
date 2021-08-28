package plus.jenkins.rest.features;

import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.ResponseParser;
import plus.jenkins.rest.domain.JenkinsResult;
import plus.jenkins.rest.filters.BlueOceanAuthenticationFilter;
import plus.jenkins.rest.parser.JenkinsResultParser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * description
 *
 * @author pengzhenchen 2021/08/19 3:36 下午
 */
@Path("/")
@SuppressWarnings("all")
@Consumes(MediaType.APPLICATION_JSON)
@RequestFilters(BlueOceanAuthenticationFilter.class)
public interface JenkinsExtendApi {


    /**
     * 根据 jenkinsfile 转换
     * @param jenkinsfile
     * @return
     */
    @POST
    @Path("pipeline-model-converter/toJson")
    @Consumes({"application/x-www-form-urlencoded"})
    @ResponseParser(JenkinsResultParser.class)
    JenkinsResult toJson(@FormParam("jenkinsfile") String jenkinsfile);

    @POST
    @Path("pipeline-model-converter/validateJson")
    @Consumes({"application/x-www-form-urlencoded"})
    @ResponseParser(JenkinsResultParser.class)
    JenkinsResult validateJson(@FormParam("json") String json);

    @POST
    @Path("pipeline-model-converter/toJenkinsfile")
    @Consumes({"application/x-www-form-urlencoded"})
    @ResponseParser(JenkinsResultParser.class)
    JenkinsResult toJenkinsfile(@FormParam("json") String json);
}
