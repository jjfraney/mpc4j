package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class MoveIdTest {

    @Test
    public void moveWithFrom() {
        String text = new MoveId(10, 30).text();
        assertThat(text).isEqualTo("moveid 10 30");
    }
}
