package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class SwapTest {

    @Test
    public void swapPos() {
        String text = new Swap(3, 4).text();
        assertThat(text).isEqualTo("swap 3 4");
    }

    @Test
    public void swapId() {
        String text = new SwapId(3, 4).text();
        assertThat(text).isEqualTo("swapid 3 4");
    }
}
