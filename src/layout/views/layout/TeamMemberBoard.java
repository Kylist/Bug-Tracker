package layout.views.layout;


import common.Project.Projecthold;
import common.Team.Userhold;
import java.awt.EventQueue;
import common.Enum.Role;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TeamMemberBoard extends JFrame {

	private JPanel contentPane;
	private static JTable MemberTable;
	private JButton AddingRow;
	private JButton Delete;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamMemberBoard frame = new TeamMemberBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public TeamMemberBoard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeamMemberBoard.class.getResource("/layout/resource/BugTracker.png")));
		setTitle("Bug Tracker - Team Member Board");
		
		initcomponent();
		eventHandler();
		renderMemberUI();
	
		
		
	}
	
	
	
	public void renderMemberUI() {
		((DefaultTableModel)MemberTable.getModel()).setNumRows(0);
		MemberTable.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[]  {
					"ID", "Name", "Email", "Role", "Project 1 ", "Project 2", "Available"
				}
			));
        

        for (int i = 0; i < Userhold.getUsers().size(); i++) {
        	
        	
            //all projecti chosen. All team member will be displayed
           
            	if (Userhold.getUsers().get(i).getRole() != Role.ADMIN && Userhold.getUsers().get(i).getRole() != Role.PROJECT_MANAGER) {
            	DefaultTableModel model =(DefaultTableModel) MemberTable.getModel();
				int a;
				model.addRow(new Object[] {
						
						a = Userhold.getUsers().get(i).getID(),
						Userhold.getUsers().get(i).getName(),
						Userhold.getUsers().get(i).getEmail(),
						Userhold.getUsers().get(i).getRole(),
						GetProjectName1(a),
						GetProjectName2(a),
						CheckAvailability(a)
					
						
		});}
                
            } 
                    }
                
           
	private Object GetProjectName1(int a) {
		Object Pname = null;
		// TODO Auto-generated method stub
		 for (int i = 0; i < Projecthold.getProjects().size() ; i++) {
	            //another loop to check the that project at [i]'s team array contain the current user ID
	            for (int j = 0; j < Projecthold.getProjects().get(i).getTeam().size(); j++) {
	                if (a > -1) {
	                    if (Projecthold.getProjects().get(i).getTeam().get(j) == a) {
	                        //if team array contain the the user, add the project to Object
	                         Pname = Projecthold.getProjects().get(i).getName();
	                         
	                        
	                    }
	                }
	            
	        }}
		return Pname;}
        
   

	
	private Object GetProjectName2(int a) {
		Object Pname = null;
		// TODO Auto-generated method stub
		 for (int i = Projecthold.getProjects().size()-1; i >=0 ; i--) {
	            //another loop to check the that project at [i]'s team array contain the current user ID
	            for (int j = 0; j < Projecthold.getProjects().get(i).getTeam().size(); j++) {
	                if (a > -1) {
	                    if (Projecthold.getProjects().get(i).getTeam().get(j) == a) {
                                
	                        //if team array contain the the user, add the project to Object
	                         Pname = Projecthold.getProjects().get(i).getName();
	                         
	                        
	                    }
	                    
	                }
	            
	        }
	            if (Pname == GetProjectName1(a)) {
	            	Pname = null;
	            }
		 }
		return Pname;}
		 
		
		

	private Object CheckAvailability(int a) {
		Object Availability = "UNAVAILABLE";
			if (GetProjectName1(a) == null || GetProjectName2(a) == null ) {
				Availability = "FREE";
			}
		
		
		
		return Availability;
		// TODO Auto-generated method stub
		}
        
		
	

	private void eventHandler() {
		// TODO Auto-generated method stub
		AddingRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				DefaultTableModel model =(DefaultTableModel) MemberTable.getModel();
				model.addRow(new Object[] {
						
						"UserIDget()",
						"Get data",
						"Get data",
						"Get data",
						"Get data",
						"Get data"
						
						
						
			
		});
		


			}});
		
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model =(DefaultTableModel) MemberTable.getModel();
					if(MemberTable.getSelectedRow()==-1) {
						if(MemberTable.getRowCount()==0) {
							
							JOptionPane.showMessageDialog(null, "No data to delete","Progress Board", JOptionPane.OK_OPTION);
						
						} else {
							JOptionPane.showMessageDialog(null, "Select a row to delete","Progress Board", JOptionPane.OK_OPTION);
						}} else {
							model.removeRow(MemberTable.getSelectedRow());
						}
					}
			});
		
	
	
	}

	private void initcomponent() {
		// TODO Auto-generated method stub
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 757, 540);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				
				JScrollPane scrollPane = new JScrollPane();
				
				AddingRow = new JButton("Adding Row\r\n");
				
				
				Delete = new JButton("Delete");
				Delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(Delete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(AddingRow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(AddingRow)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Delete)
							.addContainerGap(37, Short.MAX_VALUE))
				);
				
				MemberTable = new JTable();
				MemberTable.setEnabled(false);
				
				MemberTable.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
					},
					new String[]  {
						"ID", "Name", "Email", "Role", "Task Posted ", "Task OnGoing"
					}
				));
				scrollPane.setViewportView(MemberTable);
				contentPane.setLayout(gl_contentPane);
			} }
		
