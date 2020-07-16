package layout.views;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FilterViews extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel FilterViews;
	public JLabel lblNewLabel;
	public JRadioButton FilterOption1;
	
	public JRadioButton FilterOption2;
	
	public JRadioButton FilterOption3;
	
	public JRadioButton FilterOption4;
	
	public JButton FilterButton;
	
	// for Filter Testing
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterViews frame = new FilterViews();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	
	
	public FilterViews() {
		
		
		initComponents();
		createEvents();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void createEvents() {

	}

	

	private void initComponents() {
		
	
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(FilterViews.class.getResource("/layout/resource/BugTracker.png")));
		setTitle("Bug Tracker 3000 - Filter Options\r\n");
		setResizable(false);
		
		setBounds(100, 100, 398, 348);
		FilterViews = new JPanel();
		FilterViews.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(FilterViews);
		
		lblNewLabel = new JLabel("Filter Options");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		FilterOption1 = new JRadioButton("5$\r\n");
		
		FilterOption2 = new JRadioButton("10$\r\n");
		
		FilterOption3 = new JRadioButton("15$");
		
		FilterOption4 = new JRadioButton("20$");
		
		FilterButton = new JButton("Submit\r\n");
		
		GroupLayout gl_FilterViews = new GroupLayout(FilterViews);
		gl_FilterViews.setHorizontalGroup(
			gl_FilterViews.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_FilterViews.createSequentialGroup()
					.addGap(125)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addGap(112))
				.addGroup(gl_FilterViews.createSequentialGroup()
					.addGap(117)
					.addGroup(gl_FilterViews.createParallelGroup(Alignment.LEADING)
						.addComponent(FilterButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_FilterViews.createSequentialGroup()
							.addComponent(FilterOption4)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_FilterViews.createSequentialGroup()
							.addComponent(FilterOption3)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_FilterViews.createSequentialGroup()
							.addComponent(FilterOption2)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_FilterViews.createSequentialGroup()
							.addComponent(FilterOption1)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(122))
		);
		gl_FilterViews.setVerticalGroup(
			gl_FilterViews.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FilterViews.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(FilterOption1)
					.addGap(18)
					.addComponent(FilterOption2)
					.addGap(18)
					.addComponent(FilterOption3)
					.addGap(18)
					.addComponent(FilterOption4)
					.addGap(18)
					.addComponent(FilterButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		FilterViews.setLayout(gl_FilterViews);
		
	}
}
