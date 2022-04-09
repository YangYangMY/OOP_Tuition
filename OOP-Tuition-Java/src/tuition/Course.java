package tuition;

public class Course {
    private String code;
    private String title;
    private String details;
    private String description;
    private double fee;
    final private int maxStudentNo;

    //Constructor
    public Course() {
        this("","", "", "", 150.0, 75);
    }

    public Course(String courseCode, String courseTitle, String courseDetails, String courseDescription, double courseFee, int capacity){
        this.code = courseCode;
        this.title = courseTitle;
        this.details = courseDetails;
        this.description = courseDescription;
        this.fee = courseFee;
        this.maxStudentNo = capacity;
    }

    //Getter & Setter
    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDetails() {
        return this.details;
    }

    public String getDescription() {
        return this.description;
    }

    public double getFee() {
        return this.fee;
    }

    public int getCapacity(){
        return this.maxStudentNo;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String courseTitle){
        this.title = courseTitle;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String courseInfo(){
        String output = "";

        output += "\nDetails: " + this.details + "\n" + 
                  "\nDescription: " + this.description + "\n";

        return output;
    }

    //Methods
    @Override
    public String toString() {
        String output = "";

        output += "Course Title: " + this.getTitle()
                + "\nCourse Code: " + this.getCode()
                + "\nCourse Details: " + this.getDetails()
                + "\nCourse Description: " + this.getDescription()
                + "\nCourse Fee: RM" + String.format("%.2f", this.getFee());

        return output;
    }

}
