package modele;

import java.util.Random;

/**
 * Classe de déroulement du jeu dans le modèle, en prenant en charge
 * chacun des élements du jeu.
 * 
 * @author Alexis LE GOADEC
 *
 */
public class GrenouillolandGame {

	int resolution;
	Grenouille grenouille;
	Element[][] carte;
	
	/**
	 * Constructeur initialisant le jeu en chargeant la grille
	 * des élements, ainsi que la grenouuille.
	 * 
	 * @param resolution Entier représentant la résolution désirée.
	 */
	public GrenouillolandGame(int resolution){
		
		this.resolution = resolution;
		this.carte = new Element[resolution][resolution];
		for(int a=0; a<resolution; a++)
			for(int b=0; b<resolution; b++){
				carte[a][b] = new Eau(a, b);
			};
		
		carte[0][resolution - 1] = new Nenuphare(Effet.NENUPHARE,
												 Age.IMMORTEL,
												 0,
												 resolution-1);
		carte[resolution - 1][0] = new Nenuphare(Effet.NENUPHARE,
												 Age.IMMORTEL,
				 								 0,
				 								 resolution-1);
		
		this.grenouille = new Grenouille();
		this.grenouille.setX(0);
		this.grenouille.setY(resolution - 1);
	}
	
	/**
	 * Valider le déplacement de la grenouille.
	 * 
	 * @param x Coordonnée d'absisse du nouveau déplacement
	 * @param y Coordonnée d'ordonnée du nouveau déplacement
	 * @return Un booléen validant ou non le déplacement
	 */
	public boolean deplacerGrenouille(int x, int y){
		
		if(x < 0 || y < 0 || x > resolution-1 || y > resolution-1){
			return false;
		};
		
		if( Math.abs(x - grenouille.getX()) > 1 ||
			Math.abs(y - grenouille.getY()) > 1 ){
			return false;
		};
		
		if( Math.abs(x - grenouille.getX()) +
			Math.abs(y - grenouille.getY()) > 1){
			return false;
		}
		
		return true;
	}

	/**
	 * Faire viellir chacun des éléments de la grille de jeu.
	 */
	public void vieillirCarte(){
		for(int a=0; a < resolution; a++)
			for(int b=0; b < resolution; b++){
				carte[a][b].vieillir();
				if(carte[a][b].getAge()==0){
					carte[a][b] = new Eau(a, b);
				};
			};
	}
	
	/**
	 * Replacer les nénuphares de façon à recréer un chemin
	 * entre la grenouille et le nénuphare final
	 */
	public void placementCarte(){
		
		this.vieillirCarte();
		
		Random rand = new Random();
		int actualX = grenouille.getX();
		int actualY = grenouille.getY();
		
		for(int x=actualX; x<resolution; x++){
			if(carte[x][0].getEffet().equals(Effet.EAU)){
				Effet e = Effet.values()[1 + (Math.abs(rand.nextInt()) % (Effet.values().length-1))];
				carte[x][0] = new Nenuphare(e, Age.GRAND, x, 0);
			};
			if(carte[x][actualY].getEffet().equals(Effet.EAU)){
				Effet e = Effet.values()[1 + (Math.abs(rand.nextInt()) % (Effet.values().length-1))];
				carte[x][actualY] = new Nenuphare(e, Age.GRAND, x, actualY);
			};
		};

		for(int y=actualY; y > 0; y--){
			if(carte[resolution-1][y].getEffet().equals(Effet.EAU)){
				Effet e = Effet.values()[1 + (Math.abs(rand.nextInt()) % (Effet.values().length-1))];
				carte[resolution-1][y] = new Nenuphare(e, Age.GRAND, resolution-1, y);
			};
			if(carte[actualX][y].getEffet().equals(Effet.EAU)){
				Effet e = Effet.values()[1 + (Math.abs(rand.nextInt()) % (Effet.values().length-1))];
				carte[actualX][y] = new Nenuphare(e, Age.GRAND, actualX, y);
			};
		};
	}
	
	/**
	 * Cette fonction consciste à déplacer la grenouille
	 * sur une case, et à infliger les conséquences du type
	 * de l'élément sur la grenouille.
	 * 
	 * @param x La coordonnée d'abscisse de la case de destination
	 * @param y La coordonnée d'ordonnée de la case de destination
	 * @return Un booléen, true si la grenouuille est arrivée, false sinon.
	 */
	public boolean jouer(int x, int y){
		
		if( !deplacerGrenouille(x, y) )return false;
		
		grenouille.setX(x);
		grenouille.setY(y);
		carte[x][y].doEffet(grenouille);
		
		if( estFini() )return true;		
		return false;
	}
	
	/**
	 * Comparaison des coordonnées de la grenouille à la case de
	 * destination finale, afin de déterminé si la partie est terminée.
	 * 
	 * @return True si la partie est fini, false sinon.
	 */
	public boolean estFini(){
		return(grenouille.getX()==resolution-1 &&
		   grenouille.getY()==0);
	}
	
	/**
	 * Obtenir la résolution en cours.
	 * @return Un entier correspondant à la résolution
	 */
	public int getResolution(){
		return this.resolution;
	}
	
	/**
	 * Obtenir l'élément à la case spécifiée par ses coordonnées.
	 * @param x La coordonnée de l'abscisse
	 * @param y La coordonnée de l'ordonnée
	 * @return Un type Element correspondant à l'élément de la case.
	 */
	public Element getElement(int x, int y){
		return this.carte[x][y];
	}
	
	/**
	 * Obtenir l'abscisse de la position de la grenouille.
	 * @return Un entier correspondant à l'abscisse de la grenouille
	 */
	public int grenouilleX(){
		return this.grenouille.getX();
	}
	
	/**
	 * Obtenir l'abscisse de la position de la grenouille.
	 * @return Un entier correspondant à l'abscisse de la grenouille
	 */
	public int grenouilleY(){
		return this.grenouille.getY();
	}
	
	/**
	 * Vérifie si la grenouille est inféctée. 
	 * @return True si la grenouille est infectée, False si la grenouille est saine.
	 */
	public boolean isGrenouilleInfected(){
		return this.grenouille.infectee;
	}
	
	/**
	 * Vérifie si la grenouille est morte. 
	 * @return True si la grenouille est morte, False si la grenouille est vivante.
	 */
	public boolean isGrenouilleDead(){
		return !this.grenouille.alive;
	}

	/**
	 * Obtenir les points de vie de la grenouille.
	 * @return Un entier correspondant aux points de vie de la grenouille.
	 */
	public int getPointDeVie(){
		return this.grenouille.pointDeVie;
	}
}
