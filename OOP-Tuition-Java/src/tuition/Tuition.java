package tuition;

import java.util.Scanner;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tuition {

    private final static String username = "admin";
    private final static String password = "rsf1s3g2";

    public static void main(String[] args) {
        
        //Initialize looping for login
        Scanner input = new Scanner(System.in);
        int times = 3;
        boolean contactManagement = false;
        
        //Start Login
        System.out.println("Login Page");
        do {
            try{
                System.out.print("Username: ");
                String enteredUsername = input.nextLine();
                System.out.print("Password: ");
                String enteredPassword = input.nextLine();
                if (!enteredUsername.equals(username) || !enteredPassword.equals(password)){
                    throw new InvalidException();
                }
                else{
                    //Stop Loop when correct username and password
                    times = 0;
                    contactManagement = false;
                    
                    //Initialize and load dummy data
                    People[] stuArray = new Student[100];
                    People[] tutArray = new Tutor[50];
                    dummyScript.dummyData(stuArray);
                    dummyScript.dummyData2(tutArray);

                    Course Psychology = new Course();
                    Course IT = new Course();
                    Course Language = new Course();
                    dummyScript.CourseDummyData(Psychology, IT, Language);

                    Psychology[] psyCourse = new Psychology[3];
                    IT[] itCourse = new IT[3];
                    Language[] langCourse = new Language[3];

                    dummyScript.psyCourseDummyData(psyCourse);
                    dummyScript.itCourseDummyDate(itCourse);
                    dummyScript.langCourseDummyDate(langCourse);
                    
                    //Enter menu with all objects made
                    menu(stuArray, tutArray, Psychology, IT, Language, psyCourse, itCourse, langCourse);
                }

            }
            catch(InvalidException e){
                System.out.print(e.getErrorMsg());
                times--;
                contactManagement = true;
            }
        } while (times > 0);

        if (contactManagement) {
            System.out.println("Sorry, you have reached the maximum times of login. Please contact the management for the username and password\n");
            System.out.println("Logout.");
        }



    }
    
    public static void menu(People[] stuArray, People[] tutArray, Course Psychology, Course IT, Course Language, Psychology[] psyCourse, IT[] itCourse, Language[] langCourse) {
        Scanner input = new Scanner(System.in);


        int taskChoice = 0;
        
        do {
            try{
                displayMenu();
                taskChoice = input.nextInt();
                if(taskChoice != 1 && taskChoice!= 2 && taskChoice!= 3 && taskChoice!= 4 && taskChoice!= 5 && taskChoice!= 6 && taskChoice!= 7 && taskChoice!= 8 && taskChoice!= 9 && taskChoice!= 10 && taskChoice!= 11 && taskChoice!= 12 && taskChoice!= 13 && taskChoice != 14){
                    System.out.print("Only (1-14) is allowed, please try again!\n");
                }

            } catch (Exception e){
                System.out.print("Only (1-14) is allowed, please try again!\n");
                input.next();
            }
             switch (taskChoice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        addPeople(stuArray);
                        break;
                    case 5:
                        modifyPeople(stuArray);
                        break;
                    case 6:
                        deletePeople(stuArray);
                        break;
                    case 7:
                        addPeople(tutArray);
                        break;
                    case 8:
                        modifyPeople(tutArray);
                        break;
                    case 9:
                        deletePeople(tutArray);
                        break;
                    case 10:
                        //new peopleTable(stuArray);
                        for (int i = 0; i < Student.getStuCount(); i++) {
                            System.out.println(stuArray[i]);
                        }
                        break;
                    case 11:
                        //new peopleTable(tutArray);
                        for (int i = 0; i < Tutor.getTutorCount(); i++) {
                            System.out.println(tutArray[i].toString());
                        }
                        break;
                    case 12:
                        //new Course
                        System.out.println(Psychology.toString());
                        System.out.println(IT.toString());
                        System.out.println(Language.toString());
                        break;
                    case 13:
                        for (int x = 0; x < psyCourse.length; x++) {
                            System.out.println(psyCourse[x]);
                        }

                        for (int y = 0; y < itCourse.length; y++) {
                            System.out.println(itCourse[y]);
                        }

                        for (int z = 0; z < langCourse.length; z++) {
                            System.out.println(langCourse[z]);
                        }
                        break;
                    case 14:
                        System.out.println("Thank YOU!!");
                        break;
        }
            
            
        }while (taskChoice != 14);    
    }
    
    public static void displayMenu(){
        System.out.print("TTL Tuition Center\nCourse\n\t1. Add course\n\t2. Modify course\n\t3. Remove course"
                                + "\nStudent\n\t4. Add Student\n\t5. Modify Student\n\t6. Remove Student"
                                + "\nTutor\n\t7. Add Tutor\n\t8. Modify Tutor\n\t9. Remove Tutor"
                                + "\nList\n\t10. Student\n\t11. Tutor\n\t12. Course\n\t13. Language\n14. Exit\nSelect task to perform: ");
    }
    

    public static void addPeople(People[] peopleArr) {
        Scanner input = new Scanner(System.in);
        String name, phoneNum, email, description;
        char sex;
        int age;
        double balance;
        boolean valid = true;
        

            valid = true;
            
            //Input and Validation
            name = NameInputValidate();         
            age = AgeInputValidate();
            sex = SexInputValidate();
            phoneNum = PhoneInputValidate();
            email = EmailInputValidate();    
            

        if (peopleArr[0] instanceof Student) {
            System.out.print("Enter description: ");
            description = input.nextLine();
            balance = BalanceInputValidate();
            peopleArr[((Student) peopleArr[0]).getStuNum()] = new Student(name, age, sex, phoneNum, email, description, balance);
        } else {
            System.out.print("Enter major (IT, PSY, HR): ");
            String major = input.nextLine();
            System.out.print("Enter level (Doctorate, BachelorDegree, MasterDegree): ");
            String level = input.nextLine();

            peopleArr[((Tutor) peopleArr[0]).getTutorNum()] = new Tutor(name, age, sex, phoneNum, email, ((Tutor) peopleArr[0]).getMajor(major), ((Tutor) peopleArr[0]).getLevel(level));
        }
    }
    
    public static String NameInputValidate(){
        boolean valid;
        String name = "";
        Scanner input = new Scanner(System.in);
        
        do{
            valid = true;
            System.out.print("Enter name: ");
            name = input.nextLine();
            if(isWord(name)){
                valid = true;
            } else{
                System.out.println("Invalid Input!!");               
                valid = false;
            }
           if(name.length() > 50){
               System.out.println("Name cannot be longer than 50 letters!");
               valid = false;
           }
        }while(!valid);

        return name;
    }
    
    public static int AgeInputValidate(){
        int age = 0;

        boolean valid;
        Scanner input = new Scanner(System.in);
        
        do{
            valid = true;
            try{
                System.out.print("Enter age: ");
                age = input.nextInt();
                if(age >= 0 && age <= 150){
                    valid = true;
                }
                else{
                    System.out.println("Age is not valid!");
                    valid = false;
                }
            }catch (Exception e){
                System.out.println("Invalid Input, please make sure you enter correctly!");
                input.next();
                valid = false;
            }

        }while(!valid);    
        
        return age;
    }
 
    public static char SexInputValidate(){
        char sex = 'A';
        String stringSex;
        boolean valid;
        Scanner input = new Scanner(System.in);
        
        do{
            valid = true;

            System.out.print("Enter sex: ");
            stringSex = input.nextLine();
            if(stringSex.length() == 1){
                valid = true;
            }
            else{
                System.out.println("Only M or F are allowed!");
                valid = false;
            }
            sex = stringSex.charAt(0); 
            if(sex != 'm' && sex != 'f' && sex != 'M' && sex != 'F'){
                System.out.println("Only M or F are allowed!");
                valid = false;
            }
            else{
                valid = true;
            }
            if(Character.isLowerCase(sex)){
                sex = Character.toUpperCase(sex);
            }

        }while(!valid);
        
        return sex;
    }
    
    public static String PhoneInputValidate(){
        String phoneNum;
        boolean valid;
        Scanner input = new Scanner(System.in);
        
        do{
            valid = true;
            System.out.print("Enter phone number(+6017-725 5766): ");
            phoneNum = input.nextLine();
            if(PhoneIsValid(phoneNum)){
                valid = true;
            }
            else{
                valid = false;
                System.out.println("Incorrect Format");
            }
        }while(!valid);
            
            
        
        return phoneNum;
    }
    
    public static boolean PhoneIsValid(String s){
        Pattern p = Pattern.compile("^\\+601\\d-\\d{3}\\s\\d{4}");
        
        Matcher m = p.matcher(s);
        
        return (m.matches());
    }

    public static String EmailInputValidate(){
        String email;
        boolean valid;
        Scanner input = new Scanner(System.in);
        
        do{
            valid = true;
            System.out.print("Enter email: ");
            email = input.nextLine();
            if(EmailisValid(email)){
                valid = true;
            }
            else{
                valid = false;
                System.out.println("Please enter a valid email!");
            }
        }while(!valid);
        
        return email;
    }
    
   static boolean EmailisValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
    
   public static double BalanceInputValidate(){
       double balance;
       boolean valid;
       Scanner input = new Scanner(System.in);
       
       
       do{
           valid = true;
           System.out.print("Enter balance: ");
           balance = input.nextDouble();
           if(balance > 0 ){
               valid = true;
           }
           else{
               valid = false;
               System.out.println("Balance cannot be lower than 0!");
           }
       }while(!valid);
       

       
       return balance;
   }
   
   
    public static void modifyPeople(People[] peopleArr) {
        Scanner input = new Scanner(System.in);
        boolean peopleExist = false;
        int tempI = 0;
        System.out.print("Enter ID to modify: ");
        String id = input.nextLine();

        if (peopleArr[0] instanceof Student) {
            for (int i = 0; i < Student.getStuCount(); i++) {
                if ((((Student) peopleArr[i]).getStuID()).equals(id)) {
                    System.out.println("Yes Student");
                    peopleExist = true;
                    tempI = i;
                }
            }
        } else {
            for (int i = 0; i < Tutor.getTutorCount(); i++) {
                if ((((Tutor) peopleArr[i]).getTutorID()).equals(id)) {
                    System.out.println("Yes Tutor");
                    peopleExist = true;
                    tempI = i;
                }
            }
        }

        if (peopleExist) {
            if (peopleArr[0] instanceof Student) {
                System.out.print("Select to modify\n1. Name\n2. Age\n3. Sex\n4. Phone Number\n5. Email\n6. Description\n7. Balance");
                String stringModifyChoice = input.nextLine();
                int modifyChoice = Integer.parseInt(stringModifyChoice);

                switch (modifyChoice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        String newName = input.nextLine();
                        peopleArr[tempI].setName(newName);
                        break;
                    case 2:
                        System.out.print("Enter new age: ");
                        int newAge = input.nextInt();
                        peopleArr[tempI].setAge(newAge);
                        break;
                    case 3:
                        System.out.print("Enter new sex: ");
                        char newSex = input.next().charAt(0);
                        peopleArr[tempI].setSex(newSex);
                        break;
                    case 4:
                        System.out.print("Enter new phone number: ");
                        String newNumber = input.nextLine();
                        peopleArr[tempI].setPhoneNum(newNumber);
                        break;
                    case 5:
                        System.out.print("Enter new email: ");
                        String newEmail = input.nextLine();
                        peopleArr[tempI].setEmail(newEmail);
                        break;
                    case 6:
                        System.out.print("Enter new description: ");
                        String newDescription = input.nextLine();
                        ((Student) peopleArr[tempI]).setDescription(newDescription);
                        break;
                    case 7:
                        System.out.print("Enter new balance: ");
                        double newBalance = input.nextDouble();
                        ((Student) peopleArr[tempI]).setBalance(newBalance);
                        break;
                }

            } else {
                System.out.print("Select to modify\n1. Name\n2. Age\n3. Sex\n4. Phone Number\n5. Email\n6. Level");
                String stringModifyChoice = input.nextLine();
                int modifyChoice = Integer.parseInt(stringModifyChoice);

                switch (modifyChoice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        String newName = input.nextLine();
                        peopleArr[tempI].setName(newName);
                        break;
                    case 2:
                        System.out.print("Enter new age: ");
                        int newAge = input.nextInt();
                        peopleArr[tempI].setAge(newAge);
                        break;
                    case 3:
                        System.out.print("Enter new sex: ");
                        char newSex = input.next().charAt(0);
                        peopleArr[tempI].setSex(newSex);
                        break;
                    case 4:
                        System.out.print("Enter new phone number: ");
                        String newNumber = input.nextLine();
                        peopleArr[tempI].setPhoneNum(newNumber);
                        break;
                    case 5:
                        System.out.print("Enter new email: ");
                        String newEmail = input.nextLine();
                        peopleArr[tempI].setEmail(newEmail);
                        break;
                    case 6:
                        System.out.print("Enter new level: ");
                        String newLevel = input.nextLine();
                        ((Tutor) peopleArr[tempI]).setLevel(((Tutor) peopleArr[tempI]).getLevel(newLevel));
                        break;
                }
            }
        } else {
            System.out.println("The ID doesn't exist");
        }
    }

    public static void deletePeople(People[] peopleArr) {
        Scanner input = new Scanner(System.in);
        boolean peopleExist = false;
        int tempI = 0;
        System.out.print("Enter ID to delete: ");
        String id = input.nextLine();

        if (peopleArr[0] instanceof Student) {
            for (int i = 0; i < Student.getStuNum(); i++) {
                if ((((Student) peopleArr[i]).getStuID()).equals(id)) {
                    System.out.println("Yes Student");
                    peopleExist = true;
                    tempI = i;
                }
            }
        } else {
            for (int i = 0; i < Tutor.getTutorNum(); i++) {
                if ((((Tutor) peopleArr[i]).getTutorID()).equals(id)) {
                    System.out.println("Yes Tutor");
                    peopleExist = true;
                    tempI = i;
                }
            }
        }

        if (peopleExist) {
            if (peopleArr[0] instanceof Student) {
                ((Student)peopleArr[0]).reduceStuCount();
                People[] clonePeople = new Student[((Student)peopleArr[0]).getStuCount()];
                People[] tempPeople = new Student[((Student)peopleArr[0]).getStuCount()];
                int tempCount = Student.getStuCount();
                clonePeople = peopleArr.clone();
                System.out.println(clonePeople[0]);
                tempPeople = peopleArr;
                
                int a = 0;
                // Move Entire student array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount+1; i++){
                    if (! ((Student)peopleArr[i]).getStuID().equals(id)){
                        System.out.println(a + " to " + i);
                        clonePeople[a] = peopleArr[i];
//                        System.out.println(a);
//                        System.out.println(tempPeople[a]);
                        a++;
                    }
                }
                tempPeople = clonePeople;
                System.out.println("The Student ID " + id + " has been deleted");
            } else {
                People[] tempPeople1 = new Tutor[((Tutor)peopleArr[0]).getTutorCount()-1];
                ((Tutor)peopleArr[0]).reduceTutorCount();
                int tempCount = Tutor.getTutorCount();
                tempPeople1 = peopleArr.clone();

                int a = 0;
                // Move Entire tutor array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount+1; i++){
                    if (! ((Tutor)peopleArr[i]).getTutorID().equals(id)){
                        tempPeople1[a] = peopleArr[i];
                        a++;
                    }

                }
                peopleArr = tempPeople1;
                System.out.println("The Tutor ID " + id + " has been deleted");
            }
        } else {
            System.out.println("The ID doesn't exist");
        }
    }

    private static boolean isWord(String name) {
        return Pattern.matches("[a-zA-Z]+", name);
    }
    
    // Exception for handling invalid username or password
  private static class InvalidException extends Exception {
      private final String errorMsg;
      
      InvalidException(){
          this.errorMsg = "Invalid Password or Username, please try again!\n";
      }
      
      
      public String getErrorMsg(){
          return errorMsg;
      }
  }
  
  
}
