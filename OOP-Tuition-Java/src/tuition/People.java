package tuition;

class People {
    private String name;
    private int age;
    private char sexChar;
    private Sex sex;
    private String phoneNum;
    private String email;
    
    enum Sex{
        M,
        F
    }
    
    public People() {
    }   

    public People(String name, int age, char sexChar, String phoneNum, String email) {
        this.name = name;
        this.age = age;
        switch(sexChar){
            case 'M':
                this.sex = Sex.M;
                break;
            case 'F':
                this.sex = Sex.F;
                break;
        }
        this.phoneNum = phoneNum;
        this.email = email;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(char sexChar) {
        switch(sexChar){
            case 'M':
                this.sex = Sex.M;
                break;
            case 'F':
                this.sex = Sex.F;
                break;
        }
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Sex: " + sex + ", PhoneNum: " + phoneNum + ", Email: " + email;
    }
    
}
