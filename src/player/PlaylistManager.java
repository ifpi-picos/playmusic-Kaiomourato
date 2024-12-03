package player;

import java.util.List;
import util.FileLoader;

public class PlaylistManager {
    private List<Album> albums;  // Gerencia álbuns
    private int currentAlbumIndex; // índice que rastreia qual álbum está sendo acessado atualmente.
    private int currentTrackIndex; // Um índice que indica qual faixa dentro do álbum atual está sendo reproduzida.

    public PlaylistManager(String musicFolderPath) {
        // Carrega os álbuns e músicas
        albums = FileLoader.loadMusicFiles(musicFolderPath);
        currentAlbumIndex = 0;
    
        // Verifica se há álbuns e músicas e inicializa corretamente
        if (!albums.isEmpty() && !albums.get(currentAlbumIndex).getTracks().isEmpty()) {
            currentTrackIndex = 0;  // Inicializa o índice da primeira música do primeiro álbum
        } else {
            currentTrackIndex = -1;  // Nenhuma música carregada
        }
    }    

    // Retorna o álbum atual baseado no indice
    public Album getCurrentAlbum() {
        if (albums.isEmpty() || currentAlbumIndex == -1) {
            return null;
        }
        return albums.get(currentAlbumIndex);
    }

    // retorna a musica atual do album
    public Track getCurrentTrack() {
        if (albums.isEmpty() || currentAlbumIndex == -1 || getCurrentAlbum().getTracks().isEmpty()) {
            return null;
        }
        // Verifica se o índice da música atual é válido
        if (currentTrackIndex >= 0 && currentTrackIndex < getCurrentAlbum().getTracks().size()) {
        return getCurrentAlbum().getTracks().get(currentTrackIndex);
    } else {
        return null; 
    }

    }

    public Track nextTrack() {
        if (albums.isEmpty()) {
            return null;
        }
    
        // Avançar para a próxima música
        currentTrackIndex++;
        if (currentTrackIndex >= getCurrentAlbum().getTracks().size()) {
            currentTrackIndex = 0; // Reiniciar a música do álbum
    
            // Se todas as músicas do álbum atual acabaram, ir para o próximo álbum
            currentAlbumIndex++;
            if (currentAlbumIndex >= albums.size()) {
                currentAlbumIndex = 0; // Reiniciar a lista de álbuns
            }
        }
        return getCurrentTrack();
    }
    

    public Track previousTrack() {
        if (albums.isEmpty()) {
            return null;
        }

        // Retroceder para a música anterior
        currentTrackIndex--;
        if (currentTrackIndex < 0) {
            currentAlbumIndex--;
            if (currentAlbumIndex < 0) {
                currentAlbumIndex = albums.size() - 1;
            }
            currentTrackIndex = getCurrentAlbum().getTracks().size() - 1;
        }
        return getCurrentTrack();
    }

    // Verifica se há álbuns carregados na lista.
    public boolean hasTracks() {
        return !albums.isEmpty();
    }
}
