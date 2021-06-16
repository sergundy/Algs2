import java.util.*;
import java.util.LinkedList;

public class Kosaraju
{
    private int V;   // Число вершин
    private LinkedList<Integer> adj[]; // Список смежности
  
    // Конструктор
    @SuppressWarnings("rawtypes")
    Kosaraju(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
  
    // Функция добавления ребра в граф
    void addEdge(int v, int w)  { adj[v].add(w); }
  
    // Функция для печати DFS, начиная с v
    void DFSUtil(int v,boolean visited[])
    {
        // Отмечаем текущий узел как посещенный и выводим его
        visited[v] = true;
        System.out.print(v + " ");
  
        int n;
  
        // Рекурсия для всех вершин, смежных с этой вершиной
        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }
  
    // Функция, которая возвращает транспонированный граф
    Kosaraju getTranspose()
    {
        Kosaraju g = new Kosaraju(V);
        for (int v = 0; v < V; v++)
        {
            //Рекурсия для всех вершин, смежных с этой вершиной
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }
  
    @SuppressWarnings("rawtypes")
    void fillOrder(int v, boolean visited[], Stack stack)
    {
        // Отметить текущий узел как посещенный и вывести его
        visited[v] = true;
  
        // Рекурсивно для всех вершин, смежных с этой вершиной
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }
  
        //Все вершины, достижимые из v, уже обработаны, помещаем v в стек
        stack.push(new Integer(v));
    }
  
    // Основная функция, которая находит и печатает все строго подключенные компоненты
    @SuppressWarnings("rawtypes")
    void printKosaraju()
    {
        Stack stack = new Stack();
  
        // Помечаем все вершины как непосещенные
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;
        
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);
  
        // Создаем транспонированный граф
        Kosaraju gr = getTranspose();
  
        // Отметиv все вершины как непосещенные
        for (int i = 0; i < V; i++)
            visited[i] = false;
  
        // Теперь обработtv все вершины в порядке, определенном стеком.
        while (stack.empty() == false)
        {
            // Pop a vertex from stack
            int v = (int)stack.pop();
  
            // Вывод результата
            if (visited[v] == false)
            {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }
}
