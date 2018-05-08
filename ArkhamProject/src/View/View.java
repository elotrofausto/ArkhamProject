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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JFrame{

	private BgLabel[][] arrayCasillas;
	private JLabel bg, statTitle, controlTitle, northTitle, fuerza, velocidad, oro, energia, sabiduria, hero, cthulhu;
	private BackGround tab;
	private JPanel stats, control, north;
	private Dimension screenSize, columna;
    private GraphicsEnvironment ge;
	private GraphicsDevice screen;
	private GridBagConstraints c = new GridBagConstraints();
	private Font fuente;
	
	public View() {
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		screen = ge.getDefaultScreenDevice();
		tab= new BackGround();
		stats= new JPanel();
		control= new JPanel();
		north= new JPanel();
		fuente = new Font("", 1, 20);
		fuerza = new JLabel("Fuerza");
		velocidad = new JLabel("Velocidad");
		oro = new JLabel("Oro");
		energia = new JLabel("Energía");
		sabiduria = new JLabel("Sabiduría");
		hero = new JLabel(new ImageIcon("img/hero2.png"));
		cthulhu = new JLabel(new ImageIcon("img/cth.png"));
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		columna=new Dimension ((int) ((screenSize.getWidth() - 975 )/2), (int) screenSize.getHeight()/2);
		bg= new JLabel(new ImageIcon("img/background.png"));
		statTitle= new JLabel("Personaje");
		controlTitle= new JLabel("Juego");
		northTitle= new JLabel(new ImageIcon("img/logo.png"));
		
		arrayCasillas = new BgLabel[8][15];
		for (int i=0; i<arrayCasillas.length; i++) {
			for (int j=0; j<arrayCasillas[0].length; j++) {
				
				//if ((i+j) %2 == 0)
				arrayCasillas[i][j]=new BgLabel("img/floor1.png");
				arrayCasillas[i][j].setIcon(new ImageIcon("img/blank.png"));
				//arrayCasillas[i][j].setSize(65, 65);
				arrayCasillas[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				tab.add(arrayCasillas[i][j]);
				
			}
		}
		initFrame();
	}

	private void initFrame() {
		
		//Stats
		stats.setPreferredSize(columna);
		stats.setBorder(BorderFactory.createRaisedBevelBorder());
		stats.setBackground( new Color(255, 0, 0, 80) );
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
		
		//Control
		control.setPreferredSize(columna);
		control.setBorder(BorderFactory.createRaisedBevelBorder());
		control.setBackground( new Color(0, 255, 0, 80) );
		control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));
		controlTitle.setForeground(Color.WHITE);
		controlTitle.setFont(fuente);
		control.add(controlTitle);
		control.add(cthulhu);
		
		//Title
		northTitle.setFont(fuente);
		north.add(northTitle);
		north.setBackground( new Color(0, 0, 0, 95) );
		
		//Tablero
		//tab.setSize(975,650);
		//tab.setBackground("img/tab_bg");
		tab.setLayout(new GridLayout(8,15,0,0));
		tab.setBackground( new Color(0, 0, 0, 99) );
		tab.setBorder(BorderFactory.createRaisedBevelBorder());
		
		//Frame principal
		this.setTitle("Arkham Project");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		
		//Organizamos los elementos con un GridBagLayout
		bg.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		bg.add(stats, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight = 1;
		bg.add(north, c);
		
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight = 2;
		bg.add(control, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		bg.add(tab, c);
		
		this.add(bg);
		this.setVisible(true);
		//screen.setFullScreenWindow(this); //Pantalla completa por encima del SO
	}
}
