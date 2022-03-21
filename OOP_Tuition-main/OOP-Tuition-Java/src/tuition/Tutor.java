package tuition;

public class Tutor extends People{
    private String tutorID;
    private String major;
    private String level;
    private static int tutorNum = 1;
    
    public Tutor(){
        super();
        this.tutorID = null;
        this.major = null;
        this.level = null;
    }
    
    public Tutor(String name, int age, char sex, String phoneNum, String email, String major, String level) {
        super(name, age, sex, phoneNum, email);
        this.major = major;
        this.level = level;
        
        if (major == "IT"){
            this.tutorID = "TIT" + tutorNum;
        }
        else if (major == "PSY"){
            this.tutorID = "TPSY" + tutorNum;
        }
        else if (major == "HR"){
            this.tutorID = "THR" + tutorNum;
        }
        else{
            this.tutorID = "T" + tutorNum;
        }
        tutorNum++;
    }

    public String getTutorID() {
        return tutorID;
    }

    public static int getTutorNum() {
        return tutorNum;
    }
    
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    public String toString(){
       String message = super.toString() + ", TutorID: " + tutorID + ", Major: " + major + ", Level: " + level;           
       return message;
    }
    
}
