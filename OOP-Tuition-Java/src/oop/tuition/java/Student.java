class Student extends People {
    static int stuNum;
    String stuID;
    String description;
    double balance;
    
    public Student(String name, int age, char sex, String phoneNum, String email, String description, double balance) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.email = email;
        this.stuNum++;
        this.stuID = "W" + stuNum;
        this.description = description;
        this.balance = balance;
    }
    
    public String toString() {
        String message;
        
        message = "Name: " + this.name + "\nID: " + this.stuID; 
        
        return message;
  }
}
