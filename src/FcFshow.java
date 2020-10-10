import javax.swing.JPanel;




import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;

public class FcFshow extends JPanel{
	JLabel showlbl[];
	Graphics g = getGraphics();
	// JLabel proslbl[],arvlbl[],burstlbl[],waitlbl[],finshlbl[];
	static int AR[], BR[], k,FT[];
int p[];
	public FcFshow() {
		setBackground(new Color(128, 128, 128));
		setLayout(null);

		k = OptionPanel.getInput();
		JPanel showpanel = new JPanel();
		showpanel.setBackground(Color.WHITE);
		showpanel.setBounds(10, 86, 652, 215);
		showpanel.setLayout(new GridLayout(k, 5));
		add(showpanel);

		JLabel lblProcess = new JLabel("Process");
		lblProcess.setForeground(new Color(255, 255, 255));
		lblProcess.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProcess.setBounds(34, 52, 54, 23);
		add(lblProcess);

		JLabel lblArrivalTime = new JLabel("Arrival time");
		lblArrivalTime.setForeground(new Color(255, 255, 255));
		lblArrivalTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArrivalTime.setBounds(134, 52, 77, 23);
		add(lblArrivalTime);

		JLabel lblBurstTime = new JLabel("Burst time");
		lblBurstTime.setForeground(new Color(255, 255, 255));
		lblBurstTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBurstTime.setBounds(268, 52, 69, 23);
		add(lblBurstTime);

		JLabel lblWaitingTime = new JLabel("Waiting time");
		lblWaitingTime.setForeground(new Color(255, 255, 255));
		lblWaitingTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWaitingTime.setBounds(392, 52, 89, 23);
		add(lblWaitingTime);

		JLabel lblFinishedTime = new JLabel("TurnArround Time");
		lblFinishedTime.setForeground(new Color(255, 255, 255));
		lblFinishedTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFinishedTime.setBounds(519, 52, 111, 23);
		add(lblFinishedTime);
		
		JLabel lblAverageWaitingTime = new JLabel();
		lblAverageWaitingTime.setForeground(new Color(255, 255, 255));
		lblAverageWaitingTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAverageWaitingTime.setBounds(22, 335, 286, 23);
		add(lblAverageWaitingTime);
		
		JLabel lblAvgtat = new JLabel();
		lblAvgtat.setForeground(new Color(255, 255, 255));
		lblAvgtat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAvgtat.setBounds(370, 335, 273, 23);
		add(lblAvgtat);

		JButton btnShow = new JButton("Show Result");
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showlbl = new JLabel[k];
				FT = new int[k];
				int WT[] = new int[k];
//				for (int i = 0; i < k; i++) {
//					// System.out.println(AR[i]+" "+BR[i]);
//
//				}
				float totalWait = 0;
				float totalTaT=0;
				float avgWait;
				float avgTaT;
				//

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

					totalWait +=  WT[i];
					totalTaT += FT[i];
				}

				 for (int i = 0; i < k; i++) {
				 showpanel.add(new JLabel("    Process " + (i + 1)+" : "));
				 showpanel.add(new JLabel("    " + AR[i]));
				 showpanel.add(new JLabel("    " + BR[i]));
				 showpanel.add(new JLabel("    " + WT[i]));
				 showpanel.add(new JLabel("    " + FT[i]));
				 }
				
				avgWait = totalWait / k;
				avgTaT= totalTaT/k;
               lblAverageWaitingTime.setText("Average waiting time : "+ String.valueOf(avgWait));
               lblAvgtat.setText("Average Turnaround time : "+ String.valueOf(avgTaT));
			}

		});
		btnShow.setBounds(175, 11, 125, 23);
		add(btnShow);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CPU_Schedueling.showPanel("fcfs");
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(344, 11, 111, 24);
		add(btnBack);
		

	}

	public static void setData(ArrayList<Integer> ar, ArrayList<Integer> br, int k) {
		AR = new int[k];
		BR = new int[k];

		for (int i = 0; i < ar.size(); i++) {
			AR[i] = ar.get(i);
		}
		for (int i = 0; i < br.size(); i++) {
			BR[i] = br.get(i);
		}
	}
	
}
