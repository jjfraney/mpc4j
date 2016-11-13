package musicpd.protocol;

/**
 * @author jfraney
 */
class FilterParameter implements Parameter {

    private final String text;
    public FilterParameter(Parameter type, String what) {
        this.text = new StringBuilder()
                .append(type.toParameter())
                .append(" \"")
                .append(what)
                .append('"')
                .toString();
    }

    @Override
    public String toParameter() {
        return text;
    }
}
