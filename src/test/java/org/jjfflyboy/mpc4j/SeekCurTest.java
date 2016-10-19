package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class SeekCurTest {

    @Test
    public void textBigDecimal() {
        assertThat(new SeekCur(new BigDecimal("30.3")).text()).as("wrong command").isEqualTo("seekcur 30.3");
    }
    @Test
    public void textInteger() {
        assertThat(new SeekCur(Integer.valueOf(20)).text()).as("wrong command").isEqualTo("seekcur 20");
    }
    @Test
    public void textFloat() {
        assertThat(new SeekCur(Float.valueOf("1.2")).text()).as("wrong command").isEqualTo("seekcur 1.2");
    }
}