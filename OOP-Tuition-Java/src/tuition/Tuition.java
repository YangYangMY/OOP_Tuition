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
                Font.print(Font.ANSI_RED, e.getErrorMsg());
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
                if(taskChoice != 1 && taskChoice!= 2 && taskChoice!= 3 && taskChoice!= 4 && taskChoice!= 5 && taskChoice!= 6 && taskChoice!= 7 && taskChoice!= 8 && taskChoice!= 9 && taskChoice!= 10 && taskChoice!= 11 && taskChoice!= 12){
                    Screen.clear();
                    Font.print(Font.ANSI_RED,"Only (1-12) is allowed, please try again!\n");
                }

            } catch (Exception e){
                Screen.clear();
                Font.print(Font.ANSI_RED,"Only (1-12) is allowed, please try again!\n");
                input.next();
            }
             switch (taskChoice) {
                    case 1:
                        addCourse(stuArray, tutArray, psy, it, lang, psyCourse, itCourse, langCourse);
                        break;
                    case 2:
                        modifyCourse(psyCourse, itCourse, langCourse);
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
                        }
                        break;
                    case 11:
                        Screen.clear();
                        report(stuArray, tutArray, psy, it, lang, psyCourse, itCourse, langCourse);
                        break;
                    case 12:
                        System.out.println("Thank YOU!!");
                        break;
        }
        }while (taskChoice != 12);    
    }

    public static void displayMenu(){
        System.out.print("\nTTL Tuition Center\nCourse\n\t1. Add course\n\t2. Modify course\n\t3. Remove course"
                                + "\nStudent\n\t4. Add Student\n\t5. Modify Student\n\t6. Remove Student"
                                + "\nTutor\n\t7. Add Tutor\n\t8. Modify Tutor\n\t9. Remove Tutor"
                                + "\n10.Course\n11.Report\n12. Exit\nSelect task to perform: ");
    }

    public static int chooseCourse(){
        Screen.clear();
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
        }

    }

    public static void addPsyCourse(Course[] psyCourse){
        Scanner input = new Scanner(System.in);
        String code, title, details, description, type, skillLearned;
        double fee;
        int capacity;

        System.out.print("Enter course code: ");
        code = input.nextLine();

        System.out.print("Enter course title: ");
        title = input.nextLine();

        System.out.print("Enter course details: ");
        details = input.nextLine();

        System.out.print("Enter course description: ");
        description = input.nextLine();

        System.out.print("Enter course fee: ");
        fee = input.nextDouble();

        System.out.print("Enter enrollment limit: ");
        capacity = input.nextInt();
        input.nextLine();

        System.out.print("Enter psychology type: ");
        type = input.nextLine();

        System.out.print("Enter skill(s) learned: ");
        skillLearned = input.nextLine();

        psyCourse[(Psychology.getNumOfPsyCourse())] = new Psychology(code, title, details, description, fee, capacity, type, skillLearned);
    }

    public static void addItCourse(Course[] itCourse){
        Scanner input = new Scanner(System.in);
        String code, title, details, description, preRequisite, language;
        double fee;
        int capacity;

        System.out.print("Enter course code: ");
        code = input.nextLine();

        System.out.print("Enter course title: ");
        title = input.nextLine();

        System.out.print("Enter course details: ");
        details = input.nextLine();

        System.out.print("Enter course description: ");
        description = input.nextLine();

        System.out.print("Enter course fee: ");
        fee = input.nextDouble();

        System.out.print("Enter enrollment limit: ");
        capacity = input.nextInt();
        input.nextLine();

        System.out.print("Enter Pre-Requisite course: ");
        preRequisite = input.nextLine();

        System.out.print("Enter programming language used: ");
        language = input.nextLine();

        itCourse[(IT.getNumOfItCourse())] = new IT(code, title, details, description, fee, capacity, preRequisite, language);
    }

    public static void addLangCourse(Course[] langCourse){
        Scanner input = new Scanner(System.in);
        String code, title, details, description, language, system;
        double fee;
        int capacity;

        System.out.print("Enter course code: ");
        code = input.nextLine();

        System.out.print("Enter course title: ");
        title = input.nextLine();

        System.out.print("Enter course details: ");
        details = input.nextLine();

        System.out.print("Enter course description: ");
        description = input.nextLine();

        System.out.print("Enter course fee: ");
        fee = input.nextDouble();

        System.out.print("Enter enrollment limit: ");
        capacity = input.nextInt();
        input.nextLine();

        System.out.print("Enter language of the course: ");
        language = input.nextLine();

        System.out.print("Enter examination system: ");
        system = input.nextLine();

        langCourse[(Language.getNumOfLangCourse())] = new Language(code, title, details, description, fee, capacity, language, system);
    }

    public static void modifyPsyCourse(Course[] psyCourse, Course modifyCourse){
        Scanner input = new Scanner(System.in);
        int psyModifyChoice = 0;
        boolean isValid = false;

        System.out.println("\n==========\nPSYCHOLOGY\n==========");

        do {
            System.out.print(
                    "\t1. Course code\n\t2. Course Title\n\t3. Course Details\n\t4. Course Description\n\t5. Course Fee\n\t6. Psychology type\n\t7. Skill(s) learned\nChoose what to modify: ");
            psyModifyChoice = input.nextInt();
            input.nextLine();

            if (psyModifyChoice >= 1 && psyModifyChoice <= 7) {
                isValid = true;
            } else {
                System.out.println("\nOnly (1-7) is allowed. Please try again!");
            }
        } while (isValid == false);

        switch (psyModifyChoice) {
            case 1:
                // Modify course code
                System.out.print("Enter new course code: ");
                String courseCode = input.nextLine();
                modifyCourse.setCode(courseCode);
                break;

            case 2:
                // Modify course title
                System.out.print("Enter new course title: ");
                String courseTitle = input.nextLine();
                modifyCourse.setTitle(courseTitle);
                break;

            case 3:
                // Modify course details
                System.out.print("Enter new course details: ");
                String courseDetails = input.nextLine();
                modifyCourse.setDetails(courseDetails);
                break;

            case 4:
                // Modyfy course description
                System.out.print("Enter new course description: ");
                String courseDescription = input.nextLine();
                modifyCourse.setDescription(courseDescription);
                break;

            case 5:
                // Modyfy course fee
                System.out.print("Enter new course fee: ");
                double fee = input.nextDouble();
                modifyCourse.setFee(fee);
                break;

            case 6:
                // Modify type
                System.out.print("Enter new psychology type: ");
                String type = input.nextLine();
                ((Psychology)modifyCourse).setType(type);
                break;

            case 7:
                // Modify skill learned
                System.out.print("Enter new skill(s) learned: ");
                String skillLearned = input.nextLine();
                ((Psychology)modifyCourse).setSkillLearned(skillLearned);
                break;
        }
    }

    public static void modifyitCourse(Course[] itCourse, Course modifyCourse){
        Scanner input = new Scanner(System.in);

        System.out.println("\n======================\nINFORMATION TECHNOLOGY\n======================");
        int itModifyChoice = 0;
        boolean isValid = false;

        do {
            System.out.print(
                    "\t1. Course code\n\t2. Course Title\n\t3. Course Details\n\t4. Course Description\n\t5. Course Fee\n\t6. Pre-Requisite\n\t7. Programming Language\nChoose what to modify: ");
            itModifyChoice = input.nextInt();
            input.nextLine();
            
            if (itModifyChoice >= 1 && itModifyChoice <= 7) {
                isValid = true;
            } else {
                System.out.println("\nOnly (1-7) is allowed. Please try again!");
            }
        } while (isValid == false);

        switch (itModifyChoice) {
            case 1:
                // Modify course code
                System.out.print("Enter new course code: ");
                String courseCode = input.nextLine();
                modifyCourse.setCode(courseCode);
                break;

            case 2:
                // Modify course title
                System.out.print("Enter new course title: ");
                String courseTitle = input.nextLine();
                modifyCourse.setTitle(courseTitle);
                break;

            case 3:
                // Modify course details
                System.out.print("Enter new course details: ");
                String courseDetails = input.nextLine();
                modifyCourse.setDetails(courseDetails);
                break;

            case 4:
                // Modyfy course description
                System.out.print("Enter new course description: ");
                String courseDescription = input.nextLine();
                modifyCourse.setDescription(courseDescription);
                break;

            case 5:
                // Modyfy course fee
                System.out.print("Enter new course fee: ");
                double fee = input.nextDouble();
                modifyCourse.setFee(fee);
                break;

            case 6:
                // Modify pre-requisite
                System.out.print("Enter new Pre-Requisite: ");
                String preRequisite = input.nextLine();
                ((IT)modifyCourse).setPreRequisite(preRequisite);
                break;

            case 7:
                // Modify programming language
                System.out.print("Enter new programming language: ");
                String programmingLanguage = input.nextLine();
                ((IT)modifyCourse).setProgrammingLanguage(programmingLanguage);
                break;
        }
    }

    public static void modifyLangCourse(Course[] itCourse, Course modifyCourse){
        Scanner input = new Scanner(System.in);
        System.out.println("\n========\nLANGUAGE\n========");
        int langModifyChoice = 0;
        boolean isValid = false;
        do {
            System.out.print(
                    "\t1. Course code\n\t2. Course Title\n\t3. Course Details\n\t4. Course Description\n\t5. Course Fee\n\t6. Language\n\t7. System\nChoose what to modify: ");
            langModifyChoice = input.nextInt();
            input.nextLine();

            if (langModifyChoice >= 1 && langModifyChoice <= 7) {
                isValid = true;
            } else {
                System.out.println("\nOnly (1-7) is allowed. Please try again!");
            }
        } while (isValid == false);

        switch (langModifyChoice) {
            case 1:
                // Modify course code
                System.out.print("Enter new course code: ");
                String courseCode = input.nextLine();
                modifyCourse.setCode(courseCode);
                break;

            case 2:
                // Modify course title
                System.out.print("Enter new course title: ");
                String courseTitle = input.nextLine();
                modifyCourse.setTitle(courseTitle);
                break;

            case 3:
                // Modify course details
                System.out.print("Enter new course details: ");
                String courseDetails = input.nextLine();
                modifyCourse.setDetails(courseDetails);
                break;

            case 4:
                // Modyfy course description
                System.out.print("Enter new course description: ");
                String courseDescription = input.nextLine();
                modifyCourse.setDescription(courseDescription);
                break;

            case 5:
                // Modyfy course fee
                System.out.print("Enter new course fee: ");
                double fee = input.nextDouble();
                modifyCourse.setFee(fee);
                break;  

            case 6:
                // Modify language
                System.out.print("Enter new language: ");
                String language = input.nextLine();
                ((Language)modifyCourse).setLanguage(language);
                break;

            case 7:
                // Modify system
                System.out.print("Enter new examination system: ");
                String system = input.nextLine();
                ((Language)modifyCourse).setSystem(system);
                break;
        }
    }

    public static void modifyCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse) {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;

        System.out.print("\nEnter course code to modify: ");
        String code = input.nextLine();

        for (int x = 0; x < Psychology.getNumOfPsyCourse(); x++) {
            if ((psyCourse[x].getCode()).equals(code)) {
                isValid = true;
                modifyPsyCourse(psyCourse, psyCourse[x]);
            }
        }

        for (int y = 0; y < IT.getNumOfItCourse(); y++) {
            if ((itCourse[y].getCode()).equals(code)) {
                isValid = true;
                modifyitCourse(itCourse, itCourse[y]);
            }
        }

        for (int z = 0; z < Language.getNumOfLangCourse(); z++) {
            if ((langCourse[z].getCode()).equals(code)) {
                isValid = true;
                modifyLangCourse(itCourse, langCourse[z]);
            }
        }

        if(isValid == false){
            System.out.print("\nThis course code does not exist. Please try again!");
            modifyCourse(psyCourse, itCourse, langCourse);
        }
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
                Font.print(Font.ANSI_RED,"Invalid Input!!");               
                valid = false;
            }
           if(name.length() > 50){
            Font.print(Font.ANSI_RED,"Name cannot be longer than 50 letters!");
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
                    Font.print(Font.ANSI_RED,"Age is not valid!");
                    valid = false;
                }
            }catch (Exception e){
                Font.print(Font.ANSI_RED,"Invalid Input, please make sure you enter correctly!");
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
                Font.print(Font.ANSI_RED,"One character Only!");
                valid = false;
            }
            sex = stringSex.charAt(0); 
            if(sex != 'm' && sex != 'f' && sex != 'M' && sex != 'F'){
                Font.print(Font.ANSI_RED,"Only (m,f,M,F) are allowed!");
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
                Font.print(Font.ANSI_RED,"Incorrect Format");
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
                Font.print(Font.ANSI_RED,"Please enter a valid email!");
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
                    Font.print(Font.ANSI_RED,"Balance cannot be lower than 0!");
                }
            } catch (Exception e){
                Font.print(Font.ANSI_RED,"Invalid Input, please make sure you enter correctly!");
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
            Font.print(Font.ANSI_RED,"Only IT, PSY, LANG are allowed!");
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
            Font.print(Font.ANSI_RED,"Only Doctorate, BachelorDegree, MasterDegree are allowed!");
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
                        Font.print(Font.ANSI_RED,"Invalid Input");
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
  
    public static void report(People[] stuArray, People[] tutArray, Course psy, Course it, Course lang, Course[] psyCourse, Course[] itCourse, Course[] langCourse){
        int userChoice;
        Scanner input = new Scanner(System.in);
        
        do{
            try{
                
                Font.print(Font.CYAN_BOLD_BRIGHT, "Report");
                System.out.println("----------------");
                System.out.println("1. Student Report");
                System.out.println("2. Tutor Report");
                System.out.println("3. Summary Report");
                System.out.println("4. Back");
                System.out.print("Enter Choice: ");
                userChoice = input.nextInt();
                if(userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4){
                    Screen.clear();
                    Font.print(Font.ANSI_RED,"Only (1-5) are allowed!");
                }
            }catch(Exception e){
                Screen.clear();
                Font.print(Font.ANSI_RED,"Invalid Input");
                input.next();
                userChoice = 100;
            }
            
            switch(userChoice){
                case 1:
                Font.print(Font.ANSI_BLUE, "Student Report");
                StudentReport(stuArray);
                    break;
                case 2:
                    Font.print(Font.ANSI_BLUE, "Tutor Report");
                    TutorReport(tutArray);
                    break;
                case 3:
                    Font.print(Font.ANSI_BLUE, "Summary Report");
                    break;
            }
        } while(userChoice != 4);
    }


    public static void StudentReport(People[] stuArray){
        Screen.clear();
        System.out.println("=====================================================================================================================================================================");
        System.out.printf("%12s %19s %15s %6s %17s %23s %22s %12s", "Student ID", "Name", "Age", "Sex", "Phone Number", "Email", "Description", "Balance");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Student.getStuCount(); i++) {
            System.out.printf("%9s %30s %6s %6s %19s %30s %12s %13s",((Student)stuArray[i]).getStuID() , stuArray[i].getName(), stuArray[i].getAge(), stuArray[i].getSex(), stuArray[i].getPhoneNum(), stuArray[i].getEmail(), ((Student)stuArray[i]).getDescription(), ((Student)stuArray[i]).getBalance());
            System.out.println();
        }
        System.out.println("=====================================================================================================================================================================");
    }
    
    public static void TutorReport(People[] tutArray){
        Screen.clear();
        System.out.println("=====================================================================================================================================================================");
        System.out.printf("%10s %22s %15s %6s %15s %26s %18s %14s", "Tutor ID", "Name", "Age", "Sex", "Phone Number", "Email", "Major", "Level");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Tutor.getTutorCount(); i++) {
            System.out.printf("%8s %30s %9s %5s %17s %33s %9s %19s",((Tutor)tutArray[i]).getTutorID() , tutArray[i].getName(), tutArray[i].getAge(), tutArray[i].getSex(), tutArray[i].getPhoneNum(), tutArray[i].getEmail(), ((Tutor)tutArray[i]).getMajor(), ((Tutor)tutArray[i]).getLevelName());
            System.out.println();
        }
        System.out.println("=====================================================================================================================================================================");
    }

    public static void SummaryReport(){
        Screen.clear();
        // Course Name + Tutor Name + Number of Student + Total Profit
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
