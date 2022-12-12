package util;
import java.util.ArrayList;

public class Grafo {
  private ArrayList<Vertice> cidades;
  private ArrayList<Aresta> conexoes;

  public Grafo() {
    this.cidades = new ArrayList<Vertice>();
    this.conexoes = new ArrayList<Aresta>();
  }

  public Grafo(ArrayList<Vertice> cidades, ArrayList<Aresta> conexoes) {
    this.cidades = cidades;
    this.conexoes = conexoes;
  }

  public void info_cidades() {
    System.out.println("Lista de cidades:");
    for (Vertice cidade: cidades) {
      System.out.println(cidade);
    }
  }
  
  public void info_conexoes() {
    System.out.println("Lista de conexões:");
    for (Aresta conexao: conexoes) {
      System.out.println(conexao);
    }
  }

  public ArrayList<Vertice> lista_cidades() {
    return cidades;
  }

  public Vertice cadastra_cidade(String nomeCidade) {
    Vertice novaCidade = new Vertice(nomeCidade, new ArrayList<Vertice>(), new ArrayList<Aresta>());
    cidades.add(novaCidade);
    return novaCidade;
  }
  public Vertice cadastra_cidade(String nomeCidade, ArrayList<Vertice> vizinhanca, ArrayList<Aresta> conexoes) {
    Vertice novaCidade = new Vertice(nomeCidade, vizinhanca, conexoes);
    cidades.add(novaCidade);
    return novaCidade;
  }
  
  public ArrayList<Aresta> lista_conexoes() {
    return conexoes;
  }
  public Aresta cadastra_conexao(Vertice cidade1, Vertice cidade2, int distancia) {
    Aresta novaAresta = new Aresta(cidade1, cidade2, distancia);

    // adiciona conexao ao grafo
    conexoes.add(novaAresta);

    // adiciona cidade a vizinhança e a aresta a nova conexao.
    cidade1.cadastra_vizinhanca(cidade2);
    cidade1.cadastra_conexao(novaAresta);
    
    cidade2.cadastra_vizinhanca(cidade1);
    cidade2.cadastra_conexao(novaAresta);

    return novaAresta;
  }
}