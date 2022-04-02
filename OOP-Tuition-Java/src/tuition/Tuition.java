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
        Screen.clear();
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

                    Course[] psyCourse = new Psychology[10];
                    Course[] itCourse = new IT[10];
                    Course[] langCourse = new Language[10];

                    dummyScript.psyCourseDummyData(psyCourse);
                    dummyScript.itCourseDummyDate(itCourse);
                    dummyScript.langCourseDummyDate(langCourse);
                    
                    //Enter menu with all objects made
                    Screen.clear();
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
            Screen.clear();
            System.out.println("Sorry, you have reached the maximum times of login. Please contact the management for the username and password\n");
            System.out.println("Logout.");
        }



    }
    
    public static void menu(People[] stuArray, People[] tutArray, Course psy, Course it, Course lang, Course[] psyCourse, Course[] itCourse, Course[] langCourse) {
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
            Screen.clear();
             switch (taskChoice) {
                    case 1:
                        addCourse(stuArray, tutArray, psy, it, lang, psyCourse, itCourse, langCourse);
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
                        // new Course
                        int courseChoice = chooseCourse();

                        switch (courseChoice) {
                            case 1:
                                System.out.println("\n==========\nPSYCHOLOGY\n==========");
                                System.out.println(psy.toString());
                                for (int x = 0; x < Psychology.getNumOfPsyCourse(); x++) {
                                    System.out.println((x+1) + ".");
                                    System.out.println(psyCourse[x]);
                                }
                                break;

                            case 2:
                                System.out.println("\n======================\nINFORMATION TECHNOLOGY\n======================");
                                System.out.println(it.toString());
                                for (int y = 0; y < IT.getNumOfItCourse(); y++) {
                                    System.out.println((y+1) + ".");
                                    System.out.println(itCourse[y]);
                                }
                                break;

                            case 3:
                                System.out.println("\n========\nLANGUAGE\n========");
                                System.out.println(lang.toString());
                                for (int z = 0; z < Language.getNumOfLangCourse(); z++) {
                                    System.out.println((z+1) + ".");
                                    System.out.println(langCourse[z]);
                                }
                                break;

                            case 4:
                                Screen.clear();
                                menu(stuArray, tutArray, psy, it, lang, psyCourse, itCourse, langCourse);
                        }
                        break;
                    case 13:
                        System.out.println("Thank YOU!!");
                        break;
        }
            
            
        }while (taskChoice != 13);    
    }

    public static int chooseCourse(){
        Scanner input = new Scanner(System.in);

        System.out.println("\nCourses\n\t1. Psychology\n\t2. Information Technology\n\t3. Language\n\t4. Back to menu");
        System.out.print("Enter a course: ");
        int courseChoice = input.nextInt();

        return courseChoice;
    }

    public static void addCourse(People[] stuArray, People[] tutArray, Course psy, Course it, Course lang, Course[] psyCourse, Course[] itCourse, Course[] langCourse){
        int courseChoice = chooseCourse();

        if(courseChoice == 1){
            addPsyCourse(psyCourse);
        }else if(courseChoice == 2){
            addItCourse(itCourse);
        }else if(courseChoice == 3){
            addLangCourse(langCourse);
        }else{
            Screen.clear();
            menu(stuArray, tutArray, psy, it, lang, psyCourse, itCourse, langCourse);
        }

    }

    public static void addPsyCourse(Course[] psyCourse){
        Scanner input = new Scanner(System.in);
        String code, title, details, description, type, skillLearned;
        int capacity;

        System.out.print("Enter course code: ");
        code = input.nextLine();

        System.out.print("Enter course title: ");
        title = input.nextLine();

        System.out.print("Enter course details: ");
        details = input.nextLine();

        System.out.print("Enter course description: ");
        description = input.nextLine();

        System.out.print("Enter enrollment limit: ");
        capacity = input.nextInt();
        input.nextLine();

        System.out.print("Enter psychology type: ");
        type = input.nextLine();

        System.out.print("Enter skill(s) learned: ");
        skillLearned = input.nextLine();

        psyCourse[(Psychology.getNumOfPsyCourse())] = new Psychology(code, title, details, description, capacity, type, skillLearned);
    }

    public static void addItCourse(Course[] itCourse){
        Scanner input = new Scanner(System.in);
        String code, title, details, description, preRequisite, language;
        int capacity;

        System.out.print("Enter course code: ");
        code = input.nextLine();

        System.out.print("Enter course title: ");
        title = input.nextLine();

        System.out.print("Enter course details: ");
        details = input.nextLine();

        System.out.print("Enter course description: ");
        description = input.nextLine();

        System.out.print("Enter enrollment limit: ");
        capacity = input.nextInt();
        input.nextLine();

        System.out.print("Enter Pre-Requisite course: ");
        preRequisite = input.nextLine();

        System.out.print("Enter programming language used: ");
        language = input.nextLine();

        itCourse[(IT.getNumOfItCourse())] = new IT(code, title, details, description, capacity, preRequisite, language);
    }

    public static void addLangCourse(Course[] langCourse){
        Scanner input = new Scanner(System.in);
        String code, title, details, description, language, system;
        int capacity;

        System.out.print("Enter course code: ");
        code = input.nextLine();

        System.out.print("Enter course title: ");
        title = input.nextLine();

        System.out.print("Enter course details: ");
        details = input.nextLine();

        System.out.print("Enter course description: ");
        description = input.nextLine();

        System.out.print("Enter enrollment limit: ");
        capacity = input.nextInt();
        input.nextLine();

        System.out.print("Enter language of the course: ");
        language = input.nextLine();

        System.out.print("Enter examination system: ");
        system = input.nextLine();

        langCourse[(Language.getNumOfLangCourse())] = new Language(code, title, details, description, capacity, language, system);
    }
    
    public static void displayMenu(){
        System.out.print("\nTTL Tuition Center\nCourse\n\t1. Add course\n\t2. Modify course\n\t3. Remove course"
                                + "\nStudent\n\t4. Add Student\n\t5. Modify Student\n\t6. Remove Student"
                                + "\nTutor\n\t7. Add Tutor\n\t8. Modify Tutor\n\t9. Remove Tutor"
                                + "\nList\n\t10. Student\n\t11. Tutor\n\t12. Course\n13. Exit\nSelect task to perform: ");
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
            peopleArr[((Student) peopleArr[0]).getStuCount()] = new Student(name, age, sex, phoneNum, email, description, balance);
        } else {
            String major = MajorInputValidate();
            String level = LevelInputValidate();

            peopleArr[((Tutor) peopleArr[0]).getTutorCount()] = new Tutor(name, age, sex, phoneNum, email, ((Tutor) peopleArr[0]).getMajor(major), ((Tutor) peopleArr[0]).getLevel(level));
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
                System.out.println("One character Only!");
                valid = false;
            }
            sex = stringSex.charAt(0); 
            if(sex != 'm' && sex != 'f' && sex != 'M' && sex != 'F'){
                System.out.println("Only (m,f,M,F) are allowed!");
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
       double balance = 0;
       boolean valid;
       Scanner input = new Scanner(System.in);
       
       do{
           try{
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
            } catch (Exception e){
                System.out.println("Invalid Input, please make sure you enter correctly!");
                input.next();
                valid = false;
            }
       }while(!valid);
       
       return balance;
   }
   
   public static String MajorInputValidate(){
    String major;
    boolean valid;
    Scanner input = new Scanner(System.in);
    
    do{
        valid = true;
        System.out.print("Enter major (IT, PSY, LANG): ");
        major = input.nextLine();
        if (!major.equals("IT") && !major.equals("PSY") && !major.equals("LANG")){
            valid = false;
            System.out.println("Only IT, PSY, LANG are allowed!");
        }
        else{
            valid = true;
        }

    }while(!valid);


    return major;
   }

         public static String LevelInputValidate(){
    String level;
    boolean valid;
    Scanner input = new Scanner(System.in);
    
    do{
        valid = true;
        System.out.print("Enter level (Doctorate, BachelorDegree, MasterDegree): ");
        level = input.nextLine();
        if (!level.equals("Doctorate") && !level.equals("BacherlorDegree") && !level.equals("MasterDegree")){
            valid = false;
            System.out.println("Only Doctorate, BachelorDegree, MasterDegree are allowed!");
        }
        else{
            valid = true;
        }
    }while(!valid);
    return level;
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
            String message;
            if (peopleArr[0] instanceof Student) {
                message = "Select to modify\n1. Name\n2. Age\n3. Sex\n4. Phone Number\n5. Email\n6. Description\n7. Balance";
            } else{
                message = "Select to modify\n1. Name\n2. Age\n3. Sex\n4. Phone Number\n5. Email\n6. Level";
            }    
            System.out.println(message);
            String stringModifyChoice = input.nextLine();
            int modifyChoice = Integer.parseInt(stringModifyChoice);

            switch (modifyChoice) {
                case 1:
                    String newName = NameInputValidate();
                    peopleArr[tempI].setName(newName);
                    break;
                case 2:
                    int newAge = AgeInputValidate();
                    peopleArr[tempI].setAge(newAge);
                    break;
                case 3:
                    char newSex = SexInputValidate();
                    peopleArr[tempI].setSex(newSex);
                    break;
                case 4:
                    String newNumber = PhoneInputValidate();
                    peopleArr[tempI].setPhoneNum(newNumber);
                    break;
                case 5:
                    String newEmail = EmailInputValidate();
                    peopleArr[tempI].setEmail(newEmail);
                    break;
                case 6:
                    if (peopleArr[0] instanceof Student) {
                        System.out.print("Enter new description: ");
                        String newDescription = input.nextLine();
                        ((Student) peopleArr[tempI]).setDescription(newDescription);
                        break;
                    } else {
                        String newLevel = LevelInputValidate();
                        ((Tutor) peopleArr[tempI]).setLevel(((Tutor) peopleArr[tempI]).getLevel(newLevel));
                        break;
                    }
                case 7:
                    if (peopleArr[0] instanceof Student) {
                        double newBalance = BalanceInputValidate();
                        ((Student) peopleArr[tempI]).setBalance(newBalance);
                        break;
                    } else {
                        System.out.print("Invalid Input");
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
                ((Student)peopleArr[0]).reduceStuCount();
                People[] clonePeople = new Student[((Student)peopleArr[0]).getStuCount()];
                int tempCount = Student.getStuCount();
                clonePeople = peopleArr;
                
                int a = 0;
                // Move Entire student array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount+1; i++){
                    if (! ((Student)peopleArr[i]).getStuID().equals(id)){
                        clonePeople[a] = peopleArr[i];
                        a++;
                    }
                }
                clonePeople[((Student)peopleArr[0]).getStuCount()] = null;
                System.out.println("The Student ID " + id + " has been deleted");
            } else {
                ((Tutor)peopleArr[0]).reduceTutorCount();
                People[] tempPeople = new Tutor[((Tutor)peopleArr[0]).getTutorCount()];
                int tempCount = Tutor.getTutorCount();
                tempPeople = peopleArr;

                int a = 0;
                // Move Entire tutor array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount+1; i++){
                    if (! ((Tutor)peopleArr[i]).getTutorID().equals(id)){
                        tempPeople[a] = peopleArr[i];
                        a++;
                    }

                }
                
                tempPeople[((Tutor)peopleArr[0]).getTutorCount()] = null;
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