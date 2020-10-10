
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class CPU_Schedueling extends JFrame {

	public static JPanel contentPane;
	private static CardLayout cardLayout;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPU_Schedueling frame = new CPU_Schedueling();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CPU_Schedueling() {
		super("CPU Schedueling Algorithm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		
		JPanel optionPanel = new OptionPanel();
		optionPanel.setBackground(new Color(128, 128, 128));
		contentPane.add(optionPanel, "option");
		optionPanel.setLayout(null);
		
		showPanel("option");
		
	}
	public static void showPanel(String name) {
		cardLayout.show(contentPane, name);
	}
}
