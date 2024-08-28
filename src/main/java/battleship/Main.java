package battleship;

import javax.swing.*;

import battleship.model.*;
import battleship.view.*;

public class Main {
    public static void main(final String[] args) {
        final JFrame frame = new JFrame("test");
        frame.getContentPane().add(new FieldDisplay(Field.WATER, new Coordinate(0,0)));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
//        System.out.println("Hier entsteht das Spiel Schiffe versenken!");
    }
}
