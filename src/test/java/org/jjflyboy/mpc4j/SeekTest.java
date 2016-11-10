package org.jjflyboy.mpc4j;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * @author jfraney
 */
public class SeekTest {

    @Test
    public void textBigDecimal() {
        String text = new Seek(10, new BigDecimal("30.3")).text();
        assertThat(text).as("wrong command").isEqualTo("seek 10 30.3");
    }
    @Test
    public void textInteger() {
        String text = new Seek(10, Integer.valueOf(20)).text();
        assertThat(text).as("wrong command").isEqualTo("seek 10 20");
    }
    @Test
    public void textFloat() {
        String text = new Seek(10, 1.2f).text();
        assertThat(text).as("wrong command").isEqualTo("seek 10 1.2");
    }
}