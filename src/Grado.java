
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Grado {
    private String Name_Grado = "Default";
    CopyOnWriteArrayList<Estudiante> Students = new CopyOnWriteArrayList<>();

    //SETTERS AND GETTERS


    public String getName_Grado() {
        return Name_Grado;
    }

    public void setName_Grado(String name_Grado) {
        Name_Grado = name_Grado;
    }

    public CopyOnWriteArrayList<Estudiante> getStudents() {
        return Students;
    }

    public void setStudents(CopyOnWriteArrayList<Estudiante> students) {
        Students = students;
    }
    public void addStudent(Estudiante estudiante){
        this.Students.add(estudiante);

    }

    //CONSTRUCTOR
    public Grado (String nombre){
        this.Name_Grado= nombre;
    }



    @Override
    public String toString() {

        return "" +
                "\n"+
                " Grado= " + Name_Grado +
                "\n"+
                " Estudiantes= " + Arrays.toString(Students.toArray()) +
                "\n"+
                "";


    }

}
