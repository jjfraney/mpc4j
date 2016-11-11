package musicpd.protocol;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jfraney
 */
public class MixRampDBTest {
    @Test
    public void text() {
        assertThat(new MixRampDB(new BigDecimal("3.1")).text()).as("wrong command").isEqualTo("mixrampdb 3.1");
    }
}