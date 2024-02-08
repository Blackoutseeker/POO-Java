package br.edu.ufca.campeonato;

import static br.edu.ufca.campeonato.utils.Constantes.NOMES_DE_CLUBES;
import static br.edu.ufca.campeonato.utils.Gerador.*;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void testGerarListaDeNomesAleatorios() {
        // Deve lançar um erro ao receber uma quantidade de zero nomes
        assertThrows(IndexOutOfBoundsException.class, () -> gerarListaDeNomesAleatorios(0));

        // Deve lançar um erro ao receber uma quantidade
        // superior ao número de nomes do array de strings "NOMES_DE_CLUBES"
        assertThrows(IndexOutOfBoundsException.class, () -> gerarListaDeNomesAleatorios(quantidadeDeNomes + 1));

        // Verifica se a lista gerada possui a mesma quantidade de nomes passados via argumento
        assertEquals(5, gerarListaDeNomesAleatorios(5).size());

        final List<String> nomesAleatorios = gerarListaDeNomesAleatorios(quantidadeDeNomes);
        for (final String clubeAleatorio: nomesAleatorios) {
            // Checa se cada nome aleatório está incluso no array de strings "NOMES_DE_CLUBES"
            assertTrue(checarSeNomeDoClubeEstaListado(clubeAleatorio));
        }
    }
}
