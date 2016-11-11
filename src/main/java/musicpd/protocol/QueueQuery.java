package musicpd.protocol;

/**
 * @author jfraney
 */
abstract class QueueQuery extends AbstractCommand<QueuedSongInfoResponse> {
    public QueueQuery(Parameter... parameters) {
        super(parameters);
    }

    @Override
    public QueuedSongInfoResponse response(java.util.List<String> responseLines) {
        return new QueuedSongInfoResponse(responseLines);
    }
}
