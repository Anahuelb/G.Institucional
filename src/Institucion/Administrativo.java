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
public class Administrativo extends Funcionario {

    public Administrativo(String nombre, String rut, int edad, float sueldo) {
        super(nombre, rut, edad, sueldo);
        // si hay formula para el sueldo se llena aca
    }

    @Override
    public ArrayList Mostrar(ArrayList x) {
        x.add("Codigo Miembro Institucional =" + getMiCodigo());
        x.add("Nombre = " + getNombre());
        x.add("R.U.T  = " + getRut());
        x.add("Edad   = " + getEdad());
        x.add("Sueldo = " + getSueldo());
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
            wr.println("Nombre=" + getNombre());
            wr.println("R.U.T  = " + getRut());
            wr.println("Edad   = " + getEdad());
            wr.println("Sueldo = " + getSueldo());
            wr.println("**************************");
            wr.close();
            bw.close();
        } catch (IOException e) {
        };
        return f;
    }

}
