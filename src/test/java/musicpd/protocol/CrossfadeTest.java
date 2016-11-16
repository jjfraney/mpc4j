package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class CrossfadeTest {
    @Test
    public void textDefault() {

        assertThat(new Crossfade().text()).as("wrong text").isEqualTo("crossfade 0");
    }
    @Test
    public void textByTen() {
        assertThat(new Crossfade(10).text()).as("wrong text").isEqualTo("crossfade 10");
    }

}