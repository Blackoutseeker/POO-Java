package br.edu.ufca.campeonato;

import br.edu.ufca.campeonato.entidades.Clube;
import br.edu.ufca.campeonato.entidades.Campeonato;
import static br.edu.ufca.campeonato.utils.Constantes.NOMES_DE_CLUBES;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CampeonatoTest {
    static private Campeonato campeonato;
    static private final Clube clubeComMaiorPontuacao = new Clube("Clube A");
    static private final Clube clubeComMenorPontuacao = new Clube("Clube B");

    @BeforeAll
    static void setUp() {
        final List<Clube> clubes = new ArrayList<>();
        clubeComMaiorPontuacao.pontos = 99;
        clubeComMaiorPontuacao.saldoGols = 99;

        clubeComMenorPontuacao.pontos = -99;
        clubeComMenorPontuacao.saldoGols = -99;

        for (int indice = 0; indice < NOMES_DE_CLUBES.length; indice++) {
            final String nome = NOMES_DE_CLUBES[indice];
            final Clube clube = new Clube(nome);
            if (indice == 4) {
                clubes.add(clubeComMaiorPontuacao);
                continue;
            }
            else if (indice == 10) {
                clubes.add(clubeComMenorPontuacao);
                continue;
            }
            clubes.add(clube);
        }
        campeonato = new Campeonato(clubes);
        campeonato.jogarCampeonato();
        campeonato.getClassificacao();
    }

    @Test
    void testCriacaoDeInstancia() {
        final List<Clube> listaVazia = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> new Campeonato(listaVazia));
    }

    @Test
    void testOrdenacaoDaClassificacao() {
        final int indiceDoUltimoClube = NOMES_DE_CLUBES.length - 1;
        // O primeiro clube classificado deve ser o "Clube A"
        assertEquals("Clube A", campeonato.clubes.get(0).nome);
        // O último clube classificado deve ser o "Clube B"
        assertEquals("Clube B", campeonato.clubes.get(indiceDoUltimoClube).nome);
    }
}
