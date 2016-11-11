package musicpd.protocol;

/**
 * @author jfraney
 */
abstract class DatabaseQuery extends AbstractCommand<DatabaseSongInfoResponse> {
    public DatabaseQuery(Parameter... parameters) {
        super(parameters);
    }

    public DatabaseQuery(java.util.List<Parameter> parameters) {
        super(parameters);
    }

    @Override
    public DatabaseSongInfoResponse response(java.util.List<String> responseLines) {
        return new DatabaseSongInfoResponse(responseLines);
    }
}
