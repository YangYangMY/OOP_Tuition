package oop.tuition.java;

public class Course {
    String description;
    int maxStudentNo;

public Course(){
}

public Course(String courseDescription, int capacity){
    this.description = courseDescription;
    this.maxStudentNo = capacity;
}

@Override
    public String toString() {
        String output = "";

        output+= "Course description: " + this.description + "\n" +
        "Enrollment Limit : " + this.maxStudentNo + " students\n";

        return output;
    }
}
