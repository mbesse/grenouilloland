package modele;

/**
 * Cette classe modélise la grenouille.
 * @author Alexis LE GOADEC
 *
 */
public class Grenouille {

	/**
	 * Coordonnées de la grenouille dans le jeu.
	 */
	int x, y;
	
	/**
	 * Points de vie restant.
	 */
	int pointDeVie;
	
	/**
	 * Variable boolean indiquant si la grenouille est en vie
	 * ou non.
	 */
	boolean alive;
	
	/**
	 * Variable boolean indiquant si la grenouille est
	 * infectée ou non.
	 */
	boolean infectee;
	
	/**
	 * Initialisation de la grenouille avec son point de vie,
	 * et son état de santé.
	 */
	public Grenouille() {
		// Point de vie à 1
		this.pointDeVie = 1;
		// Déclarée en vie
		this.alive      = true;
		// Non-infectée
		this.infectee   = false;

	}
	
	/**
	 * Définir la position sur l'absisse de la grenouille.
	 * @param x Entier compris entre 0 et N-1, où N est le nombre
	 * de cases de l'absisse et l'ordonnée.
	 */
	void setX(int x){
		this.x = x;
	}
	
	/**
	 * Définir la position sur l'ordonnée de la grenouille.
	 * @param x Entier compris entre 0 et N-1, où N est le nombre
	 * de cases de l'absisse et l'ordonnée.
	 */
	void setY(int y){
		this.y = y;
	}
	
	/**
	 * Obtenir la position sur l'absisse de la grenouille.
	 * @return Un entier correspondant à l'absisse de la position de
	 * la grenouille.
	 */
	int getX(){
		return this.x;
	}

	/**
	 * Obtenir la position sur l'ordonnée de la grenouille.
	 * @return Un entier correspondant à l'ordonnée de la position de
	 * la grenouille.
	 */
	int getY(){
		return this.y;
	}
	
}
