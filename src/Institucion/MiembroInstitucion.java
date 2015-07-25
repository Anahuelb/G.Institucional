package Institucion;

import java.io.*;
import java.util.ArrayList;

/**
 * @author ANAHUEL
 */
public class MiembroInstitucion {

    public MiembroInstitucion(String nombre, String rut, int edad) {
        super();
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        CodigoMiembro++;
        MiCodigo = CodigoMiembro;
    }
    static int CodigoMiembro = 0;

    public int getMiCodigo() {
        return MiCodigo;
    }
    private int MiCodigo;

    private String nombre, rut;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList Mostrar(ArrayList x) {
        System.out.println("Holi");
        //para ser reescrito
        return x;
    }

    public int getCode_asig() {
        return code_asig;
    }

    public void setCode_asig(int code_asig) {
        this.code_asig = code_asig;
    }
    private int code_asig;

    public File Escribir(File f) {
        //reescribible obligatoriamente xD
        return f;
    }

    /**
     * Busca todo el contenido entero de un texto y lo regresa en un Strin.
     */
    static public String obtieneContenidoArchivo(File archivo) {

        StringBuilder contenido = new StringBuilder();

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            try {
                String linea = null;
                while ((linea = entrada.readLine()) != null) {
                    contenido.append(linea);
                    contenido.append(System.getProperty("line.separator"));
                }
            } finally {
                entrada.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return contenido.toString();
    }
}
