package musicpd.protocol;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to access the last line of every mpd response..
 * @author jfraney
 */
public final class SimpleResponse extends HealthResponse {

    SimpleResponse(java.util.List<String> responseLines) {
        super(responseLines);
    }
}
