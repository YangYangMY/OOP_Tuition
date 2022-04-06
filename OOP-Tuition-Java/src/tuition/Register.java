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

    @Override
    public String toString(){
        String output = "";

        output += "Course title: " + course.getTitle()
                + "\nTutor(s): " + tutor.getName() + "\n";

                return output;
    }
}


