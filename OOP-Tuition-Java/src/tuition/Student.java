package tuition;

class Student extends People {
    private static int stuNum;
    private String stuID;
    private String description;
    private double balance;
    
    public Student(){
        super();
        this.stuID = null;
        this.description = null;
        this.balance = 0.0;
    }
    
    public Student(String name, int age, char sex, String phoneNum, String email, String description, double balance) {
        super(name, age, sex, phoneNum, email);
        this.stuNum++;
        this.stuID = "W" + stuNum;
        this.description = description;
        this.balance = balance;
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