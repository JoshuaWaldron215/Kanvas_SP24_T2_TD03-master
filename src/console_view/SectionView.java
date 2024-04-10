package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuAction;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.Section;
import model.modulecontent.Announcement;
import model.modulecontent.Assignment;
import model.modulecontent.Quiz;

public class SectionView {
    private Section section;

    public SectionView(Section section) {
        this.section = section;
    }

    /*
     * A menu that we can reuse, that contains commonly-used choices
     */
    private Menu mnMaint = new Menu("Maintenance");
    private MenuChoice mcList = mnMaint.addMenuChoice("List");
    private MenuChoice mcCreate = mnMaint.addMenuChoice("Create");
    private MenuChoice mcDelete = mnMaint.addMenuChoice("Delete");
    private MenuChoice mcQuit = mnMaint.getMenuChoiceQuit();
    private MenuDisplay mdMaint = new MenuDisplay(mnMaint);

    private Announcement chooseAnnouncement(String title) {
        Menu menu = new Menu(title);

        for (Announcement announcement : section.getAnnouncements()) {
            MenuChoice choice = new MenuChoice(announcement.getTopic());
            choice.setObject(announcement);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Announcement) choice.getObject();
        }
    }
    public MenuAction handleAnnouncements = new MenuAction() {
        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Announcement Maintenance");
            mcList.setMenuAction(listAnnouncements);
            mcCreate.setMenuAction(createAnnouncement);
            mcDelete.setMenuAction(deleteAnnouncement);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private MenuAction listAnnouncements = new MenuAction() {
        @Override
        public void execute() {
            Announcement announcement;
            do {
                announcement = chooseAnnouncement("Announcements");
                if (announcement != null) {
                    AnnouncementView.display(announcement);
                }
            } while (announcement != null);
        }
    };
    private MenuAction createAnnouncement = new MenuAction() {
        @Override
        public void execute() {
            Announcement announcement = AnnouncementView.createAnnouncement();
            section.addAnnouncement(announcement);
        }
    };
    private MenuAction deleteAnnouncement = new MenuAction() {
        @Override
        public void execute() {
            Announcement announcement;
            do {
                announcement = chooseAnnouncement("Delete Announcement");
                if (announcement != null) {
                    section.deleteAnnouncement(announcement);
                }
            } while (announcement != null);
        }
    };

    private Assignment chooseAssignment(String title) {
        Menu menu = new Menu(title);

        for (Assignment assignment : section.getAssignments()) {
            MenuChoice choice = new MenuChoice(assignment.getName());
            choice.setObject(assignment);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Assignment) choice.getObject();
        }
    }
    public MenuAction handleAssignments = new MenuAction() {

        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Assignment Maintenance");
            mcList.setMenuAction(listAssignments);
            mcCreate.setMenuAction(createAssignment);
            mcDelete.setMenuAction(deleteAssignment);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private MenuAction listAssignments = new MenuAction() {
        @Override
        public void execute() {
            Assignment assignment;
            do {
                assignment = chooseAssignment("Assignments");
                if (assignment != null) {
                    AssignmentView.display(assignment);
                }
            } while (assignment != null);
        }
    };
    private MenuAction createAssignment = new MenuAction() {
        @Override
        public void execute() {
            Assignment assignment = AssignmentView.createAssignment();
            section.addAssignment(assignment);
        }
    };
    private MenuAction deleteAssignment = new MenuAction() {
        @Override
        public void execute() {
            Assignment assignment;
            do {
                assignment = chooseAssignment("Delete Assignments");
                if (assignment != null) {
                    section.deleteAssignment(assignment);
                }
            } while (assignment != null);
        }
    };

    private Quiz chooseQuiz(String title) {
        Menu menu = new Menu(title);

        for (Quiz quiz : section.getQuizzes()) {
            MenuChoice choice = new MenuChoice(quiz.getName());
            choice.setObject(quiz);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Quiz) choice.getObject();
        }
    }
    public MenuAction handleQuizzes = new MenuAction() {

        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Quiz Maintenance");
            mcList.setMenuAction(listQuizzes);
            mcCreate.setMenuAction(createQuiz);
            mcDelete.setMenuAction(deleteQuiz);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private MenuAction listQuizzes = new MenuAction() {
        @Override
        public void execute() {
            Quiz quiz;
            do {
                quiz = chooseQuiz("Quizzes");
                if (quiz != null) {
                    QuizView.display(quiz);
                }
            } while (quiz != null);
        }
    };
    private MenuAction createQuiz = new MenuAction() {
        @Override
        public void execute() {
            Quiz quiz = QuizView.createQuiz();
            section.addQuiz(quiz);
        }
    };
    private MenuAction deleteQuiz = new MenuAction() {
        @Override
        public void execute() {
            Quiz quiz;
            do {
                quiz = chooseQuiz("Delete Quiz");
                if (quiz != null) {
                    section.deleteQuiz(quiz);
                }
            } while (quiz != null);
        }
    };
}
