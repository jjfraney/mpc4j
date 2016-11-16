package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class DeleteTest {

    @Test
    public void deleteWithPos() {
        final String text = new Delete(10).text();
        assertThat(text).isEqualTo("delete 10");
    }
    @Test
    public void deleteWithStartEnd() {
        final String text = new Delete(10, 20).text();
        assertThat(text).isEqualTo("delete 10:20");
    }

}
