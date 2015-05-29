package App;

import Utils.Console;

/**
 * Interface de linha de comando do programa.
 * 
 * @author the-linck
 * @version 0.1
 *
 */
public final class Terminal extends Application {
	/**
	 * Mensagem exibida para pergunta ao usuário o volume de água
	 */
	private final String mensagemVolume = "Informe o volume (em litros) de água: ";
	/**
	 * Mensagem exibida para pergunta ao usuário o pH da água
	 */
	private final String mensagemPh = "Informe o ph da água: ";

	/**
	 * Objeto que centraliza as ações da linha de comando.
	 */
	private final Console console;

	/**
	 * Indica se o programa deve ser executado só uma vez.
	 */
	private boolean singleRun;

	/**
	 * Volume de água.
	 */
	private double volume;

	/**
	 * pH da água.
	 */
	private double phInicial;

	/**
	 * Configura o programa.
	 */
	public Terminal() {
		console = new Console();
		singleRun = hasArgument("simples");
		String arg = getArgument("volume");
		if (arg.isEmpty()) {
			volume = Double.NEGATIVE_INFINITY;
		} else {
			singleRun = true;
			lerVolume(arg);
		}
		arg = getArgument("ph");
		if (arg.isEmpty()) {
			phInicial = Double.NEGATIVE_INFINITY;
		} else {
			singleRun = true;
			lerPh(arg);
		}
	}

	/**
	 * Formata um número para ter até 2 casas decimais.
	 * 
	 * @param number
	 *            Número para formatar
	 * @return Número fomatado com no máximo 2 casas decimais.
	 */
	private String formatNumber(double number) {
		return Double.toString(number).replaceFirst("(\\d+)\\.(\\d{1,2})\\d+",
				"$1.$2");
	}

	/**
	 * Lê o volume de água a partir do terminal.
	 */
	private void lerVolume() {
		lerVolume(console.readNumber());
	}

	/**
	 * Verifica se o volume informado é válido.
	 * 
	 * @param vol
	 *            Volume para verificar
	 */
	private void lerVolume(String vol) {
		try {
			volume = Double.parseDouble(vol);
		} catch (NumberFormatException erro) {
			console.showError("O volume deve ser um número", erro);
			volume = Double.NEGATIVE_INFINITY;
		}
	}

	/**
	 * Lê o pH a partir do terminal.
	 */
	private void lerPh() {
		lerPh(console.readNumber());
	}

	/**
	 * Verifica se o pH informado é válido
	 * 
	 * @param ph
	 *            pH para verificar
	 */
	private void lerPh(String ph) {
		try {
			phInicial = Double.parseDouble(ph);
			if (phInicial < 0 || phInicial > 7) {
				console.showError("O pH deve estar entre 0 e 7", null);
				phInicial = Double.NEGATIVE_INFINITY;
			}
		} catch (NumberFormatException erro) {
			console.showError("O pH inicial deve ser um número", erro);
			phInicial = Double.NEGATIVE_INFINITY;
		}
	}

	/**
	 * Executa o programa através da linha de comando.
	 * 
	 */
	@Override
	public void executar() {
		console.showMessage("----NeutralizaPH----\n");
		console.showMessage("-Neutralização de água ácida com CaOH (cal)-\n");
		if (singleRun) {
			_executar();
		} else {
			do {
				_executar();
				volume = Double.NEGATIVE_INFINITY;
				phInicial = Double.NEGATIVE_INFINITY;
				console.showMessage("\nSimulação concluída\nInsira [s] para sair ou outro caractere para continuar.");
			} while (!console.readExit());
		}
		console.showMessage("\n----Até logo----\n");
	}

	/**
	 * Realiza a interação com o usuário.
	 */
	private void _executar() {
		while (volume == Double.NEGATIVE_INFINITY) {
			console.showMessage(mensagemVolume, false);
			lerVolume();
		}
		while (phInicial == Double.NEGATIVE_INFINITY) {
			console.showMessage(mensagemPh, false);
			lerPh();
		}
		console.showMessage("\nPara neutralizar " + formatNumber(volume)
				+ "l de água com pH " + formatNumber(phInicial)
				+ " são necessários:\n", false);
		double qtNeutralizante = (7 - phInicial) * (volume / 10.55);
		String _qtNeutralizante = formatNumber(qtNeutralizante);
		console.showMessage("    " + _qtNeutralizante
				+ "g de cal (CaOH)");
	}
}
