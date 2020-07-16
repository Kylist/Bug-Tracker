package layout.views.AlertUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Alert.Alert;
import common.Team.Userhold;
import common.User.CurrentUserhold;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class AlertCardDetail extends JFrame {

	private JPanel contentPane;
	private JLabel SenderLabel;
	private JScrollPane scrollPane;
	private JLabel SenderName;
	private JLabel SenderRole;
	private JTextField textField;
	private JLabel AlertName;
	private JLabel StatusLabel;
	private JLabel Status;
	private JTextArea MessageTextField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param alert 
	 */
	public AlertCardDetail(Alert alert) {
		setTitle("Bug Tracker 3000 - Alert Details");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlertCardDetail.class.getResource("/layout/resource/BugTracker.png")));
		
		

		// TODO Auto-generated method stub
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		SenderLabel = new JLabel("Sender\r\n");
		
	
		
		
		
		scrollPane = new JScrollPane();
		SenderName = new JLabel();
		SenderRole = new JLabel();
		for (int i = 0; i< Userhold.getUsers().size(); i++)
			if(alert.getSender()==(Userhold.getUsers().get(i).getID())){
				SenderName = new JLabel(Userhold.getUsers().get(i).getName());
			}
			
			
			
			for (int i = 0; i< Userhold.getUsers().size(); i++)
				if(alert.getSender()==(Userhold.getUsers().get(i).getID())){
					SenderRole = new JLabel(Userhold.getUsers().get(i).getRole().toString());
				}
		
		AlertName = new JLabel(alert.getName());
		
		StatusLabel = new JLabel("Status :");
		
		Status = new JLabel();
		
		if(alert.getSender()==(CurrentUserhold.getUser().getID())){
			Status = new JLabel("SENT");
		} else {
			Status = new JLabel("RECEIVED");
		}
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(SenderLabel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(SenderRole)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(SenderName)
											.addGap(306)
											.addComponent(StatusLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(Status)))
									.addGap(145))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(253)
							.addComponent(AlertName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(256)))
					.addGap(6))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(SenderLabel)
							.addComponent(SenderName))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(Status)
							.addComponent(StatusLabel)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SenderRole)
					.addGap(28)
					.addComponent(AlertName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		MessageTextField_1 = new JTextArea();
		scrollPane.setViewportView(MessageTextField_1);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
		
		
	}
}
