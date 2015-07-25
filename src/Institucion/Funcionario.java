/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institucion;

/**
 *
 * @author ANAHUEL
 */
public class Funcionario extends MiembroInstitucion {

    public Funcionario(String nombre, String rut, int edad, float sueldo) {
        super(nombre, rut, edad);
        this.sueldo = sueldo;
        code++;//al crear cualquier tipo de funcionario crea un codigo
        System.out.println("Funcionario Creado Code=" + code);
    }
    float sueldo;
    static private int code;//este codigo nos da la posicion del funcionario que creemos al ser static es para todas las clases hijas.

    public void eliminar_fun() {
        code--;
    }

    public float getSueldo() {
        return this.sueldo;
    }

}
