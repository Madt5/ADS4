import java.util.*;

public abstract class Search<V> {
    protected final Vertex<V> startVertex;
    protected final Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    protected final Set<Vertex<V>> marked = new HashSet<>();

    public Search(Vertex<V> startVertex) {
        this.startVertex = startVertex;
    }

    public boolean hasPathTo(Vertex<V> v) {
        return marked.contains(v);
    }

    public List<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        List<Vertex<V>> path = new ArrayList<>();
        for (Vertex<V> x = v; x != startVertex; x = edgeTo.get(x)) {
            path.add(x);
        }
        path.add(startVertex);
        Collections.reverse(path);
        return path;
    }
}
