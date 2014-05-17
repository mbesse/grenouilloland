package vue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Cette classe est la dérivée de l'élément JButton implémentant la
 * classe de gestion des évenements, correspondant à un élément
 * directement interactif du jeu.
 * 
 * @author Alexis LE GOADEC
 *
 */
class Case extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	
    protected final ModeleGraphique modeleGraphique;
    protected final int ligne;
    protected final int colonne;

    /**
     * Construction de la case.
     * @param modeleGraphique Référence du modèle graphique
     * @param ligne Ligne de la case
     * @param colonne Colonne de la case
     */
	public Case(ModeleGraphique modeleGraphique, int ligne, int colonne) {

		this.ligne = ligne;
		this.colonne = colonne;

		this.modeleGraphique = modeleGraphique;
		addActionListener(this);
	}

	/**
	 * Obtenir la référence du modèle graphique
	 * @return La référence du midèle graphique
	 */
	public ModeleGraphique lireModeleGraphique() {
		return modeleGraphique;
	}

	/**
	 * Renvoi la ligne de la case correspondante
	 * @return Un entier
	 */
	protected int lireLigne() {
		return ligne;
	}

	/**
	 * Renvoi la colonne de la case correspondante
	 * @return Un entier
	 */
	protected int lireColonne() {
		return colonne;
	}

	/**
	 * Action a effectuer en cas de clique de l'utilisateur
	 */
    public void actionPerformed(ActionEvent evt) {
    	this.modeleGraphique.vue.cbJouer(this.colonne, this.ligne);
    }

    /**
     * Mise à jourindividuelle de la case.
     */
    protected void mettreAJour() {
    	final ImageSelect is = this.modeleGraphique.vue.presentateur.imageCellule(ligne, colonne);
    	this.setIcon(is.getThisImage());
    }
}
