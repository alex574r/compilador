package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class LexicalAnalyzer {
    private String input;
    private List<Token> tokens;

    public LexicalAnalyzer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
    }

    public List<Token> analyze() {
        // Definir el patrón de palabras clave actualizado
        Pattern palabraR = Pattern.compile("\\b(while|print|if|else)\\b");
        Pattern text = Pattern.compile("^\\\"[\\w | ]*\\\"");
        //Pattern text = Pattern.compile("\\b\\w*\\b");
        Pattern identifierPattern = Pattern.compile("\\b[a-zA-Z_]\\w*\\b");
        Pattern numberPattern = Pattern.compile("\\b\\d+\\b");
        Pattern operatorPattern = Pattern.compile("[+\\-*/]");

        // Crear un matcher para cada patrón
        Matcher matcher;

        // Analizar la entrada
        while (!input.isEmpty()) {
            // Ignorar espacios en blanco
           input = input.trim();

            
            
            // Coincidir con palabras clave
            matcher = palabraR.matcher(input);
            if (matcher.find()) {
                tokens.add(new Token(TokenType.WordReservate, matcher.group()));
                input = input.substring(matcher.end());
                continue;
            }
           
             // Coincidir con texto
            matcher = text.matcher(input);
            if (matcher.find()) {
                tokens.add(new Token(TokenType.text, matcher.group()));
                input = input.substring(matcher.end());
                continue;
            }
            
             // Coincidir con identificadores
            matcher = identifierPattern.matcher(input);
            if (matcher.find()) {
                tokens.add(new Token(TokenType.IDENTIFIER, matcher.group()));
                input = input.substring(matcher.end());
                continue;
            }
           

            // Coincidir con números
            matcher = numberPattern.matcher(input);
            if (matcher.find()) {
                tokens.add(new Token(TokenType.NUMBER, matcher.group()));
                input = input.substring(matcher.end());
                continue;
            }
            // Coincidir con operadores
            matcher = operatorPattern.matcher(input);
            if (matcher.find()) {
                tokens.add(new Token(TokenType.OPERATOR, matcher.group()));
                input = input.substring(matcher.end());
                continue;
            }


            // Si no se encuentra un token válido, lanzar una excepción
            JOptionPane.showMessageDialog(null, "No se encontro: " + input);
            throw new IllegalArgumentException("Invalid input: " + input);
        }

        return tokens;
    }
}
