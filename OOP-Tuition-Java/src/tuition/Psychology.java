package tuition;

public class Psychology extends Course {
    private String type;
    private String skillLearned;
    static int numOfStudents;

    //Constructor
    public Psychology() {
        super();
        this.type = "Clinical";
        this.skillLearned = "Communication";
    }

    public Psychology(String type, String skillLearned){
        this.type = type;
        this.skillLearned = skillLearned;
    }

    public Psychology(String courseCode, String courseTitle, String courseDetails, String courseDescription, int capacity, String type, String skillLearned) {
        super(courseCode, courseTitle, courseDetails, courseDescription, capacity);
        this.type = type;
        this.skillLearned = skillLearned;
    }

    //Getter & Setter
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
