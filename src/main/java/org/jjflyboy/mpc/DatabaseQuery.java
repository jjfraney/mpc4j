package org.jjflyboy.mpc;

/**
 * @author jfraney
 */
public abstract class DatabaseQuery extends AbstractCommand<DatabaseQueryResponse> {
    public DatabaseQuery(final Parameter... parameters) {
        super(parameters);
    }

    public DatabaseQuery(final java.util.List<Parameter> parameters) {
        super(parameters);
    }

    @Override
    public DatabaseQueryResponse response(final java.util.List<String> responseLines, final String connectResponse) {
        return new DatabaseQueryResponse(responseLines, connectResponse);
    }
}
