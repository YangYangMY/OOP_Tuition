package tuition;

class Student extends People {
    private static int stuNum;
    private String stuID;
    private String description;
    private double balance;
    private static int StuCount;
    
    public Student(){
        super();
        this.stuID = null;
        this.description = null;
        this.balance = 0.0;
        this.stuNum++;
        this.StuCount++;
    }
    
    public Student(String name, int age, char sexChar, String phoneNum, String email, String description, double balance) {
        super(name, age, sexChar, phoneNum, email);
        this.stuNum++;
        this.StuCount++;
        this.stuID = "W" + stuNum;
        this.description = description;
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
    
    public String toString() {        
        String message = super.toString() + ", ID: " + stuID + ", Description: " + description + ", Balance: " + balance; 
        return message;
  }
}
