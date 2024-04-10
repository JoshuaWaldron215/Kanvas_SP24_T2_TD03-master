package util;

import model.*;
import model.Module;
import model.modulecontent.Announcement;
import model.modulecontent.Assignment;
import model.modulecontent.Quiz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateSampleSection {
    public static Section initIst261() {
        Section section = new Section();

        Teacher teacher = new Teacher("O'Connell", "Philip", "J", "pxo4");
        section.setTeacher(teacher);

        section.addStudents(Arrays.asList(
                new Student("Gates", "William", "Henry", "whg5123"),
                new Student("Allen", "Paul", "Gardner", "pga123")
        ));

        Module module = new Module("Week01 [Part 1] - Introduction, Syllabus, Programming");
        section.addModule(module);

        section.setAnnouncements(createSampleAnnouncements());

        for (Assignment a : initAssignments()) {
            section.addAssignment(a);
        }

        for (Quiz q : initQuizzes()) {
            section.addQuiz(q);
        }

        return section;
    }

    public static List<Announcement> createSampleAnnouncements() {
        List<Announcement> announcements = new ArrayList<>();

        announcements.add(new Announcement("Welcome!", "Welcome to Abington IST.  Please read the syllabus"));
        announcements.add(new Announcement("Midterm exam", "The midterm exam is next week"));

        return announcements;
    }

    public static List<Assignment> initAssignments() {
        List<Assignment> assignments = new ArrayList<>();
        Assignment assignment;

        assignment = new Assignment("IA01");
        assignment.setPublished(true);
        assignment.setInstructions((new StringBuilderPlus())
                .appendLine(" Display a randomly-determined even number to the user")
                .appendLine()
                .appendLine("* Display your name, PSU email, course, section, assignment number")
                .appendLine()
                .appendLine("* Display a randomly-determined even number to the user")
                .appendLine("  * The number should be between 2 and 10 *_inclusive_*")
                .appendLine()
                .appendLine("* Prompt the user to enter the value of half that number")
                .appendLine("  * You can assume the user will enter valid numbers, not letters or gibberish")
                .appendLine("  * They only get one chance to answer per number")
                .appendLine()
                .appendLine("* Tell the user if they are right or wrong")
                .toString()
        );
        assignment.setDueDateTime(LocalDateTime.now().plusMinutes(5));
        assignment.setAvailableUntilDateTime(assignment.getDueDateTime().plusDays(2));
        assignment.setSubmissionType(AssignmentSubmissionFileType.ZIP);

        assignments.add(assignment);

        return assignments;
    }

    public static List<Quiz> initQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        Quiz quiz;

        quiz = new Quiz("Triangles");
        quizzes.add(quiz);

        QuizQuestion question;

        question = new QuizQuestion("How many sides does a triangle have?", 10);
        question.addAnswer(new QuizAnswer("1", false));
        question.addAnswer(new QuizAnswer("2", false));
        question.addAnswer(new QuizAnswer("3", true));
        quiz.addQuestion(question);

        question = new QuizQuestion("What is the sum of the angles in a triangle?", 15);
        question.addAnswer(new QuizAnswer("100", false));
        question.addAnswer(new QuizAnswer("90", false));
        question.addAnswer(new QuizAnswer("180", true));
        question.addAnswer(new QuizAnswer("360", false));
        quiz.addQuestion(question);

        quiz = new Quiz("Squares");
        quizzes.add(quiz);

        question = new QuizQuestion("How many sides does a square have?", 10);
        question.addAnswer(new QuizAnswer("2", false));
        question.addAnswer(new QuizAnswer("3", true));
        question.addAnswer(new QuizAnswer("4", true));
        quiz.addQuestion(question);

        question = new QuizQuestion("What is the sum of the angles in a square?", 15);
        question.addAnswer(new QuizAnswer("100", false));
        question.addAnswer(new QuizAnswer("90", false));
        question.addAnswer(new QuizAnswer("180", false));
        question.addAnswer(new QuizAnswer("360", true));
        quiz.addQuestion(question);

        return quizzes;

    }
}
