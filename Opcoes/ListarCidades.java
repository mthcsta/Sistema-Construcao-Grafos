package Opcoes;

import java.util.ArrayList;
import java.util.Collections;
import util.Grafo;
import util.Vertice;
import util.Auxiliar;

public class ListarCidades implements Opcao {
  private String titulo = "Listar Cidades";
  private Grafo grafo;

  public ListarCidades(Grafo grafo) {
    this.grafo = grafo;
  }
  
  public void Executar() {
    ArrayList<String> listaOrdenada = new ArrayList<String>();
    for (Vertice cidade: grafo.lista_cidades()) {
      listaOrdenada.add(cidade.pega_nome());      
    }
    Collections.sort(listaOrdenada);
    System.out.println("Lista de cidades do grafo:");    
    Auxiliar.EscreverLista(listaOrdenada);
  }

  public String getTitulo() {
    return titulo;
  }
}