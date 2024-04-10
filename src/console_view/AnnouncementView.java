package console_view;

import model.modulecontent.Announcement;

import java.util.Scanner;

import static console_view.ViewUtil.makeUnderline;


public class AnnouncementView {

    public static void display(Announcement announcement) {
        String underline = makeUnderline(announcement.getTopic());

        System.out.println(underline);
        System.out.println(announcement.getTopic());
        System.out.println(underline);
        System.out.println(announcement.getText());
    }

    /**
     * Prompts the user for the name and text of a new announcement and returns the Announcement object.
     * @return Announcement with the text of the annoucement.
     * If the input is empty for both topic and text,
     * it will return "Cannot be blank" and ask the user again for input.
     * @author John Heil (jch70@psu.edu)
     */
    public static Announcement createAnnouncement() {
        // TODO 01 - [console_view.AnnouncementView.createAnnouncement] Prompt user for the name and text of the new announcement, and return the Announcement object
        Scanner scanner = new Scanner(System.in);
        String topic;
        do {
            System.out.print("Enter the topic of the announcement: ");
            topic = scanner.nextLine();
            if (topic.trim().isEmpty()) {
                System.out.println("Cannot be blank");
            }
        } while (topic.trim().isEmpty());

        String text;
        do {
            System.out.print("Enter the text of the announcement: ");
            text = scanner.nextLine();
            if (text.trim().isEmpty()) {
                System.out.println("Cannot be blank");
            }
        } while (text.trim().isEmpty());

        return new Announcement(topic, text);
    }
}
