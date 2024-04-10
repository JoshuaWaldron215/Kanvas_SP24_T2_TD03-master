package model;

import model.modulecontent.Announcement;
import model.modulecontent.Assignment;
import model.modulecontent.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Section {
    private Teacher teacher;

    private List<Student> students = new ArrayList<>();
    private List<Announcement> announcements = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();
    private List<Quiz> quizzes = new ArrayList<>();
    private List<Module> modules = new ArrayList<>();

    public void addStudent(Student student) {
        if (students.contains(student)) {
            throw new IllegalArgumentException(String.format("Student '%s' already in section", student.toString()));
        }
        students.add(student);
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public void dropStudent(Student student) {
        students.remove(student);
    }

    public int studentCount() {
        return students.size();
    }

    public Student findStudent(String psuLogin) {
        for (Student s : students) {
            if (s.getLogin().equals(psuLogin)) {
                return s;
            }
        }
        return null;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Iterable<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public boolean isEnrolled(String psuLogin) {
        return (findStudent(psuLogin) != null);
    }

    public Iterable<Announcement> getAnnouncements() {
        return Collections.unmodifiableList(announcements);
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    public Iterable<Assignment> getAssignments() {
        return Collections.unmodifiableList(assignments);
    }

    public Iterable<Quiz> getQuizzes() {
        return Collections.unmodifiableList(quizzes);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    /**
     * Remove the announcement from the section.
     * <p>
     * This method removes the specific announcement from the list of announcements
     * associated with the section.
     * </p>
     * @param announcement The announcement to be removed from the section.
     * @author Mark Jachura (mgj5130@psu.edu)
     */
    public void deleteAnnouncement(Announcement announcement) {
        // TODO 09 - [model.Section.deleteAnnouncement] - Remove the announcement
        announcements.remove(announcement);
    }

    /**
     * Removes the assignment
     * <p>
     *     Assignment gets deleted
     * </p>
     * @param assignment
     * @author Kayla Swenson(Kas7927@psu.edu)
     */

    public void deleteAssignment(Assignment assignment) {
        // TODO 10 - [model.Section.deleteAssignment] - Remove the assignment
        assignments.remove(assignment);
    }

    /**
     * Removes the quiz
     * <p>
     *     Quiz gets deleted
     * </p>
     * @param quiz
     * @author Kayla Swenson (Kas7927@psu.edu)
     */

    public void deleteQuiz(Quiz quiz) {
        // TODO 11 - [model.Section.deleteQuiz] - Remove the quiz
        quizzes.remove(quiz);
    }
}
