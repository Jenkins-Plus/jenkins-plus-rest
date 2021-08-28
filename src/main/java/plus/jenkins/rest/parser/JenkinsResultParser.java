package plus.jenkins.rest.parser;

import com.google.common.base.Function;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jclouds.http.HttpResponse;
import org.jclouds.util.Strings2;
import plus.jenkins.rest.domain.JenkinsResult;

import java.io.IOException;

/**
 * description
 *
 * @author pengzhenchen 2021/08/19 4:08 下午
 */
@SuppressWarnings("all")
public class JenkinsResultParser implements Function<HttpResponse, JenkinsResult> {

    @Override
    public @Nullable JenkinsResult apply(@Nullable HttpResponse input) {
        if (checkStatus(input.getStatusCode())) {
            try {
                return JenkinsResult.of(value(input));
            } catch (IOException exception) {
                throw new RuntimeException(input.getStatusLine(), exception);
            }
        } else {
            throw new RuntimeException(input.getStatusLine());
        }
    }

    private static String value(HttpResponse input) throws IOException {
        return Strings2.toStringAndClose(input.getPayload().openStream());
    }

    private boolean checkStatus(int statusCode){
        return statusCode >= 200 && statusCode < 400;
    }
}
