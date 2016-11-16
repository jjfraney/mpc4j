package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class PlayIdTest {

    @Test
    public void textDefault() {
        assertThat(new PlayId().text()).as("wrong command").isEqualTo("playid");
    }
    @Test
    public void textSongPos() {
        assertThat(new PlayId(10).text()).as("wrong command").isEqualTo("playid 10");
    }
}