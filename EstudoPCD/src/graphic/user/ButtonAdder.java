package graphic.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ButtonAdder {
	
	private JFrame window;
	private JButton add_button;
	private AddButtonListener listener;
	
	public ButtonAdder() {
		window = new JFrame("Button adder");
		add_button = new JButton("Add new button");
		listener = new AddButtonListener();

		Container container = window.getContentPane();
		container.setLayout(new FlowLayout());

		container.add(add_button);
		add_button.addActionListener(listener);

		window.setSize(200, 200);
		window.setLocation(200, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void execute() {
		window.setVisible(true);
	}

	public static void main(String[] argumentos) {
		ButtonAdder button_adder = new ButtonAdder();
		button_adder.execute();
	}
	

	private class AddButtonListener implements ActionListener {
		int current_button_number = 1;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == add_button) {
				// Create a new button:
				JButton new_button = new JButton("Button "
						+ current_button_number++);

				// Change the appearance of the button:
				new_button.setForeground(Color.GREEN);
				new_button.setBackground(Color.BLACK);

				// Add this listener to the button so that the button sends an
				// event
				// whenever it is pressed:
				new_button.addActionListener(this);
				window.getContentPane().add(new_button);
			} else {
				// The source of the event is the button that was pressed
				// and that we should remove:
				JButton button_pressed = (JButton) e.getSource();

				// We remove the button from the content pane:
				window.getContentPane().remove(button_pressed);

				// Ask the content pane to eventually redraw itself:
				window.getContentPane().repaint();
			}
			// validate() causes the content pane to re-layout the buttons:
			window.getContentPane().validate();
		}
	}

}
