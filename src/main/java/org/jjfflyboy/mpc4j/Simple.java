package org.jjfflyboy.mpc4j;

/**
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
    public SimpleResponse response(String[] responseLines) {
        return new SimpleResponse(responseLines);
    }

}
