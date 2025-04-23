package br.dev.kauan.ConversorTemperatura.model;

import java.util.Scanner;

public class Temperatura {
	//Atributo
	private double celsius;
	
	//Métodos
	
	public double getCelsius() {
		return celsius;
		
	}
	
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	
	public double converterParaKelvin() {
		double kelvin;
		kelvin = celsius + 273.15;
		return kelvin;
	}
	
	public double converterParaFahreinhet() {
		double fahreinhet = 0;
		fahreinhet = (celsius*1.8)+32;
		return fahreinhet;
	}
	
//	public void Testar() {
//		System.out.println("-----------------------------");
//		System.out.println("Digite um valor em Célsius:");
//		Scanner reader = new Scanner(System.in);
//		celsius = reader.nextDouble();
//		System.out.println("-----------------------------");
//		System.out.println("Resultado em kelvin: "+converterParaKelvin());
//		System.out.println("Resultado em Fahreinhet: "+converterParaFahreinhet());
//		System.out.println("-----------------------------");
//		
//	}
}
