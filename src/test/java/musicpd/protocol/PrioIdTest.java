package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PrioIdTest {

    @Test
    public void textA() {
        final String text = new PrioId(10, 3).text();
        assertThat(text).isEqualTo("prioid 10 3");
    }

    @Test
    public void textB() {
        final String text = new PrioId(10, 3, 30, 60, 20).text();
        assertThat(text).isEqualTo("prioid 10 3 30 60 20");
    }
}
