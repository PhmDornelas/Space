package br.com.joaocarloslima;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Jogo {

    protected List<Asset> assets = new CopyOnWriteArrayList<>();
    protected Nave nave = new Nave(280, 400, 10, Direcao.DIREITA);
    private int pontos;
    private int nivel = 1;

    public Tiro atirar() {
        Tiro tiro = nave.atirar(nivel);
        assets.add(tiro);
        return tiro;
    }

    public Meteoro criarMeteoro() {
        int x = (int) (Math.random() * 590);
        Meteoro meteoro = new Meteoro(x, 0, 2, Direcao.BAIXO);
        assets.add(meteoro);
        return meteoro;
    }

    public void pontuar() {
        pontos++;
        nivel = pontos / 10 + 1;
        if (nivel > 4) nivel = 4;
    }

    public int getPontos() { return pontos; }
    public int getNivel() { return nivel; }
}
