package org.jjflyboy.mpc4j;

/**
 * Common base class defining a simple response.  Many commands return only OK or ACK and
 * would use this base class.
 * @author jfraney
 */
public abstract class Simple extends AbstractCommand<SimpleResponse> {

    /**
     * instantiate simple command.  The concrete class name, to lower case, is the command's spelling.
     * @param parameters
     */
    protected Simple(Parameter ... parameters) {
        super(parameters);
    }

    @Override
    public SimpleResponse response(java.util.List<String> responseLines) {
        return new SimpleResponse(responseLines);
    }

}
