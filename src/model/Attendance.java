package model;
import java.sql.Date;
public class Attendance {
    private int id;              
    private int studentId;       
    private Student student;     
    private Date date;
    private String status;
    public Attendance() {}
    public Attendance(int studentId, Date date, String status) {
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }
    public Attendance(int id, Student student, Date date, String status) {
        this.id = id;
        this.student = student;
        this.date = date;
        this.status = status;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
