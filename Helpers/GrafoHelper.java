package Helpers;

import util.Grafo;
import util.Vertice;
import util.Auxiliar;
import java.util.ArrayList;

public class GrafoHelper {
  private Grafo grafo;

  public GrafoHelper(Grafo grafo) {
    this.grafo = grafo;
  }

  public Vertice BuscarCidade(String nomeCidade) {
    String nomeCidadeSlug = Auxiliar.toSlug(nomeCidade);
    for (Vertice cidade: grafo.lista_cidades()) {
      if (Auxiliar.toSlug(cidade.toString()).equals(nomeCidadeSlug)) {
        return cidade;
      }
    }
    return null;
  }

  public boolean ExisteConexao(Vertice cidade1, Vertice cidade2) {
    return cidade1.pega_vizinhanca().contains(cidade2);
  }

  public Vertice[] VizinhosOrdenadoPorDistancia(Vertice cidade) {
    ArrayList<Vertice> vizinhos = new ArrayList<Vertice>();

    // for (Vertice vizinho: cidade.pega_vizinhos()) {
      
    // }

    return (Vertice[]) vizinhos.toArray();
  }
}