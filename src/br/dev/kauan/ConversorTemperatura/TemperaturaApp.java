package br.dev.kauan.ConversorTemperatura;

import br.dev.kauan.ConversorTemperatura.gui.TelaConversor;
import br.dev.kauan.ConversorTemperatura.model.Temperatura;

public class TemperaturaApp {

	public static void main(String[] args) {
//		Temperatura temperatura = new Temperatura();
//		temperatura.Testar();
		
		TelaConversor conversor = new TelaConversor();
		conversor.criarTelaConversor("Conversor de Temperatura");
	}

}
