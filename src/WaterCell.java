// src/WaterCell.java
import java.awt.Color;

public class WaterCell extends Cell {
  public WaterCell(int x, int y) { super(x, y); }
  @Override protected Color baseColor() { return new Color(200, 230, 255); } // light blue
  @Override public boolean isWalkable() { return false; }  // example: impassable
  @Override public int moveCost() { return 3; }
}
