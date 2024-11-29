package main;
import ui.MainWindow;

public class App {
    public static void main(String[] args) {
        // Inicializa a interface gráfica
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}
