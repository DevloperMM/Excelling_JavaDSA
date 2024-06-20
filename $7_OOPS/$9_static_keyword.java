package $7_OOPS;

public class $9_static_keyword {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student.collegeName = "PEC";
        s1.SID = 22104106;

        Student s2 = new Student();
        s2.name = "Mangal Murti";
        System.out.println(Student.collegeName); //equivalent to s2.collegeName
    }
}

class Student {
    static int retunPercentage(int phy, int chem, int math) {
        return (phy+chem+math)/3;
    }
    String name;
    int SID;
    static String collegeName;

    void setName(String nm) {
        this.name = nm;
    }
    String getName() {
        return this.name;
    }
}
