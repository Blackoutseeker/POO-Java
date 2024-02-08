package br.edu.ufca.campeonato;

import br.edu.ufca.campeonato.entidades.Clube;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClubeTest {
    private static Clube clube;

    @BeforeEach
    void setUp() {
        clube = new Clube("Clube A");
    }

    @Test
    void testCriacaoDeInstancia() {
        assertThrows(IllegalArgumentException.class, () -> new Clube(" "));
    }

    @Test
    void testGanhar() {
        final int golsFeitos = 2;
        clube.ganhar(golsFeitos);
        assertEquals(3, clube.pontos);
        assertEquals(golsFeitos, clube.saldoGols);
    }

    @Test
    void testEmpatar() {
        clube.empatar();
        assertEquals(1, clube.pontos);
        assertEquals(0, clube.saldoGols);
    }

    @Test
    void testPerder() {
        final int golsSofridos = 4;
        clube.perder(golsSofridos);
        assertEquals(0, clube.pontos);
        assertEquals(-(golsSofridos), clube.saldoGols);
    }
}
