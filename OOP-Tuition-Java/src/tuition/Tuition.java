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
        Font.print(Font.ANSI_YELLOW,"           _____ _____ __       _____     _ _   _            _____         _           ");
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
                displayMenu();
                taskChoice = input.nextInt();
                if (taskChoice < 1 || taskChoice > 14) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "                            Only (1-14) is allowed, please try again!\n");
                }

            } catch (Exception e) {
                Screen.clear();
                Font.print(Font.ANSI_RED, "                            Only (1-14) is allowed, please try again!\n");
                input.next();
            }
            switch (taskChoice) {
                case 1:
                    int courseChoice = chooseCourse();
                    Screen.clear();
                    addCourse(psy, it, lang, psyCourse, itCourse, langCourse, courseChoice);
                    break;
                case 2:
                    modifyCourse(psyCourse, itCourse, langCourse);
                    break;
                case 3:
                    deleteCourse(psyCourse, itCourse, langCourse);
                    break;
                case 4:
                    addPeople(stuArray);
                    break;
                case 5:
                    modifyPeople(stuArray);
                    break;
                case 6:
                    deletePeople(stuArray, enrollArr);
                    break;
                case 7:
                    addPeople(tutArray);
                    break;
                case 8:
                    modifyPeople(tutArray);
                    break;
                case 9:
                    deletePeople(tutArray, enrollArr);
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
                    break;
                case 15:
                    Screen.clear();
                    report(stuArray, tutArray, psy, it, lang, psyCourse, itCourse, langCourse, enrollArr);
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
                Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tAdd Course");
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
            addPsyCourse(psyCourse);
        } else if (courseChoice == 2) {
            addItCourse(itCourse);
        } else if (courseChoice == 3) {
            addLangCourse(langCourse);
        } else {
            Screen.clear();
        }

    }

    public static void addPsyCourse(Course[] psyCourse) {
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

    public static void addItCourse(Course[] itCourse) {
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

    public static void addLangCourse(Course[] langCourse) {
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

    public static void modifyPsyCourse(Course[] psyCourse, Course modifyCourse) {
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
                Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
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
                ((Psychology) modifyCourse).setType(type);
                break;

            case 7:
                // Modify skill learned
                System.out.print("Enter new skill(s) learned: ");
                String skillLearned = input.nextLine();
                ((Psychology) modifyCourse).setSkillLearned(skillLearned);
                break;
        }
    }

    public static void modifyitCourse(Course[] itCourse, Course modifyCourse) {
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
                Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
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
                ((IT) modifyCourse).setPreRequisite(preRequisite);
                break;

            case 7:
                // Modify programming language
                System.out.print("Enter new programming language: ");
                String programmingLanguage = input.nextLine();
                ((IT) modifyCourse).setProgrammingLanguage(programmingLanguage);
                break;
        }
    }

    public static void modifyLangCourse(Course[] itCourse, Course modifyCourse) {
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
                Font.print(Font.ANSI_RED, "                            Only (1-7) is allowed. Please try again!");
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
                ((Language) modifyCourse).setLanguage(language);
                break;

            case 7:
                // Modify system
                System.out.print("Enter new examination system: ");
                String system = input.nextLine();
                ((Language) modifyCourse).setSystem(system);
                break;
        }
    }

    public static void modifyCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse) {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;

        System.out.print("\nEnter course code to modify: ");
        String code = input.nextLine();

        for (int x = 0; x < Psychology.getPsyCount(); x++) {
            if ((psyCourse[x].getCode()).equals(code)) {
                isValid = true;
                modifyPsyCourse(psyCourse, psyCourse[x]);
            }
        }

        for (int y = 0; y < IT.getItCount(); y++) {
            if ((itCourse[y].getCode()).equals(code)) {
                isValid = true;
                modifyitCourse(itCourse, itCourse[y]);
            }
        }

        for (int z = 0; z < Language.getLangCount(); z++) {
            if ((langCourse[z].getCode()).equals(code)) {
                isValid = true;
                modifyLangCourse(itCourse, langCourse[z]);
            }
        }
        if(isValid == false){
            Font.print(Font.ANSI_RED, "                            The course code does not exist.\n");
        }
    }

    public static void deleteCourse(Course[] psyCourse, Course[] itCourse, Course[] langCourse){
        Scanner input = new Scanner(System.in);
        boolean isCodeExist = false;
        
        System.out.print("                                   Enter course code to delete: ");
        String code = input.nextLine();

        for (int x = 0; x < ((Psychology) psyCourse[0]).getPsyCount(); x++) {
            if ((psyCourse[x].getCode()).equals(code)) {
                isCodeExist = true;
                Psychology.reducePsyCount();;
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

                System.out.println("The course " + code + " has been deleted.");
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
                System.out.println("The course " + code + " has been deleted.");
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
                System.out.println("The course " + code + " has been deleted.");
            }
        }

        if(isCodeExist == false){
            Font.print(Font.ANSI_RED, "                            The course code does not exist.");
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



        if (peopleArr[0] instanceof Student) {
            //Input and Validation
            Screen.clear();
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tAdd Student");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            name = NameInputValidate();
            age = AgeInputValidate();
            sex = SexInputValidate();
            phoneNum = PhoneInputValidate();
            email = EmailInputValidate();
            System.out.print("                                   Enter description: ");
            description = input.nextLine();
            balance = BalanceInputValidate();
            peopleArr[((Student) peopleArr[0]).getStuCount()] = new Student(name, age, sex, phoneNum, email, description, balance);
        } else {
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
            if (isWord(name)) {
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
                System.out.print("                                   Enter age: ");
                age = input.nextInt();
                if (age >= 0 && age <= 150) {
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

            System.out.print("                                   Enter sex: ");
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
            } else {
                valid = true;
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
            System.out.print("                                   Enter phone number(+6017-725 5766): ");
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
            System.out.print("                                   Enter email: ");
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
                System.out.print("                                   Enter balance: ");
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
            System.out.print("                                   Enter major (IT, PSY, LANG): ");
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
            System.out.print("                                   Enter level (Doctorate, BachelorDegree, MasterDegree): ");
            level = input.nextLine();
            if (!level.equals("Doctorate") && !level.equals("BacherlorDegree") && !level.equals("MasterDegree")) {
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


        if (peopleArr[0] instanceof Student) {
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tModify Student");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            System.out.print("                                   Enter ID to modify: ");
            String id = input.nextLine();
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
            String id = input.nextLine();
            for (int i = 0; i < Tutor.getTutorCount(); i++) {
                if ((((Tutor) peopleArr[i]).getTutorID()).equals(id)) {
                    peopleExist = true;
                    tempI = i;
                }
            }
        }

        if (peopleExist) {
            String message;
            if (peopleArr[0] instanceof Student) {
                message = " \n                                      Select to modify\n                                1. Name\n                                2. Age\n                                3. Sex\n                                4. Phone Number\n                                5. Email\n                                6. Description\n                                7. Balance";
            } else {                                
                message = "\n                                      Select to modify\n                                1. Name\n                                2. Age\n                                3. Sex\n                                4. Phone Number\n                                5. Email\n                                6. Level";
            }
            System.out.println(message);
            System.out.print("\n                                Choose your option: ");
            String stringModifyChoice = input.nextLine();
            int modifyChoice = Integer.parseInt(stringModifyChoice);
            if(modifyChoice < 1 || modifyChoice > 7){
                Font.print(Font.ANSI_RED, "\n                                      Invalid Input");
            }


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
                        System.out.print("                               Enter new description: ");
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
                        Font.print(Font.ANSI_RED, "\n                                      Invalid Input");
                    }
            }
        } else {
            Font.print(Font.ANSI_RED, "\n                                      The ID doesn't exist");
        }
        System.out.println("\n                                 Press enter to continue...");
        try{System.in.read();}
        catch(Exception e){}
        Screen.clear();
    }

    public static void deletePeople(People[] peopleArr, Enroll[] enrollArr) {
        Scanner input = new Scanner(System.in);
        boolean peopleExist = false;
        int tempI = 0;
        String id = "";

        Screen.clear();



        if (peopleArr[0] instanceof Student) {
            Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tDelete Student");
            Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
            System.out.print("                                   Enter ID to delete: ");
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
            System.out.print("                                   Enter ID to delete: ");
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
                People[] clonePeople = new Student[((Student) peopleArr[0]).getStuCount()];
                int tempCount = Student.getStuCount();
                clonePeople = peopleArr;

                int a = 0;
                // Move Entire student array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount + 1; i++) {
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
                People[] tempPeople = new Tutor[((Tutor) peopleArr[0]).getTutorCount()];
                int tempCount = Tutor.getTutorCount();
                tempPeople = peopleArr;

                int a = 0;
                // Move Entire tutor array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount + 1; i++) {
                    if (!((Tutor) peopleArr[i]).getTutorID().equals(id)) {
                        tempPeople[a] = peopleArr[i];
                        a++;
                    }
                }
                tempPeople[((Tutor) peopleArr[0]).getTutorCount()] = null;
                Font.print(Font.ANSI_YELLOW,"\n                              The Tutor ID"  + id + " has been deleted\n");
            }
        } else {
            Font.print(Font.ANSI_RED, "\n                                   The ID doesn't exist");
        }
        System.out.println("\n                                  Press enter to continue...");
        try{System.in.read();}
        catch(Exception e){}
        Screen.clear();
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
        }else{
            System.out.print("                                   Enter Tutor ID: ");
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
        }

        //Testing
        if(isRegSuccess  == true){
            for(int i = 0; i < Register.getRegNo(); i++){
                System.out.println(regArr[i].toString());
            }
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
                System.out.println("\n                                   Register Successfully!");
                isSuccess = true;
            }else{
                Font.print(Font.ANSI_RED, "\n                                  Registeration Duplicated");
            }
        }else{
            Font.print(Font.ANSI_RED, "\n                Tutor's major does not match with the course.");
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

    private static boolean isWord(String name) {
        return Pattern.matches("[a-zA-Z]+", name);
    }

    public static void report(People[] stuArray, People[] tutArray, Course psy, Course it, Course lang, Course[] psyCourse, Course[] itCourse, Course[] langCourse, Enroll[] enrollArr) {
        int userChoice;
        Scanner input = new Scanner(System.in);

        do {
            try {

                Font.print(Font.CYAN_BOLD_BRIGHT, "Report");
                System.out.println("----------------");
                System.out.println("1. Student Report");
                System.out.println("2. Tutor Report");
                System.out.println("3. Enrollment Report");
                System.out.println("4. Summary Report");
                System.out.println("5. Back");
                System.out.print("Enter Choice: ");
                userChoice = input.nextInt();
                if (userChoice < 1 || userChoice > 5) {
                    Screen.clear();
                    Font.print(Font.ANSI_RED, "Only (1-5) are allowed!");
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
                    Font.print(Font.ANSI_BLUE, "                                                              Summary Report");
                    SummaryReport(enrollArr, psy, it, lang, psyCourse, itCourse, langCourse);
                    break;
                case 5:
                    Screen.clear();
            }
        } while (userChoice != 5);
    }


    public static void StudentReport(People[] stuArray) {
        System.out.println("=========================================================================================================================================================================");
        System.out.printf("%12s %19s %15s %6s %17s %23s %22s %12s", "Student ID", "Name", "Age", "Sex", "Phone Number", "Email", "Description", "Balance", "Course Name");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Student.getStuCount(); i++) {
            System.out.printf("%9s %30s %6s %6s %19s %30s %12s %13s", ((Student) stuArray[i]).getStuID(), stuArray[i].getName(), stuArray[i].getAge(), stuArray[i].getSex(), stuArray[i].getPhoneNum(), stuArray[i].getEmail(), ((Student) stuArray[i]).getDescription(), ((Student) stuArray[i]).getBalance());
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
            System.out.printf("%8s %30s %9s %5s %17s %33s %9s %19s", ((Tutor) tutArray[i]).getTutorID(), tutArray[i].getName(), tutArray[i].getAge(), tutArray[i].getSex(), tutArray[i].getPhoneNum(), tutArray[i].getEmail(), ((Tutor) tutArray[i]).getMajor(), ((Tutor) tutArray[i]).getLevelName());
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

