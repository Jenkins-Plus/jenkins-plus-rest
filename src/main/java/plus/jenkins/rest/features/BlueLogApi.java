package plus.jenkins.rest.features;

import org.jclouds.rest.annotations.RequestFilters;
import plus.jenkins.rest.filters.BlueOceanAuthenticationFilter;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * description
 *
 * @author pengzhenchen 2021/08/03 8:29 下午
 */
@Path("/blue/rest")
@SuppressWarnings("all")
@Consumes(MediaType.APPLICATION_JSON)
@RequestFilters(BlueOceanAuthenticationFilter.class)
public interface BlueLogApi {
}
