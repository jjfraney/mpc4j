package org.jjflyboy.mpc;

/**
 * @author jfraney
 */
public abstract class QueueQuery extends AbstractCommand<QueueQueryResponse> {
    public QueueQuery(final Parameter... parameters) {
        super(parameters);
    }

    @Override
    public QueueQueryResponse response(final java.util.List<String> responseLines, final String connectResponse) {
        return new QueueQueryResponse(responseLines, connectResponse);
    }
}
