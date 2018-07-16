import java.util.ArrayList;
import java.util.Arrays;

public class Grado {
    private String Name_Grado = "Default";
    private ArrayList<Object> Students = new ArrayList<>();

    //SETTERS AND GETTERS


    public String getName_Grado() {
        return Name_Grado;
    }

    public void setName_Grado(String name_Grado) {
        Name_Grado = name_Grado;
    }

    public ArrayList<Object> getStudents() {
        return Students;
    }

    public void setStudents(ArrayList<Object> students) {
        Students = students;
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
