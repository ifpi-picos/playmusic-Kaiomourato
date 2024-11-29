package ui;

import javax.swing.*;
import java.awt.*;

public class MusicIcon {
    public static ImageIcon loadIcon(String iconPath, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(iconPath);
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            System.err.println("Erro ao carregar o ícone: " + iconPath);
            return null;
        }
    }
}
