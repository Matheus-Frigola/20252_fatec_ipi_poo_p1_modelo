package br.gov.sp.cps.fatecipiranga;
import java.util.Random;

public class Terrorista {
    private int energia;
    private String nome;
    private int quantidadeGranadas;
    private String armamento;

    private Random gerarNumero = new Random();

    public Terrorista(String nome, int energia, int quantidadeGranadas) {
        setNome(nome);
        setEnergia(energia);
        setQuantidadeGranadas(quantidadeGranadas);
        gerarArmamento();
    }

    // Getters
    public int getEnergia() {
        return energia;
    }

    public String getArmamento() {
        return armamento;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeGranadas() {
        return quantidadeGranadas;
    }

    // Setters (sempre travando entre limites)
    public void setEnergia(int energia) {
        if (energia < 0) {
            this.energia = 0;
        } else if (energia > 10) {
            this.energia = 10;
        } else {
            this.energia = energia;
        }
    }

    public void setNome(String nome) {
        this.nome = (nome != null && nome.length() >= 4) ? nome : "SemNome";
    }

    public void setQuantidadeGranadas(int quantidadeGranadas) {
        if (quantidadeGranadas < 0) {
            this.quantidadeGranadas = 0;
        } else if (quantidadeGranadas > 5) {
            this.quantidadeGranadas = 5;
        } else {
            this.quantidadeGranadas = quantidadeGranadas;
        }
    }

    // Sorteio de arma
    public void gerarArmamento() {
        int opcaoArmas = gerarNumero.nextInt(3);
        switch (opcaoArmas) {
            case 0:
                this.armamento = "Faca";
                break;
            case 1:
                this.armamento = "Pistola";
                break;
            case 2:
                this.armamento = "Fuzil";
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

    public void atacar() {
        System.out.println(nome + " atacou com " + armamento);
    }

    public void passarAVez() {
        System.out.println(nome + " passou a vez");
    }

    @Override
    public String toString() {
        return String.format("%s - Energia: %d, Granadas: %d, Arma: %s",
                nome, energia, quantidadeGranadas, armamento);
    }
}