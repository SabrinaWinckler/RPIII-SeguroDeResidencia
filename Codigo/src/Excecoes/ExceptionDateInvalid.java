/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecoes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Matheus Montanha
 */
public class ExceptionDateInvalid {

    public static Date isValido(String datas) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = df.parse(datas);
        return today;
    }
}
