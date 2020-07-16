package layout.views.AlertUI;

import javax.swing.JPanel;

import common.Alert.Alert;
import common.Team.Userhold;
import common.User.CurrentUserhold;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AlertCard extends JPanel {
	
	private JLabel AlertNameLabel;
	private JTextField MessageTextField;
	private JLabel AlertName;
	private JLabel SenderLabel;
	private JLabel SenderName;
	private JLabel SenderRole;
	private JLabel StatusLabel;
	private JLabel Status;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 * @param alert 
	 */
	


	public AlertCard(Alert alert) {
		
		setBackground(Color.LIGHT_GRAY);
		
		AlertNameLabel = new JLabel("Alert Name\r\n");
		
		AlertName = new JLabel(alert.getName());
		
		SenderLabel = new JLabel("Sender :\r\n");
		
		SenderName = new JLabel();
		for (int i = 0; i< Userhold.getUsers().size(); i++)
		if(alert.getSender()==(Userhold.getUsers().get(i).getID())){
			SenderName = new JLabel(Userhold.getUsers().get(i).getName());
		}
		
		
		
		for (int i = 0; i< Userhold.getUsers().size(); i++)
			if(alert.getSender()==(Userhold.getUsers().get(i).getID())){
				SenderRole = new JLabel(Userhold.getUsers().get(i).getRole().toString());
			}
		
		
		SenderRole = new JLabel();
		
		StatusLabel = new JLabel("Status: ");
		
		Status = new JLabel();
			if(alert.getSender()==(CurrentUserhold.getUser().getID())){
				Status = new JLabel("SENT");
			} else {
				Status = new JLabel("RECEIVED");
			}
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(AlertNameLabel)
								.addComponent(SenderLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(SenderRole)
								.addComponent(SenderName)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(AlertName, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(71)
									.addComponent(StatusLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Status, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(AlertNameLabel)
						.addComponent(AlertName)
						.addComponent(StatusLabel)
						.addComponent(Status))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(SenderLabel)
						.addComponent(SenderName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SenderRole)
					.addGap(9)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		MessageTextField = new JTextField(alert.getmessage());
		MessageTextField.setHorizontalAlignment(SwingConstants.LEFT);
		scrollPane.setViewportView(MessageTextField);
		MessageTextField.setColumns(10);
		setLayout(groupLayout);
		// TODO Auto-generated constructor stub
		initcomponent();
		eventhandler();
		
		
		
		
		
		
	}


	


	private void eventhandler() {
		// TODO Auto-generated method stub
		
	}

	private void initcomponent() {
		// TODO Auto-generated method stub
		
	}

}
