package Opcoes;

import util.Grafo;
import Helpers.GrafoHelper;

import java.util.Scanner;

public class CadastrarCidade implements Opcao {
  private String titulo = "Cadastrar Cidade";
  private Scanner input = new Scanner(System.in);
  private Grafo grafo;
  private GrafoHelper grafoHelper;

  public CadastrarCidade(Grafo grafo) {
    this.grafo = grafo;
    this.grafoHelper = new GrafoHelper(grafo);
  }
  
  public void Executar() {
    String nomeCidade;
    boolean jaCadastrada = true;
    
    System.out.println("Cadastrar nova cidade");
    
    do {
      System.out.print("Nome da cidade: ");
      nomeCidade = input.nextLine();
      jaCadastrada = grafoHelper.BuscarCidade(nomeCidade) == null;
      if (nomeCidade.isEmpty()) {
        System.out.println("Saindo sem cadastrar cidade.");
        return;
      }
      if (jaCadastrada) {
        System.out.println("Ops... cidade já cadastrada!");
      }
    } while (jaCadastrada);
    grafo.cadastra_cidade(nomeCidade);

    System.out.printf("A cidade '%s' foi cadastrada com sucesso.", nomeCidade);
  }

  public String getTitulo() {
    return titulo;
  }
}