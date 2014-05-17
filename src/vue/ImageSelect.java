package vue;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 * 
 * Enum de séléction de l'image correspondante.
 * 
 * @author Alexis LE GOADEC
 *
 */
public enum ImageSelect {

	GRENOUILLE        ("vue/ressource/grenouille.png"),
	GRENOUUILLE_M	  ("vue/ressource/grenouille_m.png"),
	NENUPHARE         ("vue/ressource/nenuphare.png"),
	NENUPHARE_DOPANT  ("vue/ressource/nenuphare_mor.png"),
	NENUPHARE_NUTRITIF("vue/ressource/nenuphare_nut.png"),
	NENUPHARE_VENENEUX("vue/ressource/nenuphare_ven.png"),
	NENUPHARE_MORTEL  ("vue/ressource/nenuphare_mor.png"),
	LIFE_IMG          ("vue/ressource/life.png"),
	DEFAULT           ("vue/ressource/eau.png");
	
	String cheminIcone;
	ImageIcon icone;
	
	/**
	 * constructeur prennant en paramètre le chemin de l'image à afficher.
	 * @param c String correspondant au chemin de l'image.
	 */
	ImageSelect(String c) {
		cheminIcone = c;
    	ClassLoader loader = ImageSelect.class.getClassLoader();
    	URL url = loader.getResource(cheminIcone);
    	icone = new ImageIcon(url);
	}
	
	/**
	 * Obtenir la référence de l'image correspondante.
	 * @return l'ImageIcon de l'image voulue.
	 */
	ImageIcon getThisImage() {
    	return icone;
	}
	
}
