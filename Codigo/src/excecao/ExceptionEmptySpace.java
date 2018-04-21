/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecao;

/**
 *
 * @author SABRINA
 */
public class ExceptionEmptySpace extends RuntimeException {

    public ExceptionEmptySpace(String message) {
        super(message);
    }
    public static void informaDado(String nome) {
        while (nome == null || nome.startsWith(" ") || nome.equals("")) {
            throw new ExceptionEmptySpace("Não foi inserida nenhuma informação!");
        }
    }
}
