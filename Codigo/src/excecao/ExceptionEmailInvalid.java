/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecao;

/**
 *
 * @author Matheus Montanha
 */
public class ExceptionEmailInvalid extends RuntimeException {

    public ExceptionEmailInvalid(String message) {
        super(message);
    }

    public static String informaEmail(String email) {
        if ((email.contains("@")) && (email.contains(".")) && (!email.contains(" "))) {

            String usuario = new String(email.substring(0, email.lastIndexOf('@')));
            String dominio = new String(email.substring(email.lastIndexOf('@') + 1, email.length()));

            if ((usuario.length() >= 1) && (!usuario.contains("@"))
                    && (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".")
                    >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {
                return email = "E-mail válido";
            } else {
                return email = "E-mail Inválido";
            }
        } else {
            return email = "E-mail Inválido";
        }
    }
}
