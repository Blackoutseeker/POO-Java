package br.edu.ufca.campeonato;

import static br.edu.ufca.campeonato.utils.Constantes.NOMES_DE_CLUBES;
import static br.edu.ufca.campeonato.utils.Gerador.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeradorTest {
    final int quantidadeDeNomes = NOMES_DE_CLUBES.length;

    private boolean checarSeNomeDoClubeEstaListado(String nomeDoClube) {
        boolean estaListado = Arrays.stream(NOMES_DE_CLUBES).toList().contains(nomeDoClube);
        if (!estaListado) {
            // Para facilitar a depuração do teste, um erro será lançado apresentando o nome do clube
            throw new RuntimeException(nomeDoClube + " não está listado como um clube");
        }
        return true;
    }

    @Test
    void testGerarNomeAleatorio() {
        assertThrows(RuntimeException.class, () -> checarSeNomeDoClubeEstaListado("Sport Club"));
        for (int indice = 0; indice < 50; indice++) {
            final String nomeAleatorio = gerarNomeAleatorio();
            assertTrue(checarSeNomeDoClubeEstaListado(nomeAleatorio));
        }
    }
}
