package com.github.jjfraney.mpc;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * base abstract class for most, if not all, commmands.
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
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
    protected AbstractCommand(final Parameter... parameters) {
        this(Arrays.asList(parameters));
    }

    /**
     * generate this command's text from itself and the list of parameters
     * supplied from concrete command classes.
     * @param parameters from which the command parameters are generated.
     */
    protected AbstractCommand(final java.util.List<Parameter> parameters) {
        final StringBuilder b = new StringBuilder(command());
        if(parameters.size() > 0) {
            b.append(' ').append(
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
     *     This base implementation returns the simple name
     *     of this class in lower case.
     *     Override this method if the command name cannot
     *     match the class name, like replay_gain_mode.
     * </p>
     * @return the command's verb
     */
    protected String command() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    /**
     * adapt an array of objects to a Parameter.
     * <p>
     *     This method is a utility for concrete command classes.
     * </p>
     * @param array to adapt
     * @param <T> generic for multiple binding
     * @return a Parameter wrapping the array
     */
    protected static <T> Parameter adapt(final T[] array) {
        return () -> Arrays.stream(array).map(Object::toString).collect(Collectors.joining(" "));
    }

    /**
     * adapt an array of Parameters to a Parameter
     * <p>
     *     This method is a utility for concrete command classes.
     * </p>
     * @param array to adapt
     * @param <T> generic for multiple binding
     * @return a Parameter wrapping the array
     */
    protected static <T extends Parameter> Parameter adapt(final T[] array) {
        return () -> Arrays.stream(array).map(Parameter::toParameter).collect(Collectors.joining(" "));
    }
    /**
     * adapt an list of Parameters to a Parameter
     * <p>
     *     This method is a utility for concrete command classes.
     * </p>
     * @param list to adapt
     * @param <T> generic for multiple binding
     * @return a Parameter wrapping the list
     */
    protected static <T extends Parameter> Parameter adapt(final java.util.List<? extends Parameter> list) {
        return () -> list.stream().map(Parameter::toParameter).collect(Collectors.joining(" "));
    }



    /**
     * adapt an object to a Parameter
     * <p>
     *     This method is a utility for concrete command classes.
     * </p>
     * @param object to adapt to a Parameter
     * @param <T> generic for multiple binding
     * @return a Parameter wrapping the object
     */
    protected static <T> Parameter adapt(final T object) {
        return object::toString;
    }

}
