package org.jjflyboy.mpc4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author jfraney
 */
public abstract class AbstractCommand<R extends Command.Response> implements Command<R> {

    // this class calculates the command text at construction
    private final String text;

    @Override
    public String text() {
        return text;
    }


    protected AbstractCommand(Parameter ... parameters) {
        StringBuilder b = new StringBuilder(command());
        if(parameters.length > 0) {
            b.append(" ").append(
                    Arrays.stream(parameters)
                            .map(Parameter::toParameter)
                            .filter(s -> s.length() > 0)
                            .collect(Collectors.joining(" "))
            );
        }
        text = b.toString();
    }
    protected String command() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    /**
     * adapt an array of objects to a Parameter
     * @param array
     * @param <T>
     * @return
     */
    protected static <T> Parameter adapt(final T[] array) {
        return new Parameter() {
            @Override
            public String toParameter() {
                return new StringBuilder()
                        .append(Arrays.stream(array).map(Object::toString).collect(Collectors.joining(" ")))
                        .toString();
            }
        };
    }

    /**
     * adapt an array of Parameters to a Parameter
     * @param array
     * @param <T>
     * @return
     */
    protected static <T extends Parameter> Parameter adapt(final T[] array) {
        return new Parameter() {
            @Override
            public String toParameter() {
                return new StringBuilder()
                        .append(Arrays.stream(array).map(Parameter::toParameter).collect(Collectors.joining(" ")))
                        .toString();
            }
        };
    }

    /**
     * adapt an object to a Parameter
     * @param object
     * @param <T>
     * @return
     */
    protected static <T> Parameter adapt(final T object) {
        return new Parameter() {
            @Override
            public String toParameter() { return object.toString();}
        };
    }

}
