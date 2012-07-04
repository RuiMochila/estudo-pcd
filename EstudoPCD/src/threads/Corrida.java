package threads;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Corrida {

	private JTextField text1 = new JTextField(2);
	private JTextField text2 = new JTextField(2);
	private JTextField text3 = new JTextField(2);
	private JButton botao = new JButton("Inicia");
	private JFrame janela = new JFrame("Corrida");
	private Cavalo c1 = new Cavalo(text1);
	private Cavalo c2 = new Cavalo(text2);
	private Cavalo c3 = new Cavalo(text3);

	private class Cavalo extends Thread {

		private JTextField text;
		private final int distancia = 30;

		public Cavalo(JTextField text) {
			this.text = text;
		}

		@Override
		public void run() {
			try {
				for (int i = distancia; i >= 0; i--) {
					text.setText(Integer.toString(i));
					sleep(new Random().nextInt(1000));
				}
			} catch (InterruptedException e) {
				System.out.println("Fui interrompido " + e);
			}
		}

	}

	public Corrida() {
		janela.setSize(200, 80);
		janela.setLocation(200, 100);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);

		Container contentor = janela.getContentPane();
		contentor.setLayout(new BorderLayout());

		text1.setEditable(false);
		text2.setEditable(false);
		text3.setEditable(false);

		text1.setHorizontalAlignment(JTextField.RIGHT);
		text2.setHorizontalAlignment(JTextField.RIGHT);
		text3.setHorizontalAlignment(JTextField.RIGHT);

		JPanel painelText = new JPanel();
		painelText.add(text1);
		painelText.add(text2);
		painelText.add(text3);

		contentor.add(painelText, BorderLayout.CENTER);
		contentor.add(botao, BorderLayout.SOUTH);
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				c1.start();
				System.out.println("Cavalo 1 começou");
				c2.start();
				System.out.println("Cavalo 2 começou");
				c3.start();
				System.out.println("Cavalo 3 começou");

			}
		});

	}

	private void mostra() {
		janela.setVisible(true);
	}

	public static void main(String[] args) {
		Corrida c = new Corrida();
		c.mostra();
	}
}
