package layout.views.BoardUI;

import javax.swing.JPanel;

import common.Board.Board;
import common.Enum.BoardType;
import common.Project.Projecthold;
import common.Task.Task;
import common.Task.TaskHold;
import common.User.CurrentUserhold;
import layout.views.TaskUI.TaskCardUI;
import layout.views.TaskUI.TaskDetailsUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import layout.views.SwitchBoardPopUp.SwitchBoardPopUp;
import layout.views.project.ProjectUIDropdown;
import layout.views.sprint.SprintUIDropdown;

public class BoardUI extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 7331854978956106556L;

    private Board board;
    private int numOfCardDisplay;

    /**
     * Create the panel.
     */
    public BoardUI(BoardType type) {
        numOfCardDisplay = 0;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        board = new Board(type);
        renderBoard(board.read());
    }

    public void renderBoard(List<Task> tasks) {
        setNumOfCardDisplay(0);
        if (CurrentUserhold.getUser() != null) {
            //get all task of that particular board || pretty much a population call || tasks now hold all the task of that board

            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                //condition for when filter need to reload and task was already delete
                //TODO do the same with sprint
                if (Projecthold.searchByID(task.getProjectID())) {
                    //render by user?
                    if (task.getAssignees().contains(CurrentUserhold.getUser().getID())) {
                        //render by project
                        if (ProjectUIDropdown.getProjectAccessID() == -1) {
                            //render by sprint
                            if (SprintUIDropdown.getSprintAccessID() == -1) {
                                addTaskToBoard(task);
                            } else if (SprintUIDropdown.getSprintAccessID() == task.getSprintID()) {
                                addTaskToBoard(task);
                            }
                        } else if (ProjectUIDropdown.getProjectAccessID() == task.getProjectID()) {
                            if (SprintUIDropdown.getSprintAccessID() == -1) {
                                addTaskToBoard(task);
                            } else if (SprintUIDropdown.getSprintAccessID() == task.getSprintID()) {
                                addTaskToBoard(task);
                            }
                        }
                    }
                }
            }

        } //condition for log out
        else {
            for (int i = 0; i < TaskHold.getEmptyTaskList().size(); i++) {
                if ((TaskHold.getEmptyTaskList().get(i).getStatus().name().equals("ONNEW") || TaskHold.getEmptyTaskList().get(i).getStatus().name().equals("ONREVIEW"))
                        && this.getBoard().getType().name().equals("BACKLOG")) {
                    TaskCardUI card = new TaskCardUI(TaskHold.getEmptyTaskList().get(i));
                    this.add(card);
                } else if (TaskHold.getEmptyTaskList().get(i).getStatus().name().equals("ONTAKEN")
                        && this.getBoard().getType().name().equals("TAKEN")) {
                    TaskCardUI card = new TaskCardUI(TaskHold.getEmptyTaskList().get(i));
                    this.add(card);
                } else if (TaskHold.getEmptyTaskList().get(i).getStatus().name().equals("ONGOING")
                        && this.getBoard().getType().name().equals("ONGOING")) {
                    TaskCardUI card = new TaskCardUI(TaskHold.getEmptyTaskList().get(i));
                    this.add(card);
                } else if (TaskHold.getEmptyTaskList().get(i).getStatus().name().equals("ONFINISH")
                        && this.getBoard().getType().name().equals("FINISH")) {
                    TaskCardUI card = new TaskCardUI(TaskHold.getEmptyTaskList().get(i));
                    this.add(card);
                }

            }
        }
    }

    public void filter() {

    }

    public void refresh() {
        this.getBoard().refresh();
        this.removeAll();

        renderBoard(board.read());
    }

    public void sortSummaryAsc() {
        this.getBoard().sortSummaryAsc();
        this.removeAll();
        renderBoard(board.read());
    }

    public void sortSummaryDesc() {
        this.getBoard().sortSummaryDesc();
        this.removeAll();
        renderBoard(board.read());
    }

    public void sortDueDate() {
        this.getBoard().sortDueDate();
        this.removeAll();
        renderBoard(board.read());
    }

    public void sortSeverityAsc() {
        this.getBoard().sortSeverityAsc();
        this.removeAll();
        renderBoard(board.read());
    }

    public void sortSeverityDesc() {
        this.getBoard().sortSeverityDesc();
        this.removeAll();
        renderBoard(board.read());
    }

    public void sortIDAsc() {
        this.getBoard().sortIDAsc();
        this.removeAll();
        renderBoard(board.read());
    }

    public void sortIDDesc() {
        this.getBoard().sortIDDesc();
        this.removeAll();
        renderBoard(board.read());
    }

    public void search(String searchInput) {
        if (searchInput == null || searchInput.equals("")) {
            this.removeAll();
            renderBoard(board.read());
        } else {
            this.removeAll();
            renderBoard(board.search(searchInput));
        }
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the numOfCardDisplay
     */
    public int getNumOfCardDisplay() {
        return numOfCardDisplay;
    }

    /**
     * @param numOfCardDisplay the numOfCardDisplay to set
     */
    public void setNumOfCardDisplay(int numOfCardDisplay) {
        this.numOfCardDisplay = numOfCardDisplay;
    }

    public void renderBoardAssignedTask(List<Task> tasks) {

        setNumOfCardDisplay(0);
        if (CurrentUserhold.getUser() != null) {
            //get all task of that particular board || pretty much a population call || tasks now hold all the task of that board

            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);

                //render by user?
                if (task.getAssignees().contains(CurrentUserhold.getUser().getID()) && task.getAssignees().size() == 2) {
                    //render by project
                    if (ProjectUIDropdown.getProjectAccessID() == -1) {
                        //render by sprint
                        if (SprintUIDropdown.getSprintAccessID() == -1) {
                            TaskCardUI card = new TaskCardUI(task);
                            setNumOfCardDisplay(getNumOfCardDisplay() + 1);
                            card.addMouseListener(new MouseAdapter() {
                                public void mousePressed(MouseEvent me) {
                                    if (me.getClickCount() == 2) {
                                        TaskDetailsUI details = new TaskDetailsUI(task);
                                        details.setVisible(true);
                                        details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    } else if (me.isPopupTrigger()) {
                                        SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                                        menu.show(me.getComponent(), me.getX(), me.getY());
                                    }
                                }

                                public void mouseReleased(MouseEvent me) {
                                    if (me.isPopupTrigger()) {
                                        SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                                        menu.show(me.getComponent(), me.getX(), me.getY());
                                    }
                                }
                            });
                            //this refer to the JPanel 
                            this.add(card);
                        } else if (SprintUIDropdown.getSprintAccessID() == task.getSprintID()) {
                            TaskCardUI card = new TaskCardUI(task);
                            setNumOfCardDisplay(getNumOfCardDisplay() + 1);
                            card.addMouseListener(new MouseAdapter() {
                                public void mousePressed(MouseEvent me) {
                                    if (me.getClickCount() == 2) {
                                        TaskDetailsUI details = new TaskDetailsUI(task);
                                        details.setVisible(true);
                                        details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    } else if (me.isPopupTrigger()) {
                                        SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                                        menu.show(me.getComponent(), me.getX(), me.getY());
                                    }
                                }

                                public void mouseReleased(MouseEvent me) {
                                    if (me.isPopupTrigger()) {
                                        SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                                        menu.show(me.getComponent(), me.getX(), me.getY());
                                    }
                                }
                            });
                            //this refer to the JPanel 
                            this.add(card);
                        }
                    } else if (ProjectUIDropdown.getProjectAccessID() == task.getProjectID()) {
                        if (SprintUIDropdown.getSprintAccessID() == -1) {
                            TaskCardUI card = new TaskCardUI(task);
                            setNumOfCardDisplay(getNumOfCardDisplay() + 1);
                            card.addMouseListener(new MouseAdapter() {
                                public void mousePressed(MouseEvent me) {
                                    if (me.getClickCount() == 2) {
                                        TaskDetailsUI details = new TaskDetailsUI(task);
                                        details.setVisible(true);
                                        details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    } else if (me.isPopupTrigger()) {
                                        SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                                        menu.show(me.getComponent(), me.getX(), me.getY());
                                    }
                                }

                                public void mouseReleased(MouseEvent me) {
                                    if (me.isPopupTrigger()) {
                                        SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                                        menu.show(me.getComponent(), me.getX(), me.getY());

                                    }
                                }
                            });
                            this.add(card);
                        } else if (SprintUIDropdown.getSprintAccessID() == task.getSprintID()) {
                            TaskCardUI card = new TaskCardUI(task);
                            setNumOfCardDisplay(getNumOfCardDisplay() + 1);
                            card.addMouseListener(new MouseAdapter() {
                                public void mousePressed(MouseEvent me) {
                                    if (me.getClickCount() == 2) {
                                        TaskDetailsUI details = new TaskDetailsUI(task);
                                        details.setVisible(true);
                                        details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    } else if (me.isPopupTrigger()) {
                                        SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                                        menu.show(me.getComponent(), me.getX(), me.getY());
                                    }
                                }

                                public void mouseReleased(MouseEvent me) {
                                    if (me.isPopupTrigger()) {
                                        SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                                        menu.show(me.getComponent(), me.getX(), me.getY());

                                    }
                                }
                            });
                            this.add(card);
                        }
                    }
                }
            }
        }
    }

    public void addTaskToBoard(Task task) {
        TaskCardUI card = new TaskCardUI(task);
        setNumOfCardDisplay(getNumOfCardDisplay() + 1);
        card.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    TaskDetailsUI details = new TaskDetailsUI(task);
                    details.setVisible(true);
                    details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                } else if (me.isPopupTrigger()) {
                    SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                    menu.show(me.getComponent(), me.getX(), me.getY());
                }
            }

            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger()) {
                    SwitchBoardPopUp menu = new SwitchBoardPopUp(task, BoardUI.this);
                    menu.show(me.getComponent(), me.getX(), me.getY());
                }
            }
        });
        //this refer to the JPanel 
        this.add(card);
    }
}
