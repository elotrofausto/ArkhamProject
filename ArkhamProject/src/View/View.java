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

	private Tablero model;
	private BgLabel[][] tableroCasillas;
	private JMenuBar mainMenu;
	private JMenu leyenda, salir;
	private JLabel bg, northTitle, fuerza, velocidad, oro, energia, sabiduria, movimientos, movVar, fuerzaVar, veloVar,
			oroVar, enerVar, sabVar, hero, cthulhu, controlInst;
	private JButton up, down, right, left, lanzarDado, finTurno;
	private BackGround tab;
	private JPanel stats, control, north, arrows, controlMov, controlStats, cabeceraS, cabeceraC, oroPanel, controlInfo;
	private Dimension screenSize, columna;
	private GridBagConstraints c = new GridBagConstraints();
	private Font fuente;
	private GraphicsEnvironment ge;
	private GraphicsDevice screen;

	public View(Tablero model) {
		this.model = model;
		// Elementos para configurar la pantalla completa y las dimensiones de
		// las
		// columnas
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		screen = ge.getDefaultScreenDevice();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		columna = new Dimension((int) ((screenSize.getWidth() - 975) / 2), (int) screenSize.getHeight() / 2);
		// Menú bar
		mainMenu = new JMenuBar();
		leyenda = new JMenu("Leyenda");
		salir = new JMenu("Salir");
		// Paneles de tablero, estadísticas, juego y título. Juntos componen la
		// pantalla
		// del videojuego
		tab = new BackGround();
		stats = new JPanel();
		control = new JPanel();
		north = new JPanel();
		arrows = new JPanel();
		controlMov = new JPanel();
		controlStats = new JPanel();
		cabeceraS = new JPanel();
		cabeceraC = new JPanel();
		oroPanel = new JPanel();
		controlInfo = new JPanel();
		fuerza = new JLabel("Fuerza");
		velocidad = new JLabel("Velocidad");
		oro = new JLabel("Oro");
		energia = new JLabel("Energía");
		sabiduria = new JLabel("Sabiduría");
		movimientos = new JLabel("Movs");
		fuerzaVar = new JLabel("1,00");
		veloVar = new JLabel("100,00");
		oroVar = new JLabel("1,00");
		enerVar = new JLabel("1,00");
		sabVar = new JLabel("1,00");
		movVar = new JLabel(String.valueOf(model.getMovimientos()));
		controlInst = new JLabel(new ImageIcon("img/controlInst2.png"));
		// Imágenes estéticas y fuentes. Botones de movimiento y juego.
		fuente = new Font("", 1, 20);
		bg = new JLabel(new ImageIcon("img/background.png"));
		northTitle = new JLabel(new ImageIcon("img/logo.png"));
		hero = new JLabel(new ImageIcon("img/pers.png"));
		cthulhu = new JLabel(new ImageIcon("img/game.png"));
		up = new JButton(new ImageIcon("img/up.png"));
		down = new JButton(new ImageIcon("img/down.png"));
		left = new JButton(new ImageIcon("img/left.png"));
		right = new JButton(new ImageIcon("img/right.png"));
		lanzarDado = new JButton("Lanzar Dado");
		finTurno = new JButton("Fin de turno");
		// Tablero de juego
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

		// Panel de Stats. Para este panel y algunos otros el layout es un
		// GridBagLayout. Permite crear un grid más
		// complejo que GridLayout.
		stats.setPreferredSize(columna);
		stats.setBorder(BorderFactory.createRaisedBevelBorder());
		stats.setBackground(new Color(255, 0, 0, 80));
		stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
		cabeceraS.setLayout(new GridBagLayout());
		cabeceraS.setBackground(new Color(0, 0, 0, 0));
		controlStats.setLayout(new GridLayout(5, 2));
		controlStats.setBackground(new Color(0, 0, 0, 0));
		oroPanel.setLayout(new GridBagLayout());
		oroPanel.setBackground(new Color(0, 0, 0, 0));
		controlInfo.setBackground(new Color(0, 0, 0, 0));
		fuerza.setForeground(Color.WHITE);
		fuerzaVar.setForeground(Color.WHITE);
		velocidad.setForeground(Color.WHITE);
		veloVar.setForeground(Color.WHITE);
		oro.setForeground(Color.WHITE);
		oroVar.setForeground(Color.WHITE);
		energia.setForeground(Color.WHITE);
		enerVar.setForeground(Color.WHITE);
		sabiduria.setForeground(Color.WHITE);
		sabVar.setForeground(Color.WHITE);

		fuerza.setFont(fuente);
		fuerzaVar.setFont(fuente);
		velocidad.setFont(fuente);
		veloVar.setFont(fuente);
		oro.setFont(fuente);
		oroVar.setFont(fuente);
		energia.setFont(fuente);
		enerVar.setFont(fuente);
		sabiduria.setFont(fuente);
		sabVar.setFont(fuente);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		oroPanel.add(oro, c);
		cabeceraS.add(hero, c);
		controlStats.add(fuerza, c);
		c.gridx = 1;
		c.gridy = 0;
		oroPanel.add(oroVar);
		controlStats.add(fuerzaVar, c);
		c.gridx = 0;
		c.gridy = 1;
		controlStats.add(velocidad, c);
		c.gridx = 1;
		c.gridy = 1;
		controlStats.add(veloVar, c);
		c.gridx = 0;
		c.gridy = 2;
		controlStats.add(energia, c);
		c.gridx = 1;
		c.gridy = 2;
		controlStats.add(enerVar, c);
		c.gridx = 0;
		c.gridy = 3;
		controlStats.add(sabiduria, c);
		c.gridx = 1;
		c.gridy = 3;
		controlStats.add(sabVar, c);
		controlInfo.add(controlInst);
		stats.add(cabeceraS);
		stats.add(controlStats);
		stats.add(oroPanel);
		stats.add(controlInfo);

		// Panel de juego.
		arrows.setLayout(new GridBagLayout());
		controlMov.setLayout(new GridBagLayout());
		up.setName("up");
		down.setName("down");
		left.setName("left");
		right.setName("right");
		lanzarDado.setName("lanzarDado");
		finTurno.setName("finTurno");
		up.setBackground(new Color(0, 0, 0, 0));
		up.setBorder(null);
		down.setBackground(new Color(0, 0, 0, 0));
		down.setBorder(null);
		left.setBackground(new Color(0, 0, 0, 0));
		left.setBorder(null);
		right.setBackground(new Color(0, 0, 0, 0));
		right.setBorder(null);
		cabeceraC.setBackground(new Color(0, 0, 0, 0));
		c.gridx = 0;
		c.gridy = 0;
		cabeceraC.add(cthulhu, c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.weightx = 0;
		arrows.add(up, c);
		c.gridx = 0;
		c.gridy = 1;
		arrows.add(left, c);
		c.gridx = 3;
		c.gridy = 1;
		arrows.add(right, c);
		c.gridx = 1;
		c.gridy = 2;
		arrows.add(down, c);
		c.gridx = 1;
		c.gridy = 0;
		movimientos.setFont(fuente);
		controlMov.add(movimientos, c);
		c.gridx = 0;
		c.gridy = 1;
		controlMov.add(lanzarDado, c);
		c.gridy = 1;
		c.gridx = 1;
		movVar.setFont(fuente);
		controlMov.add(movVar, c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		controlMov.add(finTurno, c);
		c.gridwidth = 1;
		arrows.setBackground(new Color(0, 0, 0, 0));
		controlMov.setBackground(new Color(0, 0, 0, 0));
		control.setPreferredSize(columna);
		control.setBorder(BorderFactory.createRaisedBevelBorder());
		control.setBackground(new Color(0, 255, 0, 80));
		control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));
		cthulhu.setHorizontalAlignment(JLabel.CENTER);
		control.add(cabeceraC);
		control.add(controlMov);
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
		screen.setFullScreenWindow(this); // Pantalla completa por encima de los
											// elementos del SO
	}

	public void efectuarMovimiento(String dir, int[] pos, String nombre) {
		switch (dir) {
		case "up":
			tableroCasillas[pos[0] + 1][pos[1]].setIcon(new ImageIcon("img/blank.png"));
			tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" + nombre + ".gif"));
			break;
		case "down":
			tableroCasillas[pos[0] - 1][pos[1]].setIcon(new ImageIcon("img/blank.png"));
			tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" + nombre + ".gif"));
			break;
		case "left":
			tableroCasillas[pos[0]][pos[1] + 1].setIcon(new ImageIcon("img/blank.png"));
			tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" + nombre + ".gif"));
			break;
		case "right":
			tableroCasillas[pos[0]][pos[1] - 1].setIcon(new ImageIcon("img/blank.png"));
			tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" + nombre + ".gif"));
			break;
		}

	}

	public void actualizaStats(int[] pos) {
		this.getFuerzaVar()
				.setText(String.format("%.2f", (float) model.getBoard()[pos[0]][pos[1]].getPj().getFuerza()));
		this.getVeloVar()
				.setText(String.format("%.2f", (float) model.getBoard()[pos[0]][pos[1]].getPj().getVelocidad()));
		this.getOroVar().setText(String.format("%.2f", (float) model.getBoard()[pos[0]][pos[1]].getPj().getOro()));
		this.getEnerVar()
				.setText(String.format("%.2f", (float) (model.getBoard()[pos[0]][pos[1]].getPj().getEnergía())));
		this.getSabVar()
				.setText(String.format("%.2f", (float) model.getBoard()[pos[0]][pos[1]].getPj().getSabiduría()));
		// this.tableroCasillas[pos[0]][pos[1]].setIcon(new ImageIcon("img/" +
		// this.model.getBoard()[pos[0]][pos[1]].getEdificio().getImage() +
		// ".gif"));
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

	public BackGround getTab() {
		return tab;
	}

	public void setTab(BackGround tab) {
		this.tab = tab;
	}

	public JLabel getMovVar() {
		return movVar;
	}

	public void setMovVar(JLabel movVar) {
		this.movVar = movVar;
	}

	public JLabel getFuerzaVar() {
		return fuerzaVar;
	}

	public void setFuerzaVar(JLabel fuerzaVar) {
		this.fuerzaVar = fuerzaVar;
	}

	public JLabel getVeloVar() {
		return veloVar;
	}

	public void setVeloVar(JLabel veloVar) {
		this.veloVar = veloVar;
	}

	public JLabel getOroVar() {
		return oroVar;
	}

	public void setOroVar(JLabel oroVar) {
		this.oroVar = oroVar;
	}

	public JLabel getEnerVar() {
		return enerVar;
	}

	public void setEnerVar(JLabel enerVar) {
		this.enerVar = enerVar;
	}

	public JLabel getSabVar() {
		return sabVar;
	}

	public void setSabVar(JLabel sabVar) {
		this.sabVar = sabVar;
	}

	public JButton getLanzarDado() {
		return lanzarDado;
	}

	public void setLanzarDado(JButton lanzarDado) {
		this.lanzarDado = lanzarDado;
	}

	public JButton getFinTurno() {
		return finTurno;
	}

	public void setFinTurno(JButton finTurno) {
		this.finTurno = finTurno;
	}

}
