import java.util.*;

public class Eulerian_circuit {
    private final int V; // Числов вершин
    private int E;
    private final ArrayList<Integer>[] adj; // Список смежности
    Stack <Integer> stack = new Stack<>();

    // Конструктор
    public Eulerian_circuit(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V(){
        return V;
    }

    // Функция добавления ребра в граф
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    // Функция удаления ребра из графа
    private void removeEdge(Integer v, Integer w) {
        adj[v].remove(w);
        adj[w].remove(v);
    }

    // Функция вывода простых циклов 
    public void print(){
        for(int i = 0; i < V(); i++){
            System.out.print(i + ": ");
            for (int j = 0; j<adj[i].size(); j++){
                int n = adj[i].get(j);
                System.out.print( n + " ");
            }
            System.out.println();
        }
    }

    // Выводит финальцый цикл Эйлера
    public void Euler (){
        int v = 0;
        tour(v);
        System.out.println("Цикл Эйлера: ");
        while (!stack.empty()){
            v = stack.pop();
            System.out.printf(v + " ");
        }
        System.out.println(" ");
    }

    // Цикл Эйлера
    public void tour(int v){
            int w;
            stack.push(v);
            w = adj[v].get(0);
            removeEdge(v, w);
            v = w;
            print();
            System.out.println();
            if(adj[v].size()!=0)
                tour(v);
            else if (check()) {
                int k = stack.pop();
                tour(stack.pop());
            }
            else {
                stack.push(v);
            }

    }

    // Функция проверки
    private boolean check() {
        int k = 0;
        for(int i = 0; i < V(); i++){
           if(adj[i].size() == 0)
               k++;
        }
        if(k==V())
            return false;
        else{
        return true;
        }
    }
}
