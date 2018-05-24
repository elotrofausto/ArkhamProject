package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class CombatView extends JFrame {

	private JLabel fondo, personaje, enemigo, damagePj, damageEne;
	private JButton fight;
	private GridBagConstraints c;
	private ArrayList<String> combate;
	private JProgressBar pjLife, eneLife;

	public CombatView(ArrayList<String> combate) {
		
		this.combate = combate;
		c = new GridBagConstraints();
		fondo = new JLabel(new ImageIcon("img/catedral.gif"));
		personaje = new JLabel(new ImageIcon("img/char.gif"));
		enemigo = new JLabel(new ImageIcon("img/" + combate.get(0) + "BIG" + ".gif"));
		damagePj = new JLabel("DAÑO PJ");
		damageEne = new JLabel("DAÑO ENE");
		fight = new JButton("Combate!");
		pjLife = new JProgressBar(0, 300);
		eneLife = new JProgressBar(0, 150);
		iniciarCombatView();
	}

	public void iniciarCombatView() {

		pjLife.setValue(100); // Fijar valor por defecto.
		pjLife.setStringPainted(true); // Mostrar valor numérico del progreso de la barra

		eneLife.setValue(100); // Fijar valor por defecto.
		eneLife.setStringPainted(true); // Mostrar valor numérico del progreso de la barra
		
		fondo.setLayout(new GridBagLayout());
		fight.setFont(new Font("", 1, 20));
		damagePj.setFont(new Font("", 1, 20));
		damagePj.setForeground(Color.RED);
		damageEne.setFont(new Font("", 1, 20));
		damageEne.setForeground(Color.RED);
		
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

		this.setSize(new Dimension(768, 368));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.requestFocus();
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
	
	
	
}
