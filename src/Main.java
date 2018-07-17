import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static String getMenu() {
        return "Menu:\n" +
                "\t1. Agregar Nivel\n" +
                "\t2. Agregar Grado\n" +
                "\t3. Agregar Estudiante\n" +
                "\t4. Ver Grados en un nivel especificado\n" +
                "\t5. Ver Asignaciones en un grado\n" +
                "\t6. Salir\n";
    }


    public static void main(String[] args) {
        CopyOnWriteArrayList<Nivel> Niveles = new CopyOnWriteArrayList<Nivel>();
        Nivel x = new Nivel("prueba");
        Grado primero = new Grado("primero");
        Estudiante Luis = new Estudiante("Guicho",18473);

        primero.addStudent(Luis);
        x.addGrado(primero);
        Niveles.add(x);

        boolean kill = true;
        boolean wantsToContinue = true;
        do {
            System.out.println(getMenu());
            System.out.print("Ingrese una opcion del menú: ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            if (option == 1) {
                System.out.print("Ingrese un nombre para el nivel: ");
                Scanner NOMBRE_NIVEL = new Scanner(System.in);
                String NOMBRENIVEL1 = NOMBRE_NIVEL.next();

                for (Nivel s : Niveles) {
                    String nombre_a_verificar = s.getName();
                    if (!nombre_a_verificar.equals(NOMBRENIVEL1)) {
                        Nivel newlevel = new Nivel(NOMBRENIVEL1);
                        Niveles.add(newlevel);
                        System.out.println("Se ha agregado su Nivel");
                        System.out.println("los Niveles registrados son : ");
                        System.out.println(Niveles);
                    } else {
                        System.out.println("El Nombre de Ese nivel ya está registrado");
                    }
                }
            } else if (option == 2) {

                System.out.print("Ingrese un nombre para el nivel: ");
                Scanner NOMBRE_NIVEL_ESPECIFICADO = new Scanner(System.in);
                String NOMBRENIVEL1_ESPECIFICADO = NOMBRE_NIVEL_ESPECIFICADO.next();


                for (Nivel s : Niveles) {
                    String OBTENER_NOMBRE = s.getName();

                    if (OBTENER_NOMBRE.equals(NOMBRENIVEL1_ESPECIFICADO)) {
                        System.out.println("Se encuentra en el nivel: \n" + s);
                        System.out.print("Ingrese un nombre de grado para guardar: ");
                        Scanner NOMBRE_GRADO_A_GUARDAR = new Scanner(System.in);
                        String STRING_NOMBRE_GRADO_A_GUARDAR = NOMBRE_GRADO_A_GUARDAR.next();
                        for (Grado a : s.getGrados()) {
                            String grado_a_evaluar = a.getName_Grado();

                            if (!grado_a_evaluar.equals(STRING_NOMBRE_GRADO_A_GUARDAR)) {
                                Grado newgrado = new Grado(STRING_NOMBRE_GRADO_A_GUARDAR);
                                s.addGrado(newgrado);
                                System.out.println("Se ha agregado el grado, el estado actual del nivel es: ");
                                System.out.println(s.getGrados());

                            } else {
                                System.out.println("El grado que ingresó ya está guardado");
                            }
                        }

                    }

                    //SWITCH


                }
            } else if (option == 3) {

                System.out.print("Ingrese un nivel: ");
                Scanner NOMBRE_NIVEL_ESPECIFICADO_ESTUDIANTE = new Scanner(System.in);
                String NOMBRENIVEL1_ESPECIFICADO_ESTUDIANTE = NOMBRE_NIVEL_ESPECIFICADO_ESTUDIANTE.next();


                for (Nivel s : Niveles) {
                    String nombre_a_verificar = s.getName();
                    if (nombre_a_verificar.equals(NOMBRENIVEL1_ESPECIFICADO_ESTUDIANTE)) {
                        System.out.println("Se encuentra en el nivel: \n" + s);
                        //
                        System.out.print("Ingrese el grado en el que asignará al alumno: ");
                        Scanner NOMBRE_GRADO_A_ASIGNAR = new Scanner(System.in);
                        String STRING_NOMBRE_GRADO_A_ASIGNAR = NOMBRE_GRADO_A_ASIGNAR.next();
                        for (Grado a : s.getGrados()) {
                            String grado_a_evaluar = a.getName_Grado();
                            if (grado_a_evaluar.equals(STRING_NOMBRE_GRADO_A_ASIGNAR)) {
                                //ingreso de datos estudiante
                                System.out.print("Ingrese el código del alumno: ");
                                Scanner codigo_alumno = new Scanner(System.in);
                                Integer integer_codigo_alumno = codigo_alumno.nextInt();
                                for (Estudiante b: a.getStudents()){
                                    int codigo_a_evaluar= b.getCodigo_Estudiante();
                                    System.out.println(codigo_a_evaluar);
                                    if (codigo_a_evaluar==(integer_codigo_alumno)){
                                        System.out.println("El alumno ya existe con el código: "+integer_codigo_alumno);


                                    }else{
                                        System.out.print("Ingrese el nombre del alumno: ");
                                        Scanner nombre_alumno = new Scanner(System.in);
                                        String string_nombre_alumno = nombre_alumno.next();
                                        Estudiante newEstudiante = new Estudiante(string_nombre_alumno, integer_codigo_alumno);
                                        a.addStudent(newEstudiante);
                                        System.out.println("Se ha agregado al Alumno: \n" + b);
                                        System.out.println("El estado actual del nivel es : \n" + s);
                                    }

                                }
                            } else {
                                System.out.println("El grado que ingresó no existe");
                            }


                        }
                    } else {
                        System.out.println("El nivel especificado no existe.");

                    }
                }

            } else if (option==4) {
                System.out.print("Ingrese el nivel que desea visualizar");
                Scanner NOMBRE_NIVEL_VISUALIZAR = new Scanner(System.in);
                String STRING_NOMBRE_NIVEL_VISUALIZAR = NOMBRE_NIVEL_VISUALIZAR.next();
                for (Nivel s : Niveles) {
                    String nombre_a_verificar = s.getName();
                    if (nombre_a_verificar.equals(STRING_NOMBRE_NIVEL_VISUALIZAR)) {
                        System.out.println("Se muestra el sumario de los grados y sus respectivos Estudiantes: ");
                        System.out.println(s);
                    }else{
                        System.out.println("El nivel especificado no existe.");
                    }
                }





            }else if (option==5){
                for (Nivel s : Niveles) {
                    for (Grado a : s.getGrados()) {
                        System.out.print("Ingrese El grado del que quiere ver los alumnos: ");
                        Scanner NOMBRE_GRADO_A_BUSCAR = new Scanner(System.in);
                        String STRING_NOMBRE_GRADO_A_BUSCAR = NOMBRE_GRADO_A_BUSCAR.next();
                        String nombre_a_verificar = a.getName_Grado();
                        if (nombre_a_verificar.equals(STRING_NOMBRE_GRADO_A_BUSCAR)){
                            System.out.println(a.getStudents());
                        }else{
                            System.out.println("No existe el grado especificado");
                        }

                    }
                }

            }else if (option==6){
                wantsToContinue=false;
            }
        }while (wantsToContinue) ;
    }
}