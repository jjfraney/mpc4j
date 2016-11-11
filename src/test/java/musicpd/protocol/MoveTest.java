package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class MoveTest {

    @Test
    public void moveWithFrom() {
        String text = new Move(10, 30).text();
        assertThat(text).isEqualTo("move 10 30");
    }
    @Test
    public void moveWithStartEnd() {
        String text = new Move(10, 20, 30).text();
        assertThat(text).isEqualTo("move 10:20 30");
    }
}
