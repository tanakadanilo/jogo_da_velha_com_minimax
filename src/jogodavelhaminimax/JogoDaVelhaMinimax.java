/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogodavelhaminimax;

/**
 *
 * @author tanak
 */
public class JogoDaVelhaMinimax {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.marcar(0, 0, true);
        tabuleiro.marcar(1, 0, true);
        tabuleiro.marcar(2, 0, true);
        mostraTabuleiro(tabuleiro);
    }

    private static void mostraTabuleiro(Tabuleiro tabuleiro) {

        char[][] casas = tabuleiro.getCasas();
        for (char[] linha : casas) {
            for (int i = 0; i < linha.length - 1; i++) {
                System.out.print(linha[i] + "|");
            }
            System.out.println("\n___");
        }
    }
}
