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
public class VALIDADOR {

    public boolean ValidaRut(String cadena) {
        int suma = 0;
        int digito;
        String cadena2 = "";
        String guion = "-";
        char com;
        char ver = 'v';
        boolean valida = false;
        int n = cadena.length();
        if (cadena.substring(n - 2, n - 1).equals(guion)) {
            cadena2 = cadena.substring(0, n - 2);
            String x = cadena.substring(n - 1, n);
            ver = x.charAt(0);
        } else {
            return false;
        }
        int rut = Integer.parseInt(cadena2);
        for (int i = 2; rut > 0; i++) {
            digito = rut % 10;
            rut /= 10;
            suma += digito * i;
            if (i >= 7) {
                i = 1;
            }
        }
        int resto = suma % 11;
        int resultado = 11 - resto;
        if (resultado < 10) {
            com = Character.forDigit(resultado, 10);
        } else if (resultado == 10) {
            com = 'k';
        } else {
            com = '0';
        }
        if (ver != 'v' && ver != com) {
            valida = false;
        } else if (ver != 'v') {
            valida = true;
        }
        return valida;
    }

    public boolean validaNombre(String nombre) {
        String N = "0123456789";
        int control = 0;
        for (int i = 1; i <= nombre.length(); i++) {
            for (int j = 1; j <= 10; j++) {
                if (nombre.substring((i - 1), i).equals(N.substring((j - 1), j))) {
                    control = 1;
                }
            }

        }
        if (control == 0) {
            if (nombre.length() < 3) {
                return false;
            } else {
                if (nombre.length() < 35) {
                    return true;
                } else {
                    return false;
                }

            }
        } else {
            return false;
        }

    }

    public boolean validaEdad(int edad) {
        if (edad < 18 || edad > 90) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaEdad(int edad, int tipo) {
        if (edad < 4 || edad > 100) {
            return false;
        } else {
            return true;
        }
    }
}
