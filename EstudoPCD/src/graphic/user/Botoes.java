package graphic.user;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Botoes {
	private JFrame janela = new JFrame("Eventos");
	private JButton botão_OK = new JButton("OK");
	private JButton botão_Cancel = new JButton("Cancel");
	private SentinelaParaAcções sentinela = new SentinelaParaAcções();

	
	//Uma das formas de programar a sentinela. Classe Interna.
	//Assim a mesma sentinala serve para vários botões, apesar de n ser boa prática.
	//Ver como se declara de forma anónima.
	private class SentinelaParaAcções implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton botão = (JButton) e.getSource();
			if (botão == botão_OK) {
				System.out.println("Carregou no botão OK");
			} else {
				System.out.println("Carregou no botão Cancel");
			}
			//Ou um switch se forem vários
		}
	}
	
	
	public Botoes() {
		//Explicar porque está aqui dentro e não no main
		Container contentor = janela.getContentPane();
		contentor.setLayout(new FlowLayout());

		contentor.add(botão_OK);
		contentor.add(botão_Cancel);

		// Regista sentinelas:
		botão_OK.addActionListener(sentinela);
		botão_Cancel.addActionListener(sentinela);

		janela.setSize(100, 100);
		janela.setLocation(200, 100);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void mostra() {
		janela.setVisible(true);
	}

	
	public static void main(String[] argumentos) {
		Botoes b = new Botoes();
		b.mostra();
	}

	/*
	 * Extra:
	 * Adiciona um novo botão chamado Stop.
	 * Este botão quando é carregado bloqueia os outros botões até que volte a ser primido.
	 * 
	 * Fazer uma nova classe "Botoes2" igual a esta, com sentinelas anónimas, para praticar.
	 * Exercicios assitido xD
	 * 
	 * Brincar com outros componentes. Como a JList e ListSelectionListener. 
	 * Só se for necessário.
	 */
	
}
