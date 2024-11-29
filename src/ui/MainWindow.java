package ui;

import player.MusicPlayer;
import player.PlaylistManager;
import player.Track;
import util.Constants;
import player.Album;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JLabel nomeAlbum;   // JLabel para exibir o álbum
    private JLabel nomeMusica;    // JLabel para exibir a música
    private MusicPlayer musicPlayer; // Controla a reprodução da Música (pausar, tocar...)
    private PlaylistManager playlistManager; // Controla a Playlist e musicas que estão na fila (próxima, anteriot)

    public MainWindow() {
        // Configurações da janela
        setTitle(Constants.APP_TITLE);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon appIcon = new ImageIcon(Constants.ICON_PATH);
        setIconImage(appIcon.getImage()); // Define o ícone para a janela

        // Define a cor da Janela
        getContentPane().setBackground(new Color(144, 238, 144));

        // Inicializa o MusicPlayer
        musicPlayer = new MusicPlayer(playlistManager);

        // Caminho para a pasta onde estão os álbuns
        String musicFolderPath = "Resources/music"; // Modifique para o caminho correto
        playlistManager = new PlaylistManager(musicFolderPath);

        // Ícone de música
        JLabel iconLabel = new JLabel(new ImageIcon(Constants.ICON_PATH));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(iconLabel, BorderLayout.NORTH);

        // Nome do álbum
        nomeAlbum = new JLabel("Álbum: Nenhum", SwingConstants.CENTER);
        add(nomeAlbum, BorderLayout.NORTH);

        // Nome da música
        nomeMusica = new JLabel("Nenhuma música tocando", SwingConstants.CENTER);
        add(nomeMusica, BorderLayout.CENTER);

        // Botões de controle
        JPanel controlsPanel = new JPanel();
        JButton prevButton = new JButton("Anterior");
        JButton playPauseButton = new JButton("Tocar/Pausar");
        JButton nextButton = new JButton("Próxima");

        controlsPanel.add(prevButton);
        controlsPanel.add(playPauseButton);
        controlsPanel.add(nextButton);

        add(controlsPanel, BorderLayout.SOUTH);

        // Adiciona ação aos botões
        prevButton.addActionListener(e -> playPrevious());
        playPauseButton.addActionListener(e -> playPause());
        nextButton.addActionListener(e -> playNext());

        // Exibe o primeiro álbum e a primeira música
        updateAlbumAndSong();
    }

    private void playPrevious() {
        Track track = playlistManager.previousTrack();
        updateAlbumAndSong();
        if (track != null) {
            musicPlayer.playTrack(track.getPath());
        }
    }

    private void playPause() {
        musicPlayer.togglePlayPause();
    }

    private void playNext() {
        Track track = playlistManager.nextTrack();
        updateAlbumAndSong();
        if (track != null) {
            musicPlayer.playTrack(track.getPath());
        }
    }

    private void updateAlbumAndSong() {
        Album currentAlbum = playlistManager.getCurrentAlbum();
        Track currentTrack = playlistManager.getCurrentTrack();

        if (currentAlbum != null && currentTrack != null) {
            nomeAlbum.setText("Álbum: " + currentAlbum.getName());
            nomeMusica.setText("Música: " + currentTrack.getName());
        } else {
            nomeAlbum.setText("Álbum: Nenhum");
            nomeMusica.setText("Nenhuma música disponível");
        }
    }
}
