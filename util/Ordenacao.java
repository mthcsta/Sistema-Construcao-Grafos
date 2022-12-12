package util;

import java.util.ArrayList;
import java.util.function.BiPredicate;

public class Ordenacao {

  public static void quickSort(ArrayList<Integer> lista) {
    quickSort(lista, (itemA, itemB) -> itemA > itemB);
  }
  /*
  * Recebe um ArrayList e uma expressão lambda de como deve ser feita a comparação
  * Ordena o ArrayList com base na expressão lambda passada usando o algoritmo Quick Sort
  * */
  public static <T> void quickSort(ArrayList<T> lista, BiPredicate<T, T> comparador) {
    quickSortAux(lista, comparador, 0, lista.size() - 1);
  }

  private static <T> void quickSortAux(ArrayList<T> lista, BiPredicate<T, T> comparador, int inicio, int fim) {
    if (inicio >= fim) {
      return;
    }
    int[] nPar = quickSortPartition(lista, comparador, inicio, fim);
    quickSortAux(lista, comparador, inicio, nPar[0]);
    quickSortAux(lista, comparador, nPar[1], fim);
  }

  /*
  * @return par de inteiros
  * */
  private static <T> int[] quickSortPartition(ArrayList<T> lista, BiPredicate<T, T> comparador, int inicio, int fim) {
    T pivo = lista.get(inicio);
    int atual = inicio;

    while (inicio <= fim) {
      if (comparador.test(lista.get(inicio), pivo)) {
        swap(lista, inicio, fim);
        fim--;
      } else if (comparador.test(pivo, lista.get(inicio))) {
        swap(lista, atual, inicio);
        atual++;
        inicio++;
      } else {
        inicio++;
      }
    }

    return new int[]{atual-1, inicio};
  }

  private static <T> void swap(ArrayList<T> lista, int itemA, int itemB) {
    T itemACorrente = lista.get(itemA);
    lista.set(itemA, lista.get(itemB));
    lista.set(itemB, itemACorrente);
  }

}