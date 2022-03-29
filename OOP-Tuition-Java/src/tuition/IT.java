package tuition;

public class IT extends Course {
    private String preRequisite;
    private String programmingLanguage;
    static int numOfStudents;

    //Constructor
    public IT() {
        super();
        this.preRequisite = "Introduction to Web Design";
        this.programmingLanguage = "HTML";
    }

    public IT(String preRequisite, String programmingLanguage){
        this.preRequisite = preRequisite;
        this.programmingLanguage = programmingLanguage;
    }

    public IT(String courseCode, String courseTitle, String courseDetails, String courseDescription, int capacity, String preRequisite, String programmingLanguage) {
        super(courseCode, courseTitle, courseDetails, courseDescription, capacity);
        this.preRequisite = preRequisite;
        this.programmingLanguage = programmingLanguage;
    }

    //Getter & Setter
    public String getPreRequisite() {
        return this.preRequisite;
    }

    public void setPreRequisite(String preRequisite) {
        this.preRequisite = preRequisite;
    }

    public String getProgrammingLanguage() {
        return this.programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
    
    //Methods
    @Override
    public String toString() {
        String output = "";

        output += super.getTitle() + "\n"
                + "Course Code: " + super.getCode()
                + super.toString()
                + "Pre-requisite: " + this.preRequisite + "\n"
                + "Programming Language(s): " + this.programmingLanguage + "\n";

        return output;
    }
}
