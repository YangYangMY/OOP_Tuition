package tuition;

class Student extends People implements CourseTaken{
    private static int stuNum;
    private String stuID;
    private String description;
    private double balance;
    private static int StuCount;
    
    public Student(){
        super();
        this.stuNum++;
        this.StuCount++;
        this.stuID = "W" + stuNum;
        this.description = "";
        this.balance = 0;
    }
    
    public Student(String name, int age, char sex, String phoneNum, String email, String description, double balance) {
        super(name, age, sex, phoneNum, email);
        this.stuNum++;
        this.StuCount++;
        this.stuID = "W" + stuNum;
        this.description = description;
        this.balance = balance;
    }
    
    public Student(String name, int age, char sex, String phoneNum, String email, double balance) {
        super(name, age, sex, phoneNum, email);
        this.stuNum++;
        this.StuCount++;
        this.stuID = "W" + stuNum;
        this.description = "";
        this.balance = balance;
    }

    public static int getStuCount(){
        return StuCount;
    }

    public void setStuCount(int stuCount){
        Student.StuCount = stuCount;
    } 

    public void reduceStuCount(){
        Student.StuCount --;
    }

    public String getStuID() {
        return stuID;
    }
    
    public static int getStuNum() {
        return stuNum;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {        
        String message = super.toString() + ", ID: " + stuID + ", Description: " + description + ", Balance: " + balance; 
        return message;
    }

    @Override
    public boolean numOfTakenCourse(Enroll[] enrollArr) {
        int enrollNum = 0;
        for(int i = 0; i < Enroll.getEnrollNum(); i++){
            if((enrollArr[i].getStudent().stuID).equals(this.stuID)){
                enrollNum++;
            }
        }
        if(enrollNum > PlatinumMemberEnroll){
            return true;
        } else {
            return false;
        }
    }
}
