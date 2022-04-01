package tuition;

public class Language extends Course {
    private String language;
    private String system;
    static int numOfStudents;

    //Constructor
    public Language() {
        super();
        this.language = "English";
        this.system = "MUET";
    }

    public Language(String language, String system){
        this.language = language;
        this.system = system;
    }

    public Language(String courseCode, String courseTitle, String courseDetails, String courseDescription, int capacity, String language, String system) {
        super(courseCode, courseTitle, courseDetails, courseDescription, capacity);
        this.language = language;
        this.system = system;
    }

    //Getter & Setter
    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    //Methods
    @Override
    public String toString() {
        String output = "";

        output += "Course Title: " + super.getTitle()
                + "\nCourse Code: " + super.getCode()
                + "\nCourse Details: " + super.getDetails()
                + "\nCourse Description: " + super.getDescription()
                + "\nLanguage: " + this.language
                + "\nExam System: " + this.system
                + "\nEnrollment Limit : " + this.getCapacity() + " students\n";

        return output;
    }
}
