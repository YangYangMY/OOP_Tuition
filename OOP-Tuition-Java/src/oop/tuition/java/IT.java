package oop.tuition.java;

public class IT extends Course{
    String code;
    String name;
    double fee;
    int numOfStudent;

public IT(){
}
    
public IT(String courseCode, String courseName, double courseFee){
    this.code = courseCode;
    this.name = courseName;
    this.fee = courseFee;
}

@Override
    public String toString() {
        String output = "";

        output+= "Course code: " + this.code + "\n" +
        "Course title: " + this.name + "\n" +
        "Course fee: " + this.fee + "\n";

        return output;
    }
}
