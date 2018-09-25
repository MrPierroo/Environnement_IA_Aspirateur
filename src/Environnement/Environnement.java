package Environnement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;



public class Environnement extends JFrame {

	private final static int nbrOfGrid = 100;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Environnement frame = new Environnement();
					frame.setJMenuBar(createMenuBar());
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public Environnement() {

		//Get the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();									
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();

		//Config the interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(width/2-height/2-20, 0, height-40, height);
		setTitle("Environnement");
		setResizable(false);

		//Add the grid
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout((int)Math.sqrt(nbrOfGrid),(int)Math.sqrt(nbrOfGrid),1,1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		Border blackline = BorderFactory.createLineBorder(Color.black,1);

		for(int cases = 0; cases<nbrOfGrid; cases++){
			JPanel grid = new JPanel();
			grid.setBorder(blackline);
			contentPane.add(grid);
		}

		setContentPane(contentPane);
	}

	
	/**
	 * Create the menu
	 */
	
	public static JMenuBar createMenuBar() {

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rdmi;

		//Create the menu bar.
		menuBar = new JMenuBar();
		menuBar.repaint();

		//Build the simulationMenu
		menu = new JMenu("Simulation");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("Set event");
		menuBar.add(menu);

		//Create the item to restart the simulation
		menuItem = new JMenuItem("Restart");
		menuItem.setMnemonic(KeyEvent.VK_P);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_P, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Restart");
		menu.add(menuItem);

		//Create the groups to select the state
		menu.addSeparator();
		ButtonGroup groupRun = new ButtonGroup();
		rdmi = new JRadioButtonMenuItem("Running");
		rdmi.setSelected(true);
		rdmi.setMnemonic(KeyEvent.VK_R);
		groupRun.add(rdmi);
		menu.add(rdmi);

		rdmi = new JRadioButtonMenuItem("Pause");
		rdmi.setMnemonic(KeyEvent.VK_SPACE);
		groupRun.add(rdmi);
		menu.add(rdmi);

		//Create the groups to select the speed
		menu.addSeparator();
		ButtonGroup groupSpeed = new ButtonGroup();
		rdmi = new JRadioButtonMenuItem("Fast");
		rdmi.setSelected(true);
		rdmi.setMnemonic(KeyEvent.VK_F);
		groupSpeed.add(rdmi);
		menu.add(rdmi);

		rdmi = new JRadioButtonMenuItem("Slow");
		rdmi.setMnemonic(KeyEvent.VK_S);
		groupSpeed.add(rdmi);
		menu.add(rdmi);

		//Create the parameterMenu
		menu = new JMenu("Parameters");
		menu.setMnemonic(KeyEvent.VK_E);
		menu.getAccessibleContext().setAccessibleDescription(
				"Edit Menu");
		menuBar.add(menu);
		
		return menuBar;
		
	}
}

