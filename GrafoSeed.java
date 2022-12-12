
import util.Grafo;
import util.Vertice;
import util.Aresta;

import java.util.HashMap;
import java.util.Map;

public class GrafoSeed {
  public static void run(Grafo grafo) {
    Map<Integer, Vertice> cidades = new HashMap<Integer, Vertice>();

    cidades.put(1, grafo.cadastra_cidade("Porto Alegre"));
    cidades.put(2, grafo.cadastra_cidade("Viamão"));
    cidades.put(3, grafo.cadastra_cidade("Canoas"));
    cidades.put(4, grafo.cadastra_cidade("São Leopoldo"));
    cidades.put(5, grafo.cadastra_cidade("Cachoeirinha"));
    cidades.put(6, grafo.cadastra_cidade("Gravataí"));
    cidades.put(7, grafo.cadastra_cidade("Esteio"));
    cidades.put(8, grafo.cadastra_cidade("Alvorada"));

    // vizinhos de porto alegre
    grafo.cadastra_conexao(cidades.get(1), cidades.get(2), 100);
    grafo.cadastra_conexao(cidades.get(1), cidades.get(3), 150);
    grafo.cadastra_conexao(cidades.get(1), cidades.get(5), 300);
    grafo.cadastra_conexao(cidades.get(1), cidades.get(8), 50);

    // vizinhos de viamão
    grafo.cadastra_conexao(cidades.get(2), cidades.get(8), 30);

    // vizinhos de canoas
    grafo.cadastra_conexao(cidades.get(3), cidades.get(7), 150);
    grafo.cadastra_conexao(cidades.get(3), cidades.get(5), 5);

    // vizinhos de São Leopoldo
    grafo.cadastra_conexao(cidades.get(4), cidades.get(7), 50);

    // vizinhos de cachoeirinha
    grafo.cadastra_conexao(cidades.get(5), cidades.get(6), 70);

    // vizinhos de alvorada
    grafo.cadastra_conexao(cidades.get(8), cidades.get(5), 300);



  }
}