package org.jjfflyboy.mpc4j;

import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

/**
 * @author jfraney
 */
public class CurrentSongTest {
    @Test
    public void text() {
        Assert.assertEquals("wrong command", "currentsong", new CurrentSong().text());
    }

    @Test
    public void response() throws Exception {
        ZonedDateTime now = ZonedDateTime.now();
        String file = "someFileName";
        CurrentSong.Response r = new CurrentSong().response(new String[] {
                "Last-Modified: " + now.format(DateTimeFormatter.ISO_ZONED_DATE_TIME),
                "Id: 10",
                "Time: 99",
                "Pos: 23",
                "file: " + file

        });
        Assert.assertEquals("wrong ", 99, r.getTime().get().intValue());
        Assert.assertEquals("wrong ", file, r.getFile().get());
        Assert.assertEquals("wrong ", 10, r.getId().get().intValue());
        Assert.assertEquals("wrong ", now, r.getLastModified().get());
        Assert.assertEquals("wrong ", 23, r.getPosition().get().intValue());
    }

}