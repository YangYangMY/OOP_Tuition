package tuition;

public class Enroll {
    private Student student;
    private Course course;
    private static int enrollNum;

    public Enroll(){
    }

    public Enroll(Student student, Course course) {
        this.student = student;
        this.course = course;
        enrollNum++;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public static int getEnrollNum() {
        return enrollNum;
    }

    public static void setEnrollNum(int enrollNum) {
        Enroll.enrollNum = enrollNum;
    }
    
    @Override 
    public String toString() {
        return "StudentID: " + student.getStuID() + ", StudentName: " + student.getName() + ", Course: " + course.getCode() + ", Course Name: " + course.getTitle();
    }

}
