package tuition;

public class Psychology extends Course {
    private String type;
    private String skillLearned;
    private static int numOfPsyCourse;
    private static int psyCount;

    //Constructor
    public Psychology() {
        super();
        this.type = "Clinical";
        this.skillLearned = "Communication";
        Psychology.numOfPsyCourse++;
        Psychology.psyCount++;
    }

    public Psychology(String type, String skillLearned){
        this.type = type;
        this.skillLearned = skillLearned;
        Psychology.numOfPsyCourse++;
        Psychology.psyCount++;
    }

    public Psychology(String courseCode, String courseTitle, String courseDetails, String courseDescription, double courseFee,int capacity, String type, String skillLearned) {
        super(courseCode, courseTitle, courseDetails, courseDescription, courseFee, capacity);
        this.type = type;
        this.skillLearned = skillLearned;
        Psychology.numOfPsyCourse++;
        Psychology.psyCount++;
    }

    //Getter & Setter
    public static int getPsyCount(){
        return psyCount;
    }

    public static void reducePsyCount(){
        Psychology.psyCount--;
    }
    
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

        output += super.toString() 
                + "\nType: " + this.type
                + "\nSkill(s) Learned: " + this.skillLearned
                + "\nEnrollment Limit : " + this.getCapacity() + " students\n";

        return output;
    }
}
