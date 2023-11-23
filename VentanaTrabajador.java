import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class VentanaTrabajador extends JFrame implements ActionListener {
    private JTextField nombreField, apellidoField, rutField, fonasaField, isapreField;
    private JButton agregarButton, leerButton;
    private ArrayList<Trabajador> listaTrabajadores;

    public VentanaTrabajador() {
        setTitle("Ventana Trabajador");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listaTrabajadores = new ArrayList<>();

        nombreField = new JTextField(20);
        apellidoField = new JTextField(20);
        rutField = new JTextField(10);
        fonasaField = new JTextField(10);
        isapreField = new JTextField(10);

        agregarButton = new JButton("Agregar");
        leerButton = new JButton("Leer por rut");

        agregarButton.addActionListener(this);
        leerButton.addActionListener(this);

        JPanel panelDatos = new JPanel(new GridLayout(5, 2));
        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(nombreField);
        panelDatos.add(new JLabel("Apellido:"));
        panelDatos.add(apellidoField);
        panelDatos.add(new JLabel("RUT:"));
        panelDatos.add(rutField);
        panelDatos.add(new JLabel("Fonasa:"));
        panelDatos.add(fonasaField);
        panelDatos.add(new JLabel("Isapre:"));
        panelDatos.add(isapreField);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(agregarButton);
        panelBotones.add(leerButton);

        setLayout(new BorderLayout());
        add(panelDatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarButton) {
            Trabajador nuevoTrabajador = new Trabajador(
                    nombreField.getText(),
                    apellidoField.getText(),
                    rutField.getText(),
                    fonasaField.getText(),
                    isapreField.getText()
            );

            listaTrabajadores.add(nuevoTrabajador);
            nuevoTrabajador.leerDatos();

            limpiarCampos();
        } else if (e.getSource() == leerButton) {
            String rutBuscado = rutField.getText();
            Trabajador trabajadorEncontrado = buscarTrabajadorPorRut(rutBuscado);

            if (trabajadorEncontrado != null) {
                JOptionPane.showMessageDialog(this, "Trabajador encontrado:\n" + trabajadorEncontrado, "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Trabajador no encontrado", "Resultado de la búsqueda", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private Trabajador buscarTrabajadorPorRut(String rutBuscado) {
        for (Trabajador trabajador : listaTrabajadores) {
            if (trabajador.getRut().equals(rutBuscado)) {
                return trabajador;
            }
        }
        return null;
    }

    private void limpiarCampos() {
        nombreField.setText("");
        apellidoField.setText("");
        rutField.setText("");
        fonasaField.setText("");
        isapreField.setText("");
    }
}
