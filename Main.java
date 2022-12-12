import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import util.*;
import Opcoes.*;

class Main {
  
  public static void main(String[] args) {
    int opcao;
    AtomicBoolean emExecucao = new AtomicBoolean(true);
    Grafo grafo = new Grafo();
    Scanner input = new Scanner(System.in);
    Map<Integer, Opcao> opcoes = new LinkedHashMap<Integer, Opcao>();

    // popula opcoes
    opcoes.put(1, new CadastrarCidade(grafo));
    opcoes.put(2, new CadastrarConexao(grafo)); 
    opcoes.put(3, new ListarCidades(grafo)); 
    opcoes.put(4, new ListarConexoes(grafo)); 
    opcoes.put(5, new ListarCidadesVizinhas(grafo));
    opcoes.put(6, new MenorRota(grafo));
    opcoes.put(0, new EncerrarAtividades(emExecucao));


    // popula o grafo
    GrafoSeed.run(grafo);

    while (emExecucao.get()) {
      ListarOpcoes(opcoes);
      System.out.print("Escolha uma das opções acima: ");
      opcao = input.nextInt();
      Auxiliar.LimpaBuffer(input);
      if (!opcoes.containsKey(opcao)) {
        OpcaoInvalida();
        continue;
      }
      opcoes.get(opcao).Executar();
      Auxiliar.Separador();
    }

    input.close();

  }

  private static void ListarOpcoes(Map<Integer, Opcao> opcoes) {
    for (Map.Entry<Integer, Opcao> opcao: opcoes.entrySet()) {
      System.out.printf("%d - %s\n", opcao.getKey(), opcao.getValue().getTitulo());
    }
  }

  // opção default:
  private static void OpcaoInvalida() {
    System.out.println("Opção inválida. Tente novamente.");
  }

}