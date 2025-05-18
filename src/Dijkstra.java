import java.util.*;

public class Dijkstra<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo = new HashMap<>();

    public Dijkstra(Vertex<V> startVertex) {
        super(startVertex);
        dijkstra(startVertex);
    }

    private void dijkstra(Vertex<V> start) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        distTo.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            marked.add(current);

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distTo.get(current) + weight;

                if (!distTo.containsKey(neighbor) || newDist < distTo.get(neighbor)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double distanceTo(Vertex<V> v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}
