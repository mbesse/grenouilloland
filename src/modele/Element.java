package modele;

/**
 * Interface représentant les elements pouvant apparaitre dans le jeu (Eau et
 * Nénuphares).
 * 
 * @author Alexis LE GOADEC
 *
 */
public interface Element {

	/**
	 * Cette méthode fait vieillir d'une unité l'élement
	 * en cours. 
	 */
	public void vieillir();
	
	/**
	 * Définir la position de l'absisse de l'élement en cours.
	 * @param x Position de l'élement à l'absisse.
	 */
	public void setX(int x);
	/**
	 * Définir la position de l'ordonnée de l'élement en cours.
	 * @param y Position de l'élement à l'ordonnée.
	 */
	public void setY(int y);
	
	/**
	 * Obtenir la coordonnée en absisse de l'élement.
	 * @return Un entier correspondant à l'absisse.
	 */
	public int getX();
	/**
	 * Obtenir la coordonnée en ordonnée de l'élement.
	 * @return Un entier correspondant à l'ordonnée.
	 */
	public int getY();
	
	/**
	 * Obtenir l'age de l'élement en cours.
	 * @return L'age de l'élement. Retourne -1 si
	 * l'élement ne vieillit pas.
	 */
	public int getAge();
	
	/**
	 * Méthode provoquant un effet sur la grenouuille en fonction
	 * du type d'élement.
	 * @param g L'instance de la grenouille.
	 */
	public void doEffet(Grenouille g);
	
	/**
	 * Lecteur de l'effet de l'élement.
	 * @return Un enum de type Effet
	 */
	public Effet getEffet();
	
}
