package util;

import java.util.Scanner;
import java.util.ArrayList;

public class Auxiliar {

  // LimpaBuffer: método auxiliar para limpeza do buffer de scanner,
  public static void LimpaBuffer(Scanner input) {
    input.nextLine();
  }

  public static void Separador() {
    System.out.println("--------------------------------------------");
  }

  public static <T> void EscreverLista(ArrayList<T> lista) {
    if (lista.size() == 0) {
      System.out.println("Nenhum item encontrado.");
      return;
    }
    for (T item: lista) {
      System.out.println(item);
    }
  }

  public static String toSlug(String string) {
    return string.replaceAll(" ", "-").toLowerCase();
  }
  
}