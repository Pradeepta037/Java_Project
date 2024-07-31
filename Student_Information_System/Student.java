public class Student {
    private String name;
    private int id;
    private Course[] courses;
    private int courseCount;
    private double grade;
    private static final int MAX_COURSES = 10;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.courses = new Course[MAX_COURSES];
        this.courseCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void addCourse(Course course) {
        if (courseCount < MAX_COURSES) {
            courses[courseCount++] = course;
        } else {
            System.out.println("Maximum number of courses reached.");
        }
    }

    public void removeCourse(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equals(courseCode)) {
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--courseCount] = null;
                return;
            }
        }
        System.out.println("Course not found.");
    }

    public Course[] getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        StringBuilder studentInfo = new StringBuilder("Student Name: " + name + ", ID: " + id + ", Grade: " + grade + "\nCourses:\n");
        for (int i = 0; i < courseCount; i++) {
            studentInfo.append(courses[i].toString()).append("\n");
        }
        return studentInfo.toString();
    }
}
