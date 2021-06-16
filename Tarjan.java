import java.util.*; 

public class Tarjan{
    
private int V; // Число вершин 
  
private LinkedList<Integer> adj[]; // Список смежности
private int Time;
  
// Конструктор
@SuppressWarnings("unchecked")
Tarjan(int v) 
{ 
    V = v; 
    adj = new LinkedList[v];
      
    for(int i = 0; i < v; ++i) 
        adj[i] = new LinkedList(); 
          
    Time = 0;
} 
  
// Функция добавления ребра в граф
void addEdge(int v,int w) 
{ 
    adj[v].add(w); 
} 

// stackMember[] - индексный массив, который позволяет быстро проверить, находится ли узел в стеке
// disc[] - Сохраняет время открытия посещенных вершин
void TR(int u, int low[], int disc[], boolean stackMember[], Stack<Integer> st)
{
      
    disc[u] = Time; // Инициализируем время время открытия вершины
    low[u] = Time;  // Инициализируем время время посещения вершины с минимальным временем обнаружения (вершина, которую мы посетелили раньше всего)
    Time += 1;
    stackMember[u] = true;
    st.push(u);

    int n;
    Iterator<Integer> i = adj[u].iterator(); 
    while (i.hasNext()) 
    { 
        n = i.next(); 
        
        if (disc[n] == -1) 
        {
            TR(n, low, disc, stackMember, st);
              
            low[u] = Math.min(low[u], low[n]); // Обновляем значение low[u] путём нахождения наименьшего
        }
        
        else if (stackMember[n] == true) // Если эл-т находится в стеке
        {
            low[u] = Math.min(low[u], disc[n]); // Обновляем значение low[u] путём нахождения наименьшего
        }
    } 

    while(st.empty() == false){ 
        int w = st.pop();
        System.out.print(w + " ");
    }
    
}

// Основная функция обчеспечивающая корректное выполнение алгоритма
void tarjan()
{
      
    // Помечаем все вершины как непосещённые
    // инициальзируем родительский и посещённый элементы 
    int disc[] = new int[V]; 
    int low[] = new int[V]; 
    for(int i = 0;i < V; i++)
    {
        disc[i] = -1;
        low[i] = -1;
    }
      
    boolean stackMember[] = new boolean[V]; 
    Stack<Integer> st = new Stack<Integer>(); 
    
    for(int i = 0; i < V; i++)
    {
        if (disc[i] == -1)
            TR(i, low, disc, stackMember, st);
    }
  } 
}
