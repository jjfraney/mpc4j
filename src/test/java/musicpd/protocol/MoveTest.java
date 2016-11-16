package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class MoveTest {

    @Test
    public void moveWithFrom() {
        final String text = new Move(10, 30).text();
        assertThat(text).isEqualTo("move 10 30");
    }
    @Test
    public void moveWithStartEnd() {
        final String text = new Move(10, 20, 30).text();
        assertThat(text).isEqualTo("move 10:20 30");
    }
}
