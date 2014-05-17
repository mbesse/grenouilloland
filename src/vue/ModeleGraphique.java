package vue;

import presentateur.Presentateur;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 * 
 * Classe représentant le plateau graphique du jeu. C'est une classe dérivée
 * de JPanel, afin d'optimiser le positionnement des éléments sur l'interface.
 * 
 * @author Alexis LE GOADEC
 *
 */
class ModeleGraphique extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected final Vue vue;
	protected final Case[][] cellules;

	/**
	 * Initialisation du modèle graphique, en préparant et en plaçant les
	 * élements, selon leur type et leurs coordonnées.
	 * @param vue La référence de la vue en cours.
	 */
	public ModeleGraphique(Vue vue) {

		this.vue = vue;
		final Presentateur presentateur = vue.presentateur;

		final int resolution = presentateur.getCurrentResolution();

		cellules = new Case[resolution][resolution];
		for (int i = 0; i < resolution; i ++) {
			for (int j = 0; j < resolution; j ++) {
				cellules[i][j] = new Case(this, i, j);
				cellules[i][j].setPreferredSize( new Dimension(80, 80) );
			};
		};

		final int dimension = resolution + 2;
		setLayout(new GridLayout(dimension, dimension, 0, 0));

		for (int i = 0; i < dimension; i ++) {
			final JButton bouton = new JButton();
			bouton.setVisible(false);
			bouton.setEnabled(false);
			add(bouton);
		};

		for (int i = 0; i < resolution; i ++) {

			{
				final JButton bouton = new JButton();
				bouton.setVisible(false);
				bouton.setEnabled(false);
				add(bouton);
		    }

			for (int j = 0; j < resolution; j ++) {
				ImageSelect im = ImageSelect.DEFAULT;
				cellules[i][j].setIcon(im.getThisImage());
				add(cellules[i][j]);
			};

			{
				final JButton bouton = new JButton();
				bouton.setVisible(false);
				bouton.setEnabled(false);
				add(bouton);
		    }
		};

		for (int i = 0; i < dimension; i ++) {
			final JButton bouton = new JButton();
			bouton.setVisible(false);
			bouton.setEnabled(false);
			add(bouton);
		};
		
		this.mettreAJour();
    }

	/**
	 * Obtenir la référence de la vue en cours.
	 * @return La référence de la vue en cours.
	 */
	public Vue lireVue() {
		return vue;
	}

	/**
	 * Mise à jour cellule par cellule du plateau de jeu.
	 */
	protected void mettreAJour() {
		for (int i = 0; i < cellules.length; i ++) {
			for (int j = 0; j < cellules.length; j ++) {
				cellules[i][j].mettreAJour();
			};
		};
	}
}
