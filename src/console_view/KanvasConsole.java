package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.Section;
import util.CreateSampleSection;

public class KanvasConsole {
    private static Section ist261 = CreateSampleSection.initIst261();
    private static SectionView sectionView = new SectionView(ist261);
    private static Menu menu = new Menu("Kanvas");

    public static void main(String[] args) {
        menu.addMenuChoice("Announcements").setMenuAction(sectionView.handleAnnouncements);
        menu.addMenuChoice("Assignments").setMenuAction(sectionView.handleAssignments);
        menu.addMenuChoice("Quizzes").setMenuAction(sectionView.handleQuizzes);

        MenuDisplay display = new MenuDisplay(menu);

        // TODO 00 [KanvasConsole#main] - Your team info
        System.out.println("TEAM 02"); // Put team number here
        // Include your PSU login and git login
        System.out.println("Kayla Swenson (psu: Kas7927, git: Kas7927)");
        System.out.println("Joshua Waldron (psu: Jsw5796, git: Joshuawaldron)");
        System.out.println("Mark Jachura (psu: Mgj5130, git: Markj2104)");
        System.out.println("John Heil (psu: Jch70, git: Jch70)");
        System.out.println("Paul Henry-Thomas (psu: Pmt5128, git: Paul6123)");

        while (true) {
            MenuChoice choice = display.displayAndChoose();
            if (choice == menu.getMenuChoiceQuit()) {
                break;
            }
        }

    }
}