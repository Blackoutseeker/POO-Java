package br.edu.ufca.campeonato.entidades;

import java.util.List;

public class Campeonato {
    public List<Clube> clubes;

    public Campeonato(List<Clube> clubes) {
        if (clubes.size() < 2) {
            throw new IllegalArgumentException("A lista de clubes deve conter no mínimo 2 clubes");
        }
        this.clubes = clubes;
    }
}
