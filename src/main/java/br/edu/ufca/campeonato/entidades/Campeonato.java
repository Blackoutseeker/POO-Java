package br.edu.ufca.campeonato.entidades;

import java.util.List;

import static br.edu.ufca.campeonato.utils.Gerador.*;
import static br.edu.ufca.campeonato.utils.Constantes.VISUALIZAR_PARTIDAS;

public class Campeonato {
    public List<Clube> clubes;

    public Campeonato(List<Clube> clubes) {
        if (clubes.size() < 2) {
            throw new IllegalArgumentException("A lista de clubes deve conter no mínimo 2 clubes");
        }
        this.clubes = clubes;
    }

    /**
     * Irá fazer uma iteração de ida e volta entre os clubes,
     * fazendo com que joguem duas partidas com resultados distintos.
     * Clubes com o mesmo nome não irão disputar entre si, obviamente.
     * <p>
     * OBS: é possível visualizar cada partida caso a constante "VISUALIZAR_PARTIDAS"
     * esteja com o valor "true".
     */
    public void jogarCampeonato() {
        for (int indice = 0; indice < clubes.size(); indice++) {
            final Clube clubeM = clubes.get(indice);
            for (Clube clubeV : clubes) {
                final boolean saoClubesDiferentes = !clubeM.nome.equals(clubeV.nome);
                if (saoClubesDiferentes) {
                    jogarPartida(clubeM, clubeV);
                    if (VISUALIZAR_PARTIDAS) {
                        System.out.println("\n" + clubeM.nome + " x " + clubeV.nome);
                        System.out.println("Pontos: " + clubeM.pontos + " x " + clubeV.pontos);
                        System.out.println("Saldo de gols: " + clubeM.saldoGols + " x " + clubeV.saldoGols);
                    }
                }
            }
        }
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

    /**
     * @return A classificação do campeonato, ordenando os times por nome, pontos e saldo de gols.
     */
    public String getClassificacao() {
        gerarDesempate(clubes);
        final StringBuilder classificacao = new StringBuilder();
        for (final Clube clube : clubes) {
            classificacao.append(clube.nome)
                    .append("\n").append("- pontos: ").append(clube.pontos)
                    .append("\n").append("- saldo de gols: ").append(clube.saldoGols)
                    .append("\n\n");
        }
        return classificacao.toString();
    }

    /**
     * @return O clube com maior pontuação e saldo de gols do campeonato.
     */
    public Clube getCampeao() {
        return clubes.get(0);
    }
}
