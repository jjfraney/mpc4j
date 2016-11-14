package org.jjflyboy.mpc;

/**
 * @author jfraney
 */
public abstract class DatabaseQuery extends AbstractCommand<DatabaseQueryResponse> {
    public DatabaseQuery(Parameter... parameters) {
        super(parameters);
    }

    public DatabaseQuery(java.util.List<Parameter> parameters) {
        super(parameters);
    }

    @Override
    public DatabaseQueryResponse response(java.util.List<String> responseLines, String connectResponse) {
        return new DatabaseQueryResponse(responseLines, connectResponse);
    }
}
