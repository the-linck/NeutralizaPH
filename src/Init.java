import App.Application;
import App.Terminal;

/**
 * Classe inicial do programa. Verifica se ele será executado pelo terminal ou
 * por interface gráfica. TODO: criar interface gráfica.
 * 
 * @author the-linck
 * @version 0.1
 */
public final class Init {
	/**
	 * Parte funcional do programa.
	 */
	private static Application app;

	/**
	 * Inicia o programa.
	 * 
	 * @param cmdArgs
	 *            Parâmetros de inicialização.
	 */
	public static void main(String[] cmdArgs) {
		Application.storeCmdArgs(cmdArgs);
		// Permite descobrir se o programa foi iniciado com o argumento
		// <em>console</em>, que força a usar o terminal ao invés de GUI
		// Será usado em versões futuras
		// if (Application.hasArgument("console", cmdArgs)) {
		// // Executar pelo terminal
		app = new Terminal();
		// } else {
		// // Executar pela interface gráfica
		// }
		app.executar();
	}

}
