package Com.OS.org;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoundRobin extends JFrame implements ActionListener {
	JButton jb[] = new JButton[3];
	JTextField jt1[], jt2[];
	JLabel jl[], jl1, jl2, jl3;
	JPanel jp, jp1;
	Container con;
	int k, p;
	String str[] = { "SUBMIT", "RESET", "EXIT" };
	String str1[] = { "Process", "   Arrival Time  ", "  Burst Time", "  Waiting Time  ", "  Finished Time  " };

	public RoundRobin() {
		super();
		con = getContentPane();

		k = Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));

		jl1 = new JLabel("Process");
		jl2 = new JLabel("Arival Time");
		jl3 = new JLabel("Burst Time");

		jl = new JLabel[k];
		jt1 = new JTextField[k];
		jt2 = new JTextField[k];

		for (int i = 0; i < k; i++) {
			jl[i] = new JLabel("process" + (i + 1));
			jt1[i] = new JTextField(10);
			jt2[i] = new JTextField(10);
		}

		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton(str[i]);
		}

		con.setLayout(new GridLayout(k + 2, 3));
		con.add(jl1);
		con.add(jl2);
		con.add(jl3);

		int l = 0;

		for (int i = 0; i < k; i++) {
			con.add(jl[l]);
			con.add(jt1[l]);
			con.add(jt2[l]);
			l++;
		}
		l = 0;
		for (int i = 0; i < 3; i++) {
			con.add(jb[l]);
			jb[l].addActionListener(this);
			l++;
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		int FT[] = new int[k];
		int AR[] = new int[k];
		int BR[] = new int[k];
		int WT[] = new int[k];

		float sum = 0;
		float avg;
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		jp = new JPanel();
		jp1 = new JPanel();
		jp.setLayout(new GridLayout(k + 1, 7));
		jp1.setLayout(new FlowLayout());

		if (ae.getSource() == jb[2]) {
			System.exit(0);
		} else if (ae.getSource() == jb[0]) {
			for (int i = 0; i < k; i++) {
				AR[i] = Integer.parseInt(jt1[i].getText());
				BR[i] = Integer.parseInt(jt2[i].getText());
			}
			for (int i = 0; i < k; i++) {
				for (int j = i + 1; j < k; j++) {
					if (AR[i] > AR[j]) {
						int temp = AR[i];
						AR[i] = AR[j];
						AR[j] = temp;
		
						int temp1 = BR[i];
						BR[i] = BR[j];
						BR[j] = temp1;
					}

				}
			}
			FT[0] = AR[0] + BR[0];

			for (int i = 0; i < k; i++) {
				if (i == 0) {
					WT[i] = 0;
				} else {
					if (FT[i - 1] < AR[i]) {
						FT[i] = AR[i] + BR[i];
						WT[i] = 0;
					} else {
						FT[i] = FT[i - 1] + BR[i];
						WT[i] = FT[i - 1] - AR[i];
					}

				}

				sum = sum + WT[i];

			}
			for (int i = 0; i < 5; i++) {
				jp.add(new JLabel(str1[i]));
			}
			for (int i = 0; i < k; i++) {
				jp.add(new JLabel("process" + (i + 1)));
				jp.add(new JLabel("       " + AR[i]));
				jp.add(new JLabel("       " + BR[i]));
				jp.add(new JLabel("       " + WT[i]));
				jp.add(new JLabel("       " + FT[i]));

			}
			avg = sum / k;
			String str2 = "Average Waiting Time is " + avg;
			jp1.add(new JLabel(str2));
			main.add(jp, BorderLayout.NORTH);
			main.add(jp1, BorderLayout.SOUTH);

			JOptionPane.showMessageDialog(null, main, "output", JOptionPane.PLAIN_MESSAGE);

		} else if (ae.getSource() == jb[1]) {
			setVisible(false);
			RoundRobin window = new RoundRobin();
			window.setSize(650, 500);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	}

	public static void main(String[] args) {
		RoundRobin window = new RoundRobin();
		window.setSize(650, 500);
		window.setBackground(Color.black);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
