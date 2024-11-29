package util;

import player.Track;
import player.Album;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static List<Album> loadMusicFiles(String folderPath) {
        List<Album> albums = new ArrayList<>();
        File rootFolder = new File(folderPath);

        if (rootFolder.exists() && rootFolder.isDirectory()) {
            // Percorrer os álbuns (pastas) dentro da pasta raiz
            for (File albumFolder : rootFolder.listFiles()) {
                if (albumFolder.isDirectory()) {
                    List<Track> tracks = new ArrayList<>();
                    // Carregar as músicas dentro do álbum (pastas)
                    for (File file : albumFolder.listFiles()) {
                        if (file.isFile() && file.getName().endsWith(".wav")) {
                            tracks.add(new Track(file.getName(), file.getAbsolutePath()));
                        }
                    }
                    if (!tracks.isEmpty()) {
                        albums.add(new Album(albumFolder.getName(), tracks));
                    }
                }
            }
        }
        return albums;
    }
}
