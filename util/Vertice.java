package util;
import java.util.ArrayList;

public class Vertice {
  private String nomeCidade;
  private ArrayList<Vertice> vizinhanca;
  private ArrayList<Aresta> conexoes;

  public Vertice(String nomeCidade) {
    this.nomeCidade = nomeCidade;
    this.vizinhanca = new ArrayList<Vertice>();
    this.conexoes = new ArrayList<Aresta>();
  }

  public Vertice(String nomeCidade, ArrayList<Vertice> vizinhanca, ArrayList<Aresta> conexoes) {
    this.nomeCidade = nomeCidade;
    this.vizinhanca = vizinhanca;
    this.conexoes = conexoes;
  }

  public void info_vizinhos() {
    System.out.println("Lista de vizinhos:");
    for (Vertice vizinho: vizinhanca) {
      System.out.println(vizinho);
    }
  }

  public void info_conexoes() {
    System.out.println("Lista de conexões:");
    for (Aresta conexao: conexoes) {
      System.out.println(conexao);
    }
  }

  public void info_vertice() {
    System.out.println(toString());
  }

  public String pega_nome() {
    return nomeCidade;
  }
  public ArrayList<Vertice> pega_vizinhanca() {
    return vizinhanca;
  }
  public ArrayList<Aresta> pega_conexoes() {
    return conexoes;
  }

  public void cadastra_vizinhanca(Vertice novaVizinhanca) {
    vizinhanca.add(novaVizinhanca);  
  }

  public void cadastra_conexao(Aresta novaConexao) {
    conexoes.add(novaConexao);
  }

  public String toString() {
    return nomeCidade;
  }
}