package Opcoes;

import util.Grafo;
import util.Aresta;

public class ListarConexoes implements Opcao {
  private String titulo = "Listar Conexões";
  private Grafo grafo;

  public ListarConexoes(Grafo grafo) {
    this.grafo = grafo;
  }
  
  public void Executar() {
    System.out.println("Lista de conexões do grafo:");
    System.out.printf(
      "%35s\t%35s\t%10s\n",
      "Cidade A",
      "Cidade B",
      "Distância"
    );
    for (Aresta conexao: grafo.lista_conexoes()) {
      System.out.println(conexao.toTable());
    }
  }

  public String getTitulo() {
    return titulo;
  }
}