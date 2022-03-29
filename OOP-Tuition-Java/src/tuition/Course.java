package tuition;

public class Course {
    private String code;
    private String title;
    private String details;
    private String description;
    final private int maxStudentNo;
    //Constructor
    public Course() {
        this("","", "", "", 75);
    }

    public Course(int capacity){
        this.maxStudentNo = capacity;
    }

    public Course(String courseCode, String courseTitle, String courseDetails, String courseDescription, int capacity){
        this.code = courseCode;
        this.title = courseTitle;
        this.details = courseDetails;
        this.description = courseDescription;
        this.maxStudentNo = capacity;
    }

    //Getter & Setter
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setTitle(String courseTitle){
        this.title = courseTitle;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Methods
    @Override
    public String toString() {
        String output = "";

        if(this.description == ""){
            output += "\nCourse Details: " + this.details + 
            "\nEnrollment Limit : " + this.maxStudentNo + " students\n";
        }else{
            output += "\nCourse Details: " + this.details + 
        "\nCourse Description: " + this.description + 
        "\nEnrollment Limit : " + this.maxStudentNo + " students\n";
        }

        // output += "\nCourse Details: " + this.details + 
        // "\nCourse Description: " + this.description + 
        // "\nEnrollment Limit : " + this.maxStudentNo + " students\n";

        return output;
    }

}
