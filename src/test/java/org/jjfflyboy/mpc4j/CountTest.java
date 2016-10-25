package org.jjfflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class CountTest {

    @Test
    public void text() {
        Count cmd = new Count(Tag.ARTIST, "bob dylan");
        assertThat(cmd.text()).isEqualTo("count artist \"bob dylan\"");
    }

    @Test
    public void textComplex() {
        Count.Filter[] filters = {
                new Count.Filter(Tag.ARTIST, "bob dylan"),
                new Count.Filter(Tag.TITLE, "stones")
        };
        Count cmd = new Count(filters, Tag.TITLE);
        assertThat(cmd.text()).isEqualTo("count artist \"bob dylan\" title \"stones\" group title");
    }
}
