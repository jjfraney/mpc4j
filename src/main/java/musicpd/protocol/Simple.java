package musicpd.protocol;

import org.jjflyboy.mpc.AbstractCommand;
import org.jjflyboy.mpc.Parameter;
import org.jjflyboy.mpc.SimpleResponse;

/**
 * Common base class defining a simple response.
 * Many commands return only OK or ACK and
 * would use this base class.
 * @author jfraney
 */
public abstract class Simple extends AbstractCommand<SimpleResponse> {

    /**
     * instantiate simple command.  The concrete class name,
     * to lower case, is the command's spelling.
     * @param parameters of this command
     */
    protected Simple(final Parameter... parameters) {
        super(parameters);
    }

    @Override
    public SimpleResponse response(final java.util.List<String> responseLines, final String connectResponse) {
        return new SimpleResponse(responseLines, connectResponse);
    }

}
