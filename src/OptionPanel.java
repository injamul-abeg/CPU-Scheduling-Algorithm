import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OptionPanel extends JPanel {
	static int k;
	int l;

	public OptionPanel() {
		setBackground(new Color(128, 128, 128));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("CPU Schedueling  Algorithm");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(50, 21, 344, 36);
		add(lblNewLabel);

		JButton btnFcfs = new JButton("First Come First Serve");
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				k = Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));
				FCFSpanel fcfs = new FCFSpanel();
				CPU_Schedueling.contentPane.add(fcfs, "fcfs");
				fcfs.setLayout(null);
				CPU_Schedueling.showPanel("fcfs");
			}
		});
		btnFcfs.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFcfs.setBounds(71, 145, 204, 23);
		add(btnFcfs);

		JButton btnNewButton = new JButton("Shortest-Job-First");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				k = Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));
				SJFpanel sjf = new SJFpanel();
				CPU_Schedueling.contentPane.add(sjf, "sjf");
				sjf.setLayout(null);
				CPU_Schedueling.showPanel("sjf");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(71, 209, 204, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Priority Scheduling");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				k = Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));
				PSpnl psp = new PSpnl();
				CPU_Schedueling.contentPane.add(psp, "ps");
				psp.setLayout(null);
				CPU_Schedueling.showPanel("ps");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(71, 276, 204, 23);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Round Robin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				k = Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));
				RobinPnl rrp = new RobinPnl();
				CPU_Schedueling.contentPane.add(rrp, "rr");
				rrp.setLayout(null);
				CPU_Schedueling.showPanel("rr");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(71, 341, 204, 23);
		add(btnNewButton_2);

		JLabel lblInOperatingSystem = new JLabel("in Operating System");
		lblInOperatingSystem.setForeground(new Color(255, 255, 255));
		lblInOperatingSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInOperatingSystem.setBounds(88, 68, 226, 23);
		add(lblInOperatingSystem);

	}

	public static int getInput() {
		return k;
	}
}