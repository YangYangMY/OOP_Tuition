package tuition; 

import java.util.Scanner;

public class enrollFunction {
    
    static Scanner input = new Scanner(System.in);
    static boolean studentExist = false;
    static boolean subjectExist = false;
    static Course tempCourse;
    
    
    public static void addEnroll(Enroll[] enrollArr, People[] stuArray, Course[] psyCourse, Course[] itCourse, Course[] langCourse){
        int tempI = 0;
        Screen.clear();
        Font.print(Font.ANSI_BLUE, "\n\t\t\t\t\tAdd Enroll");
        Font.print(Font.ANSI_BLUE, "\n\t\t\t===============================================");
        System.out.print("                                   Enter Student ID: ");
        String id = input.nextLine();
        
        for (int i = 0; i < Student.getStuCount(); i++) {
            if ((((Student) stuArray[i]).getStuID()).equals(id)) {
                Font.print(Font.ANSI_RED, "\n                                      Student Exist");
                studentExist = true;
                tempI = i;
            }
        }
        
        if (studentExist) {
            for (int i = 0; i < Enroll.getEnrollNum(); i++) {
                if (id.equals(enrollArr[i].student.getStuID())) {
                    System.out.println(enrollArr[i]);
                }
            }
            System.out.print("                                   Enter Course ID: ");
            String id2 = input.nextLine();
            for (int i = 0; i < Psychology.getNumOfPsyCourse(); i++) {
                if ((((Psychology) psyCourse[i]).getCode()).equals(id2)) {
                    Font.print(Font.ANSI_RED, "\n                                      Psy Subject Exist");
                    subjectExist = true;
                    tempCourse = psyCourse[i];
                }
            }
            for (int i = 0; i < IT.getNumOfItCourse(); i++) {
                if ((((IT) itCourse[i]).getCode()).equals(id2)) {
                    Font.print(Font.ANSI_RED, "\n                                      IT Subject Exist");
                    subjectExist = true;
                    tempCourse = itCourse[i];
                }
            }
            for (int i = 0; i < Language.getNumOfLangCourse(); i++) {
                if ((((Language) langCourse[i]).getCode()).equals(id2)) {
                    Font.print(Font.ANSI_RED, "\n                                      Lang Subject Exist");
                    subjectExist = true;
                    tempCourse = langCourse[i];
                }
            }
            
            if(subjectExist){
                boolean duplicateE = false;
                for(int i = 0; i < Enroll.getEnrollNum(); i++){
                    if(stuArray[tempI].equals(enrollArr[i].getStudent())){
                        if(tempCourse.equals(enrollArr[i].getCourse())){
                            Font.print(Font.ANSI_RED, "\n                                      Duplicate Enrollment");
                            duplicateE = true;
                        }   
                    }
                }
                if(!(duplicateE)){
                    if((((Student)stuArray[tempI]).getBalance()) > tempCourse.getFee()){
                        ((Student)stuArray[tempI]).setBalance(((Student)stuArray[tempI]).getBalance() - tempCourse.getFee());
                        enrollArr[Enroll.getEnrollNum()] = new Enroll((Student)stuArray[tempI], tempCourse);
                        Font.print(Font.ANSI_RED, "\n                                      Enroll Successful");
                    } else {
                        Font.print(Font.ANSI_RED, "\n                                      Insufficient Balance");
                    }
                }
            } else {
                Font.print(Font.ANSI_RED, "\n                                      Invalid Course ID");
            }
            
        } else {
            Font.print(Font.ANSI_RED, "\n                                      Invalid Student ID");
            
        }
        System.out.println("\n                                 Press enter to continue...");
        try{System.in.read();}
        catch(Exception e){}
        Screen.clear();
    }
    
    public static void deleteEnroll(Enroll[] enrollArr){
        boolean stuEnrollExist = false;
        System.out.print("                                   Enter Student ID: ");
        String id = input.nextLine();

        for (int i = 0; i < Enroll.getEnrollNum(); i++) {
            if (id.equals(enrollArr[i].student.getStuID())) {
                System.out.println(enrollArr[i]);
                stuEnrollExist = true;
            }
        }
        if (!stuEnrollExist) {
            Font.print(Font.ANSI_RED, "\n                                      Invalid Student ID");
        } else {
            System.out.print("                                   Enter Course ID: ");
            String id2 = input.nextLine();
            boolean match = false;
            int arrayToDelete = 0;
            for (int i = 0; i < Enroll.getEnrollNum(); i++) {
                if (id.equals(enrollArr[i].student.getStuID())) {
                    if(id2.equals(enrollArr[i].course.getCode())){
                        arrayToDelete = i;
                        match = true;
                    } 
                }
            }
            if(match){
                deleteEnrollFunction(enrollArr, arrayToDelete);
                Font.print(Font.ANSI_RED, "\n                                      Enrollment deleted");
            } else {
                Font.print(Font.ANSI_RED, "\n                                      No enrollment found.");
            }
        }
        System.out.println("\n                                 Press enter to continue...");
        try{System.in.read();}
        catch(Exception e){}
        Screen.clear();
    }
    
    public static void deleteEnrollFunction(Enroll[] enrollArr, int arrayToDelete) {
        Enroll.setEnrollNum(Enroll.getEnrollNum() - 1);
        Enroll[] tempArr = enrollArr;
        for (int i = 0; i < Enroll.getEnrollNum(); i++) {
            if (i < arrayToDelete) {
                enrollArr[i] = tempArr[i];
            } else {
                enrollArr[i] = tempArr[i + 1];
            }
        }
    }
    
    public static void deleteStuEnroll(Enroll[] enrollArr, People[] stuArray, String id) {
        int timesToExecute = 0;
        for(int i = 0; i < Enroll.getEnrollNum(); i++){
            if((enrollArr[i].student.getStuID()).equals(id)){
                timesToExecute++;
            }
        }
        
        for (int j = 0; j < timesToExecute; j++) {
            for (int i = 0; i < Enroll.getEnrollNum(); i++) {
                if ((enrollArr[i].student.getStuID()).equals(id)) {
                    deleteEnrollFunction(enrollArr, i);
                }
            }
        }
    }
}
