package musicpd.protocol;

/**
 * @author jfraney
 */
abstract class QueueQuery extends AbstractCommand<QueueQueryResponse> {
    public QueueQuery(Parameter... parameters) {
        super(parameters);
    }

    @Override
    public QueueQueryResponse response(java.util.List<String> responseLines) {
        return new QueueQueryResponse(responseLines);
    }
}
