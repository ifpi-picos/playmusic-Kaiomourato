package player;

public class Track {
    private String name;
    private String path;

    public Track(String nomeString, String caminhoMusicaString) {
        this.name = nomeString;
        this.path = caminhoMusicaString;
    }

    public String getName() {
        return name;
    }

    public String getcaminhoMusicaString() {
        return path;
    }

    public String getPath() {
        return path;
    }
}
