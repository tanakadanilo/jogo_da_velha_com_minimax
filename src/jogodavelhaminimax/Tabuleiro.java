/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogodavelhaminimax;

/**
 *
 * @author tanak
 */
public class Tabuleiro {

    private final char[][] casas = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    private final char[] jogadores = new char[]{' ', 'X', 'O'};

    public Tabuleiro() {
    }

    public char[][] getCasas() {
        return casas;
    }

    public char marcar(int linha, int coluna, boolean isX) {
        if (casas[linha][coluna] != ' ') {//  * casa já ocupada
            throw new RuntimeException("A casa selecionada já está ocupada");
        }
        casas[linha][coluna] = (isX) ? jogadores[1] : jogadores[2];//   * marcando no tabuleiro
        return finalizou();//   * conferindo se finalizou o jogo
    }

    public char finalizou() {

        char ganhador = ganhouNaHorizontal();
        if (ganhador != ' ') {
            return ganhador;
        }
        ganhador = ganhouNaVertical();
        if (ganhador != ' ') {
            return ganhador;
        }
        ganhador = ganhouNaDiagonal();
        return ganhador;
    }

    public boolean deuVelha() {
        for (char[] linha : casas) {
            for (char casa : linha) {
                if (casa == ' ') {// * casa vazia
                    return false;
                }
            }
        }
        return true;
    }

    private char ganhouNaDiagonal() {
        if (casas[0][0] == casas[1][1] && casas[2][2] == casas[0][0] && casas[0][0] != ' ') {// * ganhou na diagonal, começando a superior esquerda
            return casas[0][0];
        }
        if (casas[2][0] == casas[1][1] && casas[0][2] == casas[2][0] && casas[2][0] != ' ') {// * ganhou na diagonal, começando a inferior esquerda
            return casas[0][0];
        }
        return ' ';//   * se chegou até aqui, então não houve ganhador
    }

    private char ganhouNaVertical() {
        for (int i = 0; i < casas.length; i++) {
            boolean acabouNaVertical = true;
            for (int j = 0; j < casas[i].length; j++) {//   * vendo se ganhou na vertical

                if (casas[j][i] == ' ') {// * casa vazia
                    acabouNaVertical = false;
                }
                if (casas[j][i] != casas[0][j]) {// * adversário bloqueou
                    acabouNaVertical = false;
                }
            }
            if (acabouNaVertical) {
                return casas[0][i];
            }
        }
        return ' ';
    }

    private char ganhouNaHorizontal() {
        for (int i = 0; i < casas.length; i++) {
            boolean acabouNaHorizontal = true;
            for (int j = 0; j < casas.length; j++) {
                //   * vendo se ganhou na horizontal
                if (casas[i][j] == ' ') {
                    // * casa vazia
                    acabouNaHorizontal = false;
                    break;
                }
                if (casas[i][j] != casas[i][0]) {
                    // * adversário bloqueou
                    acabouNaHorizontal = false;
                    break;
                }
            }
            if (acabouNaHorizontal) {
                return casas[i][0];
            }
        }
        return ' ';
    }
}
