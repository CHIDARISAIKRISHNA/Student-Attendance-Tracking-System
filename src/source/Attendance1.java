package source;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Attendance;
import model.Student;
import util.DBConnection;

public class Attendance1 {
public void markAttendance(Attendance attendance) {
    String checkSql = "SELECT COUNT(*) FROM attendance WHERE student_id = ? AND attendance_date = ?";
    String insertSql = "INSERT INTO attendance(student_id, attendance_date, status) VALUES(?, ?, ?)";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement checkPs = conn.prepareStatement(checkSql)) {
        checkPs.setInt(1, attendance.getStudentId());
        checkPs.setDate(2, attendance.getDate());
        ResultSet rs = checkPs.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            System.out.println("Error: Attendance already marked for this student on " + attendance.getDate());
            return;
        }
        try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
            ps.setInt(1, attendance.getStudentId());
            ps.setDate(2, attendance.getDate());
            ps.setString(3, attendance.getStatus());
            ps.executeUpdate();
            System.out.println("Attendance marked successfully.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public List<Attendance> getAllAttendance() {
    List<Attendance> list = new ArrayList<>();
    String sql = "SELECT a.attendance_id, a.student_id, s.name, s.email, " +
                 "a.attendance_date, a.status " +
                 "FROM attendance a " +
                 "JOIN students s ON a.student_id = s.student_id";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            Student student = new Student(
                rs.getInt("student_id"),
                rs.getString("name"),
                rs.getString("email")
            );

            Attendance att = new Attendance(
                rs.getInt("attendance_id"),
                student,
                rs.getDate("attendance_date"),
                rs.getString("status")
            );

            list.add(att);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

    }

