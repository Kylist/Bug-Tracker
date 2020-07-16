package layout.views.AlertUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import common.Alert.Alert;
import common.AlertBoard.AlertBoard;
import common.User.CurrentUserhold;
import layout.views.screen.ScreenUI;

public class AlertBoardUI extends JPanel {

	private AlertBoard board;

	/**
	 * Create the panel.
	 */
	public AlertBoardUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		board = new AlertBoard();
		initcomponent();
		eventhandler();
		renderAlertBoard(board.read());

	}

	private void renderAlertBoard(List<Alert> alerts) {
		// TODO Auto-generated method stub
		if (CurrentUserhold.getUser() != null) {
			// get all task of that particular board || pretty much a population call ||
			// tasks now hold all the task of that board

			// List<Alert> alerts = getAlertBoard().getAlerts();
			for (int i = 0; i < alerts.size(); i++) {
				Alert alert = alerts.get(i);
				//render by project 
				if (alert.getReceivers().contains(CurrentUserhold.getUser().getID())
						|| alert.getSender() == CurrentUserhold.getUser().getID()) {
					AlertCard card = new AlertCard(alert);

					card.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent me) {
							if (me.getClickCount() == 2) {
								AlertCardDetail details = new AlertCardDetail(alert);
								details.setVisible(true);
								details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

							} 
						}
					});
					this.add(card);
					ScreenUI.getAlertButton().setForeground(Color.RED);

				} else {
					
					ScreenUI.getAlertButton().setForeground(Color.BLACK);

				}
			}
		}
	}


	public void refresh() {
		this.getAlertBoard().refresh();
		 this.removeAll();
		renderAlertBoard(board.read());
	}

	public AlertBoard getAlertBoard() {
		// TODO Auto-generated method stub
		return this.board;
	}

	public void setAlertBoard(AlertBoard alertboard) {
		this.board = alertboard;
	}

	private void eventhandler() {
		// TODO Auto-generated method stub

	}

	private void initcomponent() {
		// TODO Auto-generated method stub

	}

}
