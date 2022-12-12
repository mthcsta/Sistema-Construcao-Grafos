package Opcoes;

import Helpers.GrafoHelper;
import util.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MenorRota implements Opcao {
    private String titulo = "Menor Rota";
    private Scanner input = new Scanner(System.in);
    private Grafo grafo;
    private GrafoHelper grafoHelper;

    public MenorRota(Grafo grafo) {
        this.grafo = grafo;
        this.grafoHelper = new GrafoHelper(grafo);
    }

    public void Executar() {
        Vertice cidadeA, cidadeB;

        cidadeA = BuscarCidade();
        if (cidadeA == null) {
            return;
        }
        cidadeB = BuscarCidade();
        if (cidadeB == null) {
            return;
        }

        ArrayList<Aresta> rota = BuscaMenorRota(MontaRotas(cidadeA, cidadeB));

        if (rota == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        ExibirRota(cidadeA, cidadeB, rota);
    }

    private Vertice BuscarCidade() {
        String nomeCidade;
        Vertice cidade;

        do {
            System.out.print("Nome da cidade: ");
            nomeCidade = input.nextLine();
            cidade = grafoHelper.BuscarCidade(nomeCidade);
            if (cidade == null && nomeCidade.length() > 0) {
                System.out.println("Ops... cidade não encontrada!");
            }
        } while (cidade == null && nomeCidade.length() > 0);

        return cidade;
    }

    private void ExibirRota(Vertice origem, Vertice destino, ArrayList<Aresta> rota) {
        Vertice corrente = origem;
        Vertice proximo;
        int distanciaTotal = 0;
        System.out.printf("Exibindo rota para passar do ponto '%s' ao ponto '%s'\n", origem.pega_nome(), destino.pega_nome());
        System.out.printf("%30s\t%30s\t%10s\n", "Ponto Atual", "Próximo Ponto", "Distância");
        for (Aresta conexao: rota) {
            proximo = conexao.pega_cidade1() == corrente ? conexao.pega_cidade2() : conexao.pega_cidade1();
            System.out.printf("%30s\t%30s\t%10d\n", corrente, proximo, conexao.pega_distancia());
            corrente = proximo;
            distanciaTotal += conexao.pega_distancia();
        }
        System.out.printf("%30s\t%30s\t%10d\n", "DISTÂNCIA TOTAL: ", "", distanciaTotal);
    }

    private ArrayList<ArrayList<Aresta>> MontaRotas(Vertice cidadeA, Vertice cidadeB) {
        ArrayList<ArrayList<Aresta>> rotas = new ArrayList<ArrayList<Aresta>>();
        ArrayList<Aresta> rota = new ArrayList<Aresta>();
        ArrayList<Vertice> visitados = new ArrayList<Vertice>();

        montaRotaAux(cidadeA, cidadeB, visitados, rota, rotas);

        return rotas;
    }

    private void montaRotaAux(Vertice cidadeA, Vertice cidadeB, ArrayList<Vertice> visitados, ArrayList<Aresta> rota, ArrayList<ArrayList<Aresta>> rotas) {
        if (visitados.contains(cidadeA)) {
            return;
        }

        cidadeA.pega_conexoes().stream().forEach((conexao) -> {
            Vertice vizinho = conexao.pega_cidade1() == cidadeA ? conexao.pega_cidade2() : conexao.pega_cidade1();
            if (visitados.contains(vizinho)) {
                return;
            }
            ArrayList<Aresta> novaRota = (ArrayList<Aresta>) rota.clone();
            novaRota.add(conexao);
            rotas.add(novaRota);
            if (vizinho != cidadeB) {
                ArrayList<Vertice> novoVisitados = (ArrayList<Vertice>) visitados.clone();
                novoVisitados.add(cidadeA);
                montaRotaAux(vizinho, cidadeB, novoVisitados, novaRota, rotas);
                if (!novaRota.stream().anyMatch((rotaConexao) -> rotaConexao.pega_cidade1() == cidadeB || rotaConexao.pega_cidade2() == cidadeB)) {
                    rotas.remove(novaRota);
                }
            }
        });
    }

    private ArrayList<Aresta> BuscaMenorRota(ArrayList<ArrayList<Aresta>> rotas) {
        if (rotas.size() == 0) {
            return null;
        }
        Ordenacao.quickSort(rotas, (rotaA, rotaB) -> SomaRotaDistancia(rotaA) > SomaRotaDistancia(rotaB));
        return rotas.get(0);
    }

    private int SomaRotaDistancia(ArrayList<Aresta> rota) {
        return rota.stream().reduce(0, (acc, conexao) -> acc + conexao.pega_distancia(), (m, n) -> m);
    }

    public String getTitulo() {
        return titulo;
    }
}
