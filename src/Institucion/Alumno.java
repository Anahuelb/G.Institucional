/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institucion;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author ANAHUEL
 */
public class Alumno extends MiembroInstitucion {

    int CodCarrera;

    public Alumno(String nombre, String rut, int edad, int CodCarrera) {
        super(nombre, rut, edad);
        this.CodCarrera = CodCarrera;
        System.out.println("Alumno numero creado");
    }

    @Override
    public ArrayList Mostrar(ArrayList x) {
        x.add("Codigo Miembro Institucional =" + getMiCodigo());
        x.add("Nombre = " + getNombre());
        x.add("R.U.T  = " + getRut());
        x.add("Edad   = " + getEdad());
        x.add("Codigo Carrera = " + this.CodCarrera);
        x.add("******************************");
        return x;
    }

    @Override
    public File Escribir(File f) {
        try {
            String textoAnterior = obtieneContenidoArchivo(f);
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.print(textoAnterior);
            wr.println("Codigo Miembro Institucional =" + getMiCodigo());
            wr.println("Nombre = " + getNombre());
            wr.println("R.U.T  = " + getRut());
            wr.println("Edad   = " + getEdad());
            wr.println("Codigo Carrera = " + this.CodCarrera);
            wr.println("**************************");
            wr.close();
            bw.close();
        } catch (IOException e) {
        };
        return f;
    }
}
