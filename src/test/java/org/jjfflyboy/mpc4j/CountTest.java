package org.jjfflyboy.mpc4j;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        Map<Count.Type, String> q = new TreeMap<>();
        q.put(Tag.ARTIST, "bob dylan");
        q.put(Tag.TITLE, "stones");

        Count cmd = new Count(q, Tag.TITLE);
        assertThat(cmd.text()).isEqualTo("count artist \"bob dylan\" title \"stones\" group title");
    }
}
