package tuition;

public class Psychology extends Course {
    private String type;
    private String skillLearned;
    private static int numOfPsyCourse;

    //Constructor
    public Psychology() {
        super();
        this.type = "Clinical";
        this.skillLearned = "Communication";
        this.numOfPsyCourse++;
    }

    public Psychology(String type, String skillLearned){
        this.type = type;
        this.skillLearned = skillLearned;
        this.numOfPsyCourse++;
    }

    public Psychology(String courseCode, String courseTitle, String courseDetails, String courseDescription, int capacity, String type, String skillLearned) {
        super(courseCode, courseTitle, courseDetails, courseDescription, capacity);
        this.type = type;
        this.skillLearned = skillLearned;
        this.numOfPsyCourse++;
    }

    //Getter & Setter
    public static int getNumOfPsyCourse(){
        return numOfPsyCourse;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSkillLearned() {
        return this.skillLearned;
    }

    public void setSkillLearned(String skillLearned) {
        this.skillLearned = skillLearned;
    }

    //Methods
    @Override
    public String toString() {
        String output = "";

        output += "Course Title: " + super.getTitle()
                + "\nCourse Code: " + super.getCode()
                + "\nCourse Details: " + super.getDetails()
                + "\nCourse Description: " + super.getDescription()
                + "\nType: " + this.type
                + "\nSkill(s) Learned: " + this.skillLearned
                + "\nEnrollment Limit : " + this.getCapacity() + " students\n";

        return output;
    }
}
