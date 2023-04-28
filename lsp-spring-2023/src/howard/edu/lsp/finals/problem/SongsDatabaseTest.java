package howard.edu.lsp.finals.problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SongsDatabaseTest {

    private SongsDatabase db;

    @Before
    public void setUp() {
        db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
    }

    @Test
    public void testAddSong() {
        db.addSong("Rap", "New Rap Song");
        Set<String> rapSongs = db.getSongs("Rap");

        assertEquals(3, rapSongs.size());
        assertEquals(true, rapSongs.contains("Savage"));
        assertEquals(true, rapSongs.contains("Gin and Juice"));
        assertEquals(true, rapSongs.contains("New Rap Song"));
    }

    @Test
    public void testGetSongs() {
        Set<String> rapSongs = db.getSongs("Rap");
        assertEquals(2, rapSongs.size());
        assertEquals(true, rapSongs.contains("Savage"));
        assertEquals(true, rapSongs.contains("Gin and Juice"));

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertEquals(1, jazzSongs.size());
        assertEquals(true, jazzSongs.contains("Always There"));

        Set<String> popSongs = db.getSongs("Pop");
        assertEquals(0, popSongs.size());
    }

    @Test
    public void testGetGenreOfSong() {
        assertEquals("Rap", db.getGenreOfSong("Savage"));
        assertEquals("Jazz", db.getGenreOfSong("Always There"));
        assertNull(db.getGenreOfSong("My Heart Will Go On"));
    }
    @Test
    public void testAddSongToNewGenre() {
        db.addSong("Rock", "Thunderstruck");
        Set<String> rockSongs = db.getSongs("Rock");
        assertEquals(1, rockSongs.size());
        assertEquals(true, rockSongs.contains("Thunderstruck"));
    }

    @Test
    public void testGetSongsForNonexistentGenre() {
        Set<String> countrySongs = db.getSongs("Country");
        assertEquals(0, countrySongs.size());
    }

    @Test
        public void testGetGenreOfNonexistentSong() {
        assertNull(db.getGenreOfSong("Bohemian Rhapsody"));
    }

    @Test
    public void testAddDuplicateSong() {
        db.addSong("Rap", "Savage");
        Set<String> rapSongs = db.getSongs("Rap");
        assertEquals(2, rapSongs.size());
        assertEquals(true, rapSongs.contains("Savage"));
}

    @Test
    public void testGetSongsReturnsCopy() {
        Set<String> jazzSongs = db.getSongs("Jazz");
        jazzSongs.add("Spain");
        Set<String> updatedJazzSongs = db.getSongs("Jazz");
        assertEquals(1, updatedJazzSongs.size());
        assertEquals(false, updatedJazzSongs.contains("Spain"));
}

}
