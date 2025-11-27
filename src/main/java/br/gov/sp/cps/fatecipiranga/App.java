package br.gov.sp.cps.fatecipiranga;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Gerador aleatório de Inteiros
        Random gerarNumero = new Random();

        // Construtor Policial e Terrorista
        Terrorista terrorista = new Terrorista("Fred", 10, 5);
        Policial policial = new Policial("Irwin", 10, 5);

        boolean bombaPlantada = false;
        boolean bombaDesarmada = false;

        // Rodadas
        Scanner scanner = new Scanner(System.in);
        int contadorRodadas = 0;
        int rodadas = 0;
        boolean quantidadeInvalida = true;
        System.out.println("Quantas rodadas deseja jogar?");
        while (quantidadeInvalida == true) {
            rodadas = scanner.nextInt();
            if (rodadas > 20 || rodadas < 0 || rodadas % 2 == 0) {
                System.out.println("Quantidade inválida, insira um número impar de 1-20");
            }
            if (rodadas < 20 && rodadas > 0 && rodadas % 2 != 0)
                quantidadeInvalida = false;

        }
        System.out.println("Qual mapa você deseja jogar?\n1-Fatec Ipiranga\n2-Roma");
        int mapa = scanner.nextInt();
        while (mapa != 1 && mapa != 2) {
            System.out.println("Mapa inválido, insira 1 ou 2");
            mapa = scanner.nextInt();
        }

        // Loop do jogo
        while (true) {
            while (true) {
                var quemMovimenta = gerarNumero.nextInt(2);
                switch (quemMovimenta) {
                    case 0:
                        // Ações Policial
                        var acaoPolicial = gerarNumero.nextInt(4);
                        switch (acaoPolicial) {
                            case 0:
                                policial.desarmarBomba();
                                printMapa(mapa);
                                bombaDesarmada = true;
                                break;
                            case 1:
                                policial.lancarGranada();
                                printMapa(mapa);
                                terrorista.setEnergia(terrorista.getEnergia() - 4);
                                break;
                            case 2:
                                policial.atacar();
                                printMapa(mapa);
                                int dano = aplicarDano(policial.getArmamento());
                                terrorista.setEnergia(terrorista.getEnergia() - dano);
                                break;
                            case 3:
                                policial.setEnergia(policial.getEnergia() + gerarNumero.nextInt(2) + 1);
                                policial.passarAVez();
                                printMapa(mapa);
                                break;
                        }
                        System.out.println(policial);
                        System.out.println("+++++++++++++++++++++++++++++++++++++++");
                        Thread.sleep(2000);
                        break;
                    case 1:
                        // Ações Terrorista
                        var acaoTerrorista = gerarNumero.nextInt(4);
                        switch (acaoTerrorista) {
                            case 0:
                                terrorista.plantarBomba();
                                printMapa(mapa);
                                bombaPlantada = true;
                                break;
                            case 1:
                                terrorista.lancarGranada();
                                printMapa(mapa);
                                policial.setEnergia(policial.getEnergia() - 4);
                                break;
                            case 2:
                                terrorista.atacar();
                                printMapa(mapa);
                                int dano = aplicarDano(terrorista.getArmamento());
                                policial.setEnergia(policial.getEnergia() - dano);
                                break;
                            case 3:
                                terrorista.setEnergia(terrorista.getEnergia() + gerarNumero.nextInt(2) + 1);
                                terrorista.passarAVez();
                                printMapa(mapa);
                                break;
                        }
                        System.out.println(terrorista);
                        System.out.println("+++++++++++++++++++++++++++++++++++++++");
                        Thread.sleep(2000);
                        break;
                }

                // FIM DE RODADA
                // Bomba plantada (terrorista vence) ou desarmada (policial vence)
                if (bombaPlantada == true)
                    break;
                // Um dos personagens sem energia
                if (terrorista.getEnergia() <= 0 || policial.getEnergia() <= 0)
                    break;
            }

            // Exibir resultado da rodada
            if (bombaPlantada == true && bombaDesarmada == false) {
                System.out.println("\n*** TERRORISTA VENCEU - Bomba plantada! ***");
            } else if (bombaDesarmada == true && bombaPlantada == true) {
                System.out.println("\n*** POLICIAL VENCEU - Bomba desarmada! ***");
            } else if (terrorista.getEnergia() <= 0) {
                System.out.println("\n*** POLICIAL VENCEU - Terrorista eliminado! ***");
            } else if (policial.getEnergia() <= 0) {
                System.out.println("\n*** TERRORISTA VENCEU - Policial eliminado! ***");
            }

            System.out
                    .println("\n>--------------<\nFim de Rodada\n>--------------<\n\n");
            contadorRodadas++;

            // Resetar estado para próxima rodada
            bombaDesarmada = false;
            bombaPlantada = false;
            terrorista.setEnergia(10);
            policial.setEnergia(10);
            terrorista.setQuantidadeGranadas(5);
            policial.setQuantidadeGranadas(5);
            terrorista.gerarArmamento();
            policial.gerarArmamento();

            // FIM DE PARTIDA
            if (contadorRodadas >= rodadas) {
                System.out.println(
                        "\n>--------------<\nFim de Partida\n>--------------<\n");
                break;
            }

        }
    }

    static int aplicarDano(String arma) {
        int dano = 0;

        if (arma.equalsIgnoreCase("Faca"))
            dano = 1;
        if (arma.equalsIgnoreCase("Pistola"))
            dano = 2;
        if (arma.equalsIgnoreCase("Fuzil"))
            dano = 3;

        return dano;
    }

    static void printMapa(int mapa) {
        switch (mapa) {
            case 1:
                System.out.println("no mapa Fatec Ipiranga");
                break;
            case 2:
                System.out.println("no mapa Roma");
                break;
        }
    }
}
