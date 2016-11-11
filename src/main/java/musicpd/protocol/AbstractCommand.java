package musicpd.protocol;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * base abstract class for most, if not all, commmands.
 * @author jfraney
 */
public abstract class AbstractCommand<R extends Command.Response> implements Command<R> {

    /**
     * the command as text...generated when this class is instantiated
     */
    private final String text;

    @Override
    public String text() {
        return text;
    }


    /**
     * generate this command's text from itself and the list of parameters
     * supplied from concrete command classes.
     * @param parameters from which the command parameters are generated.
     */
    protected AbstractCommand(Parameter ... parameters) {
        this(Arrays.asList(parameters));
    }

    /**
     * generate this command's text from itself and the list of parameters
     * supplied from concrete command classes.
     * @param parameters from which the command parameters are generated.
     */
    protected AbstractCommand(java.util.List<Parameter> parameters) {
        StringBuilder b = new StringBuilder(command());
        if(parameters.size() > 0) {
            b.append(" ").append(
                    parameters.stream()
                            .map(Parameter::toParameter)
                            .filter(s -> s.length() > 0)
                            .collect(Collectors.joining(" "))
            );
        }
        text = b.toString();
    }

    /**
     * return only the spelling of this command...the first verb.
     * <p>
     *     This base implementation returns the simple name of this class in lower case.
     *     Override this method if the command name cannot match the class name, like replay_gain_mode.
     * </p>
     * @return
     */
    protected String command() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    /**
     * adapt an array of objects to a Parameter.
     * <p>
     *     This method is a utility for concrete command classes.
     * </p>
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
     * <p>
     *     This method is a utility for concrete command classes.
     * </p>
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
     * adapt an collection of Parameters to a Parameter
     * <p>
     *     This method is a utility for concrete command classes.
     * </p>
     * @param collection
     * @param <T>
     * @return
     */
    protected static <T extends Parameter> Parameter adapt(java.util.List<Parameter> collection) {
        return new Parameter() {
            @Override
            public String toParameter() {
                return new StringBuilder()
                        .append(collection.stream().map(Parameter::toParameter).collect(Collectors.joining(" ")))
                        .toString();
            }
        };
    }



    /**
     * adapt an object to a Parameter
     * <p>
     *     This method is a utility for concrete command classes.
     * </p>
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
