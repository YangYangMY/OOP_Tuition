package tuition;

public class Language extends Course {
    private String language;
    private String system;
    private static int langCount;
    private static int numOfLangCourse;

    //Constructor
    public Language() {
        super();
        this.language = "English";
        this.system = "MUET";
        Language.numOfLangCourse++;
        Language.langCount++;
    }

    public Language(String language, String system){
        this.language = language;
        this.system = system;
        Language.numOfLangCourse++;
        Language.langCount++;
    }

    public Language(String courseCode, String courseTitle, String courseDetails, String courseDescription, double courseFee, int capacity, String language, String system) {
        super(courseCode, courseTitle, courseDetails, courseDescription, courseFee, capacity);
        this.language = language;
        this.system = system;
        Language.numOfLangCourse++;
        Language.langCount++;
    }

    //Getter & Setter
    public static int getLangCount(){
        return langCount;
    }
    
    public static void reduceLangCount(){
        Language.langCount--;
    }

    public static int getNumOfLangCourse(){
        return numOfLangCourse;
    }

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

        output += super.toString()
                + "\nLanguage: " + this.language
                + "\nExam System: " + this.system
                + "\nEnrollment Limit : " + this.getCapacity() + " students\n";

        return output;
    }
}
