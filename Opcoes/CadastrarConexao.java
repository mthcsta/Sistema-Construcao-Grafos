package Opcoes;

import java.util.Scanner;
import util.Grafo;
import util.Vertice;
import util.Aresta;
import Helpers.GrafoHelper;

public class CadastrarConexao implements Opcao {
  private String titulo = "Cadastrar Conexão";
  private Scanner input = new Scanner(System.in);
  private Grafo grafo;
  private GrafoHelper grafoHelper;

  public CadastrarConexao(Grafo grafo) {
    this.grafo = grafo;
    this.grafoHelper = new GrafoHelper(grafo);
  }
  
  public void Executar() {
    Vertice cidade1;
    Vertice cidade2;
    int distancia;
    boolean existeConexao;
    char desejaSair;

    grafo.info_cidades();

    do {
      cidade1 = ProximaCidade(1);
      cidade2 = ProximaCidade(2);
      if (cidade1 == null || cidade2 == null) {
        System.out.println("Saindo sem cadastrar conexão.");
        return;
      }
      existeConexao = grafoHelper.ExisteConexao(cidade1, cidade2);
      if (existeConexao) {
        System.out.println("Ops... Já existe uma conexão entre essas cidades!");
      }
    } while (existeConexao);    
    
    System.out.printf("Digite a distancia entre a cidade '%s' e a cidade '%s': ", cidade1, cidade2);
    distancia = input.nextInt();

    grafo.cadastra_conexao(cidade1, cidade2, distancia);
  }

  public Vertice ProximaCidade(int numero) {
    String nomeCidade;
    Vertice cidade = null;
    do {
      System.out.printf("Digite a cidade %d: ", numero);
      nomeCidade = input.nextLine();
      cidade = grafoHelper.BuscarCidade(nomeCidade);
      if (cidade == null && !nomeCidade.isEmpty()) {
        System.out.println("Ops... cidade não encontrada!");
      }
    } while (cidade == null && !nomeCidade.isEmpty());
    return cidade;
  }

  public String getTitulo() {
    return titulo;
  }
}