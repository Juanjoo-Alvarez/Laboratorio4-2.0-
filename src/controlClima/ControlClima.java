package controlClima;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class ControlClima extends JFrame {

    private JButton btnEncendido;
    private JButton btnTempUp;
    private JButton btnTempDown;
    private JTextField textTemp;
    private JCheckBox checkAuto;
    private JSlider sliderIntensidad;
    private JCheckBox checkEco;
    private JComboBox<String> comboDireccion;
    private JSlider sliderAsientosDelanteros;
    private JSlider sliderAsientosTraseros;
    private JButton btnVerHistorial;
    private JButton btnAgendarMantenimiento;
    private JCheckBox checkDesempanador;
    
    public ControlClima() {
        setTitle("Control de Clima");
        setSize(450, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        // Botón Encendido
        btnEncendido = new JButton("Encendido");
        btnEncendido.setFont(new Font("Arial", Font.BOLD, 14));
        btnEncendido.setBounds(20, 10, 150, 30);
        panel.add(btnEncendido);
        
        // Temperatura
        JLabel labelTemp = new JLabel("Temperatura:");
        labelTemp.setFont(new Font("Arial", Font.PLAIN, 12));
        labelTemp.setBounds(20, 50, 100, 30);
        panel.add(labelTemp);
        
        btnTempUp = new JButton("+");
        btnTempUp.setBounds(120, 50, 45, 30);
        panel.add(btnTempUp);
        
        textTemp = new JTextField("25°C");
        textTemp.setHorizontalAlignment(JTextField.CENTER);
        textTemp.setEditable(false);
        textTemp.setBounds(175, 50, 50, 30);
        panel.add(textTemp);
        
        btnTempDown = new JButton("-");
        btnTempDown.setBounds(235, 50, 45, 30);
        panel.add(btnTempDown);
        
        checkAuto = new JCheckBox("Modo Automático");
        checkAuto.setBounds(290, 50, 150, 30);
        panel.add(checkAuto);
        
        // Ventilación
        JLabel labelVent = new JLabel("Ventilación:");
        labelVent.setFont(new Font("Arial", Font.BOLD, 14));
        labelVent.setBounds(20, 100, 100, 30);
        panel.add(labelVent);
        
        JLabel labelIntensidad = new JLabel("Intensidad");
        labelIntensidad.setFont(new Font("Arial", Font.PLAIN, 12));
        labelIntensidad.setBounds(20, 130, 100, 30);
        panel.add(labelIntensidad);
        
        sliderIntensidad = new JSlider(0, 3, 1);
        sliderIntensidad.setMajorTickSpacing(1);
        sliderIntensidad.setPaintTicks(true);
        sliderIntensidad.setPaintLabels(true);
        sliderIntensidad.setBounds(130, 130, 200, 50);
        panel.add(sliderIntensidad);
        
        checkEco = new JCheckBox("Modo Eco");
        checkEco.setBounds(340, 130, 100, 30);
        panel.add(checkEco);
        
        JLabel labelDireccion = new JLabel("Dirección");
        labelDireccion.setFont(new Font("Arial", Font.PLAIN, 12));
        labelDireccion.setBounds(20, 190, 100, 30);
        panel.add(labelDireccion);
        
        comboDireccion = new JComboBox<>(new String[] {"Todo", "Frente", "Abajo", "Arriba"});
        comboDireccion.setBounds(130, 190, 100, 30);
        panel.add(comboDireccion);
        
        // Calefacción
        JLabel labelCalef = new JLabel("Calefacción:");
        labelCalef.setFont(new Font("Arial", Font.BOLD, 14));
        labelCalef.setBounds(20, 240, 100, 30);
        panel.add(labelCalef);
        
        JLabel labelAsientosDelanteros = new JLabel("Asientos Delanteros");
        labelAsientosDelanteros.setFont(new Font("Arial", Font.PLAIN, 12));
        labelAsientosDelanteros.setBounds(20, 270, 120, 30);
        panel.add(labelAsientosDelanteros);
        
        sliderAsientosDelanteros = new JSlider(0, 3, 1);
        sliderAsientosDelanteros.setMajorTickSpacing(1);
        sliderAsientosDelanteros.setPaintTicks(true);
        sliderAsientosDelanteros.setPaintLabels(true);
        sliderAsientosDelanteros.setBounds(150, 270, 200, 50);
        panel.add(sliderAsientosDelanteros);
        
        JLabel labelAsientosTraseros = new JLabel("Asientos Traseros");
        labelAsientosTraseros.setFont(new Font("Arial", Font.PLAIN, 12));
        labelAsientosTraseros.setBounds(20, 330, 120, 30);
        panel.add(labelAsientosTraseros);
        
        sliderAsientosTraseros = new JSlider(0, 3, 1);
        sliderAsientosTraseros.setMajorTickSpacing(1);
        sliderAsientosTraseros.setPaintTicks(true);
        sliderAsientosTraseros.setPaintLabels(true);
        sliderAsientosTraseros.setBounds(150, 330, 200, 50);
        panel.add(sliderAsientosTraseros);
        
        // Mantenimiento
        JLabel labelMantenimiento = new JLabel("Mantenimiento:");
        labelMantenimiento.setFont(new Font("Arial", Font.BOLD, 14));
        labelMantenimiento.setBounds(20, 390, 100, 30);
        panel.add(labelMantenimiento);
        
        btnVerHistorial = new JButton("Ver Historial");
        btnVerHistorial.setBounds(130, 390, 120, 30);
        panel.add(btnVerHistorial);
        
        btnAgendarMantenimiento = new JButton("Agendar Mantenimiento");
        btnAgendarMantenimiento.setBounds(260, 390, 150, 30);
        panel.add(btnAgendarMantenimiento);
        
        // Desempañador
        checkDesempanador = new JCheckBox("Desempañador");
        checkDesempanador.setBounds(20, 430, 150, 30);
        panel.add(checkDesempanador);
        
        // Agregar el panel al marco
        add(panel);
        
        // Agregar funcionalidad al botón de encendido
        btnEncendido.addActionListener(new ActionListener() {
            private boolean encendido = true;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                encendido = !encendido;
                toggleComponents(encendido);
                btnEncendido.setText(encendido ? "Encendido" : "Apagado");
            }
        });
    }

    private void toggleComponents(boolean estado) {
        btnTempUp.setEnabled(estado);
        btnTempDown.setEnabled(estado);
        textTemp.setEnabled(estado);
        checkAuto.setEnabled(estado);
        sliderIntensidad.setEnabled(estado);
        checkEco.setEnabled(estado);
        comboDireccion.setEnabled(estado);
        sliderAsientosDelanteros.setEnabled(estado);
        sliderAsientosTraseros.setEnabled(estado);
        btnVerHistorial.setEnabled(estado);
        btnAgendarMantenimiento.setEnabled(estado);
        checkDesempanador.setEnabled(estado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControlClima frame = new ControlClima();
            frame.setVisible(true);
        });
    }
}

