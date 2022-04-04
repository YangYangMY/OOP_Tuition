package tuition; 

import java.util.Scanner;

public class enrollFunction {
    
    static Scanner input = new Scanner(System.in);
    static boolean studentExist = false;
    static boolean subjectExist = false;
    static Course tempCourse;
    
    
    public static void addEnroll(Enroll[] enrollArr, People[] stuArray, Course[] psyCourse, Course[] itCourse, Course[] langCourse){
        int tempI = 0;
        System.out.print("Enter Student ID: ");
        String id = input.nextLine();
        
        for (int i = 0; i < Student.getStuCount(); i++) {
            if ((((Student) stuArray[i]).getStuID()).equals(id)) {
                System.out.println("Student Exist");
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
            System.out.print("Enter Course ID: ");
            String id2 = input.nextLine();
            for (int i = 0; i < Psychology.getNumOfPsyCourse(); i++) {
                if ((((Psychology) psyCourse[i]).getCode()).equals(id2)) {
                    System.out.println("Psy Subject Exist");
                    subjectExist = true;
                    tempCourse = psyCourse[i];
                }
            }
            for (int i = 0; i < IT.getNumOfItCourse(); i++) {
                if ((((IT) itCourse[i]).getCode()).equals(id2)) {
                    System.out.println("IT Subject Exist");
                    subjectExist = true;
                    tempCourse = itCourse[i];
                }
            }
            for (int i = 0; i < Language.getNumOfLangCourse(); i++) {
                if ((((Language) langCourse[i]).getCode()).equals(id2)) {
                    System.out.println("Lang Subject Exist");
                    subjectExist = true;
                    tempCourse = langCourse[i];
                }
            }
            
            if(subjectExist){
                boolean duplicateE = false;
                for(int i = 0; i < Enroll.getEnrollNum(); i++){
                    if(stuArray[tempI].equals(enrollArr[i].getStudent())){
                        if(tempCourse.equals(enrollArr[i].getCourse())){
                            System.out.println("Duplicate Enrollment");
                            duplicateE = true;
                        }   
                    }
                }
                if(!(duplicateE)){
                    if((((Student)stuArray[tempI]).getBalance()) > tempCourse.getFee()){
                        ((Student)stuArray[tempI]).setBalance(((Student)stuArray[tempI]).getBalance() - tempCourse.getFee());
                        enrollArr[Enroll.getEnrollNum()] = new Enroll((Student)stuArray[tempI], tempCourse);
                        System.out.println("Enroll Successful");
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                }
            } else {
                System.out.println("Invalid Course ID");
            }
            
        } else {
            System.out.println("Invalid Student ID");
        }
    }
    
    public static void deleteEnroll(Enroll[] enrollArr){
        boolean stuEnrollExist = false;
        System.out.print("Enter Student ID: ");
        String id = input.nextLine();

        for (int i = 0; i < Enroll.getEnrollNum(); i++) {
            if (id.equals(enrollArr[i].student.getStuID())) {
                System.out.println(enrollArr[i]);
                stuEnrollExist = true;
            }
        }
        if (!stuEnrollExist) {
            System.out.println("Invalid Student ID");
        } else {
            System.out.print("Enter Course ID: ");
            String id2 = input.nextLine();
            boolean match = false;
            int arrayToDelete = 0;
            for (int i = 0; i < Enroll.getEnrollNum(); i++) {
                if (id.equals(enrollArr[i].student.getStuID())) {
                    if(id2.equals(enrollArr[i].course.getCode())){
                        Enroll.setEnrollNum(Enroll.getEnrollNum() - 1);
                        arrayToDelete = i;
                        match = true;
                    } 
                }
            }
            if(match){
                Enroll[] tempArr = enrollArr;
                for (int i = 0; i < Enroll.getEnrollNum(); i++){
                    if(i < arrayToDelete){
                        enrollArr[i] = tempArr[i];
                    } else {
                        enrollArr[i] = tempArr[i + 1];
                    }
                }
                System.out.println("Enrollment deleted");
            } else {
                System.out.println("No enrollment found.");
            }
        }
    }
}
