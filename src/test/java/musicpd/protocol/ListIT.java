package musicpd.protocol;

import com.github.jjfraney.mpc.MPC;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="http://github.com/jjfraney">John J. Franey</a>
 */
public class ListIT {

    private MPC mpc;
    @Before
    public void before() {
        mpc = new MPC();
    }

    @Test
    public void listArtist() throws IOException {
        final List list = List.build(Tag.TITLE, builder -> builder
                .groupBy(Tag.ARTIST)
                .groupBy(Tag.ALBUM)
                .groupBy(Tag.GENRE));
        final List.Response r = mpc.send(list);
        final java.util.List<List.Response.Metadata> metadata = r.getMetadata();
        assertThat(metadata.size()).isEqualTo(3);
        for(int i = 0; i < 3; i++) {
            final String expectedTitle = "W" + (i+1) + " Song";
            assertThat(metadata.get(i).getType(Tag.TITLE)).isPresent();
            assertThat(metadata.get(i).getType(Tag.TITLE).orElse(null)).isEqualTo(expectedTitle);
        }
        r.getMetadata().stream()
                .map(m -> m.getType(Tag.TITLE).orElse(null) + ", " + m.getType(Tag.ALBUM).orElse(null) + ", " + m.getType(Tag.GENRE).orElse(null))
                .forEach(System.out::println);
    }
}
