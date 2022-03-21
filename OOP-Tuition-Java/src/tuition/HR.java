package tuition;

public class HR extends Course {

    private String code;
    private String name;
    private double fee;
    private int numOfStudent;

    public HR() {
        this(null, null, 0.0);
    }

    public HR(String courseCode, String courseName, Double coursefee) {
        this.code = courseCode;
        this.name = courseName;
        this.fee = coursefee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }
    
    @Override
    public String toString() {
        String output = "";

        output += "Course code: " + this.code + "\n"
                + "Course title: " + this.name + "\n"
                + "Course fee: " + this.fee + "\n";

        return output;
    }
}
