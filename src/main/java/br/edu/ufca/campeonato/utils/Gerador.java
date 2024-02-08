package br.edu.ufca.campeonato.utils;

import java.util.Random;

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
}
