package tuition;

public class Register {
    Tutor tutor;
    Course course;
    private static int regNo;
    
    public Register() {
        Register.regNo++;
    }

    public Register(Tutor tutor, Course course){
        this.tutor = tutor;
        this.course = course;
        Register.regNo++;  
    }

    public String getTutID(){
        return tutor.getTutorID();
    }

    public String getTutName(){
        return tutor.getName();
    }

    public String getCourseID(){
        return course.getCode();
    }

    public String getCourseName(){
        return course.getTitle();
    }

    public static int getRegNo(){
        return regNo;
    }

    public Tutor getTutor(){
        return this.tutor;
    }

    public Course getCourse(){
        return this.course;
    }

    public void setTutor(Tutor tutor){
        this.tutor = tutor;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public static void reduceRegNo(){
        Register.regNo--;
    }

    @Override
    public String toString(){
        String output = "";

        output += "\nTutor name: " + tutor.getName()
                + "\nCourse code: " + course.getCode() 
                + "\t\t\tCourse title: " + course.getTitle() + "\n";

                return output;
    }
}


