package Utils;

import java.util.Scanner;
// Simplifica o uso de println()
import static java.lang.System.out;
// Saída para informar erros
import static java.lang.System.err;

/**
 * Facilita a leitura e a escrita no console.
 * 
 * @author the-linck
 *
 */
public class Console {
	/**
	 * Leitor da entrada de dados.
	 */
	private final Scanner leitor;

	/**
	 * Inicia com as configurações padrão.
	 */
	public Console() {
		leitor = new Scanner(System.in);
	}

	/**
	 * Lê um número digitado pelo usuário.
	 * 
	 * @return Número digitado pelo usuário
	 * @throws NumberFormatException
	 *             Se o usuário digitar um valor inválido
	 */
	public String readNumber() throws NumberFormatException {
		return leitor.next().toLowerCase().replace(',', '.');
	}

	/**
	 * Indica se o usuário deseja sair do programa.
	 * 
	 * @return True se o usuário deseja sair, false caso contrário
	 */
	public boolean readExit() {
		return leitor.next().toLowerCase().matches("s(air)?");
	}

	/**
	 * Exibe uma mensagem para o usuário, quebrando a linha após ela.
	 * 
	 * @param message
	 *            Mensagem a ser exibida
	 */
	public void showMessage(Object message) {
		showMessage(message, true);
	}

	/**
	 * Exibe uma mensagem para o usuário.
	 * 
	 * @param message
	 *            Mensagem a ser exibida
	 * @param newLine
	 *            Indica se deve-se quebrar a linha ao fim da mensagem
	 */
	public void showMessage(Object message, boolean newLine) {
		if (newLine) {
			out.println(message);
		} else {
			out.print(message);
		}
	}

	/**
	 * Informa um erro para o usuário, quebrando a linha no final.
	 * 
	 * @param message
	 *            Mensagem a ser exibida
	 * @param erro
	 *            Erro a ser informado
	 */
	public void showError(Object message, Exception erro) {
		showError(message, erro, true);
	}

	/**
	 * Informa um erro para o usuário.
	 * 
	 * @param message
	 *            Mensagem a ser exibida
	 * @param erro
	 *            Erro a ser informado
	 * @param newLine
	 *            Indica se deve-se quebrar a linha ao final
	 */
	public void showError(Object message, Exception erro, boolean newLine) {
		if (newLine) {
			err.println(message);
		} else {
			err.print(message);
		}
	}
}
