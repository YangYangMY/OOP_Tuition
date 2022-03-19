package oop.tuition.java;

/**
 *
 * @author Wee Yan
 */
public class Tutor extends People{
    String tutorID;
    String major;
    String level;
    static int tutorNum = 1;
    
    public Tutor(String name, int age, char sex, String phoneNum, String email, String major, String level) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.email = email;
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
    
    public String toString(){
        String message = "";
        
        message += "name:" + name + "\nage:" + age + "\nsex:" + sex + "\nphoneNum:" + phoneNum + "\nemail:" + email + "\ntutorID:" + tutorID + "\nmajor:" + major + "\nlevel:" + level;
                
       return message;
    }
    
}
