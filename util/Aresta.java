package util;

import java.util.ArrayList;

public class Aresta {
  private Vertice cidade1;
  private Vertice cidade2;
  private int distancia;

  public Aresta(Vertice cidade1, Vertice cidade2, int distancia) {
    this.cidade1 = cidade1;
    this.cidade2 = cidade2;
    this.distancia = distancia;
  }

  public Vertice pega_cidade1() { return cidade1; }
  public Vertice pega_cidade2() { return cidade2; }
  public int pega_distancia() {
    return distancia;
  }

  public void info_aresta() {
    System.out.println(toString());
  }

  public String toString() {
    return String.format(
      "('%s', '%s') -> %d\n",
      cidade1,
      cidade2,
      distancia
    );
  }

  public String toTable() {
    return String.format(
      "%35s\t%35s\t%10d\n",
      cidade1,
      cidade2,
      distancia
    );
  }
  
}