package tuition;

public class Tutor extends People{
    private String tutorID;
    private Major major;
    private Level level;
    private static int tutorNum;
    
    enum Level {
        Doctorate,
        BachelorDegree,
        MasterDegree;
    }
    
    enum Major {
        IT,
        PSY,
        HR;
    }
    
    public Tutor(){
        super();
        this.tutorID = null;
        this.major = null;
        this.level = null;
        this.tutorNum++;
    }
    
    public Tutor(String name, int age, char sex, String phoneNum, String email, Major major, Level level) {
        super(name, age, sex, phoneNum, email);
        this.major = major;
        this.level = level;
        this.tutorNum++;
        if (major == Major.IT){
            this.tutorID = "TIT" + tutorNum;
        }
        else if (major == Major.PSY){
            this.tutorID = "TPSY" + tutorNum;
        }
        else if (major == Major.HR){
            this.tutorID = "THR" + tutorNum;
        }
        
    }

    public Major getMajor(String major){
        switch(major){
            case "IT":
                return Major.IT;
            case "HR":
                return Major.HR;
            case "PSY":
                return Major.PSY;
            default:
                return Major.IT;
        }
    }
    
    public Level getLevel(String level){
        switch(level){
            case "Doctorate":
                return Level.Doctorate;
            case "BachelorDegree":
                return Level.BachelorDegree;
            case "MasterDegree":
                return Level.MasterDegree;
            default:
                return Level.BachelorDegree;
        }
    }
    
    
    
    public String getTutorID() {
        return tutorID;
    }

    public static int getTutorNum() {
        return tutorNum;
    }
    
    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }


    public void setLevel(Level level) {
        this.level = level;
    }
    
    public String toString(){
       String message = super.toString() + ", TutorID: " + tutorID + ", Major: " + major + ", Level: " + level;           
       return message;
    }
    
}
