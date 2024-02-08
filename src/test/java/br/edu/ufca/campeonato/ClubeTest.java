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
}
