package presentateur;

import modele.*;
import vue.*;

/**
 * La classe principale du présentateur, réalisant la jonction
 * entre la Vue et le Modèle, principalement pour les options
 * majeures.
 * 
 * @author Alexis LE GOADEC
 *
 */
public class Presentateur {

	final int resolutionMin, resolutionMax;
	GrenouillolandGame gGame;

	Vue vue;
	
	/**
	 * Le constructeur, initialisant également la vue et le
	 * modèle, en fonctino des résolutions choisies.
	 * 
	 * @param resolutionMin Résolution minimum
	 * @param resolutionMax Resolution maximum
	 * @param resolution Résolution en cours
	 */
	public Presentateur(int resolutionMin,
						int resolutionMax,
						int resolution){

		this.resolutionMin = resolutionMin;
		this.resolutionMax = resolutionMax;

		this.gGame = new GrenouillolandGame(resolution);
		this.gGame.placementCarte();

		vue   = new Vue(this);
	}

	/**
	 * Démarrage de l'interface et du chronomètre.
	 */
	public void Start(){
		vue.pack();
		vue.setVisible(true);
		vue.temps.startBar();
	}
	
	/**
	 * Suite à l'appuie de l'utilisateur sur un bouton,
	 * on passe les coordonnées au modèle, pour valider (ou non)
	 * le déplacement désiré.
	 * 
	 * @param x Abscisse du déplacement
	 * @param y Ordonnée du déplacement
	 * @return True si la partie est réussi, False si la partie n'est pas fini.
	 */
	public boolean Jouer(int x, int y){
		return gGame.jouer(x, y);
	}
	
	/**
	 * CallBack appelé pour actualiser le jeu.
	 */
	public synchronized void cbActualiser(){
		this.gGame.placementCarte();
		this.vue.cbMiseAJour();
	}

	/**
	 * Recommencer depuis le début de la partie, en fonction
	 * de la résolution.
	 * 
	 * @param resolution La résolution choisi pour la nouvelle partie 
	 */
	public void gameReload(int resolution){
		this.vue.temps.stopBar();
		this.gGame = new GrenouillolandGame(resolution);
		this.gGame.placementCarte();
		this.vue.temps.startBar();
	}
	
	/**
	 * Obtenir la résolution minimum applicable
	 * @return Entier correspondant à la résolution minimum.
	 */
	public int getResolutionMin(){
		return this.resolutionMin;
	}
	
	/**
	 * Obtenir la résolution maximum applicable
	 * @return Entier correspondant à la résolution maximum.
	 */
	public int getResolutionMax(){
		return this.resolutionMax;
	}

	/**
	 * Obtenir la résolution actuelle
	 * @return Entier correspondant à la résolution actuelle.
	 */
	public int getCurrentResolution(){
		return this.gGame.getResolution();
	}
	
	/**
	 * Renvoyer la référence du présentateur
	 * @return La référence du présentateur
	 */
	public Presentateur getPresentateur(){
		return this;
	}
	
	/**
	 * Connaitre l'état (morte ou vivante) de la grenouille.
	 * @return True si la grenouille est morte, False sinon.
	 */
	public boolean isDead(){
		return this.gGame.isGrenouilleDead();
	}
	
	/**
	 * Obtenir les points de vie en cours de la grenouille.
	 * @return Un entier correspondant aux points de vie.
	 */
	public int getPointDeVie(){
		return this.gGame.getPointDeVie();
	}
	
	/**
	 * Obtenir la référence d'image de l'élément d'une case
	 * @param ligne La ligne de la case
	 * @param colonne La colonne de la case
	 * @return La référence d'image à positionner
	 */
	public ImageSelect imageCellule(int ligne,int colonne){
		
		if(colonne==this.gGame.grenouilleX() &&
		   ligne==this.gGame.grenouilleY()){
			if(this.gGame.isGrenouilleInfected()){
				return ImageSelect.GRENOUUILLE_M;
			}
			return ImageSelect.GRENOUILLE;
		}
		
		final Effet e = this.gGame.getElement(colonne, ligne).getEffet();
		
		if(e.equals(Effet.NENUPHARE)){
			return ImageSelect.NENUPHARE;
		};
		
		if(e.equals(Effet.NENUPHARE_DOPANT)){
			return ImageSelect.NENUPHARE_DOPANT;
		};
		
		if(e.equals(Effet.NENUPHARE_NUTRITIF)){
			return ImageSelect.NENUPHARE_NUTRITIF;
		};
		
		if(e.equals(Effet.NENUPHARE_VENENEUX)){
			return ImageSelect.NENUPHARE_VENENEUX;
		};
		
		if(e.equals(Effet.NENUPHARE_MORTEL)){
			return ImageSelect.NENUPHARE_MORTEL;
		};
		
		return ImageSelect.DEFAULT;
		
	}
	
}
