package vue;

import presentateur.*;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

/**
 * 
 * Classe principale de la vue correspondant à la dérivée
 * d'un JFrame pour la construction de la fenêtre.
 * 
 * @author Alexis LE GOADEC
 *
 */
public class Vue extends JFrame {
	
	private static final long serialVersionUID = 1L;

	final String appTitre = "Jeu du Grenouilloland";
	final Presentateur presentateur;
	final Resolution   sResolution;
	final JLabel lifeLabel;
	ModeleGraphique plan;
	public Temps temps;
	
	/**
	 * Construction de la fenêtre aisin que de tous les élements
	 * du jeu, et les barres de commandes.
	 * 
	 * @param presentateur La référence du présentateur.
	 */
	public Vue(Presentateur presentateur) {
		
		this.presentateur = presentateur;
		this.construireToolBar();

		this.sResolution  = new Resolution(JScrollBar.HORIZONTAL, this);
		this.plan = new ModeleGraphique(this);
		this.lifeLabel = new JLabel(presentateur.getPointDeVie() + " point(s) de vie . ", ImageSelect.LIFE_IMG.getThisImage(), JLabel.HORIZONTAL);
		temps = new Temps(this, this.presentateur);

		add(plan, BorderLayout.CENTER);
		add(sResolution, BorderLayout.SOUTH);
		add(temps, BorderLayout.BEFORE_LINE_BEGINS);
		add(lifeLabel, BorderLayout.EAST);
		
		setTitle(this.appTitre);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
					quitterApp();
				}
		});
		
	}
	
	/**
	 * Construction de la barre d'outil et de la barre
	 * de Menu.
	 */
	void construireToolBar(){
		final JToolBar toolBar = new JToolBar();
		final JMenuBar barreMenus = new JMenuBar();
		final JMenu menu = new JMenu("Commandes");		

		final AboutAction aboutAction = new AboutAction(this);
		final NouveauAction nouveauAction = new NouveauAction(this);
		final QuitterAction quitterAction = new QuitterAction(this);
		
		menu.add(nouveauAction);
		menu.add(aboutAction);
		menu.addSeparator();
		menu.add(quitterAction);
		
		toolBar.add(nouveauAction);
		toolBar.add(aboutAction);
		toolBar.addSeparator();
		toolBar.add(quitterAction);
		
		barreMenus.add(menu);
		setJMenuBar(barreMenus);
		
		add(toolBar, BorderLayout.NORTH);
	}
	
	/**
	 * Réinitialiser la partie, sans changer la résolution.
	 */
	protected synchronized void cbReinitialiser() {
		recommencer(presentateur.getCurrentResolution());
	}
	
	/**
	 * Callback recommançant la partie avec la nouvelle résolution.
	 * @param resolution
	 */
	protected synchronized void cbReformer(int resolution){
		recommencer(resolution);
	}
	
	/**
	 * Mise à jour de l'afficheur des points de vie ainsi que du jeu.
	 */
	public synchronized void cbMiseAJour(){
		this.lifeLabel.setText(presentateur.getPointDeVie() + " point(s) de Vie . ");
		this.plan.mettreAJour();
	}
	
	/**
	 * Callback permettant de proposer au modèle les coordonnées
	 * du coups joué par l'utilisateur.
	 * @param x La coordonnée d'abscisse
	 * @param y La coordonnée d'ordonnée
	 */
	protected synchronized void cbJouer(int x, int y){
		if( presentateur.Jouer(x, y) ){
			this.msgGagner();
			recommencer(presentateur.getCurrentResolution());
		};
		if( presentateur.isDead() ){
			this.msgPerdu();
			recommencer(presentateur.getCurrentResolution());
			return;
		};
		this.plan.mettreAJour();
	}
	
	/**
	 * Affichage du message de victoire à l'utilisateur.
	 */
	public void msgGagner(){
		final String text = "Gagné !\r\n"+
							 "Vous venez de remporter la partie avec:\r\n"+
							 this.presentateur.getPointDeVie()+" point(s) de vie !";
		this.msgBox(text);
	}

	/**
	 * Affichage du message de défaite à l'utilisateur.
	 */
	public void msgPerdu(){
		final String text = "Vous avez perdu !";
		this.msgBox(text);
	}
	
	/**
	 * Recommencer la partie, en suivant la résolution choisis.
	 * 
	 * @param resolution Un entier correspondant à la nouvelle resolution.
	 */
	protected void recommencer(int resolution){
		
		presentateur.gameReload(resolution);
		
		remove(plan);
		
		this.plan = new ModeleGraphique(this);
		add(plan, BorderLayout.CENTER);
		
		this.validate();
		this.repaint();
		
	}
	
	/**
	 * Afficher une boîte de dialogue.
	 * @param texte Afficher le texte
	 */
	protected void msgBox(String texte){
		JOptionPane.showMessageDialog(this, texte);
	}

	/**
	 * quitter l'application.
	 */
	protected void quitterApp(){
		System.exit(0);		
	}
	
}
