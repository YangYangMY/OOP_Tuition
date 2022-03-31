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

    public String getTitle() {
        return this.title;
    }

    public String getDetails() {
        return this.details;
    }

    public String getDescription() {
        return this.description;
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

    //Methods
    @Override
    public String toString() {
        String output = "";

        output += "\nDetails: " + this.details + 
        "\nDescription: " + this.description + "\n";

        return output;
    }

}
