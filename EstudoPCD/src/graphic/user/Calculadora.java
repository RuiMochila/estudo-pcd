package graphic.user;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Calculadora");
		
		janela.setSize(300, 200);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentor = janela.getContentPane();
		contentor.setLayout(new BorderLayout());

		JPanel painel = new JPanel();

		final String caracteres_dos_botoes = "789+456-123*0.^/";
		JPanel painel_dos_botões = new JPanel();
		painel_dos_botões.setLayout(new GridLayout(4, 4));
		for(int i=0; i!= caracteres_dos_botoes.length(); ++i){
			painel_dos_botões.add(new JButton(""+ caracteres_dos_botoes.charAt(i)));
		}
		
		painel.add(painel_dos_botões);

		JPanel painel_das_acções = new JPanel();
		painel_das_acções.setLayout(new GridLayout(2, 1));
		painel_das_acções.add(new JButton("C"));
		painel_das_acções.add(new JButton("="));

		painel.add(painel_das_acções);

		contentor.add(painel, BorderLayout.CENTER);
		
		
		JTextField mostrador = new JTextField();
		mostrador.setHorizontalAlignment(JTextField.RIGHT);
		mostrador.setEditable(false);
		mostrador.setFont(new Font("Arial", Font.PLAIN, 14));
		contentor.add(mostrador, BorderLayout.NORTH);
		
		janela.setVisible(true);
	}
}
