/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import javax.swing.JPanel;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author Matheus Montanha
 */
public class CursorPersonalizado extends JPanel {

    public Cursor blockedCursor() {
        String pasta = System.getProperty("user.dir");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image imagem = tk.getImage(pasta + "/src/Imagens/blockedCursor.jpg");
        Cursor cursor = tk.createCustomCursor(imagem, new Point(0, 25), "Block");
        return cursor;
    }
}
