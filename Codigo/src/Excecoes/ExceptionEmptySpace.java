/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecoes;

/**
 *
 * @author SABRINA
 */
public class ExceptionEmptySpace {

    public static void informaDado(String nome) throws NullPointerException {
        while (nome == null || nome.startsWith(" ") || nome.equals("")) {
            throw new NullPointerException("Não foi inserida nenhuma informação!");
        }
    }

}
