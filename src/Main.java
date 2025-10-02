//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

// Clase Nodo
class Nodo {
    int valor;
    Nodo izquierda;
    Nodo derecha;

    Nodo(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}

// Clase Árbol
class ArbolBinario {
    Nodo raiz;

    // Insertar número
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izquierda = insertarRec(actual.izquierda, valor);
        } else if (valor > actual.valor) {
            actual.derecha = insertarRec(actual.derecha, valor);
        }
        return actual;
    }

    // Recorrido INORDEN
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecha);
        }
    }

    // Buscar número
    public boolean buscar(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        if (valor < nodo.valor) return buscar(nodo.izquierda, valor);
        return buscar(nodo.derecha, valor);
    }
}

// Clase principal con menú
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ÁRBOL BINARIO ---");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar recorrido INORDEN");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número: ");
                    int num = sc.nextInt();
                    arbol.insertar(num);
                    System.out.println("Número insertado.");
                    break;
                case 2:
                    System.out.print("Recorrido INORDEN: ");
                    arbol.inorden(arbol.raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Número a buscar: ");
                    int buscar = sc.nextInt();
                    if (arbol.buscar(arbol.raiz, buscar)) {
                        System.out.println("El número SÍ está en el árbol.");
                    } else {
                        System.out.println("El número NO está en el árbol.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
