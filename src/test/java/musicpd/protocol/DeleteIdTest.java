package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class DeleteIdTest {

    @Test
    public void deleteId() {
        final String text = new DeleteId(10).text();
        assertThat(text).isEqualTo("deleteid 10");
    }

}
