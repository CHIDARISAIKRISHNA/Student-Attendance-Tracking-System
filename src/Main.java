import model.Student;
import source.Attendance1;
import source.Student1;
import model.Attendance;
import java.util.Scanner;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student1 studentDAO = new Student1();
        Attendance1 attendanceDAO = new Attendance1();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View Attendance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    studentDAO.addStudent(new Student(name, email));
                    break;
                case 2:
                    for (Student s : studentDAO.getAllStudents()) {
                        System.out.println(s.getStudentId() + " - " + s.getName() + " - " + s.getEmail());
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String dateStr = sc.nextLine();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = sc.nextLine();
                    attendanceDAO.markAttendance(new Attendance(sid, Date.valueOf(dateStr), status));
                    break;
                case 4:
                    System.out.println("Attendance Records:");
                    for (Attendance att : attendanceDAO.getAllAttendance()) {
                        System.out.println(att.getId() + " | " +
                                           att.getStudent().getName() + " | " +
                                           att.getDate() + " | " +
                                           att.getStatus());
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
