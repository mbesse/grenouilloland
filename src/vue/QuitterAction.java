package vue;

import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

/**
 * Dérivée de la classe de supervisino des commandes,
 * correspondant à l'action "Quitter".
 * 
 * @author Alexis LE GOADEC
 *
 */
class QuitterAction extends globalAction {
	
	private static final long serialVersionUID = 1L;

	protected static final ImageIcon icone;
	protected static final String nom = "Quitter";
	protected static final String cheminIcone = "vue/ressource/quit.png";
	
	static {
    	ClassLoader loader = AboutAction.class.getClassLoader();
    	URL url = loader.getResource(cheminIcone);
    	icone = new ImageIcon(url);
    }
	
    /**
     * Instanciation de la classe, en paramètrant la classe-mère.
     * @param vue La référence de la Vue en cours.
     */
	public QuitterAction(Vue vue){
		super(nom, icone, vue);
	}
	
	/**
	 * Déclancher une boîte de dialogue affichant le
	 * message du "Quitter".
	 */
    public void actionPerformed(ActionEvent e){
    	this.vue.quitterApp();
    }
}
