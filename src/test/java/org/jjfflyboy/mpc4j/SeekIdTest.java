package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * @author jfraney
 */
public class SeekIdTest {

    @Test
    public void textBigDecimal() {
        String text = new SeekId(10, new BigDecimal("30.3")).text();
        assertThat(text).as("wrong command").isEqualTo("seekid 10 30.3");
    }
    @Test
    public void textInteger() {
        String text = new SeekId(10, Integer.valueOf(20)).text();
        assertThat(text).as("wrong command").isEqualTo("seekid 10 20");
    }
    @Test
    public void textFloat() {
        String text = new SeekId(10, 1.2f).text();
        assertThat(text).as("wrong command").isEqualTo("seekid 10 1.2");
    }
}