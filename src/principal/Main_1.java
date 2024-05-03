package principal;


import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Main_1 {
    public static void main(String[] args) {
        String input = "if x == 5: print('Hello, world";
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(input);
        List<Token> tokens = lexicalAnalyzer.analyze();
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
