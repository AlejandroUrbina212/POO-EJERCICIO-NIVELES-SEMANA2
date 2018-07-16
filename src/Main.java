import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String getMenu() {
        return "Menu:\n" +
                "\t1. Agregar Nivel\n" +
                "\t2. Agregar Grado\n" +
                "\t3. Agregar Estudiante\n" +
                "\t4. Ver Grados en un nivel especificado\n" +
                "\t5. Ver Asignaciones en un grado" +
                "\t6. Salir\n" ;
    }


    public static void main (String[] args) {
        boolean wantsToContinue = true;
        do{
            System.out.println(getMenu());
            System.out.print("Ingrese una opcion del menú: ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            switch(option) {
                case 1:
                    System.out.print("Ingrese un nombre para el nivel: ");
                    Scanner NOMBRE_NIVEL = new Scanner(System.in);

                    break;

        } while(wantsToContinue);




    }
}
