package musicpd.protocol;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class SeekIdTest {

    @Test
    public void textBigDecimal() {
        final String text = new SeekId(10, new BigDecimal("30.3")).text();
        assertThat(text).as("wrong command").isEqualTo("seekid 10 30.3");
    }
    @Test
    public void textInteger() {
        final String text = new SeekId(10, 20).text();
        assertThat(text).as("wrong command").isEqualTo("seekid 10 20");
    }
    @Test
    public void textFloat() {
        final String text = new SeekId(10, 1.2f).text();
        assertThat(text).as("wrong command").isEqualTo("seekid 10 1.2");
    }
}