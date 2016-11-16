package musicpd.protocol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class CountTest {

    @Test
    public void text() {
        final Count cmd = new Count(Tag.ARTIST, "bob dylan");
        assertThat(cmd.text()).isEqualTo("count artist \"bob dylan\"");
    }

    @Test
    public void textComplex() {
        final Count count = Count.build(builder -> builder
                .with(Tag.ARTIST, "bob dylan")
                .with(Tag.TITLE, "stones")
                .groupBy(Tag.TITLE));
        assertThat(count.text()).isEqualTo("count artist \"bob dylan\" title \"stones\" group title");
    }
}
