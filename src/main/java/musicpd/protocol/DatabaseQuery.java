package musicpd.protocol;

/**
 * @author jfraney
 */
abstract class DatabaseQuery extends AbstractCommand<DatabaseQueryResponse> {
    public DatabaseQuery(Parameter... parameters) {
        super(parameters);
    }

    public DatabaseQuery(java.util.List<Parameter> parameters) {
        super(parameters);
    }

    @Override
    public DatabaseQueryResponse response(java.util.List<String> responseLines) {
        return new DatabaseQueryResponse(responseLines);
    }
}
