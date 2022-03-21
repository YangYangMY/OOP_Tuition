package tuition;

public class Course {

    private String description;
    private int maxStudentNo;

    public Course() {
        this(null, 0);
    }

    public Course(String courseDescription, int capacity) {
        this.description = courseDescription;
        this.maxStudentNo = capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxStudentNo(int maxStudentNo) {
        this.maxStudentNo = maxStudentNo;
    }

    @Override
    public String toString() {
        String output = "";

        output += "Course description: " + this.description + "\t"
                + "Enrollment Limit : " + this.maxStudentNo + " students\n";

        return output;
    }
}
