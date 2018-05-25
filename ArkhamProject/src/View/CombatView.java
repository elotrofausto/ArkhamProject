package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class CombatView extends JDialog {

	private JLabel fondo, personaje, enemigo, damagePj, damageEne;
	private JButton fight;
	private GridBagConstraints c;
	private ArrayList<String> combate;
	private JProgressBar pjLife, eneLife;
	private GraphicsEnvironment ge;
	private GraphicsDevice screen;

	public CombatView(ArrayList<String> combate) {

		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		screen = ge.getDefaultScreenDevice();
		this.combate = combate;
		c = new GridBagConstraints();
		new JLabel();
		fondo = new JLabel(new ImageIcon("img/catedralBIG.gif"));
		personaje = new JLabel(new ImageIcon("img/char.gif"));
		enemigo = new JLabel(new ImageIcon("img/" + combate.get(0) + "BIG" + ".gif"));
		damagePj = new JLabel("");
		damageEne = new JLabel("");
		fight = new JButton("Combate!");
		pjLife = new JProgressBar(0, (int) Double.parseDouble(this.combate.get(1)));
		System.out.println((int) Double.parseDouble(this.combate.get(1)));
		eneLife = new JProgressBar(0, (int) Double.parseDouble(this.combate.get(2)));
		System.out.println((int) Double.parseDouble(this.combate.get(2)));
		iniciarCombatView();
	}

	public void iniciarCombatView() {

		pjLife.setValue((int) Double.parseDouble(this.combate.get(1))); // Fijar valor por defecto.
		pjLife.setStringPainted(true); // Mostrar valor numérico del progreso de la barra
		pjLife.setForeground(Color.GREEN);

		eneLife.setValue((int) Double.parseDouble(this.combate.get(2))); // Fijar valor por defecto.
		eneLife.setStringPainted(true); // Mostrar valor numérico del progreso de la barra
		eneLife.setForeground(Color.RED);
		
		fondo.setLayout(new GridBagLayout());
		fight.setFont(new Font("", 1, 20));
		damagePj.setFont(new Font("", 1, 20));
		damagePj.setForeground(Color.RED);
		damageEne.setFont(new Font("", 1, 20));
		damageEne.setForeground(Color.GRAY);
		
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 0;
		fondo.add(damagePj);
		c.gridx = 1;
		c.gridy = 0;
		fondo.add(Box.createVerticalStrut(100), c);
		c.gridx = 2;
		c.gridy = 0;
		fondo.add(damageEne);
		c.gridx = 0;
		c.gridy = 1;
		fondo.add(pjLife, c);
		c.gridx = 1;
		c.gridy = 1;
		fondo.add(Box.createVerticalStrut(20), c);
		c.gridx = 2;
		c.gridy = 1;
		fondo.add(eneLife, c);
		c.gridx = 0;
		c.gridy = 2;
		fondo.add(personaje, c);
		c.gridx = 1;
		c.gridy = 2;
		fondo.add(fight, c);
		c.weighty=1;
		c.gridx = 2;
		c.gridy = 2;
		fondo.add(enemigo, c);
		this.add(fondo);

		this.setUndecorated(true);
		this.setSize(new Dimension(768, 368));
		this.setLocationRelativeTo(null);
		this.requestFocus();
		this.setAlwaysOnTop(true);
		fondo.setBackground(Color.BLACK);
		screen.setFullScreenWindow(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
	
	@Override
	public void dispose() {
		combate.clear();
		super.dispose();
	}

	public JLabel getDamagePj() {
		return damagePj;
	}

	public void setDamagePj(JLabel damagePj) {
		this.damagePj = damagePj;
	}

	public JLabel getDamageEne() {
		return damageEne;
	}

	public void setDamageEne(JLabel damageEne) {
		this.damageEne = damageEne;
	}

	public JButton getFight() {
		return fight;
	}

	public void setFight(JButton fight) {
		this.fight = fight;
	}

	public ArrayList<String> getCombate() {
		return combate;
	}

	public void setCombate(ArrayList<String> combate) {
		this.combate = combate;
	}

	public JProgressBar getPjLife() {
		return pjLife;
	}

	public void setPjLife(JProgressBar pjLife) {
		this.pjLife = pjLife;
	}

	public JProgressBar getEneLife() {
		return eneLife;
	}

	public void setEneLife(JProgressBar eneLife) {
		this.eneLife = eneLife;
	}	
	
}
