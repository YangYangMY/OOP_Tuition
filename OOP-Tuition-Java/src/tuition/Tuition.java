package tuition;

import java.util.Scanner;
import java.util.Formatter;

public class Tuition {

    private final static String username = "admin";
    private final static String password = "rsf1s3g2";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int times = 3;
        boolean contactManagement = false;
        System.out.println("Login");
        do {
            System.out.print("Username: ");
            String enteredUsername = input.nextLine();
            System.out.print("Password: ");
            String enteredPassword = input.nextLine();

            if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
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
                menu(stuArray, tutArray, Psychology, IT, Language, psyCourse, itCourse, langCourse);
                times = 0;
                contactManagement = false;
            } else {
                System.out.println("\nPlease enter valid username and password.\n");
                times--;
                contactManagement = true;
            }
        } while (times > 0);

        if (contactManagement) {
            System.out.println("Sorry, you have reached the maximum times of login. Please contact the management for the username and password\n");
        }

        System.out.println("Logout.");

    }
    
    public static void menu(People[] stuArray, People[] tutArray, Course Psychology, Course IT, Course Language, Psychology[] psyCourse, IT[] itCourse, Language[] langCourse) {
        Scanner input = new Scanner(System.in);


        int taskChoice = 0;
        
        do {
            System.out.print("TTL Tuition Center\nCourse\n\t1. Add course\n\t2. Modify course\n\t3. Remove course"
                    + "\nStudent\n\t4. Add Student\n\t5. Modify Student\n\t6. Remove Student"
                    + "\nTutor\n\t7. Add Tutor\n\t8. Modify Tutor\n\t9. Remove Tutor"
                    + "\nList\n\t10. Student\n\t11. Tutor\n\t12. Psychology Courses\n\t13. IT Courses\n\t14. Language Courses\nSelect task to perform: ");
            taskChoice = input.nextInt();

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
                    //Psychology Course
                    System.out.print("\nPSYCHOLOGY");
                    System.out.println(Psychology.toString());

                    for (int x = 0; x < psyCourse.length; x++) {
                        System.out.println((x+1) + ".");
                        System.out.println(psyCourse[x]);
                    }
                    break;
                case 13:
                    // IT Course
                    System.out.print("\nINOFRMATION TECHNOLOGY (IT)");
                    System.out.println(IT.toString());

                    for (int y = 0; y < itCourse.length; y++) {
                        System.out.println((y+1) + ".");
                        System.out.println(itCourse[y]);
                    }
                    break;
                case 14:
                    // Language Course
                    System.out.print("\nLANGUAGE");
                    System.out.println(Language.toString());

                    for (int z = 0; z < langCourse.length; z++) {
                        System.out.println((z+1) + ".");
                        System.out.println(langCourse[z]);
                    }
                    break;

            }
        } while (taskChoice != 0);

    }

    public static void addPeople(People[] peopleArr) {
        Scanner input = new Scanner(System.in);
        String name, phoneNum, email, description, stringAge, stringSex;
        char sex;
        int age;
        double balance;

        System.out.print("Enter name: ");
        name = input.nextLine();
        System.out.print("Enter age: ");
        stringAge = input.nextLine();
        System.out.print("Enter sex: ");
        stringSex = input.nextLine();
        System.out.print("Enter phone number: ");
        phoneNum = input.nextLine();
        System.out.print("Enter email: ");
        email = input.nextLine();

        sex = stringSex.charAt(0);
        age = Integer.parseInt(stringAge);

        if (peopleArr[0] instanceof Student) {
            System.out.print("Enter description: ");
            description = input.nextLine();
            System.out.print("Enter balance: ");
            balance = input.nextDouble();
            peopleArr[((Student) peopleArr[0]).getStuNum()] = new Student(name, age, sex, phoneNum, email, description, balance);
        } else {
            System.out.print("Enter major (IT, PSY, HR): ");
            String major = input.nextLine();
            System.out.print("Enter level (Doctorate, BachelorDegree, MasterDegree): ");
            String level = input.nextLine();

            peopleArr[((Tutor) peopleArr[0]).getTutorNum()] = new Tutor(name, age, sex, phoneNum, email, ((Tutor) peopleArr[0]).getMajor(major), ((Tutor) peopleArr[0]).getLevel(level));
        }
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
                System.out.print("Select to modify\n1. Name\n2. Age\n3. Sex\n4. Phone Number\n5. Email\n6. Major\n7. Level");
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
                        System.out.print("Enter new major: ");
                        String newMajor = input.nextLine();
                        ((Tutor) peopleArr[tempI]).setMajor(((Tutor) peopleArr[tempI]).getMajor(newMajor));
                        break;
                    case 7:
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
                People[] tempPeople = new Student[((Student)peopleArr[0]).getStuCount()];
                int tempCount = Student.getStuCount();
                tempPeople = peopleArr;
            
                
                int a = 0;
                // Move Entire student array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount+1; i++){
                    if (! ((Student)peopleArr[i]).getStuID().equals(id)){
                        tempPeople[a] = peopleArr[i];
                        a++;
                    }
                }
                System.out.println("The Student ID " + id + " has been deleted");
            } else {
                People[] tempPeople1 = new Tutor[((Tutor)peopleArr[0]).getTutorCount()-1];
                ((Tutor)peopleArr[0]).reduceTutorCount();
                int tempCount = Tutor.getTutorCount();
                tempPeople1 = peopleArr;

                int a = 0;
                // Move Entire tutor array to a temp array except the chosen delete id
                for (int i = 0; i < tempCount+1; i++){
                    if (! ((Tutor)peopleArr[i]).getTutorID().equals(id)){
                        tempPeople1[a] = peopleArr[i];
                        a++;
                    }

                }
                System.out.println("The Tutor ID " + id + " has been deleted");
            }
        } else {
            System.out.println("The ID doesn't exist");
        }
    }
}
