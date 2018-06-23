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
public class ExceptionNaoPossuiSeguro extends Exception {
    public ExceptionNaoPossuiSeguro(String message) {
        super(message);
    }
    public static void informaResidencia(String nome) {
        while (nome == null || nome.startsWith(" ") || nome.equals("")) {
            throw new ExceptionEmptySpace("Não foi inserida nenhuma informação!");
        }
    }
}
