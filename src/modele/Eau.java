package modele;

/**
 * 
 * Classe représentant l'Eau de la marre, dans le modèle de
 * l'application.
 * 
 * @author Alexis LE GOADEC
 *
 */
public class Eau implements Element {

	/**
	 * Contient un enum de l'effet à produire sur
	 * la grenouille.
	 */
	final Effet effet;
	
	/**
	 * Les coordonnées de l'élement dans le jeu.
	 */
	int   x, y;
	
	/**
	 * Constructeur de l'élement d'eau du jeu. L'effet est mortel sur
	 * la grenouille. On le configure irréversiblement ainsi.
	 */
	public Eau(){
		this.effet = Effet.EAU;
	}
	
	/**
	 * Constructeur de l'élement d'eau du jeu. L'effet est mortel sur
	 * la grenouille. On le configure irréversiblement ainsi.
	 * @param x Absisse de l'élement dans le jeu.
	 * @param y Ordonnée de l'élement dans le jeu.
	 */
	public Eau(int x, int y){
		this.x     = x;
		this.y     = y;
		this.effet = Effet.EAU;
	}

	/**
	 * Méthode provoquant un effet sur la grenouuille en fonction
	 * du type d'élement.
	 * @param g L'instance de la grenouille.
	 */
	public void doEffet(Grenouille g){
		effet.doEffet(g);
	}
	
	public Effet getEffet(){
		return this.effet;
	}
	
	/**
	 * Cette méthode fait vieillir d'une unité l'élement
	 * en cours. Ici, s'agissant de l'eau, l'élement ne vieillit pas.
	 */
	public void vieillir() {
		return;
	}

	/**
	 * Méthode provoquant un effet sur la grenouuille en fonction
	 * du type d'élement.
	 * @param g L'instance de la grenouille.
	 */
	public int getAge(){
		return -1;
	}
	
	/**
	 * Définir la position de l'absisse de l'élement en cours.
	 * @param x Position de l'élement à l'absisse.
	 */
	public void setX(int x){
		this.x = x;
	}
	
	/**
	 * Définir la position de l'ordonnée de l'élement en cours.
	 * @param y Position de l'élement à l'ordonnée.
	 */
	public void setY(int y){
		this.y = y;
	}
	
	/**
	 * Obtenir la coordonnée en absisse de l'élement.
	 * @return Un entier correspondant à l'absisse.
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * Obtenir la coordonnée en ordonnée de l'élement.
	 * @return Un entier correspondant à l'ordonnée.
	 */
	public int getY(){
		return this.y;
	}
	
}
