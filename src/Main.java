public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "E", 3);
        graph.addEdge("E", "D", 4);
        graph.addEdge("D", "F", 11);

        Vertex<String> start = graph.getVertex("A");
        Vertex<String> end = graph.getVertex("F");

        System.out.println("=== BFS ===");
        BFS<String> bfs = new BFS<>(start);
        System.out.println("Path: " + bfs.pathTo(end));

        System.out.println("\n=== Dijkstra ===");
        Dijkstra<String> dijkstra = new Dijkstra<>(start);
        System.out.println("Path: " + dijkstra.pathTo(end));
        System.out.println("Distance: " + dijkstra.distanceTo(end));
    }
}
