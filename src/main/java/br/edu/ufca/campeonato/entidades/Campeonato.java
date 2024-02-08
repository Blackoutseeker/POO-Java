package br.edu.ufca.campeonato.entidades;

import java.util.List;

import static br.edu.ufca.campeonato.utils.Gerador.*;

public class Campeonato {
    public List<Clube> clubes;

    public Campeonato(List<Clube> clubes) {
        if (clubes.size() < 2) {
            throw new IllegalArgumentException("A lista de clubes deve conter no mínimo 2 clubes");
        }
        this.clubes = clubes;
    }

    /**
     * Dois placares serão gerados dentro do intervalo [0, 5], "placarM" e "placarV".
     * @param m Clube que irá receber o placarM, e irá jogar contra o clube V.
     * @param v Clube que irá receber o placarV, e irá jogar contra o clube M.
     */
    private void jogarPartida(Clube m, Clube v) {
        final int placarM = gerarPlacarAleatorio();
        final int placarV = gerarPlacarAleatorio();
        if (placarM > placarV) {
            m.ganhar(placarM);
            v.perder(placarV);
            return;
        }
        else if (placarM < placarV) {
            m.perder(placarM);
            v.ganhar(placarV);
            return;
        }
        m.empatar();
        v.empatar();
    }
}
