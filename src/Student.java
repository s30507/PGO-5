import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    StudyProgramme StudyProgramme;
    List<Grade> grades = new ArrayList<>();
    static List<Student > students= new ArrayList<>();
    String status;
    static int ID = 1;
    String index;

    int currentSemester;

    String FirstName;
    String LastName;
    String email;
    String Address;
    String phoneNumber;
    Date date;

    public Student(String FirstName, String LastName, String email, String Address, String phoneNumber, Date date) {
        index = "s" + ID;
        ID++;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.email = email;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.status= "new";
        this.currentSemester=0;
        students.add(this);
    }

    public static void promoteAllStudents() {
        for (int i=0; i<students.size(); i++){
            students.get(i).promoteToNextSemester();
        }
    }
    public  void promoteToNextSemester() {
        if(ExceedItns() == false) {
            this.currentSemester++;
            if (this.currentSemester==this.StudyProgramme.semestr){
                status="Graduate";
            }
        }
    }
    public boolean ExceedItns() {
        int twoGrades = 0;
        for(int i=0; i<grades.size();i++){
            if(grades.get(i).grade == 2){
                twoGrades++;
            }
        }

        boolean exceedITNS = false;

        if(twoGrades <= StudyProgramme.NoOfITNs){
            exceedITNS = true;
        }

        return exceedITNS;
    }

    public void enrollStudent(StudyProgramme sp) {
        this.StudyProgramme = sp;
    }

    public void addGrade(int grade, String subject){
        Grade g = new Grade(grade, subject);
        grades.add(g);
    }

    public static void displayInfoAboutAllStudents(){
        for(int i=0; i< students.size();i++){
            System.out.println(students.get(i).currentSemester);
        }
    }
}
