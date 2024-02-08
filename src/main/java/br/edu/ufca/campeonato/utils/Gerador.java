package br.edu.ufca.campeonato.utils;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import br.edu.ufca.campeonato.entidades.Clube;

public class Gerador {
    private static final int QUANTIDADE_DE_NOMES_DE_CLUBES = Constantes.NOMES_DE_CLUBES.length;
    private static final Random random = new Random();

    /**
     * @return Um nome aleatório do array de strings "NOMES_DE_CLUBES".
     */
    public static String gerarNomeAleatorio() {
        final int indiceAleatorio = random.nextInt(QUANTIDADE_DE_NOMES_DE_CLUBES);
        return Constantes.NOMES_DE_CLUBES[indiceAleatorio];
    }

    /**
     * @param quantidade O número desejado de nomes aleatórios.
     *                   Ele deve ser maior que 1, e menor que a
     *                   quantidade de nomes dentro do array de strings "NOMES_DE_CLUBES".
     * @return Uma lista de nomes aleatórios retirados do array de strings "NOMES_DE_CLUBES".
     * @throws IndexOutOfBoundsException caso a quantidade não esteja dentro do intervalo definido.
     */
    public static List<String> gerarListaDeNomesAleatorios(int quantidade) {
        if (quantidade > QUANTIDADE_DE_NOMES_DE_CLUBES || quantidade < 1) {
            throw new IndexOutOfBoundsException("A quantidade deve estar no intervalo [1, "
                    + QUANTIDADE_DE_NOMES_DE_CLUBES + "]");
        }

        List<String> nomes = new ArrayList<>();
        for (int indice = 0; indice < quantidade; indice++) {
                while (nomes.size() < quantidade) {
                final String nomeAleatorio = gerarNomeAleatorio();
                if (!nomes.contains(nomeAleatorio)) {
                    nomes.add(nomeAleatorio);
                }
            }
        }
        return nomes;
    }

    /**
     * @return Um número aleatório dentro do intervalo [0, 5].
     */
    public static int gerarPlacarAleatorio() {
        return random.nextInt(6);
    }

    /** O desempate entre clubes é feito através de suas pontuações, e em casos de pontuações iguais,
     * seus saldos de gols serão comparados para efetivar o desempate.
     * @param clubes A lista de clubes que será ordenada conforme as regras de desempate.
     */
    public static void gerarDesempate(List<Clube> clubes) {
         clubes.sort(Comparator.comparingInt((Clube clube) -> clube.pontos)
                 .thenComparingInt(clube -> clube.saldoGols)
                 .reversed());
    }
}
