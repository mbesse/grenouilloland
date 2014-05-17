package vue;

import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

/**
 * Dérivée de la classe de supervisino des commandes,
 * correspondant à l'action "A Propos".
 * 
 * @author Alexis LE GOADEC
 *
 */
class AboutAction extends globalAction {

	private static final long serialVersionUID = 1L;

	protected static final ImageIcon icone;
	protected static final String nom = "apropos";
    protected static final String cheminIcone = "vue/ressource/about.png";
	protected final String message = "Grenouilloland - Version 1.0\r\nAuteurs: Alexis LE GOADEC, Elodie VAUDORE\r\n"+
									 "Projet de CPOO - Licence Informatique,\r\nUniversité de Caen, 2012-2013.";
	
    static {
    	ClassLoader loader = AboutAction.class.getClassLoader();
    	URL url = loader.getResource(cheminIcone);
    	icone = new ImageIcon(url);
    }
	
    /**
     * Instanciation de la classe, en paramètrant la classe-mère.
     * @param vue La référence de la Vue en cours.
     */
	public AboutAction(Vue vue){
		super(nom, icone, vue);
	}
	
	/**
	 * Déclancher une boîte de dialogue affichant le
	 * message du "A Propos".
	 */
    public void actionPerformed(ActionEvent e){
    	this.vue.msgBox(message);
    }
}
