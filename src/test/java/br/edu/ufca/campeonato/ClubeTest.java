package br.edu.ufca.campeonato;

import br.edu.ufca.campeonato.entidades.Clube;

import org.junit.jupiter.api.BeforeEach;

public class ClubeTest {
    private static Clube clube;

    @BeforeEach
    void setUp() {
        clube = new Clube("Clube A");
    }
}
