package howard.edu.lsp.finals.problem;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    /* Key is the genre, HashSet contains associated songs */
    private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

    /* Add a song title to a genre */
    public void addSong(String genre, String songTitle) {
         // Check if the genre already exists in the map
        if (!map.containsKey(genre)) {
            // If not, create a new HashSet to store song titles
            map.put(genre, new HashSet<String>());
        }
         // Add the song title to the HashSet associated with the genre
        map.get(genre).add(songTitle);
    }

    /* Return the Set that contains all songs for a genre */
    public Set<String> getSongs(String genre) {
    	  if (!map.containsKey(genre)) {
             // If not, return an empty set
              return new HashSet<String>();
          }
          return new HashSet<String>(map.get(genre));
    }

    /* Return genre, i.e., jazz, given a song title */
    public String getGenreOfSong(String songTitle) {
        // Iterate over the map entries to find the genre associated with the song title
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            // If the HashSet value contains the song title, return the genre key
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        // If the song title is not found, return null
        return null;
    }
}
