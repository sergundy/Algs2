import java.util.ArrayList;

public class Fleury {
  
    public int V; // Число вершин
    public ArrayList<Integer>[] adj; // Список смежности
  
    // Констуктор
    Fleury(int numOfV)
    {
        // Инициализируем количество вершин
        this.V = numOfV;
  
        // Инициализируем список смежности
        initfleury();
    }
  
    // Метод для инициализации списка смежности
    @SuppressWarnings("unchecked")
    public void initfleury()
    {
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) 
        {
            adj[i] = new ArrayList<>();
        }
    }
  
    // Функция добавления ребра u-v
    public void addEdge(Integer u, Integer v)
    {
        adj[u].add(v);
        adj[v].add(u);
    }
  
    // Функция удаления ребра u-v
    public void removeEdge(Integer u, Integer v)
    {
        adj[u].remove(v);
        adj[v].remove(u);
    }
  
    // Основная функция, которая выводит результат работы программы
    public void printEulerTour()
    {
        // Находим вершину с нечетной степенью
        Integer u = 0;
        for (int i = 0; i < V; i++)
        {
            if (adj[i].size() % 2 == 1)
            {
                u = i;
                break;
            }
        }
          
        // Выводим начиная с нечётного
        printEulerUtil(u);
        System.out.println();
    }
  
    // Функция вывода
    public void printEulerUtil(Integer u)
    {
        // Рекурсия для всех V, смежных с этой вершиной
        for (int i = 0; i < adj[u].size(); i++)
        {
            Integer v = adj[u].get(i);

            // Если ребро u-v - допустимое
            if (isValidNextEdge(u, v)) 
            {
                System.out.print(u + "-" + v + " ");
                  
                // Удаляем выведенное ребро
                removeEdge(u, v); 
                printEulerUtil(v);
            }
        }
    }
    
    // Функция для проверки того, является ли ребро u-v допустимым
    public boolean isValidNextEdge(Integer u, Integer v)
    {
        // Ребро u-v будет допустимым в одном из случаев
        // 1) Если v единственная смежная вершина u
        if (adj[u].size() == 1) {
            return true;
        } 
        // 2.а) количество V достижимых от u
        boolean[] isVisited = new boolean[this.V];
        int count1 = dfsCount(u, isVisited);
  
        // 2.б) Удаляем ребро u-v 
        removeEdge(u, v);
        isVisited = new boolean[this.V];
        int count2 = dfsCount(u, isVisited);
  
        // 2.в) Добавляем ребро обратно
        addEdge(u, v);
        return (count1 > count2) ? false : true;
    }
  
    // Функция на основе DFS для вычисления достижимости V из v
    public int dfsCount(Integer v, boolean[] isVisited)
    {
        // Отмечаем текущий узел как посещенныйd
        isVisited[v] = true;
        int count = 1;
        // Рекурсия для всех V, смежных с этой вершиной
        for (int adj : adj[v])
        {
            if (!isVisited[adj])
            {
                count = count + dfsCount(adj, isVisited);
            }
        }
        return count;
    }
}
    

