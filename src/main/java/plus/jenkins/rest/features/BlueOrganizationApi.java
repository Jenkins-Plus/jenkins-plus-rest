package plus.jenkins.rest.features;

import org.jclouds.rest.annotations.RequestFilters;
import plus.jenkins.rest.domain.org.BlueOrganization;
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
 * @author pengzhenchen 2021/08/03 2:34 下午
 */
@Path("/blue/rest")
@SuppressWarnings("all")
@Consumes(MediaType.APPLICATION_JSON)
@RequestFilters(BlueOceanAuthenticationFilter.class)
public interface BlueOrganizationApi {

    @GET
    @Path("organizations/{organization}")
    BlueOrganization organization(@PathParam("organization") String organization);

    @GET
    @Path("organizations")
    List<BlueOrganization> organizations();
}
