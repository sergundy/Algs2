public class test {

    public static void main(String[] args) {
      
    System.out.println("\n");
    System.out.println("────────────────────────────────────────────────────────");
    System.out.println("\n");

    //System.out.println("алгоритм Флёри: \n");

    /*Fleury a = new Fleury(4);
    
    a.addEdge(0, 1);
    a.addEdge(0, 2);
    a.addEdge(1, 2);
    a.addEdge(2, 3);

    a.printEulerTour();

    System.out.println("\n");
    System.out.println("────────────────────────────────────────────────────────");
    System.out.println("\n");

    System.out.println("алгоритм Косарайю:\n");

    Kosaraju b = new Kosaraju(5);

    b.addEdge(1, 0);
    b.addEdge(0, 2);
    b.addEdge(2, 1);
    b.addEdge(0, 3);
    b.addEdge(3, 4);

    b.printKosaraju();*/

    System.out.println("\n");
    System.out.println("────────────────────────────────────────────────────────");
    System.out.println("\n");

    System.out.println("алгоритм Тарьяна:\n");

    Tarjan c = new Tarjan(6); 
  
    c.addEdge(5, 2);
    c.addEdge(5, 0);
    c.addEdge(4, 0);
    c.addEdge(4, 1);
    c.addEdge(2, 3);
    c.addEdge(3, 1);
    c.tarjan();

    System.out.println("\n");
    System.out.println("────────────────────────────────────────────────────────");
    System.out.println("\n");

    /*System.out.println("алгоритм поиска Эйлерова цикла:\n");

    Eulerian_circuit d = new Eulerian_circuit(7);

    d.addEdge(0,1);
    d.addEdge(0,2);
    d.addEdge(4,6);
    d.addEdge(4,5);
    d.addEdge(0,5);
    d.addEdge(0,6);
    d.addEdge(3,4);
    d.addEdge(2,3);
    d.addEdge(2,4);
    d.addEdge(1,2);
    
    d.Euler();*/

    System.out.println("\n");
    System.out.println("────────────────────────────────────────────────────────");
    System.out.println("\n");


    }
}
