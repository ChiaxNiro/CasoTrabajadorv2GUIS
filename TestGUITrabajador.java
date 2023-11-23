import javax.swing.*;

public class TestGUITrabajador {
    public static void main(String[] args) {
        GestorArchivo.crearArchivo("Trabajadores.txt"," ");
        SwingUtilities.invokeLater(() -> {
            VentanaTrabajador ventana = new VentanaTrabajador();
            ventana.setVisible(true);
        });
    }
}

