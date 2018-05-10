package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Model.Logic.Tablero;

@SuppressWarnings("serial")
public class View extends JFrame {

	private BgLabel[][] tableroCasillas;
	private JMenuBar mainMenu;
	private JMenu leyenda, salir;
	private JLabel bg, statTitle, controlTitle, northTitle, fuerza, velocidad, oro, energia, sabiduria, hero, cthulhu;
	private JButton up, down, right, left;
	private BackGround tab;
	private JPanel stats, control, north, arrows;
	private Dimension screenSize, columna;
	private GraphicsEnvironment ge;
	private GraphicsDevice screen;
	private GridBagConstraints c = new GridBagConstraints();
	private Font fuente;

	public View(Tablero model) {
		//Elementos para configurar la pantalla completa y las dimensiones de las columnas
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		screen = ge.getDefaultScreenDevice();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		columna = new Dimension((int) ((screenSize.getWidth() - 975) / 2), (int) screenSize.getHeight() / 2);
		//Menú bar
		mainMenu = new JMenuBar();
		leyenda = new JMenu("Leyenda");
		salir = new JMenu("Salir");
		//Paneles de tablero, estadísticas, juego y título. Juntos componen la pantalla del videojuego
		tab = new BackGround();
		stats = new JPanel();
		control = new JPanel();
		north = new JPanel();
		arrows = new JPanel();
		fuerza = new JLabel("Fuerza");
		velocidad = new JLabel("Velocidad");
		oro = new JLabel("Oro");
		energia = new JLabel("Energía");
		sabiduria = new JLabel("Sabiduría");
		//Imágenes estéticas y fuentes. Botones de movimiento.
		fuente = new Font("", 1, 20);
		bg = new JLabel(new ImageIcon("img/background.png"));
		statTitle = new JLabel("Personaje");
		controlTitle = new JLabel("Juego");
		northTitle = new JLabel(new ImageIcon("img/logo.png"));
		hero = new JLabel(new ImageIcon("img/hero2.png"));
		cthulhu = new JLabel(new ImageIcon("img/cth.png"));
		up= new JButton(new ImageIcon("img/up.png"));
		down= new JButton(new ImageIcon("img/down.png"));
		left= new JButton(new ImageIcon("img/left.png"));
		right= new JButton(new ImageIcon("img/right.png"));
		//Tablero de juego
		tableroCasillas = new BgLabel[8][15];
		for (int i = 0; i < tableroCasillas.length; i++) {
			for (int j = 0; j < tableroCasillas[0].length; j++) {
				tableroCasillas[i][j] = new BgLabel("img/" + model.getBoard()[i][j].getEdificio().getImage() + ".png");
				if (model.getBoard()[i][j].getPj() == null) {
					tableroCasillas[i][j].setIcon(new ImageIcon("img/blank.png"));
				} else {
					tableroCasillas[i][j]
							.setIcon(new ImageIcon("img/" + model.getBoard()[i][j].getPj().getNombre() + ".gif"));
				}
				tab.add(tableroCasillas[i][j]);
			}
		}
		initFrame();
	}

	private void initFrame() {

		// JMenu
		mainMenu.add(leyenda);
		mainMenu.add(salir);
		mainMenu.setVisible(true);

		// Panel de Stats
		stats.setPreferredSize(columna);
		stats.setBorder(BorderFactory.createRaisedBevelBorder());
		stats.setBackground(new Color(255, 0, 0, 80));
		stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
		statTitle.setForeground(Color.WHITE);
		statTitle.setFont(fuente);
		fuerza.setForeground(Color.WHITE);
		velocidad.setForeground(Color.WHITE);
		oro.setForeground(Color.WHITE);
		energia.setForeground(Color.WHITE);
		sabiduria.setForeground(Color.WHITE);
		stats.add(statTitle);
		stats.add(hero);
		stats.add(fuerza);
		stats.add(velocidad);
		stats.add(oro);
		stats.add(energia);
		stats.add(sabiduria);

		// Panel de juego
		arrows.setLayout(new GridLayout(3,3));
		arrows.setSize(100,100);
		up.setName("up"); down.setName("down"); left.setName("left"); right.setName("right");
		arrows.add(up);
		arrows.add(down);
		arrows.add(left);
		arrows.add(right);
		control.setPreferredSize(columna);
		control.setBorder(BorderFactory.createRaisedBevelBorder());
		control.setBackground(new Color(0, 255, 0, 80));
		control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));
		controlTitle.setForeground(Color.WHITE);
		controlTitle.setFont(fuente);
		control.add(controlTitle);
		control.add(cthulhu);
		control.add(arrows);

		// Title
		northTitle.setFont(fuente);
		north.add(northTitle);
		north.setBackground(new Color(0, 0, 0, 95));

		// Tablero
		tab.setLayout(new GridLayout(8, 15, 0, 0));
		tab.setBackground(new Color(0, 0, 0, 99));
		tab.setBorder(BorderFactory.createRaisedBevelBorder());

		// Frame principal
		this.setTitle("Arkham Project");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setUndecorated(true);

		// Organizamos los elementos con un GridBagLayout
		bg.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		bg.add(stats, c);

		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		bg.add(north, c);

		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		bg.add(control, c);

		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		bg.add(tab, c);

		this.add(bg);
		this.setJMenuBar(mainMenu);
		this.setVisible(true);
		screen.setFullScreenWindow(this); // Pantalla completa por encima de los elementos del SO
	}

	public void efectuarMovimiento(String dir, int[] pos, String nombre) {
		switch (dir) {
		case "up":
			tableroCasillas[pos[0]+1][pos[1]].setIcon(new ImageIcon("img/blank.png"));
			tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" + nombre + ".gif"));
			break;
		case "down":
			tableroCasillas[pos[0]-1][pos[1]].setIcon(new ImageIcon("img/blank.png"));
			tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" + nombre + ".gif"));
			break;
		case "left":
			tableroCasillas[pos[0]][pos[1]+1].setIcon(new ImageIcon("img/blank.png"));
			tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" + nombre + ".gif"));
			break;
		case "right":
			tableroCasillas[pos[0]][pos[1]-1].setIcon(new ImageIcon("img/blank.png"));
			tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" + nombre + ".gif"));
			break;
		}

	}

	// Getters y Setters
	public JMenu getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(JMenu leyenda) {
		this.leyenda = leyenda;
	}

	public JMenu getSalir() {
		return salir;
	}

	public void setSalir(JMenu salir) {
		this.salir = salir;
	}

	public BgLabel[][] getTableroCasillas() {
		return tableroCasillas;
	}

	public void setTableroCasillas(BgLabel[][] tableroCasillas) {
		this.tableroCasillas = tableroCasillas;
	}

	public JButton getUp() {
		return up;
	}

	public void setUp(JButton up) {
		this.up = up;
	}

	public JButton getDown() {
		return down;
	}

	public void setDown(JButton down) {
		this.down = down;
	}

	public JButton getRight() {
		return right;
	}

	public void setRight(JButton right) {
		this.right = right;
	}

	public JButton getLeft() {
		return left;
	}

	public void setLeft(JButton left) {
		this.left = left;
	}

	
	
}
