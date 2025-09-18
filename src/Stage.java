import java.awt.Graphics;
import java.awt.Point;

public class Stage {
  private final Grid grid;
  private final Registry<Actor> actors = new Registry<>();

  public Stage() {
    this.grid = new Grid();

    actors.add(new Cat(grid.cellAtColRow(0, 0)));
    actors.add(new Dog(grid.cellAtColRow(0, 15)));
    actors.add(new Bird(grid.cellAtColRow(12, 9)));
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    actors.forEach(a -> a.paint(g));
  }

  public Grid getGrid() { return grid; }
  public Registry<Actor> getActors() { return actors; }
}
