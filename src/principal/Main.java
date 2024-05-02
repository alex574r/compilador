/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTextArea textArea = new JTextArea(10, 30);

        // Crea un menú emergente
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Hola");
        popupMenu.add(menuItem);

        // Agrega un KeyListener al JTextArea
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Verifica si se presionó Ctrl + Espacio
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_SPACE) {
                    // Muestra el menú emergente en la posición del cursor
                    popupMenu.show(textArea, textArea.getCaret().getMagicCaretPosition().x, textArea.getCaret().getMagicCaretPosition().y);
                }
            }
        });

        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
