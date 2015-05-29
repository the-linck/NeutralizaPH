package App;

import java.util.Arrays;
import java.util.Optional;

/**
 * Classe base para o programa em linha de comando e para o programa em
 * interface gráfica.
 * 
 * @author the-linck
 * @version 0.1
 */
public abstract class Application {
	/**
	 * Parâmetros de inicialização.
	 */
	protected static String[] cmdArgs = null;

	/**
	 * Armazena os parâmetros de inicialização, se já não estiver armazenados
	 * 
	 * @param cmdArgs
	 *            Parâmetros de inicialização
	 */
	public static void storeCmdArgs(String[] cmdArgs) {
		if (Application.cmdArgs == null) {
			Application.cmdArgs = cmdArgs;
		}
	}

	/**
	 * Verifica se o parâmetro de inicialização procurado foi informado.
	 * 
	 * @param find
	 *            Parâmetro de inicialização para procurar
	 * @return True se o parâmetro existe ou false
	 */
	public static boolean hasArgument(String find) {
		return Arrays.stream(cmdArgs).filter(x -> x.equals(find)).findFirst()
				.isPresent();
	}

	/**
	 * Informa o valor do parâmetro de inicialização procurado.
	 * 
	 * @param find
	 *            Parâmetro de inicialização para procurar
	 * @return Valor do parâmetro (se existir) ou uma String vazia
	 */
	public static String getArgument(String find) {
		Optional<String> argument = Arrays.stream(cmdArgs)
				.filter(x -> x.startsWith(find)).findFirst();
		if (argument.isPresent()) {
			return argument.get().replaceFirst("^\\w+=(\\w+)$", "$1");
		} else {
			return "";
		}
	}

	/**
	 * Realiza configurações comuns à interface gráfica e à linha de comando.
	 * Ainda não usado nessa versão.
	 * 
	 */
	public Application() {
	}

	/**
	 * Executa o programa.
	 */
	public abstract void executar();
}
