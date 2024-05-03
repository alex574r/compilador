/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class KeywordHighlighter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Keyword Highlighter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextPane textPane = new JTextPane();
            JScrollPane scrollPane = new JScrollPane(textPane);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setSize(400, 300);
            frame.setVisible(true);

            highlightKeywords(textPane);
        });
    }

    public static void highlightKeywords(JTextPane textPane) {
        // Definir el estilo para las palabras clave
        Style keywordStyle = textPane.addStyle("Keyword", null);
        StyleConstants.setForeground(keywordStyle, Color.BLUE);

        // Obtener el kit de estilo de documento para el textPane
        StyledDocument doc = textPane.getStyledDocument();
        String text = textPane.getText();
        int start = 0;

        // Iterar sobre el texto para encontrar y resaltar las palabras clave
        while (start < text.length()) {
            int startIndex = text.indexOf("if", start);
            int endIndex = startIndex + 2; // La longitud de "if" es 2

            if (startIndex != -1) {
                // Aplicar el estilo a la palabra clave "if"
                doc.setCharacterAttributes(startIndex, endIndex - startIndex, keywordStyle, false);
                start = endIndex;
            } else {
                break;
            }
        }
    }
}
