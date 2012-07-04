package graphic.user;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Botoes2 {

	
	public static void main(String[] args) {
		JFrame janela = new JFrame("Botoes2");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(100, 100);
		janela.setLocation(200, 100);
		janela.setResizable(false);
		
		Container contentor = janela.getContentPane();
		contentor.setLayout(new FlowLayout());
		
		JButton buttonOK = new JButton("OK");
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Carregou no botão OK");
			}
		});
		contentor.add(buttonOK);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Carregou no botão Cancel");
			}
		});
		contentor.add(buttonCancel);
		
		janela.setVisible(true);
		

	}

}
