package vue;

import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

/**
 * Dérivée de la classe de supervisino des commandes,
 * correspondant à l'action "Nouveau jeu".
 * 
 * @author Alexis LE GOADEC
 *
 */
class NouveauAction extends globalAction {
	
	private static final long serialVersionUID = 1L;

	protected static final ImageIcon icone;
	protected static final String nom = "Nouveau";
    protected static final String cheminIcone = "vue/ressource/new.png";
	
    /**
     * Instanciation de la classe, en paramètrant la classe-mère.
     * @param vue La référence de la Vue en cours.
     */
	public NouveauAction(Vue vue){
		super(nom, icone, vue);
	}
	
	static {
    	ClassLoader loader = AboutAction.class.getClassLoader();
    	URL url = loader.getResource(cheminIcone);
    	icone = new ImageIcon(url);
	}
	
	/**
	 * Déclancher une boîte de dialogue affichant le
	 * message du "Nouveau Jeu".
	 */
	public void actionPerformed(ActionEvent e){
    	this.vue.recommencer(vue.presentateur.getCurrentResolution());
	}
}
