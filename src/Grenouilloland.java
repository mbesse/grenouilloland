
import presentateur.*;

/**
 * Il s'agit de la classe contenant le Main. cette fonction
 * est le démarreur de l'application.
 * 
 * @author Alexis LE GOADEC
 *
 */
public class Grenouilloland {

	static Presentateur presentateur;
	
	/**
	 * Fonction de lancement de l'application.
	 * @param args Les arguments en ligne de commande.
	 */
	public static void main(String[] args){
		presentateur = new Presentateur(5, 10, 5);
		presentateur.Start();
	}

}
