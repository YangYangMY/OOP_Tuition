package oop.tuition.java;

public class HR extends Course{
    String code;
    String name;
    double fee;
    int numOfStudent;

public HR(){
}

public HR(String courseCode, String courseName, Double coursefee){
    this.code = courseCode;
    this.name = courseName;
    this.fee = coursefee;
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
