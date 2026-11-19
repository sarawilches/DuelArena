package com.duelarena.vista;

import com.duelarena.modelo.CartaMonstruo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Vista principal implementada como JFrame Form de NetBeans.
 * El formulario visual está definido en VistaPrincipal.form; aquí solo se
 * personaliza su apariencia y se exponen datos/eventos para el controlador.
 */
public class VistaPrincipal extends JFrame {

    public VistaPrincipal() {
        initComponents();
        personalizarComponentes();
        setLocationRelativeTo(null);
    }

    //GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gbc;

        lblTitulo = new JLabel();
        lblSubtitulo = new JLabel();
        lblSeccionJugadores = new JLabel();
        lblJugador1 = new JLabel();
        lblJugador2 = new JLabel();
        txtJugador1 = new JTextField();
        txtJugador2 = new JTextField();
        btnIniciar = new JButton();

        lblSeccionCartas = new JLabel();
        lblNombreCarta = new JLabel();
        txtNombreCarta = new JTextField();
        lblAtaque = new JLabel();
        txtAtaque = new JTextField();
        lblDefensa = new JLabel();
        txtDefensa = new JTextField();
        lblDueno = new JLabel();
        cmbDueno = new JComboBox<>();
        lblPosicion = new JLabel();
        cmbPosicion = new JComboBox<>();
        lblTipo = new JLabel();
        cmbTipo = new JComboBox<>();
        lblEfecto = new JLabel();
        txtEfecto = new JTextField();
        btnAgregarCarta = new JButton();

        lblSeccionBatalla = new JLabel();
        lblJugadorAtacante = new JLabel();
        cmbJugadorAtacante = new JComboBox<>();
        lblCartaAtacante = new JLabel();
        cmbCartaAtacante = new JComboBox<>();
        lblCartaDefensora = new JLabel();
        cmbCartaDefensora = new JComboBox<>();
        btnAtacar = new JButton();
        btnAtaqueDirecto = new JButton();
        btnReportes = new JButton();

        lblLPJugador1 = new JLabel();
        lblLPJugador2 = new JLabel();
        lblHistorial = new JLabel();
        areaHistorial = new JTextArea();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Duel Arena | Fase de Batalla Yu-Gi-Oh!");
        setMinimumSize(new Dimension(1000, 760));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitulo.setText("DUEL ARENA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(12, 10, 2, 10);
        getContentPane().add(lblTitulo, gbc);

        lblSubtitulo.setText("SIMULADOR DE LA FASE DE BATALLA - YU-GI-OH!");
        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 12, 10);
        getContentPane().add(lblSubtitulo, gbc);

