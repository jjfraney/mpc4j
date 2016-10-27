package org.jjfflyboy.mpc4j;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class DeleteTest {

    @Test
    public void deleteWithPos() {
        String text = new Delete(10).text();
        assertThat(text).isEqualTo("delete 10");
    }
    @Test
    public void deleteWithStartEnd() {
        String text = new Delete(10, 20).text();
        assertThat(text).isEqualTo("delete 10:20");
    }

}
