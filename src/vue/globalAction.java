package vue;

import javax.swing.AbstractAction;
import javax.swing.Icon;

/**
 * Classe abstraite pour la supervision des commandes
 * (Nouvelle partie, A Propos, Quitter).
 * 
 * @author Alexis LE GOADEC
 *
 */
abstract class globalAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	protected Vue vue;
	
	/**
	 * Paramétrage complet d'une commande via ce constructeur
	 * @param nom Nom de la commande
	 * @param icone Icone de la commande
	 * @param vue Référence de la vue en cours
	 */
	public globalAction(String nom, Icon icone, Vue vue){
		super(nom, icone);
		this.vue = vue;
	}
	
	/**
	 * Obtenir la référence de la vue en cours.
	 * @return La référence de la vue en cours
	 */
	public Vue getVue(){
		return this.vue;
	}

}
