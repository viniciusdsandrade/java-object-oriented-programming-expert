package src.z_listas.recursao;

import static src.z_listas.recursao.Q1.isNegative;

public class Q2 {
    /*
    Daqui para cima, é admissível fazer uma função auxiliar com o único propósito de auxiliar; daqui para baixo, só se pode usar como auxiliar outra função pedida nesta lista de exercícios.
    2. Faça uma ÚNICA função que, recebendo como parâmetro dois números inteiros, resulta a soma deles.
    Importante lembrar que os números com os quais vocês trabalharão são inteiros, logo, podem ser positivos ou negativos
    Fica proibido declarar variáveis, fazer uso de
        1 - operadores aritméticos (+, -, *, / e %),
        2 - dos operadores relacionais (!=, <, <=, > e >=),
        3 - de operadores lógicos (!, && e ||),
        4 - dos comandos de seleção (if com else e switch),
        5 - de comandos repetitivos (while, do-while e for),
        6 - try-catch e de
        7 - qualquer função de biblioteca ou de sua própria autoria
        Observação: fica liberado o uso de funções auxiliares que seguem as mesmas regras aqui impostas e o uso de funções implementadas nesta lista de exercícios em outras funções da mesma lista de exercícios).

    Dica: use ++, --, ==, if sem else, return, recursão.
    Faça um programa para testar sua função.
     */

    public static void main(String[] args) {
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                String iStr = Q1.isNegative(i) ? Integer.toString(i) : "+" + i;
                String jStr = Q1.isNegative(j) ? Integer.toString(j) : "+" + j;

                System.out.println(iStr + " " + jStr + " = " + soma(i, j));
            }
        }
    }

    public static int soma(int a, int b) {
        if (b == 0) return a;
        if (isNegative(b))
            return soma(--a, ++b);
        return soma(++a, --b);
    }
}
