package br.gov.sp.cps.fatecipiranga;

import java.util.Random;

public class Terrorista {
    private int energia;
    private String nome;
    private int quantidadeGranadas;

    // Armas do terrorista
    private Faca faca = new Faca();
    private Pistola pistola = new Pistola();
    private Fuzil fuzil = new Fuzil();
    private Object armaAtual; // pode ser Faca, Pistola ou Fuzil

    private Random gerarNumero = new Random();

    public Terrorista(String nome, int energia, int quantidadeGranadas) {
        setNome(nome);
        setEnergia(energia);
        setQuantidadeGranadas(quantidadeGranadas);
        gerarArmamento(); // arma inicial
    }

    // Getters
    public int getEnergia() {
        return energia;
    }

    public String getArmamento() {
        if (armaAtual instanceof Faca) return "Faca";
        if (armaAtual instanceof Pistola) return "Pistola";
        if (armaAtual instanceof Fuzil) return "Fuzil";
        return "Desarmado";
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeGranadas() {
        return quantidadeGranadas;
    }

    // Setters (travados entre limites)
    public void setEnergia(int energia) {
        if (energia < 0) this.energia = 0;
        else if (energia > 10) this.energia = 10;
        else this.energia = energia;
    }

    public void setNome(String nome) {
        this.nome = (nome != null && nome.length() >= 4) ? nome : "SemNome";
    }

    public void setQuantidadeGranadas(int quantidadeGranadas) {
        if (quantidadeGranadas < 0) this.quantidadeGranadas = 0;
        else if (quantidadeGranadas > 5) this.quantidadeGranadas = 5;
        else this.quantidadeGranadas = quantidadeGranadas;
    }

    // Escolhe arma aleatoriamente
    public void gerarArmamento() {
        int opcaoArmas = gerarNumero.nextInt(3);

        switch (opcaoArmas) {
            case 0:
                armaAtual = faca;
                break;
            case 1:
                armaAtual = pistola;
                break;
            case 2:
                armaAtual = fuzil;
                break;
        }
    }

    // Comportamentos
    public void plantarBomba() {
        System.out.println(nome + " plantando bomba");
    }

    public void lancarGranada() {
        if (quantidadeGranadas > 0) {
            quantidadeGranadas--;
            System.out.println(nome + " lançou granada (restam " + quantidadeGranadas + ")");
        } else {
            System.out.println(nome + " tentou lançar granada, mas não tem");
        }
    }

    // ****** ATAQUE COM DANO REAL ******
    public int atacar() {
        gerarArmamento(); // escolhe arma aleatória

        int dano = 0;
        String armaTexto = getArmamento();

        if (armaAtual instanceof Faca) dano = ((Faca) armaAtual).atacar();
        if (armaAtual instanceof Pistola) dano = ((Pistola) armaAtual).atacar();
        if (armaAtual instanceof Fuzil) dano = ((Fuzil) armaAtual).atacar();

        System.out.println(nome + " atacou com " + armaTexto + " causando " + dano + " de dano");
        return dano;
    }

    public void passarAVez() {
        System.out.println(nome + " passou a vez");
    }

    @Override
    public String toString() {
        return String.format("%s - Energia: %d, Granadas: %d, Arma: %s",
                nome, energia, quantidadeGranadas, getArmamento());
    }
}
