package br.dev.kauan.ConversorTemperatura.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.kauan.ConversorTemperatura.model.Temperatura;

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
		labelResultado.setBounds(110, 120, 160, 30);
		labelResultado.setText("00 FAHRENHEIT");
		labelResultado.setFont(new Font("Courier", Font.BOLD,16));
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(50, 160, 240, 40);
		labelMensagemErro.setText("<html><body style='width: 200px;'>Caso o valor fornecido pelo usuário esteja incorreto, a mensagem de erro deverá aparecer aqui.");
		labelMensagemErro.setFont(new Font("Courier", Font.BOLD,10));
		
		// Obtendo referência do Container, o painel de conteudo da janela
		Container container = tela.getContentPane();
		
		// Adicionando elementos na janela
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonFahreinheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		
		// Adicionando escutantes de ação aos botão Kelvin
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			// Coletando os valores nos campos
			String celsius = textCelsius.getText();
			
			// Convertendo os valores para double
			double celsiusDouble = Double.parseDouble(celsius);
			
			// Fornecendo os valores para o conversor
			Temperatura temperaturaKelvin = new Temperatura(celsiusDouble);
			
			// Mostrando a temperatura convertida na tela
			labelResultado.setText(temperaturaKelvin.converterParaKelvin()+" Kelvin");
				
			}
		});
		
		// Adicionando escutantes de ação ao botão Fahrenheit
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			// coletando os valores nos campos
			String celsius = textCelsius.getText();
			
			// Convertendo os valores para double
			double celsiusDouble = Double.parseDouble(celsius);
			
			// Fornecendo os valores para o conversor
			Temperatura temperaturaKelvin = new Temperatura(celsiusDouble);
						
			// Mostrando a temperatura convertida na tela
			labelResultado.setText(temperaturaKelvin.converterParaFahreinhet()+" Fahrenheit");
							
				
			}
		});
		
		tela.setVisible(true);
	}
}
