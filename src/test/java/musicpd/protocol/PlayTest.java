package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlayTest {

    @Test
    public void textDefault() {
        assertThat(new Play().text()).as("wrong command").isEqualTo("play");
    }
    @Test
    public void textSongPos() {
        assertThat(new Play(10).text()).as("wrong command").isEqualTo("play 10");
    }
}