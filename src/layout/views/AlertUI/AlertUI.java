package layout.views.AlertUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Alert.AlertHold;
import common.Project.Projecthold;
import common.Team.Userhold;
import common.User.CurrentUserhold;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AlertUI extends JFrame {

	private static JPanel contentPane;
	private static JButton SendAlertButton;
	private static JScrollPane AlertBoardPanel;
	private static JButton DeleteButton;
	private static AlertBoardUI alertboard;
	
	
	

	/**
	 * Create the frame.
	 * 
	 */
	public AlertUI() {
		setTitle("Bug Tracker 3000 - Alert System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlertUI.class.getResource("/layout/resource/BugTracker.png")));
		 
	        
	   
		initcomponent();
		eventhandler();
		addAlert();
	
	}
	
	
	
	public static void addAlert() {
		alertboard = new AlertBoardUI();
		// TODO Auto-generated method stub
		AlertBoardPanel.setViewportView(alertboard);
	}

	public static void eventhandler() {
		// TODO Auto-generated method stub
		SendAlertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlertSendUI alertsend = new AlertSendUI();
				int ID = AlertHold.getAlertList().get(AlertHold.getAlertList().size()-1).getID() + 1;
				alertsend.setIDint(ID);
				alertsend.getTeamDropDown().removeAllItems();
				for (int j = 0; j < Userhold.getUsers().size(); j++) {
	               
					
	                
	            } alertsend.setVisible(true);
			}
		});
		
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alertboard.removeAll();
			
			}
		});
		
		
		
	}

	public void initcomponent() {
		// TODO Auto-generated method stub
		setBounds(50, 50, 655, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		AlertBoardPanel = new JScrollPane();
		
		SendAlertButton = new JButton("Send Alert\r\n");
		DeleteButton = new JButton("Delete Alert\r\n\r\n");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(AlertBoardPanel, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(DeleteButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(SendAlertButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(AlertBoardPanel, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SendAlertButton)
					.addGap(11)
					.addComponent(DeleteButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
