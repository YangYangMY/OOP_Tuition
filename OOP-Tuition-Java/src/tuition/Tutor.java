package tuition;

public class Tutor extends People{
    private String tutorID;
    private Major major;
    private Level level;
    private static int tutorNum;
    private static int tutorCount;


    enum Level {
        Doctorate,
        BachelorDegree,
        MasterDegree;
    }
    
    enum Major {
        IT,
        PSY,
        LANG;
    }
    
    public Tutor(){
        super();
        this.tutorID = null;
        this.major = null;
        this.level = null;
        Tutor.tutorNum++;
        Tutor.tutorCount++;
    }
    
    public Tutor(String name, int age, char sex, String phoneNum, String email, Major major, Level level) {
        super(name, age, sex, phoneNum, email);
        this.major = major;
        this.level = level;
        Tutor.tutorNum++;
        Tutor.tutorCount++;
        if (major == Major.IT){
            this.tutorID = "TIT" + tutorNum;
        }
        else if (major == Major.PSY){
            this.tutorID = "TPSY" + tutorNum;
        }
        else if (major == Major.LANG){
            this.tutorID = "TLANG" + tutorNum;
        }
        
    }

    public static int getTutorCount(){
        return tutorCount;
    }

    public void reduceTutorCount(){
        Tutor.tutorCount--;
    }


    public Major getMajor(String major){
        switch(major){
            case "IT":
                return Major.IT;
            case "LANG":
                return Major.LANG;
            case "PSY":
                return Major.PSY;
            default:
                return Major.IT;
        }
    }
    
    public Level getLevel(){
        return this.level;
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
