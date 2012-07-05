package graphic.user;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BasicFrame {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Calculadora");
		
		janela.setSize(500, 450);
//		janela.setLocation(x, y);
		janela.setResizable(false);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentor = janela.getContentPane();
//		contentor.setLayout(new FlowLayout());
		contentor.setLayout(new GridLayout(3, 1));
		contentor.add(new JButton("1"));
		contentor.add(new JButton("2"));
		contentor.add(new JButton("3"));
		
		//Ola
		janela.setVisible(true);
	}
}
