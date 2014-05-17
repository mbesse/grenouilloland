package vue;

import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

/**
 * Classe dérivant la barre d'ajustement de l'élement ScrollBar
 * afin de régler la résolution de la partie.
 * 
 * @author Alexis LE GOADEC
 *
 */
class Resolution extends JScrollBar implements AdjustmentListener {

	private static final long serialVersionUID = 1L;

	protected Vue vue;
	
	/**
	 * Constructeur de l'outil de réglage de la résolution
	 * de la partie.
	 * @param orientation L'orientation de la barre d'outil
	 * @param vue Référence de la vue en cours.
	 */
    public Resolution(int orientation, Vue vue) {

		super(orientation,
		      vue.presentateur.getCurrentResolution(),
		      1,
		      vue.presentateur.getResolutionMin(),
		      vue.presentateur.getResolutionMax() + 1);

		this.vue = vue;

		addAdjustmentListener(this);

    }

    /**
     * Obtenir la vue en cours.
     * @return
     */
    public Vue getVue() {
    	return this.vue;
    }

    /**
     * Précision du CallBack à appeler en cas d'ajustement.
     */
	public void adjustmentValueChanged(AdjustmentEvent evt) {
		vue.cbReformer( this.getValue() );
    }
}
