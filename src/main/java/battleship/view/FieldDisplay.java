package battleship.view;
import javax.swing.*;
import battleship.model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;


public class FieldDisplay extends JButton{
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

	public Dimension getSize(){
		return new Dimension(this.size,this.size);
	}

	public Dimension getPreferredSize(){
		return getSize();
	}
	
	public void addListener(final Consumer<Coordinate> listener) {
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.accept(coordinate);
			}
			
		});
	}

}
