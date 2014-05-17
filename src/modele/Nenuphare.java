package modele;

/**
 * Cette classe modélise un nénuphare, prenant en compte
 * ses coordonnées, ses effets, et son vieillissement.
 * 
 * @author Alexis LE GOADEC
 *
 */
public class Nenuphare implements Element {

	/**
	 * Contient un enum de l'effet à produire sur
	 * la grenouille.
	 */
	final Effet effet;

	/**
	 * Cette variable est l'âge de l'élement.
	 */
	Age   elementAge;
	
	/**
	 * Les coordonnées de l'élement dans le jeu.
	 */
	int   x, y;
	
	/**
	 * Constructeur du nénuphare. Cette méthode configure l'élement
	 * en précisant sont effet et son âge.
	 * @param effet Element d'énumeration précisant l'effet à donner.
	 * @param elementAge Variable contenant la definition de l'âge de l'élement.
	 */
	public Nenuphare(Effet effet, Age elementAge){
		this.effet       = effet;
		this.elementAge  = elementAge;
	}
	
	/**
	 * Constructeur du nénuphare. Cette méthode configure l'élement
	 * en précisant sont effet et son âge, ainsi que ses coordonnées.
	 * @param effet Element d'énumeration précisant l'effet à donner.
	 * @param elementAge Variable contenant la definition de l'âge de l'élement.
	 * @param x Absisse de l'élement dans le jeu.
	 * @param y Ordonnée de l'élement dans le jeu.
	 */
	public Nenuphare(Effet effet, Age elementAge, int x, int y){
		this.x          = x;
		this.y          = y;
		this.elementAge = elementAge;
		this.effet      = effet;
	}
	
	/**
	 * Méthode provoquant un effet sur la grenouuille en fonction
	 * du type d'élement.
	 * @param g L'instance de la grenouille.
	 */
	public void doEffet(Grenouille g){
		effet.doEffet(g);
	}
	
	/**
	 * Obtenir le type Enum de l'effet en cours du nénuphare.
	 */
	public Effet getEffet(){
		return this.effet;
	}
	
	/**
	 * Cette méthode fait vieillir d'une unité l'élement
	 * en cours, si il est apte à vieillir (nénuphare non-immortel).
	 */
	public void vieillir() {
		if(!this.elementAge.equals(Age.IMMORTEL)){
			this.elementAge = Age.values()[this.elementAge.ordinal() - 1];
		};
	}
	
	/**
	 * Méthode provoquant un effet sur la grenouuille en fonction
	 * du type d'élement.
	 * @param g L'instance de la grenouille.
	 */
	public int getAge(){
		return this.elementAge.getAge();
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
