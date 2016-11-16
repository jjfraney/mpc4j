package musicpd.protocol;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class SeekTest {

    @Test
    public void textBigDecimal() {
        final String text = new Seek(10, new BigDecimal("30.3")).text();
        assertThat(text).as("wrong command").isEqualTo("seek 10 30.3");
    }
    @Test
    public void textInteger() {
        final String text = new Seek(10, 20).text();
        assertThat(text).as("wrong command").isEqualTo("seek 10 20");
    }
    @Test
    public void textFloat() {
        final String text = new Seek(10, 1.2f).text();
        assertThat(text).as("wrong command").isEqualTo("seek 10 1.2");
    }
}