        lblSeccionJugadores.setText("1. CONFIGURAR DUELISTAS");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 10, 4, 10);
        getContentPane().add(lblSeccionJugadores, gbc);

        lblJugador1.setText("Jugador 1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblJugador1, gbc);
        txtJugador1.setColumns(18);
        txtJugador1.setToolTipText("Nombre del primer duelista");
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 12);
        getContentPane().add(txtJugador1, gbc);

        lblJugador2.setText("Jugador 2");
        gbc = new GridBagConstraints();
        gbc.gridx = 2; gbc.gridy = 3; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblJugador2, gbc);
        txtJugador2.setColumns(18);
        txtJugador2.setToolTipText("Nombre del segundo duelista");
        gbc = new GridBagConstraints();
        gbc.gridx = 3; gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 10);
        getContentPane().add(txtJugador2, gbc);

        btnIniciar.setText("Iniciar / reiniciar duelo");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 10, 10, 10);
        getContentPane().add(btnIniciar, gbc);

        lblSeccionCartas.setText("2. REGISTRAR MONSTRUO");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 10, 4, 10);
        getContentPane().add(lblSeccionCartas, gbc);

        lblNombreCarta.setText("Nombre de la carta");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 6; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblNombreCarta, gbc);
        txtNombreCarta.setColumns(18);
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 6; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 10);
        getContentPane().add(txtNombreCarta, gbc);

        lblAtaque.setText("ATQ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 7; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblAtaque, gbc);
        txtAtaque.setColumns(10);
        txtAtaque.setText("2500");
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 7; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 12);
        getContentPane().add(txtAtaque, gbc);

        lblDefensa.setText("DEF");
        gbc = new GridBagConstraints();
        gbc.gridx = 2; gbc.gridy = 7; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblDefensa, gbc);
        txtDefensa.setColumns(10);
        txtDefensa.setText("2100");
        gbc = new GridBagConstraints();
        gbc.gridx = 3; gbc.gridy = 7; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 10);
        getContentPane().add(txtDefensa, gbc);

        lblDueno.setText("Dueño");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 8; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblDueno, gbc);
        cmbDueno.setModel(new DefaultComboBoxModel<>(new String[]{"Jugador 1", "Jugador 2"}));
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 8; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 12);
        getContentPane().add(cmbDueno, gbc);

        lblPosicion.setText("Posición");
        gbc = new GridBagConstraints();
        gbc.gridx = 2; gbc.gridy = 8; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblPosicion, gbc);
        cmbPosicion.setModel(new DefaultComboBoxModel<>(new String[]{"Ataque", "Defensa"}));
        gbc = new GridBagConstraints();
        gbc.gridx = 3; gbc.gridy = 8; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 10);
        getContentPane().add(cmbPosicion, gbc);

        lblTipo.setText("Tipo de carta");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 9; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblTipo, gbc);
        cmbTipo.setModel(new DefaultComboBoxModel<>(new String[]{"Normal", "Efecto"}));
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 9; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 12);
        getContentPane().add(cmbTipo, gbc);

        lblEfecto.setText("Descripción del efecto");
        gbc = new GridBagConstraints();
        gbc.gridx = 2; gbc.gridy = 9; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblEfecto, gbc);
        txtEfecto.setColumns(18);
        txtEfecto.setToolTipText("Opcional para monstruos de efecto");
        gbc = new GridBagConstraints();
        gbc.gridx = 3; gbc.gridy = 9; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 10);
        getContentPane().add(txtEfecto, gbc);

        btnAgregarCarta.setText("Agregar monstruo al campo");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 10, 10, 10);
        getContentPane().add(btnAgregarCarta, gbc);

        lblSeccionBatalla.setText("3. FASE DE BATALLA");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 11; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 10, 4, 10);
        getContentPane().add(lblSeccionBatalla, gbc);

        lblJugadorAtacante.setText("Jugador que ataca");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 12; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblJugadorAtacante, gbc);
        cmbJugadorAtacante.setModel(new DefaultComboBoxModel<>(new String[]{"Jugador 1", "Jugador 2"}));
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 12; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 12);
        getContentPane().add(cmbJugadorAtacante, gbc);

        lblCartaAtacante.setText("Monstruo atacante");
        gbc = new GridBagConstraints();
        gbc.gridx = 2; gbc.gridy = 12; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblCartaAtacante, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3; gbc.gridy = 12; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 10);
        getContentPane().add(cmbCartaAtacante, gbc);

        lblCartaDefensora.setText("Monstruo defensor");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 13; gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 4, 5);
        getContentPane().add(lblCartaDefensora, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1; gbc.gridy = 13; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; gbc.insets = new Insets(4, 5, 4, 10);
        getContentPane().add(cmbCartaDefensora, gbc);

        btnAtacar.setText("Atacar monstruo seleccionado");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 14; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 10, 8, 6);
        getContentPane().add(btnAtacar, gbc);
        btnAtaqueDirecto.setText("Ataque directo");
        gbc = new GridBagConstraints();
        gbc.gridx = 2; gbc.gridy = 14; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 6, 8, 6);
        getContentPane().add(btnAtaqueDirecto, gbc);
        btnReportes.setText("Generar reportes");
        gbc = new GridBagConstraints();
        gbc.gridx = 3; gbc.gridy = 14; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 6, 8, 10);
        getContentPane().add(btnReportes, gbc);

        lblLPJugador1.setText("Jugador 1: 8000 LP");
        lblLPJugador1.setHorizontalAlignment(SwingConstants.CENTER);
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 15; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 10, 4, 10);
        getContentPane().add(lblLPJugador1, gbc);
        lblLPJugador2.setText("Jugador 2: 8000 LP");
        lblLPJugador2.setHorizontalAlignment(SwingConstants.CENTER);
        gbc = new GridBagConstraints();
        gbc.gridx = 2; gbc.gridy = 15; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 10, 4, 10);
        getContentPane().add(lblLPJugador2, gbc);

        lblHistorial.setText("HISTORIAL DE COMBATE");
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 16; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 10, 4, 10);
        getContentPane().add(lblHistorial, gbc);
        areaHistorial.setColumns(75);
        areaHistorial.setRows(6);
        areaHistorial.setEditable(false);
        areaHistorial.setLineWrap(true);
        areaHistorial.setWrapStyleWord(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 17; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; gbc.weighty = 1.0; gbc.insets = new Insets(4, 10, 12, 10);
        getContentPane().add(areaHistorial, gbc);

        pack();
    }
    //GEN-END:initComponents

    private void personalizarComponentes() {
        Color fondo = new Color(16, 23, 42);
        Color fondoCampo = new Color(239, 243, 250);
        Color texto = new Color(226, 234, 248);
        Color dorado = new Color(242, 193, 78);
        getContentPane().setBackground(fondo);
        setMinimumSize(new Dimension(1000, 760));
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblTitulo.setForeground(dorado);
        lblSubtitulo.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblSubtitulo.setForeground(new Color(185, 199, 224));
        for (JLabel label : new JLabel[]{lblSeccionJugadores, lblSeccionCartas, lblSeccionBatalla, lblHistorial}) {
            label.setFont(new Font("SansSerif", Font.BOLD, 16));
            label.setForeground(dorado);
            label.setBorder(new EmptyBorder(4, 2, 4, 2));
        }
        for (JLabel label : new JLabel[]{lblJugador1, lblJugador2, lblNombreCarta, lblAtaque,
                lblDefensa, lblDueno, lblPosicion, lblTipo, lblEfecto, lblJugadorAtacante,
                lblCartaAtacante, lblCartaDefensora, lblLPJugador1, lblLPJugador2}) {
            label.setFont(new Font("SansSerif", Font.BOLD, 12));
            label.setForeground(texto);
        }
        for (JTextField campo : new JTextField[]{txtJugador1, txtJugador2, txtNombreCarta,
                txtAtaque, txtDefensa, txtEfecto}) {
            campo.setFont(new Font("SansSerif", Font.PLAIN, 13));
            campo.setBackground(fondoCampo);
            campo.setForeground(new Color(24, 34, 54));
        }
        for (JComboBox<?> combo : new JComboBox<?>[]{cmbDueno, cmbPosicion, cmbTipo,
                cmbJugadorAtacante, cmbCartaAtacante, cmbCartaDefensora}) {
            combo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        }
        configurarBoton(btnIniciar, new Color(169, 117, 28));
        configurarBoton(btnAgregarCarta, new Color(42, 115, 100));
        configurarBoton(btnAtacar, new Color(169, 61, 61));
        configurarBoton(btnAtaqueDirecto, new Color(169, 117, 28));
        configurarBoton(btnReportes, new Color(52, 82, 125));
        lblLPJugador1.setForeground(dorado);
        lblLPJugador2.setForeground(dorado);
        areaHistorial.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaHistorial.setBackground(new Color(9, 14, 28));
        areaHistorial.setForeground(new Color(216, 226, 245));
        areaHistorial.setBorder(new EmptyBorder(8, 10, 8, 10));
    }

    private void configurarBoton(JButton boton, Color fondo) {
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setForeground(Color.WHITE);
        boton.setBackground(fondo);
        boton.setFocusPainted(false);
        boton.setOpaque(true);
        boton.setBorder(new EmptyBorder(9, 12, 9, 12));
    }

    public void onIniciar(ActionListener listener) { btnIniciar.addActionListener(listener); }
    public void onAgregarCarta(ActionListener listener) { btnAgregarCarta.addActionListener(listener); }
    public void onAtacar(ActionListener listener) { btnAtacar.addActionListener(listener); }
    public void onAtaqueDirecto(ActionListener listener) { btnAtaqueDirecto.addActionListener(listener); }
    public void onReportes(ActionListener listener) { btnReportes.addActionListener(listener); }
    public void onCambioJugadorAtacante(ActionListener listener) { cmbJugadorAtacante.addActionListener(listener); }

    public String getNombreJugador1() { return txtJugador1.getText(); }
    public String getNombreJugador2() { return txtJugador2.getText(); }
    public String getNombreCarta() { return txtNombreCarta.getText(); }
    public String getAtaqueTexto() { return txtAtaque.getText(); }
    public String getDefensaTexto() { return txtDefensa.getText(); }
    public String getEfectoTexto() { return txtEfecto.getText(); }
    public int getIndiceDueno() { return cmbDueno.getSelectedIndex(); }
    public int getIndicePosicion() { return cmbPosicion.getSelectedIndex(); }
    public int getIndiceTipo() { return cmbTipo.getSelectedIndex(); }
    public int getIndiceJugadorAtacante() { return cmbJugadorAtacante.getSelectedIndex(); }
    public CartaMonstruo getCartaAtacanteSeleccionada() { return (CartaMonstruo) cmbCartaAtacante.getSelectedItem(); }
    public CartaMonstruo getCartaDefensoraSeleccionada() { return (CartaMonstruo) cmbCartaDefensora.getSelectedItem(); }

    public void setCartasAtacantes(List<CartaMonstruo> cartas) {
        cmbCartaAtacante.setModel(new DefaultComboBoxModel<>(cartas.toArray(CartaMonstruo[]::new)));
    }

    public void setCartasDefensoras(List<CartaMonstruo> cartas) {
        cmbCartaDefensora.setModel(new DefaultComboBoxModel<>(cartas.toArray(CartaMonstruo[]::new)));
    }

    public void setPuntosVida(String jugador1, int lp1, String jugador2, int lp2) {
        lblLPJugador1.setText(jugador1 + ": " + lp1 + " LP");
        lblLPJugador2.setText(jugador2 + ": " + lp2 + " LP");
    }

    public void agregarAlHistorial(String texto) {
        areaHistorial.append(texto + System.lineSeparator());
        areaHistorial.setCaretPosition(areaHistorial.getDocument().getLength());
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Duel Arena - Validación", JOptionPane.WARNING_MESSAGE);
    }

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Duel Arena", JOptionPane.INFORMATION_MESSAGE);
    }

    //GEN-BEGIN:variables
    private JLabel lblTitulo;
    private JLabel lblSubtitulo;
    private JLabel lblSeccionJugadores;
    private JLabel lblJugador1;
    private JLabel lblJugador2;
    private JTextField txtJugador1;
    private JTextField txtJugador2;
    private JButton btnIniciar;
    private JLabel lblSeccionCartas;
    private JLabel lblNombreCarta;
    private JTextField txtNombreCarta;
    private JLabel lblAtaque;
    private JTextField txtAtaque;
    private JLabel lblDefensa;
    private JTextField txtDefensa;
    private JLabel lblDueno;
    private JComboBox<String> cmbDueno;
    private JLabel lblPosicion;
    private JComboBox<String> cmbPosicion;
    private JLabel lblTipo;
    private JComboBox<String> cmbTipo;
    private JLabel lblEfecto;
    private JTextField txtEfecto;
    private JButton btnAgregarCarta;
    private JLabel lblSeccionBatalla;
    private JLabel lblJugadorAtacante;
    private JComboBox<String> cmbJugadorAtacante;
    private JLabel lblCartaAtacante;
    private JComboBox<CartaMonstruo> cmbCartaAtacante;
    private JLabel lblCartaDefensora;
    private JComboBox<CartaMonstruo> cmbCartaDefensora;
    private JButton btnAtacar;
    private JButton btnAtaqueDirecto;
    private JButton btnReportes;
    private JLabel lblLPJugador1;
    private JLabel lblLPJugador2;
    private JLabel lblHistorial;
    private JTextArea areaHistorial;
    //GEN-END:variables
}
