package tuition;

import java.util.Scanner;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tuition.Tutor.Major;

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
        Font.print(Font.ANSI_YELLOW,"            _____ _____ __       _____     _ _   _            _____         _           ");
        Font.print(Font.ANSI_YELLOW,"           |_   _|_   _|  |     |_   _|_ _|_| |_|_|___ ___   |     |___ ___| |_ ___ ___ ");
        Font.print(Font.ANSI_YELLOW,"             | |   | | |  |__     | | | | | |  _| | . |   |  |   --| -_|   |  _| -_|  _|");
        Font.print(Font.ANSI_YELLOW,"             |_|   |_| |_____|    |_| |___|_|_| |_|___|_|_|  |_____|___|_|_|_| |___|_|  ");
        System.out.println("\n");
        Font.print(Font.ANSI_BLUE,"                                          Login Page");
        System.out.println("\n");
        do {
            try {
                System.out.print("                                   Username: ");
                String enteredUsername = input.nextLine();
                System.out.print("                                   Password: ");
                String enteredPassword = input.nextLine();
                if (!enteredUsername.equals(username) || !enteredPassword.equals(password)) {
                    throw new InvalidException();
                } else {
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

                    Enroll[] enrollArr = new Enroll[200];
                    dummyScript.enrollment(enrollArr, stuArray, psyCourse, itCourse, langCourse);

                    Register[] regArr = new Register[30];
                    dummyScript.registration(regArr, tutArray, psyCourse, itCourse, langCourse);
                    //Enter menu with all objects made
                    Screen.clear();
                    menu(stuArray, tutArray, Psychology, IT, Language, psyCourse, itCourse, langCourse, enrollArr, regArr);
                }

            } catch (InvalidException e) {
                Screen.clear();
                Font.print(Font.ANSI_YELLOW,"            _____ _____ __       _____     _ _   _            _____         _           ");
                Font.print(Font.ANSI_YELLOW,"           |_   _|_   _|  |     |_   _|_ _|_| |_|_|___ ___   |     |___ ___| |_ ___ ___ ");
                Font.print(Font.ANSI_YELLOW,"             | |   | | |  |__     | | | | | |  _| | . |   |  |   --| -_|   |  _| -_|  _|");
                Font.print(Font.ANSI_YELLOW,"             |_|   |_| |_____|    |_| |___|_|_| |_|___|_|_|  |_____|___|_|_|_| |___|_|  ");
                System.out.println("\n");
                Font.print(Font.ANSI_BLUE,"                                          Login Page");
                System.out.println("\n");
                Font.print(Font.ANSI_RED, e.getErrorMsg());
                times--;
                contactManagement = true;
            }
        } while (times > 0);

        if (contactManagement) {
            Screen.clear();
            Font.print(Font.ANSI_YELLOW,"              _____ _____ __       _____     _ _   _            _____         _           ");
            Font.print(Font.ANSI_YELLOW,"             |_   _|_   _|  |     |_   _|_ _|_| |_|_|___ ___   |     |___ ___| |_ ___ ___ ");
            Font.print(Font.ANSI_YELLOW,"               | |   | | |  |__     | | | | | |  _| | . |   |  |   --| -_|   |  _| -_|  _|");
            Font.print(Font.ANSI_YELLOW,"               |_|   |_| |_____|    |_| |___|_|_| |_|___|_|_|  |_____|___|_|_|_| |___|_|  ");
            System.out.println("\n");
            Font.print(Font.ANSI_RED, "   Sorry, you have reached the maximum times of login. Please contact the management for the username and password\n");
            Screen.pause(2);
            Screen.clear();
            Font.print(Font.ANSI_YELLOW,"                                                          __ __ ");
            Font.print(Font.ANSI_YELLOW,"                _____ _           _      __ __           |  |  |");
            Font.print(Font.ANSI_YELLOW,"               |_   _| |_ ___ ___| |_   |  |  |___ _ _   |  |  |");
            Font.print(Font.ANSI_YELLOW,"                 | | |   | .'|   | '_|  |_   _| . | | |  |__|__|");
            Font.print(Font.ANSI_YELLOW,"                 |_| |_|_|__,|_|_|_,_|    |_| |___|___|  |__|__|");
        }
    }

    public static void menu(People[] stuArray, People[] tutArray, Course psy, Course it, Course lang, Course[] psyCourse, Course[] itCourse, Course[] langCourse, Enroll[] enrollArr, Register[] regArr) {
        Scanner input = new Scanner(System.in);

        int taskChoice = 0;
        
        do {
            try {
                taskChoice = 0;
                displayMenu();
                taskChoice = input.nextInt();
                if (taskChoice < 1 || taskChoice > 17) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-16) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-16) is allowed, please try again!\n");
                input.next();
            }
            switch (taskChoice) {
                case 1:
                    int courseChoice = chooseCourse();
                    Screen.clear();
                    addCourse(psy, it, lang, psyCourse, itCourse, langCourse, courseChoice);
                    break;
                case 2:
                    Screen.clear();
                    modifyCourse(psyCourse, itCourse, langCourse);
                    break;
                case 3:
                    Screen.clear();
                    deleteCourse(psyCourse, itCourse, langCourse, regArr, enrollArr);
                    break;
                case 4:
                    addPeople(stuArray);
                    break;
                case 5:
                    modifyPeople(stuArray);
                    break;
                case 6:
                    deletePeople(stuArray, enrollArr, regArr);
                    break;
                case 7:
                    addPeople(tutArray);
                    break;
                case 8:
                    modifyPeople(tutArray);
                    break;
                case 9:
                    deletePeople(tutArray, enrollArr, regArr);
                    break;
                case 10:
                    //add enroll
                    Screen.clear();
                    enrollFunction.addEnroll(enrollArr, stuArray, psyCourse, itCourse, langCourse);
                    break;
                case 11:
                    //delete enroll
                    Screen.clear();
                    enrollFunction.deleteEnroll(enrollArr);
                    break;
                case 12:
                    // new Course
                    int courseChoice1 = chooseCourse();
                    Screen.clear();
                    switch (courseChoice1) {
                        case 1:
                            System.out.println("\n==========\nPSYCHOLOGY\n==========");
                            System.out.println(psy.toString());
                            for (int x = 0; x < Psychology.getPsyCount(); x++) {
                                System.out.println((x + 1) + ".");
                                System.out.println(psyCourse[x]);
                            }
                            System.out.println("\n                                 Press enter to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            Screen.clear();
                            break;

                        case 2:
                            System.out.println("\n======================\nINFORMATION TECHNOLOGY\n======================");
                            System.out.println(it.toString());
                            for (int y = 0; y < IT.getItCount(); y++) {
                                System.out.println((y + 1) + ".");
                                System.out.println(itCourse[y]);
                            }
                            System.out.println("\n                                 Press enter to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            Screen.clear();
                            break;

                        case 3:
                            System.out.println("\n========\nLANGUAGE\n========");
                            System.out.println(lang.toString());
                            for (int z = 0; z < Language.getLangCount(); z++) {
                                System.out.println((z + 1) + ".");
                                System.out.println(langCourse[z]);
                            }
                            System.out.println("\n                                 Press enter to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            Screen.clear();
                            break;

                        case 4:
                            Screen.clear();
                    }
                    break;
                case 13:
                    // Register tutor
                    Screen.clear();
                    regTutor(regArr, tutArray, psyCourse, itCourse, langCourse);
                    break;
                case 14:
                    // Remove Register
                    Screen.clear();
                    removeRegister(regArr, tutArray, psyCourse, itCourse, langCourse);
                    break;
                case 15:
                    Screen.clear();
                    report(stuArray, tutArray, psy, it, lang, psyCourse, itCourse, langCourse, enrollArr, regArr);
                    break;
                case 16:
                    Screen.clear();
                    Font.print(Font.ANSI_YELLOW,"                                                          __ __ ");
                    Font.print(Font.ANSI_YELLOW,"                _____ _           _      __ __           |  |  |");
                    Font.print(Font.ANSI_YELLOW,"               |_   _| |_ ___ ___| |_   |  |  |___ _ _   |  |  |");
                    Font.print(Font.ANSI_YELLOW,"                 | | |   | .'|   | '_|  |_   _| . | | |  |__|__|");
                    Font.print(Font.ANSI_YELLOW,"                 |_| |_|_|__,|_|_|_,_|    |_| |___|___|  |__|__|");
                    break;
            }
        } while (taskChoice != 16);
    }

    public static void displayMenu() {
        Font.print(Font.ANSI_YELLOW,"              _____ _____ __       _____     _ _   _            _____         _           ");
        Font.print(Font.ANSI_YELLOW,"             |_   _|_   _|  |     |_   _|_ _|_| |_|_|___ ___   |     |___ ___| |_ ___ ___ ");
        Font.print(Font.ANSI_YELLOW,"               | |   | | |  |__     | | | | | |  _| | . |   |  |   --| -_|   |  _| -_|  _|");
        Font.print(Font.ANSI_YELLOW,"               |_|   |_| |_____|    |_| |___|_|_| |_|___|_|_|  |_____|___|_|_|_| |___|_|  ");
        Font.print(Font.ANSI_BLUE, "\n\t\t\tCourse\t\t\t\t\tEnroll");
                
        Font.print(Font.ANSI_YELLOW, "\t\t   1. Add course\t\t\t   10. Add Enroll\n\t\t   2. Modify course\t\t\t   11. Remove Enroll\n\t\t   3. Remove course\t\t\t   12. Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\tStudent\t\t\t\t\tRegister");
        Font.print(Font.ANSI_YELLOW, "\t\t   4. Add Student\t\t\t   13. Register Tutor\n\t\t   5. Modify Student\t\t\t   14. Remove Register\n\t\t   6. Remove Student");
        Font.print(Font.ANSI_BLUE, "\n\t\t\tTutor\t\t\t\t\tReport");
        Font.print(Font.ANSI_YELLOW, "\t\t   7. Add Tutor\t\t\t\t   15. Report\n\t\t   8. Modify Tutor\n\t\t   9. Remove Tutor");
        Font.print(Font.ANSI_YELLOW, "\n\n\t\t\t\t            16. Exit");
        System.out.print( "\n\t\t\t\t     Select task to perform: ");
    }

    public static int chooseCourse() {
        int courseChoice = 0;
        Screen.clear();
        do{
            try{
                Scanner input = new Scanner(System.in);
                Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tCourses");
                Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
                Font.print(Font.ANSI_YELLOW,"\n\t\t\t\t1. Psychology\n\t\t\t\t2. Information Technology\n\t\t\t\t3. Language\n\t\t\t\t4. Back to menu");
                System.out.print("\n\t\t\t\tEnter a course: ");
                courseChoice = input.nextInt();
        
                if (courseChoice < 1 || courseChoice > 4){
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-4) is allowed, please try again!\n");
                }
            }catch (Exception e){
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-4) is allowed, please try again!\n");
            }


        }while(courseChoice != 4 && courseChoice != 1 && courseChoice != 2 && courseChoice != 3);


        return courseChoice;
    }

    public static void addCourse(Course psy, Course it, Course lang, Course[] psyCourse, Course[] itCourse, Course[] langCourse, int courseChoice){

        if (courseChoice == 1) {
            addPsyCourse(psyCourse, itCourse, langCourse);
        } else if (courseChoice == 2) {
            addItCourse(psyCourse, itCourse, langCourse);
        } else if (courseChoice == 3) {
            addLangCourse(psyCourse, itCourse, langCourse);
        } else {
            Screen.clear();
        }

    }

    public static boolean validateCode(Course[] psyCourse, Course[] itCourse, Course[] langCourse, String courseCode){
        boolean isPsyCodeExist = false;
        boolean isItCodeExist = false;
        boolean isLangCodeExist = false;
        boolean isValid = false;

        for (int x = 0; x < Psychology.getPsyCount(); x++) {
            
            if ((psyCourse[x].getCode()).equals(courseCode)) {
                isPsyCodeExist = true;
            }
        }

        if(isPsyCodeExist == false){
                for(int y = 0; y < IT.getItCount(); y++){
                    
                    if((itCourse[y].getCode()).equals(courseCode)){
                        isItCodeExist = true;
                    }
                }
        }

        if(isPsyCodeExist == false && isItCodeExist == false){
                for(int z = 0; z < Language.getLangCount(); z++){
                    if((langCourse[z].getCode()).equals(courseCode)){
                        isLangCodeExist = true;
                    }
                }
        }

        if(isPsyCodeExist == false && isItCodeExist == false && isLangCodeExist == false){
            isValid = true;
        }

        return isValid;

    }

    public static boolean validateTitle(Course[] psyCourse, Course[] itCourse, Course[] langCourse, String courseTitle){
        boolean isPsyTitleExist = false;
        boolean isItTitleExist = false;
        boolean isLangTitleExist = false;
        boolean isValid = false;

        for (int x = 0; x < Psychology.getPsyCount(); x++) {

            if ((psyCourse[x].getTitle()).equals(courseTitle)) {
                isPsyTitleExist = true;
            }
        }

        if(isPsyTitleExist == false){
                for(int y = 0; y < IT.getItCount(); y++){
                    
                    if((itCourse[y].getTitle()).equals(courseTitle)){
                        isItTitleExist = true;
                    }
                }
        }

        if(isPsyTitleExist == false && isItTitleExist == false){
                for(int z = 0; z < Language.getLangCount(); z++){
                    if((langCourse[z].getTitle()).equals(courseTitle)){
                        isLangTitleExist = true;
                    }
                }
        }

        if(isPsyTitleExist == false && isItTitleExist == false && isLangTitleExist == false){
            isValid = true;
        }

        return isValid;
    }

    public static double validateCourseFee(){
        boolean isValidFee = true;
        double courseFee = 0;
        Scanner input = new Scanner(System.in);

        do{
            try{
                System.out.print("\n                            Enter course fee: ");
                courseFee = input.nextDouble();
    
                if(courseFee <= 0){
                    Font.print(Font.ANSI_RED, "\n                      Course Fee cannot be less than or equal to RM 0!");
                    isValidFee = false;
                }else{
                    isValidFee = true;
                }
            } catch (Exception e){
                Font.print(Font.ANSI_RED, "\n                            Only Numbers are allowed!");
                isValidFee = false;
                input.next();
            }


        }while(!isValidFee);

        return courseFee;
    }

    public static int validateLimit(){
        boolean isValidLimit = true;
        int courseLimit = 0;
        Scanner input = new Scanner(System.in);

        do{
            try{
                System.out.print("\n                            Enter enrollment limit: ");
                courseLimit = input.nextInt();
    
                if(courseLimit <= 0){
                    Font.print(Font.ANSI_RED, "\n                      Enrollment limit cannot be less than or equal to 0!");
                    isValidLimit = false;
                }else{
                    isValidLimit = true;
                }
            }catch (Exception e){
                Font.print(Font.ANSI_RED, "\n                            Only Numbers are allowed!");
                isValidLimit = false;
                input.next();
            }


        }while(!isValidLimit);

        return courseLimit;

    }

    public static void addPsyCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse) {
        Scanner input = new Scanner(System.in);
        boolean isCodeValid = true;
        boolean isTitleValid = true;
        String code, title, details, description, type, skillLearned;
        double fee;
        int capacity;

        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t   Add Psychology Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");

        do{
            System.out.print("                            Enter course code: ");
            code = input.nextLine();
            isCodeValid =  validateCode(psyCourse, itCourse, langCourse, code);
            if(isCodeValid == false){
                Font.print(Font.ANSI_RED, "\n                            Course Code " + code + " existed.");
            }
            
        }while(isCodeValid == false);

        do{
            System.out.print("\n                            Enter course title: ");
            title = input.nextLine();
            isTitleValid =  validateTitle(psyCourse, itCourse, langCourse, title);
            if(isTitleValid == false){
                Font.print(Font.ANSI_RED, "\n                       Course Title \"" + title + "\" existed.");
            }
            
        }while(isTitleValid == false);

        System.out.print("\n                            Enter course details: ");
        details = input.nextLine();

        System.out.print("\n                            Enter course description: ");
        description = input.nextLine();

        fee = validateCourseFee();

        capacity = validateLimit();

        System.out.print("\n                            Enter psychology type: ");
        type = input.nextLine();

        System.out.print("\n                            Enter skill(s) learned: ");
        skillLearned = input.nextLine();

        psyCourse[(Psychology.getNumOfPsyCourse())] = new Psychology(code, title, details, description, fee, capacity, type, skillLearned);
        Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Added!");
        System.out.print("\n                             Press enter to continue...");
        input.nextLine();
        Screen.clear();
    }

    public static void addItCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse) {
        Scanner input = new Scanner(System.in);
        boolean isCodeValid = true;
        boolean isTitleValid = true;
        String code, title, details, description, preRequisite, language;
        double fee;
        int capacity;

        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tAdd IT Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");

        do{
            System.out.print("                            Enter course code: ");
            code = input.nextLine();
            isCodeValid =  validateCode(psyCourse, itCourse, langCourse, code);
            if(isCodeValid == false){
                Font.print(Font.ANSI_RED, "\n                            Course Code " + code + " existed.");
            }
            
        }while(isCodeValid == false);

        do{
            System.out.print("\n                            Enter course title: ");
            title = input.nextLine();
            isTitleValid =  validateTitle(psyCourse, itCourse, langCourse, title);
            if(isTitleValid == false){
                Font.print(Font.ANSI_RED, "\n                       Course Title \"" + title + "\" existed.");
            }
            
        }while(isTitleValid == false);

        System.out.print("\n                       Enter course details: ");
        details = input.nextLine();

        System.out.print("\n                       Enter course description: ");
        description = input.nextLine();

        fee = validateCourseFee();
        
        capacity = validateLimit();

        System.out.print("\n                            Enter Pre-Requisite course: ");
        preRequisite = input.nextLine();

        System.out.print("\n                            Enter programming language used: ");
        language = input.nextLine();

        itCourse[(IT.getNumOfItCourse())] = new IT(code, title, details, description, fee, capacity, preRequisite, language);
        Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Added!");
        System.out.print("\n                             Press enter to continue...");
        input.nextLine();
        Screen.clear();
    }

    public static void addLangCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse) {
        Scanner input = new Scanner(System.in);
        boolean isCodeValid = true;
        boolean isTitleValid = true;
        String code, title, details, description, language, system;
        double fee;
        int capacity;

        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tAdd Language Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");

        do{
            System.out.print("                            Enter course code: ");
            code = input.nextLine();
            isCodeValid =  validateCode(psyCourse, itCourse, langCourse, code);
            if(isCodeValid == false){
                Font.print(Font.ANSI_RED, "\n                            Course Code " + code + " existed.");
            }
            
        }while(isCodeValid == false);

        do{
            System.out.print("\n                            Enter course title: ");
            title = input.nextLine();
            isTitleValid =  validateTitle(psyCourse, itCourse, langCourse, title);
            if(isTitleValid == false){
                Font.print(Font.ANSI_RED, "\n                       Course Title \"" + title + "\" existed.");
            }
            
        }while(isTitleValid == false);

        System.out.print("\n                            Enter course details: ");
        details = input.nextLine();

        System.out.print("\n                            Enter course description: ");
        description = input.nextLine();

        fee = validateCourseFee();
        
        capacity = validateLimit();

        System.out.print("\n                            Enter language of the course: ");
        language = input.nextLine();

        System.out.print("\n                            Enter examination system: ");
        system = input.nextLine();

        langCourse[(Language.getNumOfLangCourse())] = new Language(code, title, details, description, fee, capacity, language, system);
        Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Added!");
        System.out.print("\n                             Press enter to continue...");
        input.nextLine();
        Screen.clear();
    }

    public static void modifyPsyCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse, Course modifyCourse) {
        Screen.clear();
        Scanner input = new Scanner(System.in);
        int psyModifyChoice = 0;
        boolean isTitleValid = true;
        boolean isValid = false;
        String title;

        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify Psychology Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");

        do {
            try {
                isValid = true;
                System.out.print(
                        "\n\t\t\t1. Course Title\n\t\t\t2. Course Details\n\t\t\t3. Course Description\n\t\t\t4. Course Fee\n\t\t\t5. Psychology type\n\t\t\t6. Skill(s) learned\n\t\t\t7. Back to menu\n\n\t\t\t\tChoose what to modify: ");
                psyModifyChoice = input.nextInt();
                input.nextLine();

                if (psyModifyChoice < 1 || psyModifyChoice > 7) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
                    isValid = false;
                }
            }catch(Exception e){
                Screen.clear();
                isValid = false;
                Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
                input.nextLine();
            }
        } while (isValid == false);

        switch (psyModifyChoice) {
            case 1:
                // Modify course title
                do{
                    System.out.print("\n                            Enter course title: ");
                    title = input.nextLine();
                    isTitleValid =  validateTitle(psyCourse, itCourse, langCourse, title);
                    if(isTitleValid == false){
                        Font.print(Font.ANSI_RED, "\n                          Course Title \"" + title + "\" existed.");
                    }
                    
                }while(isTitleValid == false);
                modifyCourse.setTitle(title);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 2:
                // Modify course details
                System.out.print("\n                            Enter new course details: ");
                String courseDetails = input.nextLine();
                modifyCourse.setDetails(courseDetails);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 3:
                // Modyfy course description
                System.out.print("\n                            Enter new course description: ");
                String courseDescription = input.nextLine();
                modifyCourse.setDescription(courseDescription);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 4:
                // Modyfy course fee
                System.out.print("\n                            Enter new course fee: ");
                double fee = validateCourseFee();
                modifyCourse.setFee(fee);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 5:
                // Modify type
                System.out.print("\n                            Enter new psychology type: ");
                String type = input.nextLine();
                ((Psychology) modifyCourse).setType(type);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 6:
                // Modify skill learned
                System.out.print("\n                            Enter new skill(s) learned: ");
                String skillLearned = input.nextLine();
                ((Psychology) modifyCourse).setSkillLearned(skillLearned);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

        }
        
        System.out.print("\n                             Press enter to continue...");
        input.nextLine();
        Screen.clear();
    }

    public static void modifyitCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse, Course modifyCourse) {
        Screen.clear();
        Scanner input = new Scanner(System.in);
        int itModifyChoice = 0;
        boolean isTitleValid = true;
        boolean isValid = false;
        String title;
        
        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify IT Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");

        do {
            try {
                isValid = true;
                System.out.print(
                    "\n\t\t\t1. Course Title\n\t\t\t2. Course Details\n\t\t\t3. Course Description\n\t\t\t4. Course Fee\n\t\t\t5. Pre-Requisite\n\t\t\t6. Programming Language\n\t\t\t7. Back to menu\n\n\t\t\t\tChoose what to modify: ");
            itModifyChoice = input.nextInt();
            input.nextLine();

                if (itModifyChoice < 1 || itModifyChoice > 7) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
                    isValid = false;
                }
            }catch(Exception e){
                Screen.clear();
                isValid = false;
                Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
                input.nextLine();
            }
        } while (isValid == false);

        switch (itModifyChoice) {
            case 1:
                // Modify course title
                do{
                    System.out.print("\n                            Enter course title: ");
                    title = input.nextLine();
                    isTitleValid =  validateTitle(psyCourse, itCourse, langCourse, title);
                    if(isTitleValid == false){
                        Font.print(Font.ANSI_RED, "\n                          Course Title \"" + title + "\" existed.");
                    }
                    
                }while(isTitleValid == false);
                modifyCourse.setTitle(title);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 2:
                // Modify course details
                System.out.print("\n                            Enter new course details: ");
                String courseDetails = input.nextLine();
                modifyCourse.setDetails(courseDetails);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 3:
                // Modyfy course description
                System.out.print("\n                            Enter new course description: ");
                String courseDescription = input.nextLine();
                modifyCourse.setDescription(courseDescription);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 4:
                // Modyfy course fee
                System.out.print("\n                            Enter new course fee: ");
                double fee = validateCourseFee();
                modifyCourse.setFee(fee);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 5:
                // Modify pre-requisite
                System.out.print("\n                            Enter new Pre-Requisite: ");
                String preRequisite = input.nextLine();
                ((IT) modifyCourse).setPreRequisite(preRequisite);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 6:
                // Modify programming language
                System.out.print("\n                            Enter new programming language: ");
                String programmingLanguage = input.nextLine();
                ((IT) modifyCourse).setProgrammingLanguage(programmingLanguage);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;
        }

        System.out.print("\n                             Press enter to continue...");
        input.nextLine();
        Screen.clear();
    }

    public static void modifyLangCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse, Course modifyCourse) {
        Screen.clear();
        Scanner input = new Scanner(System.in);
        int langModifyChoice = 0;
        boolean isTitleValid = true;
        boolean isValid = false;
        String title;

        Font.print(Font.ANSI_BLUE, "\n\t\t\t\tModify Language Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");

        do {
            try {
                isValid = true;
                System.out.print(
                    "\n\t\t\t1. Course Title\n\t\t\t2. Course Details\n\t\t\t3. Course Description\n\t\t\t4. Course Fee\n\t\t\t5. Language\n\t\t\t6. System\n\t\t\t7. Back to menu\n\n\t\t\t\tChoose what to modify: ");
            langModifyChoice = input.nextInt();
            input.nextLine();

                if (langModifyChoice < 1 || langModifyChoice > 7) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
                    isValid = false;
                }
            }catch(Exception e){
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
                input.nextLine();
            }
        } while (isValid == false);

        switch (langModifyChoice) {
            case 1:
                // Modify course title
                do{
                    System.out.print("\n                            Enter course title: ");
                    title = input.nextLine();
                    isTitleValid =  validateTitle(psyCourse, itCourse, langCourse, title);
                    if(isTitleValid == false){
                        Font.print(Font.ANSI_RED, "\n                          Course Title \"" + title + "\" existed.");
                    }
                    
                }while(isTitleValid == false);
                modifyCourse.setTitle(title);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 2:
                // Modify course details
                System.out.print("\n                            Enter new course details: ");
                String courseDetails = input.nextLine();
                modifyCourse.setDetails(courseDetails);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 3:
                // Modyfy course description
                System.out.print("\n                            Enter new course description: ");
                String courseDescription = input.nextLine();
                modifyCourse.setDescription(courseDescription);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 4:
                // Modyfy course fee
                System.out.print("\n                            Enter new course fee: ");
                double fee = validateCourseFee();
                modifyCourse.setFee(fee);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 5:
                // Modify language
                System.out.print("\n                            Enter new language: ");
                String language = input.nextLine();
                ((Language) modifyCourse).setLanguage(language);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;

            case 6:
                // Modify system
                System.out.print("\n                            Enter new examination system: ");
                String system = input.nextLine();
                ((Language) modifyCourse).setSystem(system);
                Font.print(Font.ANSI_YELLOW,"\n                                 Successfully Modified!");
                break;
        }

        
        System.out.print("\n                             Press enter to continue...");
        input.nextLine();
        Screen.clear();
    }

    public static void modifyCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse) {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;

        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
        System.out.print("                                   Enter ID to modify: ");
        String code = input.nextLine();

        for (int x = 0; x < Psychology.getPsyCount(); x++) {
            if ((psyCourse[x].getCode()).equals(code)) {
                isValid = true;
                modifyPsyCourse(psyCourse, itCourse, langCourse, psyCourse[x]);
            }
        }

        for (int y = 0; y < IT.getItCount(); y++) {
            if ((itCourse[y].getCode()).equals(code)) {
                isValid = true;
                modifyitCourse(psyCourse, itCourse, langCourse, itCourse[y]);
            }
        }

        for (int z = 0; z < Language.getLangCount(); z++) {
            if ((langCourse[z].getCode()).equals(code)) {
                isValid = true;
                modifyLangCourse(psyCourse, itCourse, langCourse, langCourse[z]);
            }
        }
        if (isValid == false) {
            Font.print(Font.ANSI_RED, "\n                            The course code does not exist.");
            System.out.print("\n                             Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }
    }

    public static void deleteCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse, Register[] regArr, Enroll[] enrollArr){
        Scanner input = new Scanner(System.in);
        boolean isCodeExist = false;
        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tDelete Course");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
        System.out.print("                                   Enter Course Code: ");
        String code = input.nextLine();

        for (int x = 0; x < ((Psychology) psyCourse[0]).getPsyCount(); x++) {
            if ((psyCourse[x].getCode()).equals(code)) {
                isCodeExist = true;
                Psychology.reducePsyCount();
                Course[] newPsyCourse = new Psychology[((Psychology) psyCourse[0]).getPsyCount()];
                int count = Psychology.getPsyCount();
                newPsyCourse = psyCourse;

                int a = 0;
                for (int i = 0; i < count + 1; i++) {
                    if (!(psyCourse[i].getCode()).equals(code)) {
                        newPsyCourse[a] = psyCourse[i];
                        a++;
                    }
                }

                psyCourse[((Psychology) psyCourse[0]).getPsyCount() + 1] = null;
                deleteRegAndEnrollCourse(regArr, enrollArr, code);
                Font.print(Font.ANSI_YELLOW,"\n                                The course " + code + " has been deleted.");
                System.out.print("\n                             Press enter to continue...");
                input.nextLine();
                Screen.clear();
            }
        }

        for(int y = 0; y < ((IT)itCourse[0]).getItCount(); y++){
            if((itCourse[y].getCode()).equals(code)){
                isCodeExist = true;
                IT.reduceItCount();
                Course[] newItCourse = new IT[((IT) itCourse[0]).getItCount()];
                int count = IT.getItCount();
                newItCourse = itCourse;

                int a = 0;
                for (int i = 0; i < count + 1; i++) {
                    if (!(itCourse[i].getCode()).equals(code)) {
                        newItCourse[a] = itCourse[i];
                        a++;
                    }
                }

                itCourse[((IT) itCourse[0]).getItCount() + 1] = null;
                deleteRegAndEnrollCourse(regArr, enrollArr, code);
                Font.print(Font.ANSI_YELLOW,"\n                                The course " + code + " has been deleted.");
                System.out.print("\n                             Press enter to continue...");
                input.nextLine();
                Screen.clear();
            }
        }

        for(int z = 0; z < ((Language)langCourse[0]).getLangCount(); z++){
            if((langCourse[z].getCode()).equals(code)){
                isCodeExist = true;
                Language.reduceLangCount();
                Course[] newLangCourse = new Language[((Language) langCourse[0]).getLangCount()];
                int count = Language.getLangCount();
                newLangCourse = langCourse;

                int a = 0;
                for (int i = 0; i < count + 1; i++) {
                    if (!(langCourse[i].getCode()).equals(code)) {
                        newLangCourse[a] = langCourse[i];
                        a++;
                    }
                }

                langCourse[((Language) langCourse[0]).getLangCount() + 1] = null;
                deleteRegAndEnrollCourse(regArr, enrollArr, code);
                Font.print(Font.ANSI_YELLOW,"\n                                The course " + code + " has been deleted.");
                System.out.print("\n                             Press enter to continue...");
                input.nextLine();
                Screen.clear();
            }
        }

        if(isCodeExist == false){
            Font.print(Font.ANSI_RED, "\n                                The course code does not exist.");
            System.out.print("\n                             Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }
    }

    public static void deleteRegFunc(Register[] regArr, int arrIndex){
        Register.reduceRegNo();
        Register[] newRegArr = regArr;

        System.arraycopy(regArr, 0, newRegArr, 0, arrIndex);
        System.arraycopy(regArr, arrIndex + 1, newRegArr, arrIndex, Register.getRegNo() - arrIndex);
    }

    public static void deleteEnrollFunc(Enroll[] enrollArr, int arrIndex){
        Enroll.setEnrollNum(Enroll.getEnrollNum() - 1);
        Enroll[] newEnrollArr = enrollArr;

        System.arraycopy(enrollArr, 0, newEnrollArr, 0, arrIndex);
        System.arraycopy(enrollArr, arrIndex + 1, newEnrollArr, arrIndex, Enroll.getEnrollNum() - arrIndex);
    }


    public static void deleteRegAndEnrollCourse(Register[] regArr, Enroll[] enrollArr, String courseCode){
        int regDeleteCount = 0;
        int enrollDeleteCount = 0;

        for(int x = 0; x < Register.getRegNo(); x++){
            if(((regArr[x].getCourse()).getCode()).equals(courseCode)){
                regDeleteCount++;
            }
            
            if((enrollArr[x].getCourse()).getCode().equals(courseCode)){
                enrollDeleteCount++;
            }
        }

        if(regDeleteCount > 0){
            for(int y = 0; y < regDeleteCount; y++){
                for(int z = 0; z < Register.getRegNo(); z++){
                    if(((regArr[z].getCourse()).getCode()).equals(courseCode)){
                        deleteRegFunc(regArr, z);
                    }
                }
            }
        }

        if(enrollDeleteCount > 0){
            for(int i = 0; i < enrollDeleteCount; i++){
                for(int j = 0; j < Enroll.getEnrollNum(); j++){
                    if((enrollArr[j].getCourse()).getCode().equals(courseCode)){
                        deleteEnrollFunc(enrollArr, j);
                    }
                }
            }
        }
    }

    public static void addPeople(People[] peopleArr) {
        Scanner input = new Scanner(System.in);
        String name = "", phoneNum, email, description;
        char sex;
        int age;
        double balance;
        boolean valid = true;

        valid = true;



        if (peopleArr[0] instanceof Student) {
            //Input and Validation
            Screen.clear();
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tAdd Student");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            name += NameInputValidate();
            age = AgeInputValidate();
            sex = SexInputValidate();
            phoneNum = PhoneInputValidate();
            email = EmailInputValidate();
            System.out.print("\n                                   Enter description: ");
            description = input.nextLine();
            balance = BalanceInputValidate();
            if(description == ""){
                peopleArr[((Student) peopleArr[0]).getStuCount()] = new Student(name, age, sex, phoneNum, email, balance);
            } else {
                peopleArr[((Student) peopleArr[0]).getStuCount()] = new Student(name, age, sex, phoneNum, email, description, balance);
            }        } else {
            //Input and Validation
            Screen.clear();
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tAdd Tutor");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            name = NameInputValidate();
            age = AgeInputValidate();
            sex = SexInputValidate();
            phoneNum = PhoneInputValidate();
            email = EmailInputValidate();
            String major = MajorInputValidate();
            String level = LevelInputValidate();
            Screen.clear();
            peopleArr[((Tutor) peopleArr[0]).getTutorCount()] = new Tutor(name, age, sex, phoneNum, email, ((Tutor) peopleArr[0]).getMajor(major), ((Tutor) peopleArr[0]).getLevel(level));
        }
    }

    public static String NameInputValidate() {
        boolean valid;
        String name = "";
        Scanner input = new Scanner(System.in);

        do {
            valid = true;
            System.out.print("                                   Enter name: ");
            name = input.nextLine();
            if (name.matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?")) {
                valid = true;
            } else {
                Font.print(Font.ANSI_RED, "\n                                      Invalid Input!!");
                valid = false;
            }
            if (name.length() > 50) {
                Font.print(Font.ANSI_RED, " \n                            Name cannot be longer than 50 letters!");
                valid = false;
            }
        } while (!valid);

        return name;
    }

    public static int AgeInputValidate() {
        int age = 0;
        boolean valid;
        Scanner input = new Scanner(System.in);

        do {
            valid = true;
            try {
                System.out.print("\n                                   Enter age: ");
                age = input.nextInt();
                if (age >= 18 && age <= 80) {
                    valid = true;
                } else {
                    Font.print(Font.ANSI_RED, "\n                                   Age is not valid!");
                    valid = false;
                }
            } catch (Exception e) {
                Font.print(Font.ANSI_RED, "\n                         Invalid Input, please make sure you enter correctly!");
                input.next();
                valid = false;
            }

        } while (!valid);

        return age;
    }

    public static char SexInputValidate() {
        char sex = 'A';
        String stringSex;
        boolean valid;
        Scanner input = new Scanner(System.in);

        do {
            valid = true;

            System.out.print("\n                                   Enter sex: ");
            stringSex = input.nextLine();
            if (stringSex.length() == 1) {
                valid = true;
            } else {
                Font.print(Font.ANSI_RED, "\n                                   One character Only!");
                valid = false;
            }
            sex = stringSex.charAt(0);
            if (sex != 'm' && sex != 'f' && sex != 'M' && sex != 'F') {
                Font.print(Font.ANSI_RED, "\n                                Only (m,f,M,F) are allowed!");
                valid = false;
            }
            if (Character.isLowerCase(sex)) {
                sex = Character.toUpperCase(sex);
            }

        } while (!valid);

        return sex;
    }

    public static String PhoneInputValidate() {
        String phoneNum;
        boolean valid;
        Scanner input = new Scanner(System.in);

        do {
            valid = true;
            System.out.print("\n                                   Enter phone number(+6017-725 5766): ");
            phoneNum = input.nextLine();
            if (PhoneIsValid(phoneNum)) {
                valid = true;
            } else {
                valid = false;
                Font.print(Font.ANSI_RED, "\n                                      Incorrect Format");
            }
        } while (!valid);
        return phoneNum;
    }

    public static boolean PhoneIsValid(String s) {
        Pattern p = Pattern.compile("^\\+601\\d-\\d{3}\\s\\d{4}");
        Matcher m = p.matcher(s);
        return (m.matches());
    }

    public static String EmailInputValidate() {
        String email;
        boolean valid;
        Scanner input = new Scanner(System.in);

        do {
            valid = true;
            System.out.print("\n                                   Enter email: ");
            email = input.nextLine();
            if (EmailisValid(email)) {
                valid = true;
            } else {
                valid = false;
                Font.print(Font.ANSI_RED, "\n                                  Please enter a valid email!");
            }
        } while (!valid);

        return email;
    }

    static boolean EmailisValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static double BalanceInputValidate() {
        double balance = 0;
        boolean valid;
        Scanner input = new Scanner(System.in);

        do {
            try {
                valid = true;
                System.out.print("\n                                   Enter balance: ");
                balance = input.nextDouble();
                if (balance > 0) {
                    valid = true;
                } else {
                    valid = false;
                    Font.print(Font.ANSI_RED, "\n                                 Balance cannot be lower than 0!");
                }
            } catch (Exception e) {
                Font.print(Font.ANSI_RED, "\n                            Invalid Input, please make sure you enter correctly!");
                input.next();
                valid = false;
            }
        } while (!valid);

        return balance;
    }

    public static String MajorInputValidate() {
        String major;
        boolean valid;
        Scanner input = new Scanner(System.in);

        do {
            valid = true;
            System.out.print("\n                                   Enter major (IT, PSY, LANG): ");
            major = input.nextLine();
            if (!major.equals("IT") && !major.equals("PSY") && !major.equals("LANG")) {
                valid = false;
                Font.print(Font.ANSI_RED, "                            Only IT, PSY, LANG are allowed!");
            } else {
                valid = true;
            }

        } while (!valid);

        return major;
    }

    public static String LevelInputValidate() {
        String level;
        boolean valid;
        Scanner input = new Scanner(System.in);

        do {
            valid = true;
            System.out.print("\n                                   Enter level (Doctorate, BachelorDegree, MasterDegree): ");
            level = input.nextLine();
            if (!level.equals("Doctorate") && !level.equals("BachelorDegree") && !level.equals("MasterDegree")) {
                valid = false;
                Font.print(Font.ANSI_RED, "                            Only Doctorate, BachelorDegree, MasterDegree are allowed!");
            } else {
                valid = true;
            }
        } while (!valid);
        return level;
    }

    public static void modifyPeople(People[] peopleArr) {
        Scanner input = new Scanner(System.in);
        boolean peopleExist = false;
        int tempI = 0;
        Screen.clear();
        String id;

        if (peopleArr[0] instanceof Student) {
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify Student");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            System.out.print("                                   Enter ID to modify: ");
            id = input.nextLine();
            for (int i = 0; i < Student.getStuCount(); i++) {
                if ((((Student) peopleArr[i]).getStuID()).equals(id)) {
                    peopleExist = true;
                    tempI = i;
                }
            }
        } else {
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify Tutor");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            System.out.print("                                   Enter ID to modify: ");
            id = input.nextLine();
            for (int i = 0; i < Tutor.getTutorCount(); i++) {
                if ((((Tutor) peopleArr[i]).getTutorID()).equals(id)) {
                    peopleExist = true;
                    tempI = i;
                }
            }
        }

        if (peopleExist) {
            Screen.clear();
            boolean valid = true;
            int modifyChoice = 0;

            do{
                try{
                    modifyChoice = 0;
                    valid = true;
                    String message;
                    if (peopleArr[0] instanceof Student) {
                        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify Student");
                        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
                        for (int i = 0; i < Student.getStuCount(); i++) {
                            if ((((Student) peopleArr[i]).getStuID()).equals(id)) {
                                System.out.println(peopleArr[i]);
                            }
                        }
                        message = " \n                                      Select to modify\n                                1. Name\n                                2. Age\n                                3. Sex\n                                4. Phone Number\n                                5. Email\n                                6. Description\n                                7. Balance\n                                8.Back";
                        System.out.println(message);
                        System.out.print("\n                                Choose your option: ");
                        modifyChoice = input.nextInt();
                        if(modifyChoice < 1 || modifyChoice > 8){
                            Screen.clear();
                            Font.print(Font.ANSI_RED, "\n                                   Only (1-8) are allowed!");
                        }
                    } else {           
                        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify Tutor");
                        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
                        for (int i = 0; i < Tutor.getTutorCount(); i++) {
                            if ((((Tutor) peopleArr[i]).getTutorID()).equals(id)) {
                                System.out.println(peopleArr[i]);
                            }
                        }                 
                        message = "\n                                      Select to modify\n                                1. Name\n                                2. Age\n                                3. Sex\n                                4. Phone Number\n                                5. Email\n                                6. Level\n                                7. Back";
                        System.out.println(message);
                        System.out.print("\n                                Choose your option: ");
                        modifyChoice = input.nextInt();
                        if(modifyChoice < 1 || modifyChoice > 7){
                            Screen.clear();
                            Font.print(Font.ANSI_RED, "\n                                   Only (1-7) are allowed!");
                            valid = false;
                        }
                    }

                } catch (Exception e){
                    valid = false;
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "\n                                        Invalid Input");
                    input.next();
                }

            } while (!valid);



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
                        System.out.print("\n                               Enter new description: ");
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
                        balanceModify(peopleArr, tempI, id);
                        break;
                    }
                }
            }
        else {
            Font.print(Font.ANSI_RED, "\n                                      The ID doesn't exist");
        }
        System.out.println("\n                                 Press enter to continue...");
        try{System.in.read();}
        catch(Exception e){}
        Screen.clear();
    }

    public static void balanceModify(People[] stuArray, int tempI, String id){
        Screen.clear();
        Scanner input = new Scanner(System.in);
        boolean valid = true;
        int balance = 0;


        do{
            try{
                valid = true;
                Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify Student");
                Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
                for (int i = 0; i < Student.getStuCount(); i++) {
                    if ((((Student) stuArray[i]).getStuID()).equals(id)) {
                        System.out.println(stuArray[i]);
                    }
                }
        
                String message = "\n                                      Select to modify\n                                1. Add Balance\n                                2. Set Balance\n                                3. Subtract Balance\n                                4. Back to Menu\n";
                System.out.print(message + "\n                                Choose your option: ");
                balance = input.nextInt();
                if (balance < 1 || balance > 4){
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "\n                                   Only (1-4) are allowed!");
                    valid = false;

                }    
            }catch (Exception e){
                valid = false;
                Screen.clear();
                Font.print(Font.ANSI_RED, "\n                                        Invalid Input");
                input.next();
            }
    
        } while(!valid);

        double newBalance = BalanceInputValidate();
                
        switch(balance){
            case 1:
                ((Student) stuArray[tempI]).setBalance((((Student) stuArray[tempI]).getBalance()) + newBalance);
                System.out.println("\n                                Balance Updated");
                break;
            case 2:
                ((Student) stuArray[tempI]).setBalance(newBalance);
                System.out.println("\n                                Balance Updated");
                break;
            case 3:
                ((Student) stuArray[tempI]).setBalance((((Student) stuArray[tempI]).getBalance()) - newBalance);
                System.out.println("\n                                Balance Updated");
                break;
        }

    }

    public static void deletePeople(People[] peopleArr, Enroll[] enrollArr, Register[] regArr) {
        Scanner input = new Scanner(System.in);
        boolean peopleExist = false;
        int tempI = 0;
        String id = "";

        Screen.clear();



        if (peopleArr[0] instanceof Student) {
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tDelete Student");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            System.out.print("\n                                   Enter ID to delete: ");
            id = input.nextLine();
            for (int i = 0; i < Student.getStuCount(); i++) {
                if ((((Student) peopleArr[i]).getStuID()).equals(id)) {
                    peopleExist = true;
                    tempI = i;
                }
            }
        } else {
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tDelete Tutor");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            System.out.print("\n                                   Enter ID to delete: ");
            id = input.nextLine();
            for (int i = 0; i < Tutor.getTutorCount(); i++) {
                if ((((Tutor) peopleArr[i]).getTutorID()).equals(id)) {
                    peopleExist = true;
                    tempI = i;
                }
            }
        }

        if (peopleExist) {
            if (peopleArr[0] instanceof Student) {
                ((Student) peopleArr[0]).reduceStuCount();
                People[] clonePeople = peopleArr;

                int a = 0;
                // Move Entire student array to a temp array except the chosen delete id
                for (int i = 0; i < Student.getStuCount() + 1; i++) { //50
                    if (!((Student) peopleArr[i]).getStuID().equals(id)) {
                        clonePeople[a] = peopleArr[i];
                        a++;
                    }
                }
                clonePeople[((Student) peopleArr[0]).getStuCount()] = null;
                enrollFunction.deleteStuEnroll(enrollArr, peopleArr, id);
                Font.print(Font.ANSI_YELLOW,"\n                             The Student ID " + id + " has been deleted\n");
            } else {
                ((Tutor) peopleArr[0]).reduceTutorCount();
                int tempCount = Tutor.getTutorCount();
                People[] tempPeople = peopleArr;

                int a = 0;
                // Move Entire tutor array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount + 1; i++) {
                    if (!((Tutor) peopleArr[i]).getTutorID().equals(id)) {
                        tempPeople[a] = peopleArr[i];
                        a++;
                    }
                }
                tempPeople[((Tutor) peopleArr[0]).getTutorCount()] = null;
                CheckRegistrationTutor(id, regArr);
                Font.print(Font.ANSI_YELLOW,"\n                              The Tutor ID "  + id + " has been deleted\n");
            }
        } else {
            Font.print(Font.ANSI_RED, "\n                                   The ID doesn't exist");
        }
        System.out.print("\n                                  Press enter to continue...");
        try{System.in.read();}
        catch(Exception e){}
        Screen.clear();
    }

    public static void CheckRegistrationTutor(String id, Register[] regArr){
        Register[] tempArr = regArr;
        int a = 0;
        int count = 0;

        for(int i = 0; i < Register.getRegNo(); i++){
            if(!(regArr[i].getTutID().equals(id))){
                    tempArr[a] = regArr[i];
                    a++;

                }
                else{
                    count++;
                }
        }
        for (int i = 0; i < count ; i++){
            Register.reduceRegNo();
            regArr[Register.getRegNo()] = null;
        }

    }





    public static void regTutor(Register[] regArr, People[] tutArray, Course[] psyCourse, Course[] itCourse, Course[] langCourse){
        Scanner input = new Scanner(System.in);
        Course regCourse = null;
        boolean isCodeExist = false;
        boolean isTutorExist = false;
        boolean isRegSuccess  = false;

        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tRegister Tutor");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
        System.out.print("                                   Enter Course Code: ");
        String courseCode = input.nextLine();

        for(int x = 0; x < Psychology.getPsyCount(); x++){
            if((psyCourse[x].getCode()).equals(courseCode)){
                isCodeExist = true;
                regCourse = psyCourse[x];
            }
        }

        for(int y = 0; y < IT.getItCount(); y++){
            if((itCourse[y].getCode()).equals(courseCode)){
                isCodeExist = true;
                regCourse = itCourse[y];
            }
        }

        for(int z = 0; z < Language.getLangCount(); z++){
            if((langCourse[z].getCode()).equals(courseCode)){
                isCodeExist = true;
                regCourse = langCourse[z];
            }
        }
        
        if(isCodeExist == false){
            Font.print(Font.ANSI_RED, "\n                                The Course Code Does Not Exist");
            System.out.print("\n                                  Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }else{
            System.out.print("\n                                   Enter Tutor ID: ");
            String tutorID = input.nextLine();
            //Validate TutorID
            for (int x = 0; x < Tutor.getTutorCount(); x++){
                if ((((Tutor) tutArray[x]).getTutorID()).equals(tutorID)){
                    //Examine Tutor Major
                    isTutorExist = true;
                    isRegSuccess  = validateRegister(regArr, tutArray, regCourse, tutorID);
                }
            }
        }

        if(isCodeExist == true && isTutorExist == false){
            Font.print(Font.ANSI_RED, "\n                                   The Tutor Does Not Exist");
            System.out.print("\n                                  Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }
    }

    public static boolean isDuplicateRegister(Register[] regArr, People[] tutArray, Course course, People tutor){
        boolean isDuplicate = false;

        for(int i = 0; i < Register.getRegNo(); i++){
            if(regArr[i].getCourse() == course && regArr[i].getTutor() == tutor){
                isDuplicate = true;
                System.out.println("\n                Course: " + (regArr[i].getCourse()).getTitle() + "\tTutor: " + (regArr[i].getTutor()).getName() + "\n");
            }
        }
        return isDuplicate;
    }


    public static boolean validateRegister(Register[] regArr, People[] tutArray, Course course, String tutorID){
        Scanner input = new Scanner(System.in);
        People tutor = null;
        boolean tutorMajor = false;
        boolean isDuplicate = true;
        boolean isSuccess = false;

        for (int x = 0; x < Tutor.getTutorCount(); x++) {
            if ((((Tutor) tutArray[x]).getTutorID()).equals(tutorID)) {
                if (course instanceof Psychology && ((Tutor)tutArray[x]).getMajor() == Major.PSY) {
                    //PSY
                    tutorMajor = true;
                    tutor = tutArray[x];
                } else if (course instanceof IT && ((Tutor)tutArray[x]).getMajor() == Major.IT) {
                    //IT
                    tutorMajor = true;
                    tutor = tutArray[x];
                } else if(course instanceof Language && ((Tutor)tutArray[x]).getMajor() == Major.LANG) {
                    //LAN
                    tutorMajor = true;
                    tutor = tutArray[x];  
                }
            }
        }

        if (tutorMajor == true) {
            isDuplicate = isDuplicateRegister(regArr, tutArray, course, tutor);
            if(isDuplicate == false){
                regArr[Register.getRegNo()] = new Register((Tutor) tutor, course);
                Font.print(Font.ANSI_YELLOW,"\n                                   Register Successfully!");
                System.out.print("\n                             Press enter to continue...");
                input.nextLine();
                Screen.clear();
                isSuccess = true;
            }else{
                Font.print(Font.ANSI_RED, "\n                                  Registeration Duplicated!");
                System.out.print("\n                             Press enter to continue...");
                input.nextLine();
                Screen.clear();
            }
        }else{
            Font.print(Font.ANSI_RED, "\n                             Tutor's major does not match with the course.");
            System.out.print("\n                                  Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }

        return isSuccess;
        
    }

    public static boolean validateReg(Register[] regArr, People[] tutArray, Course course, People tutor){
        boolean isDuplicate = true;

        for(int i = 0; i < Register.getRegNo(); i++){
            if(! (regArr[i].getCourse() == course && regArr[i].getTutor() == tutor)){
                isDuplicate = false;
            }
        }

        return isDuplicate;
    }

    public static boolean validateCourseCode(Course[] psyCourse, Course[] itCourse, Course[] langCourse, String courseCode){
        boolean isExist = false;

        for(int x = 0; x < Psychology.getPsyCount(); x++){
            if((psyCourse[x].getCode()).equals(courseCode)){
                isExist = true;
            }
        }

        for(int y = 0; y < IT.getItCount(); y++){
            if((itCourse[y].getCode()).equals(courseCode)){
                isExist = true;
            }
        }

        for(int z = 0; z < Language.getLangCount(); z++){
            if((langCourse[z].getCode()).equals(courseCode)){
                isExist = true;
            }
        }

        return isExist;
    }

    public static void removeRegister(Register[] regArr, People[] tutArray, Course[] psyCourse, Course[] itCourse, Course[] langCourse){
        Scanner input = new Scanner(System.in);
        boolean isTutorExist = false;
        boolean isCourseExist = false;
        boolean isTutorReg = false;
        boolean isDelete = false;
        String courseCode = "";
        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tRemove Register");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
        System.out.print("                                   Enter Tutor ID: ");
        String tutorId = input.nextLine();

        //Validate Tutor
        for (int x = 0; x < Tutor.getTutorCount(); x++){
            if ((((Tutor) tutArray[x]).getTutorID()).equals(tutorId)){
                isTutorExist = true;
            }
        }

        //Show every course that the tutor registered if tutor exist 
        if(isTutorExist == true){
            for(int i = 0; i < Register.getRegNo(); i++){
                if((regArr[i].getTutor().getTutorID()).equals(tutorId)){
                    System.out.print(regArr[i]);
                    isTutorReg = true;
                }
            }
        }

        if(isTutorReg == false && isTutorExist == true){
            Font.print(Font.ANSI_RED, "\n                        The tutor has not registered any courses yet.");
            System.out.print("\n                             Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }else if(isTutorReg == true && isTutorExist == true){
            System.out.print("                                   Enter Course Code: ");
            courseCode = input.nextLine();
            //Validate Course Code
            isCourseExist = validateCourseCode(psyCourse, itCourse, langCourse, courseCode);
        }else{
            Font.print(Font.ANSI_RED, "\n                                  The Tutor Does Not Exist.");
            System.out.print("\n                             Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }

        if(isTutorReg == true && isTutorExist == true && isCourseExist == true){
            for (int i = 0; i < Register.getRegNo(); i++) {
                if (((regArr[i].getTutor()).getTutorID()).equals(tutorId) && ((regArr[i].getCourse()).getCode()).equals(courseCode)) {
                    Register.reduceRegNo();
                    int regIndex = i;
                    Register[] newRegArr = regArr;

                    System.arraycopy(regArr, 0, newRegArr, 0, regIndex);
                    System.arraycopy(regArr, i + 1, newRegArr, i, Register.getRegNo() - i);

                    isDelete = true;
                    Font.print(Font.ANSI_YELLOW,"\n                                     Remove Successfully!");
                    System.out.print("\n                             Press enter to continue...");
                    input.nextLine();
                    Screen.clear();
                }
            }
        } 

        if(isDelete == false && isTutorReg == true && isTutorExist == true && isCourseExist == false){
            Font.print(Font.ANSI_RED, "\n                                  The Course Does Not Exist.");
            System.out.print("\n                             Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }

        if(isDelete == false && isTutorReg == true && isTutorExist == true && isCourseExist == true){
            Font.print(Font.ANSI_RED, "\n                            The tutor does not register in this course.");
            System.out.print("\n                             Press enter to continue...");
            input.nextLine();
            Screen.clear();
        }
    }

    public static void report(People[] stuArray, People[] tutArray, Course psy, Course it, Course lang, Course[] psyCourse, Course[] itCourse, Course[] langCourse, Enroll[] enrollArr, Register[] regArr) {
        int userChoice;
        Scanner input = new Scanner(System.in);

        do {
            try {

                Font.print(Font.CYAN_BOLD_BRIGHT, "Report");
                System.out.println("----------------");
                System.out.println("1. Student Report");
                System.out.println("2. Tutor Report");
                System.out.println("3. Student Enrollment Report");
                System.out.println("4. Tutor Registration Report");
                System.out.println("5. Summary Report");
                System.out.println("6. Platinum Member Listing");
                System.out.println("7. Back");
                System.out.print("Enter Choice: ");
                userChoice = input.nextInt();
                if (userChoice < 1 || userChoice > 7) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "Only (1-7) are allowed!");
                }
            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "\n                                      Invalid Input");
                input.next();
                userChoice = 100;
            }

            switch (userChoice) {
                case 1:
                    Screen.clear();
                    Font.print(Font.ANSI_BLUE, "                                                              Student Report");
                    StudentReport(stuArray);
                    break;
                case 2:
                    Screen.clear();
                    Font.print(Font.ANSI_BLUE, "                                                              Tutor Report");
                    TutorReport(tutArray);
                    break;
                case 3:
                    Screen.clear();
                    Font.print(Font.ANSI_BLUE, "                                                         Student Enrollment Report");
                    EnrollmentReport(enrollArr);
                    break;
                case 4:
                    Screen.clear();
                    Font.print(Font.ANSI_BLUE, "                                                              Tutor Registration Report");
                    RegistrationReport(regArr,tutArray);
                    break;
                case 5:
                    Screen.clear();
                    Font.print(Font.ANSI_BLUE, "                                                              Summary Report");
                    SummaryReport(enrollArr, psy, it, lang, psyCourse, itCourse, langCourse);
                    break;
                case 6:
                    Screen.clear();
                    Font.print(Font.ANSI_BLUE, "                                                              Platinum Member Listing");
                    PlatMemListing(stuArray, enrollArr);
                    break;
                case 7:
                    Screen.clear();
                    break;
            }
        } while (userChoice != 7);
    }


    public static void StudentReport(People[] stuArray) {
        System.out.println("=========================================================================================================================================================================");
        System.out.printf("%12s %19s %15s %6s %17s %23s %22s %12s", "Student ID", "Name", "Age", "Sex", "Phone Number", "Email", "Description", "Balance", "Course Name");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Student.getStuCount(); i++) {
            System.out.printf("%9s %30s %6s %6s %19s %30s %12s %7s", ((Student) stuArray[i]).getStuID(), stuArray[i].getName(), stuArray[i].getAge(), stuArray[i].getSex(), stuArray[i].getPhoneNum(), stuArray[i].getEmail(), ((Student) stuArray[i]).getDescription(), "");
            System.out.printf("%.2f", ((Student) stuArray[i]).getBalance());
            System.out.println();
        }
        System.out.println("=========================================================================================================================================================================");
    }

    public static void TutorReport(People[] tutArray) {
        System.out.println("=========================================================================================================================================================================");
        System.out.printf("%10s %22s %15s %6s %15s %26s %18s %14s", "Tutor ID", "Name", "Age", "Sex", "Phone Number", "Email", "Major", "Level");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Tutor.getTutorCount(); i++) {
            System.out.printf("%8s %30s %9s %5s %17s %33s %9s %19s", ((Tutor) tutArray[i]).getTutorID(), tutArray[i].getName(), tutArray[i].getAge(), tutArray[i].getSex(), tutArray[i].getPhoneNum(), tutArray[i].getEmail(), ((Tutor) tutArray[i]).getMajor(), ((Tutor) tutArray[i]).getLevel());
            System.out.println();
        }
        System.out.println("=========================================================================================================================================================================");
    }

    public static void EnrollmentReport(Enroll[] enrollArr){
        System.out.println("=========================================================================================================================================================================");
        System.out.printf("%12s %19s %22s %30s", "Student ID", "Name", "Course ID", "Course Name");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Enroll.getEnrollNum(); i++) {
            for(int z = 0; z <Enroll.getEnrollNum(); z++){
                if(enrollArr[z].student.getStuID().equals("W" + i)){
                    System.out.printf(" %9s %28s %14s %40s", enrollArr[z].student.getStuID() , enrollArr[z].student.getName() , enrollArr[z].course.getCode() , enrollArr[z].course.getTitle());
                    System.out.println();
                }
        }
    }
        System.out.println("=========================================================================================================================================================================");
}
    
    public static void RegistrationReport(Register[] regArr, People[] tutArray){
        System.out.println("=========================================================================================================================================================================");
        System.out.printf("%12s %19s %22s %30s", "Tutor ID", "Name", "Course ID", "Course Name");
        System.out.println();
        for (int i = 0; i < Register.getRegNo(); i++) {
                System.out.printf(" %9s %28s %14s %40s", regArr[i].getTutID() , regArr[i].getTutName() , regArr[i].getCourseID() , regArr[i].getCourseName());
                System.out.println();
        }
    
        System.out.println("=========================================================================================================================================================================");

    }
    
    public static void SummaryReport(Enroll[] enrollArr, Course psy, Course it, Course lang, Course[] psyCourse, Course[] itCourse, Course[] langCourse){
        // Calculate number of student for each subject
        int TotalPsySubjectCount = ((Psychology) psyCourse[0]).getPsyCount();
        int TotalITSubjectCount = ((IT)itCourse[0]).getItCount();
        int TotalLangSubjectCount = ((Language)langCourse[0]).getLangCount();

        int[] PsyStudentCount= new int[TotalPsySubjectCount];
        int[] ITStudentCount= new int[TotalITSubjectCount];
        int[] LangStudentCount= new int[TotalLangSubjectCount];
        Double[] PsyProfit = new Double[TotalPsySubjectCount];
        Double[] ITProfit = new Double[TotalITSubjectCount];
        Double[] LangProfit = new Double[TotalLangSubjectCount];


        for(int i = 0; i < Enroll.getEnrollNum(); i++) {
            for(int z = 0 ; z < TotalPsySubjectCount; z++){
                if((enrollArr[i].course.getCode()).equals(psyCourse[z].getCode())){
                    PsyStudentCount[z]++;
               }
            }
            for(int c = 0 ; c < TotalPsySubjectCount; c++){
                if((enrollArr[i].course.getCode()).equals(itCourse[c].getCode())){
                    ITStudentCount[c]++;
                }
            }
            for(int l = 0 ; l < TotalPsySubjectCount; l++){
                if((enrollArr[i].course.getCode()).equals(langCourse[l].getCode())){
                    LangStudentCount[l]++;
                }
            }
        }
        double totalProfit = 0;
        
        for(int z = 0 ; z < TotalPsySubjectCount; z++){
            PsyProfit[z] = (psyCourse[z].getFee() * PsyStudentCount[z]);
            totalProfit += PsyProfit[z];
           
        }
        for(int c = 0 ; c < TotalITSubjectCount; c++){
            ITProfit[c] = (itCourse[c].getFee() * ITStudentCount[c]);
            totalProfit += ITProfit[c];
            
        }
        for(int l = 0 ; l < TotalLangSubjectCount; l++){
            LangProfit[l] = (langCourse[l].getFee() * LangStudentCount[l]);
            totalProfit += LangProfit[l];
            
        }

        System.out.println("=====================================================================================================================================================================");
        Font.print(Font.ANSI_YELLOW, "1. Psychology");
        System.out.printf("%40s %15s %20s %11s\n" , "Course Name", "Course Fee" , " Number of Student" , " Profit");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        
        for (int x = 0; x < Psychology.getPsyCount(); x++) {
            System.out.printf("%40s %15s %13s %11s" , psyCourse[x].getTitle(), psyCourse[x].getFee() , PsyStudentCount[x] , "" );
            System.out.printf("%.2f", PsyProfit[x]);
            System.out.println();
        }
        Font.print(Font.ANSI_YELLOW, "2. IT");
        System.out.printf("%40s %15s %20s %11s\n" , "Course Name", "Course Fee" , " Number of Student" , " Profit");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        for (int x = 0; x < IT.getItCount(); x++) {
            System.out.printf("%40s %15s %13s %11s" , itCourse[x].getTitle(), itCourse[x].getFee() , ITStudentCount[x] , "" );
            System.out.printf("%.2f", ITProfit[x]);
            System.out.println();
        }
        Font.print(Font.ANSI_YELLOW, "3. Language");
        System.out.printf("%40s %15s %20s %11s\n" , "Course Name", "Course Fee" , " Number of Student" , " Profit");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        for (int x = 0; x < Language.getLangCount(); x++) {
            System.out.printf("%40s %15s %13s %11s" , langCourse[x].getTitle(), langCourse[x].getFee() , LangStudentCount[x] , "" );
            System.out.printf("%.2f", LangProfit[x]);
            System.out.println();        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("Total Profit:                                                                 RM %.2f\n", totalProfit);
        System.out.println("=====================================================================================================================================================================");
    }

    public static void PlatMemListing(People[] stuArray, Enroll[] enrollArr){
        System.out.println("=========================================================================================================================================================================");
        System.out.printf("%12s %19s %15s %6s %17s %23s %22s %12s", "Student ID", "Name", "Age", "Sex", "Phone Number", "Email", "Description", "Balance", "Course Name");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < Student.getStuCount(); i++) {
            if (((Student) stuArray[i]).numOfTakenCourse(enrollArr)) {
                System.out.printf("%9s %30s %6s %6s %19s %30s %12s %7s", ((Student) stuArray[i]).getStuID(), stuArray[i].getName(), stuArray[i].getAge(), stuArray[i].getSex(), stuArray[i].getPhoneNum(), stuArray[i].getEmail(), ((Student) stuArray[i]).getDescription(), "");
                System.out.printf("%.2f", ((Student) stuArray[i]).getBalance());
                System.out.println();
            }
        }
        System.out.println("=========================================================================================================================================================================");
    }
    
    // Exception for handling invalid username or password
    private static class InvalidException extends Exception {

        private final String errorMsg;

        InvalidException() {
            this.errorMsg = "                          Invalid Password or Username, please try again!\n";
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    
}

