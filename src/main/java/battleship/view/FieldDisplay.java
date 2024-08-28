package battleship.view;

import javax.swing.*;
import battleship.model.*;
import java.awt.*;
import java.util.function.Consumer;

public class FieldDisplay extends JButton {
    private static final long serialVersionUID = 1L;

    private final Coordinate coordinate;
    private Field field;
    private int size;

    public FieldDisplay(Coordinate coordinate, Field field) {
        this.coordinate = coordinate;
        this.field = field;
        this.size = 20;
    }

    public void setField(Field field) {
        this.field = field;
        repaint();
    }

    public void setSize(int size) {
        this.size = size;
        invalidate();
        repaint();
    }

    public Dimension getSize() {
        return new Dimension(this.size, this.size);
    }

    public Dimension getPreferredSize() {
        return getSize();
    }

    public void addListener(final Consumer<Coordinate> listener) {
        this.addActionListener(e -> listener.accept(coordinate));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(100, 100, 200));
        g.fillRect(0, 0, size, size);
        g.setColor(new Color(200, 200, 200));
        g.drawRect(0, 0, size, size);

        switch (field) {
            case WATER_HIT:
                g.setColor(Color.WHITE);
                g.drawLine(0, 0, size, size);
                g.drawLine(size, 0, 0, size);
                break;
            case SHIP:
                g.setColor(Color.BLACK);
                g.fillOval(0, 0, size, size);
                break;
            case SHIP_HIT:
                g.setColor(Color.RED);
                g.fillOval(0, 0, size, size);
                g.setColor(Color.BLACK);
                g.drawOval(0, 0, size, size);
        }
    }
}
