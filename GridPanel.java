import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {

    private int size;
    private Color[][] gridColors;

    public GridPanel(int size) {
        this.size = size;
        this.gridColors = new Color[size][100+size];
        setPreferredSize(new Dimension(1000, 1000));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellWidth = 5;//getWidth() / size;
        int cellHeight = 5;//getHeight() / size;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 100+size; col++) {
                int x = col * cellWidth;
                int y = row * cellHeight;

                // Draw the cell
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellWidth, cellHeight);

                // Fill the cell with the appropriate color
                if (gridColors[row][col] != null) {
                    g.setColor(gridColors[row][col]);
                    g.fillRect(x + 1, y + 1, cellWidth - 1, cellHeight - 1);
                }
            }
        }
    }

    public void setColor(int row, int col, Color color) {
        gridColors[row][col] = color;
        repaint();
    }

}
