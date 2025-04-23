package br.dev.kauan.ConversorTemperatura.gui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaConversor {
	// Atributo Caixa de texto
	private JTextField textCelsius;
	
	// Atributo Caixa de informação
	private JLabel labelCelsius;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	
	// Atributo Botoes de conversão
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private String tituloTela;
	
	// Métodos
	public void criarTelaConversor(String tituloTela) {
		this.tituloTela = tituloTela;
		
		// Instanciando e configurando o JFrame
		JFrame tela = new JFrame();
		tela.setTitle(this.tituloTela);
		tela.setSize(360, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		
		
		
		// Criando text labels para a janela e referencia para os Bounds
		labelCelsius = new JLabel();
		labelCelsius.setBounds( 20 ,20 ,200 ,20);
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setFont(new Font("Courier", Font.PLAIN,10)); // "Font.PLAIN" Retira o negrito e "Font.BOLD" Coloca negrito
		
		textCelsius = new JTextField();
		textCelsius.setBounds(20, 40, 300, 30);
		
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setBounds(20, 80, 147, 30);
		buttonFahreinheit.setText("FAHREINHEIT");
		buttonFahreinheit.setFont(new Font("Courier", Font.PLAIN,12));
		
		buttonKelvin = new JButton();
		buttonKelvin.setBounds(172, 80, 147, 30);
		buttonKelvin.setText("KELVIN");
		buttonKelvin.setFont(new Font("Courier", Font.PLAIN,12));
		
		labelResultado = new JLabel();
		labelResultado.setBounds(110, 120, 150, 30);
		labelResultado.setText("00 FAHRENHEIT");
		labelResultado.setFont(new Font("Courier", Font.BOLD,16));
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(50, 160, 140, 30);
		labelMensagemErro.setText("Caso o valor fornecido pelo usuário esteja incorreto, a mensagem de erro deverá aparecer aqui.");
		labelResultado.setFont(new Font("Courier", Font.BOLD,10));
		
		// Obtendo referência do Container, o painel de conteudo da janela
		Container container = tela.getContentPane();
		
		// Adicionando elementos na janela
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonFahreinheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		
		tela.setVisible(true);
	}
}
