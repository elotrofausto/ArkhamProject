package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Logic.InicioModel;

@SuppressWarnings("serial")
public class InitView extends JFrame{
	
	private JLabel fondo;
	private JPanel recogidaDatos;
	private JLabel nombrePers, northTitle;
	private ButtonGroup checkBoxGroup;
	private JCheckBox facil, medio, dificil;
	private JButton continuar, salir;
	private JTextField nombre;
	private GridBagConstraints c = new GridBagConstraints();

	public InitView(InicioModel model) {
		fondo = new JLabel(new ImageIcon("img/giphy.gif"));
		northTitle = new JLabel(new ImageIcon("img/logo.png"));
		recogidaDatos = new JPanel();
		nombrePers = new JLabel(new ImageIcon("img/nombre.png"));
		nombre = new JTextField();
		checkBoxGroup = new ButtonGroup();
		facil = new JCheckBox("Fácil",false);
		medio = new JCheckBox("Medio",true);
		dificil = new JCheckBox("Dificil",false);
		continuar = new JButton("Continuar");
		salir = new JButton("Salir");
		c = new GridBagConstraints();
		iniciarVista();
	}
	
	public void iniciarVista() {
		nombre.setSize(20,20);
		nombrePers.setSize(100,100);
		nombre.setFont(new Font("", 1, 20));
		nombre.setBackground(new Color(0,0,0,90));
		nombre.setForeground(Color.WHITE);
		nombre.setText("Introduce tu nombre...");
		nombre.setPreferredSize(new Dimension(400,30));
		facil.setBackground(new Color(0,0,0,0));
		facil.setFont(new Font("", 1, 20));
		facil.setForeground(Color.WHITE);

		medio.setBackground(new Color(0,0,0,0));
		medio.setFont(new Font("", 1, 20));
		medio.setForeground(Color.WHITE);

		dificil.setBackground(new Color(0,0,0,0));
		dificil.setFont(new Font("", 1, 20));
		dificil.setForeground(Color.WHITE);

		facil.setPreferredSize(new Dimension(200,30));
		medio.setPreferredSize(new Dimension(200,30));
		dificil.setPreferredSize(new Dimension(200,30));
		checkBoxGroup.add(facil);
		checkBoxGroup.add(medio);
		checkBoxGroup.add(dificil);
		recogidaDatos.setLayout(new GridBagLayout());
		c.fill= GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		recogidaDatos.add(nombrePers, c);
		c.gridwidth=2;
		c.gridx = 1;
		c.gridy = 0;
		recogidaDatos.add(nombre, c);
		c.gridwidth=3;
		c.gridx = 0;
		c.gridy = 1;
		recogidaDatos.add(Box.createVerticalStrut(50), c);
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 2;
		recogidaDatos.add(facil, c);
		c.gridx = 1;
		c.gridy = 2;
		recogidaDatos.add(medio, c);
		c.gridx = 2;
		c.gridy = 2;
		recogidaDatos.add(dificil, c);
		c.gridwidth=3;
		c.gridx = 0;
		c.gridy = 3;
		recogidaDatos.add(Box.createVerticalStrut(50), c);
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 4;
		recogidaDatos.add(salir, c);
		c.gridx = 1;
		c.gridy = 4;
		recogidaDatos.add(Box.createHorizontalStrut(10), c);
		c.gridx = 2;
		c.gridy = 4;
		recogidaDatos.add(continuar, c);
		c.gridwidth=3;
		c.gridx = 0;
		c.gridy = 5;
		recogidaDatos.add(Box.createVerticalStrut(50), c);
		recogidaDatos.setBackground(new Color(0,0,0,0));
		fondo.setLayout(new BorderLayout());
		fondo.add(northTitle, BorderLayout.NORTH);
		fondo.add(recogidaDatos, BorderLayout.SOUTH);
		this.add(fondo);
		this.setSize(new Dimension(1200,500));
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}

	public JPanel getRecogidaDatos() {
		return recogidaDatos;
	}

	public void setRecogidaDatos(JPanel recogidaDatos) {
		this.recogidaDatos = recogidaDatos;
	}

	public JLabel getNombrePers() {
		return nombrePers;
	}

	public void setNombrePers(JLabel nombrePers) {
		this.nombrePers = nombrePers;
	}

	public JButton getContinuar() {
		return continuar;
	}

	public void setContinuar(JButton continuar) {
		this.continuar = continuar;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	public JCheckBox getFacil() {
		return facil;
	}

	public void setFacil(JCheckBox facil) {
		this.facil = facil;
	}

	public JCheckBox getMedio() {
		return medio;
	}

	public void setMedio(JCheckBox medio) {
		this.medio = medio;
	}

	public JCheckBox getDificil() {
		return dificil;
	}

	public void setDificil(JCheckBox dificil) {
		this.dificil = dificil;
	}
	
	
	
}
