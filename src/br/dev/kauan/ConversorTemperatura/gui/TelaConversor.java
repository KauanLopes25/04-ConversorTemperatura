package br.dev.kauan.ConversorTemperatura.gui;

import java.awt.Color;
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
		labelResultado.setFont(new Font("Courier", Font.BOLD,16));
		
		labelMensagemErro = new JLabel();
		//labelMensagemErro.setText("<html><body style='width: 200px;'>"); quebra a linha em 200px
		labelMensagemErro.setFont(new Font("Courier", Font.BOLD,10));
		labelMensagemErro.setForeground(Color.RED);
		
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
			
			//Altera a "," digitada pelo usuário pelo "." utilizando a função replace da classe String
			celsius = celsius.replace(",", ".");
			
			/*
			 *MENSAGEM DE ERRO
			 *Funções .trim() e .isEmpty() presentes na classe String
			 *.trim é responsavel por retirar espaços dos valores atribuidos para uma variavel ex"kau an"
			 *.isEmpty é responsavel por retornar TRUE quando o valor atribuido para uma variavel for ex""
			*/
			if (celsius.trim().isEmpty()) {
				labelMensagemErro.setBounds(100, 160, 240, 40);
				labelMensagemErro.setText("!!VALOR NÃO INFORMADO!!");
				labelResultado.setText(null);
			} 
			else {
				
				/*
				 *try-catch é uma função nativa do java e é utilizada para erros em exeções,
				 *onde o try realiza a operação normalmente, e caso ocorra um erro o catch é acionado sem 
				 *parar o programa.
				 *NumberFormatException esta especificando o erro, e dizendo para o java que ocorrer um erro de formato
				 *deverá executar a operação dentro do catch.
				 */
				
				try {
						// Convertendo os valores para double
						double celsiusDouble = Double.parseDouble(celsius);
						
						// Tratativa do zero absoluto
						if (celsiusDouble < -273.15) {
							labelMensagemErro.setBounds(60, 160, 240, 40);
							labelMensagemErro.setText("!!IMPOSSIVEL EXCEDER O ZERO ABSOLUTO!!");
							labelResultado.setText(null);
						} else {
							// Fornecendo os valores para o conversor
							Temperatura temperaturaKelvin = new Temperatura(celsiusDouble);
							
							// Mostrando a temperatura convertida na tela
							labelResultado.setText(temperaturaKelvin.converterParaKelvin()+" Kelvin");
							labelMensagemErro.setText(null);
						}	
				}
				catch (NumberFormatException e1) {
					labelMensagemErro.setBounds(90, 160, 240, 40);
					labelMensagemErro.setText("!!DIGITE UM VALOR VÁLIDO!!");
					labelResultado.setText(null);
				}
			}
			
			
				
			}
		});
		
		// Adicionando escutantes de ação ao botão Fahrenheit
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			// coletando os valores nos campos
			String celsius = textCelsius.getText();
			celsius = celsius.replace(",", ".");
			
			if (celsius.trim().isEmpty()) {
				labelMensagemErro.setBounds(100, 160, 240, 40);
				labelMensagemErro.setText("!!VALOR NÃO INFORMADO!!");
				labelResultado.setText(null);
			} else {
				try {
					// Convertendo os valores para double
					double celsiusDouble = Double.parseDouble(celsius);
					
					// Tratativa do zero absoluto
					if (celsiusDouble < -273.15) {
						labelMensagemErro.setBounds(60, 160, 240, 40);
						labelMensagemErro.setText("!!IMPOSSIVEL EXCEDER O ZERO ABSOLUTO!!");
						labelResultado.setText(null);
					} else {
						// Fornecendo os valores para o conversor
						Temperatura temperaturaKelvin = new Temperatura(celsiusDouble);
									
						// Mostrando a temperatura convertida na tela
						labelResultado.setText(temperaturaKelvin.converterParaFahreinhet()+" Fahrenheit");
						// Limpa a mensagem de erro
						labelMensagemErro.setText(null);
					}
					
				} catch (NumberFormatException e2) {
					labelMensagemErro.setBounds(90, 160, 240, 40);
					labelMensagemErro.setText("!!DIGITE UM VALOR VÁLIDO!!");
					labelResultado.setText(null);
				}
			}
							
				
			}
		});
		
		tela.setVisible(true);
	}
}
