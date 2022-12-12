package Opcoes;

import java.util.ArrayList;
import java.util.Scanner;

import util.Aresta;
import util.Grafo;
import util.Ordenacao;
import util.Vertice;
import Helpers.GrafoHelper;

public class ListarCidadesVizinhas implements Opcao {
  private String titulo = "Listar Cidades Vizinhas";
  private Scanner input = new Scanner(System.in);  
  private Grafo grafo;
  private GrafoHelper grafoHelper;

  public ListarCidadesVizinhas(Grafo grafo) {
    this.grafo = grafo;
    this.grafoHelper = new GrafoHelper(grafo);
  }
  
  public void Executar() {
    Vertice cidade;
    ExibirCidades();
    cidade = BuscarCidade();
    // Termina execução se não foi buscada uma cidade
    if (cidade == null) {
      return;
    }
    ExibirCidadeConexoes(cidade);
  }

  // Exibe nome de cidades para auxiliar usuario na busca
  private void ExibirCidades() {
    System.out.println("Lista de cidades:");
    for (Vertice grafoCidade: grafo.lista_cidades()) {
      System.out.println(grafoCidade.pega_nome());
    }
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

  private void ExibirCidadeConexoes(Vertice cidade) {
    ArrayList<Aresta> conexoes;
    Vertice cidadeVizinha;

    conexoes = (ArrayList<Aresta>) cidade.pega_conexoes().clone();

    // Ordena conexoes usando quick sort
    Ordenacao.quickSort(conexoes, (conexaoA, conexaoB) -> conexaoA.pega_distancia() > conexaoB.pega_distancia());

    // exibe conexoes em forma de tabela com linhas de tamanho 80
    System.out.printf("%40s\t%10s\n", "Cidade Vizinha", "Distância");
    for (Aresta conexao: conexoes) {
      cidadeVizinha = cidade == conexao.pega_cidade1() ? conexao.pega_cidade2() : conexao.pega_cidade1();
      System.out.printf("%40s\t%10d\n", cidadeVizinha.pega_nome(), conexao.pega_distancia());
    }
  }

  public String getTitulo() {
    return titulo;
  }
}