public class AttendanceManager {
    private Student[] students;
    private int[] attendanceList;
    private int studentCount;
    private int attendanceCount;

    // Constructor
    public AttendanceManager(int maxStudents) {
        students = new Student[maxStudents];
        attendanceList = new int[maxStudents];
        studentCount = 0;
        attendanceCount = 0;
    }

    // Add student to the system
    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        } else {
            System.out.println("Student list is full.");
        }
    }

    // Mark attendance for a student
    public void markAttendance(int studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == studentId) {
                if (attendanceCount < attendanceList.length) {
                    attendanceList[attendanceCount++] = studentId;
                    System.out.println("Attendance marked for: " + students[i].getName());
                } else {
                    System.out.println("Attendance list is full.");
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // View attendance list
    public void viewAttendance() {
        System.out.println("Attendance List:");
        for (int i = 0; i < attendanceCount; i++) {
            int studentId = attendanceList[i];
            for (int j = 0; j < studentCount; j++) {
                if (students[j].getId() == studentId) {
                    System.out.println(students[j].toString());
                    break;
                }
            }
        }
    }

    // List all students
    public void listStudents() {
        System.out.println("List of Students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].toString());
        }
    }
}
