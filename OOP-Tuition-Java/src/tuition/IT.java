package tuition;

public class IT extends Course {
    private String preRequisite;
    private String programmingLanguage;
    private static int numOfItCourse;

    //Constructor
    public IT() {
        super();
        this.preRequisite = "Introduction to Web Design";
        this.programmingLanguage = "HTML";
        this.numOfItCourse++;
    }

    public IT(String preRequisite, String programmingLanguage){
        this.preRequisite = preRequisite;
        this.programmingLanguage = programmingLanguage;
        this.numOfItCourse++;
    }

    public IT(String courseCode, String courseTitle, String courseDetails, String courseDescription, int capacity, String preRequisite, String programmingLanguage) {
        super(courseCode, courseTitle, courseDetails, courseDescription, capacity);
        this.preRequisite = preRequisite;
        this.programmingLanguage = programmingLanguage;
        this.numOfItCourse++;
    }

    //Getter & Setter
    public static int getNumOfItCourse(){
        return numOfItCourse;
    }
    
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

        output += "Course Title: " + super.getTitle()
                + "\nCourse Code: " + super.getCode()
                + "\nCourse Details: " + super.getDetails()
                + "\nCourse Description: " + super.getDescription()
                + "\nPre-requisite: " + this.preRequisite
                + "\nProgramming Language(s): " + this.programmingLanguage
                + "\nEnrollment Limit : " + this.getCapacity() + " students\n";

        return output;
    }
}
