package player;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {

    private Clip clip;
    private boolean isPlaying;
    private PlaylistManager playlistManager;

public MusicPlayer(PlaylistManager playlistManager) {
    this.playlistManager = playlistManager;
    isPlaying = false;
}

    // Método para tocar a música
    public void playTrack(String trackPath) {
        stop(); // Para qualquer música tocando antes de começar a nova
        try {
            // Caminho do arquivo WAV
            File audioFile = new File(trackPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
    
            // Obtém o clip para reproduzir o áudio
            clip = AudioSystem.getClip();
            clip.open(audioStream);
    
            // Inicia a reprodução
            clip.start();
            isPlaying = true;
            System.out.println("Reproduzindo: " + audioFile.getName());
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Erro ao reproduzir a música: " + e.getMessage());
        }
    }
    

    // Método para parar a música
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
            isPlaying = false;
        }
    }

    // Método para alternar entre play e pause
    public void togglePlayPause() {
        if (clip != null) {
            if (isPlaying) {
                clip.stop();
            } else {
                clip.start();
            }
            isPlaying = !isPlaying;
        }
    }
}