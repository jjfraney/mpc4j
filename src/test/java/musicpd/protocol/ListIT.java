package musicpd.protocol;

import org.jjflyboy.mpc.MPC;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jfraney
 */
public class ListIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void listArtist() throws IOException {
        List list = List.build(Tag.TITLE, builder -> {
            builder
                    .groupBy(Tag.ARTIST)
                    .groupBy(Tag.ALBUM)
                    .groupBy(Tag.GENRE);
        });
        List.Response r = mpc.send(list);
        java.util.List<List.Response.Metadata> metadata = r.getMetadata();
        assertThat(metadata.size()).isEqualTo(3);
        for(int i = 0; i < 3; i++) {
            String expectedTitle = "W" + (i+1) + " Song";
            assertThat(metadata.get(i).getType(Tag.TITLE)).isPresent();
            assertThat(metadata.get(i).getType(Tag.TITLE).get()).isEqualTo(expectedTitle);
        }
        r.getMetadata().stream()
                .map(m -> m.getType(Tag.TITLE).get() + ", " + m.getType(Tag.ALBUM).get() + ", " + m.getType(Tag.GENRE).get())
                .forEach(System.out::println);
    }
}
