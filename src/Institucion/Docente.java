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
public class Docente extends Funcionario {

    public Docente(String nombre, String rut, int edad, float sueldo, int code_asig) {
        super(nombre, rut, edad, sueldo);
        this.setCode_asig(code_asig);
        // TODO Auto-generated constructor stub
    }
}
