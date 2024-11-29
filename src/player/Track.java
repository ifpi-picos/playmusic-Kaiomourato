package player;

public class Track {
    private String nameString;
    private String path;

    public Track(String nomeString, String caminhoMusicaString) {
        this.nameString = nomeString;
        this.path = caminhoMusicaString;
    }

    public String getName() {
        return nameString;
    }

    public String getcaminhoMusicaString() {
        return path;
    }

    public String getPath() {
        return path;
    }
}
