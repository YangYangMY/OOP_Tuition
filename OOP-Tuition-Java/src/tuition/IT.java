package tuition;

public class IT extends Course {
    private String preRequisite;
    private String programmingLanguage;
    private static int numOfItCourse;
    private static int itCount;

    //Constructor
    public IT() {
        super();
        this.preRequisite = "Introduction to Web Design";
        this.programmingLanguage = "HTML";
        IT.numOfItCourse++;
        IT.itCount++;

    }

    public IT(String preRequisite, String programmingLanguage){
        this.preRequisite = preRequisite;
        this.programmingLanguage = programmingLanguage;
        IT.numOfItCourse++;
        IT.itCount++;
    }

    public IT(String courseCode, String courseTitle, String courseDetails, String courseDescription, double courseFee, int capacity, String preRequisite, String programmingLanguage) {
        super(courseCode, courseTitle, courseDetails, courseDescription, courseFee, capacity);
        this.preRequisite = preRequisite;
        this.programmingLanguage = programmingLanguage;
        IT.numOfItCourse++;
        IT.itCount++;
    }

    //Getter & Setter
    public static int getItCount(){
        return itCount;
    }

    public static void reduceItCount(){
        IT.itCount--;
    }
    
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

        output += super.toString()
                + "\nPre-requisite: " + this.preRequisite
                + "\nProgramming Language(s): " + this.programmingLanguage
                + "\nEnrollment Limit : " + this.getCapacity() + " students\n";

        return output;
    }
}
