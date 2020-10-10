import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.soap.AttachmentPart;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RobinPnl extends JPanel {
	JTextField text1[], text2[];
	JLabel jlbl[];
	static int k, p;
	static String art, brt;
	static ArrayList<Integer> ar=new ArrayList<>();
	static ArrayList<Integer> br=new ArrayList<>();
	public RobinPnl() {
		// super();
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		JPanel inputpanel = new JPanel();
		inputpanel.setBackground(new Color(210, 180, 140));
		inputpanel.setBounds(10, 53, 580, 345);
		add(inputpanel);
		
		k = OptionPanel.getInput();
		//System.out.println("k="+k);
		
		jlbl = new JLabel[k];
		text1 = new JTextField[k];
		text2 = new JTextField[k];

		for (int i = 0; i < k; i++) {
			jlbl[i] = new JLabel("          Process : " + (i + 1));
			jlbl[i].setFont(new Font("Tahoma", Font.BOLD, 12));
			text1[i] = new JTextField(10);
			text1[i].setFont(new Font("Tahoma", Font.BOLD, 12));
			text2[i] = new JTextField(10);
			text2[i].setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		inputpanel.setLayout(new GridLayout(k, 3));
		int p = 0;
		for (int i = 0; i < k; i++) {
			inputpanel.add(jlbl[p]);
			inputpanel.add(text1[p]);
			inputpanel.add(text2[p]);
			p++;
		}
		JLabel lblNewLabel = new JLabel("Process");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(54, 11, 105, 31);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Arrival Time");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(235, 11, 138, 31);
		add(lblNewLabel_1);

		JLabel lblB = new JLabel("Burst Time");
		lblB.setForeground(new Color(255, 255, 255));
		lblB.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblB.setBounds(434, 11, 138, 31);
		add(lblB);

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				input(k);
				
				//System.out.println(ar);
				RobinShowpnl.setData(ar, br, k);
				RobinShowpnl rrshow = new RobinShowpnl();
				CPU_Schedueling.contentPane.add(rrshow, "Robinshow");
				CPU_Schedueling.showPanel("Robinshow");
			}

			private void input(int k)
			{
				for (int i = 0; i < k; i++) 
				{
					String s1=text1[i].getText();
					String s2=text2[i].getText();
					
					int a = Integer.parseInt(s1);
					int b = Integer.parseInt(s2);
					//System.out.println(AR[i]+"  "+BR[i]);
					ar.add(a);
					br.add(b);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(45, 417, 89, 31);
		add(btnNewButton);



		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < k; i++) {
					text1[i].setText(null);
					text2[i].setText(null);
					}
				CPU_Schedueling.showPanel("option");
			}
		});
		btnNewButton_2.setBounds(441, 417, 89, 31);
		add(btnNewButton_2);

	}
}
