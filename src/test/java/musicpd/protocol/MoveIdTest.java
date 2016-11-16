package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class MoveIdTest {

    @Test
    public void moveWithFrom() {
        final String text = new MoveId(10, 30).text();
        assertThat(text).isEqualTo("moveid 10 30");
    }
}
