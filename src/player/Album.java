package player;

import java.util.List;

public class Album {
    private String name;
    private List<Track> tracks;

    public Album(String name, List<Track> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
