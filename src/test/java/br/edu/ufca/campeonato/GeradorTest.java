package br.edu.ufca.campeonato;

import static br.edu.ufca.campeonato.utils.Constantes.NOMES_DE_CLUBES;
import static br.edu.ufca.campeonato.utils.Gerador.*;
import br.edu.ufca.campeonato.entidades.Clube;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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

    @Test
    void testGerarPlacarAleatorio() {
        for (int indice = 0; indice < 50; indice++) {
            final int placarAleatorio = gerarPlacarAleatorio();
            final boolean estaDentroDoIntervalo = placarAleatorio >= 0 && placarAleatorio <= 5;
            assertTrue(estaDentroDoIntervalo);
        }
    }

    @Test
    void testGerarDesempate() {
        final List<Clube> clubes = new ArrayList<>();
        final Clube clubeA = new Clube("Clube A");
        final Clube clubeB = new Clube("Clube B");
        final Clube clubeC = new Clube("Clube C");

        clubeA.pontos = 5;
        clubeB.pontos = 2;
        clubeC.pontos = 5;

        clubeA.saldoGols = 1;
        clubeB.saldoGols = 10;
        clubeC.saldoGols = 4;

        // O "Clube C" deve ser o primeiro, e o "Clube B" o último

        gerarDesempate(clubes);

        for (int indice = 0; indice < clubes.size(); indice++) {
            final Clube clube = clubes.get(indice);
            if (indice == 1) {
                // Verifica se o "Clube C" está em primeiro
                assertEquals(5, clube.pontos);
                assertEquals(4, clube.saldoGols);
            }
            if (indice == (clubes.size() - 1)) {
                // Verifica se o "Clube B" está em último
                assertEquals(2, clube.pontos);
                assertEquals(10, clube.saldoGols);
            }
        }
    }
}
