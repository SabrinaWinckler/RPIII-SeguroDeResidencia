/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecoes;

import java.text.ParseException;

/**
 *
 * @author Matheus Montanha
 */
public class ExceptionTiposCampos {

    public String camposString(String texto) {
        if (texto.contains("^[0-9]*$")) {
            return texto;
        } else {
            return null;
        }
    }

    public Double camposDouble(String numero) throws ParseException {
        double numeroReal = Double.parseDouble(numero);
        return numeroReal;
    }
}
