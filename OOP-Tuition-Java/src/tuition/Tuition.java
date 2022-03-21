package tuition;

public class Tuition {

    public static void main(String[] args) {
        People[] stuArray = new Student[100];
        People[] tutArray = new Tutor[30];
        dummyScript.dummyData(stuArray);
        dummyScript.dummyData2(tutArray);

        for (int i = 0; i < Student.getStuNum(); i++) {
            System.out.println(stuArray[i]);
        }
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.println(tutArray[i].toString());
        }
        System.out.println();
        Course Psychology = new Course();
        Course IT = new Course();
        Course HR = new Course();
        dummyScript.CourseDummyData(Psychology, IT, HR);

        System.out.println(Psychology.toString());
        System.out.println(IT.toString());
        System.out.println(HR.toString());

        Psychology[] psyCourse = new Psychology[3];
        IT[] itCourse = new IT[3];
        HR[] hrCourse = new HR[3];

        dummyScript.psyCourseDummyData(psyCourse);
        dummyScript.itCourseDummyDate(itCourse);
        dummyScript.hrCourseDummyDate(hrCourse);

        for (int x = 0; x < psyCourse.length; x++) {
            System.out.println(psyCourse[x]);
        }

        for (int y = 0; y < itCourse.length; y++) {
            System.out.println(itCourse[y]);
        }

        for (int z = 0; z < hrCourse.length; z++) {
            System.out.println(hrCourse[z]);
        }

    }


}
