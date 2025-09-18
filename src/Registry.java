// src/Registry.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Registry<T> {
  private final List<T> items = new ArrayList<>();

  public void add(T t) { if (t != null) items.add(t); }
  public List<T> asList() { return Collections.unmodifiableList(items); }
  public void forEach(Consumer<T> consumer) { items.forEach(consumer); }
  public int size() { return items.size(); }
}
