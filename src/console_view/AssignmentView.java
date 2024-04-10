package console_view;

import model.modulecontent.Assignment;

import java.util.Scanner;

import static console_view.ViewUtil.makeUnderline;


public class AssignmentView {

    public static void display(Assignment assignment) {
        String underline = makeUnderline(assignment.getName());

        System.out.println(underline);
        System.out.println(assignment.getName());
        System.out.println(underline);
        System.out.println(assignment.getInstructions());
    }

    /**
     * Prompts the user for the name and instructions of a new assignment and returns the Assignment object.
     * @return Assignment with the instructions of the assignment.
     * If the input is empty for both name and instructions,
     * it will return Cannot be blank and ask the user again for input.
     * @author John Heil (jch70@psu.edu)
     */
    public static Assignment createAssignment() {
        // TODO 02 - [console_view.AssignmentView.createAssignment] - Prompt user for the name and instructions of the new assignment, and return the Assignment object
        Scanner scanner = new Scanner(System.in);
        String name;
        do {
            System.out.print("Enter the name of the assignment: ");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be blank.");
            }
        } while (name.trim().isEmpty());

        String instructions;
        do {
            System.out.print("Enter the instructions for the assignment: ");
            instructions = scanner.nextLine();

            if (instructions.trim().isEmpty()) {
                System.out.println("Instructions cannot be blank.");
            }
        } while (instructions.trim().isEmpty());
        Assignment assignment = new Assignment(name);
        assignment.setInstructions(instructions);
        return assignment;
    }
}
