package modele;

/**
 * Cette énumeration contient chacun des effets pouvant être choisi par un
 * element du jeu (eau ou nénuphare) à appliquer sur la grenouille.
 * 
 * @author Alexis LE GOADEC
 *
 */
public enum Effet {

	/**
	 * Effet de l'eau sur la grenouille, effet mortel
	 * instantanément.
	 */
	EAU {
		void doEffet(Grenouille g){

			// Mise à 0 des points de vie
			g.pointDeVie = 0;
			// La grenouille déclarée morte
			g.alive      = false;
			
		}
	},
	
	/**
	 * Effet mortel sur la grenouille. Plus de points de vie
	 * et déclarée morte.
	 */
	NENUPHARE_MORTEL {
		void doEffet(Grenouille g){
			
			// Mise à 0 des points de vie
			g.pointDeVie = 0;
			// La grenouille déclarée morte
			g.alive      = false;
			
		}
	},
	
	/**
	 * La grenouille est inféctée. Si elle l'était déjà auparavant, elle est tuée.
	 * Sinon, ses points de vie sont divisés par 2.
	 */
	NENUPHARE_VENENEUX {
		void doEffet(Grenouille g){
			// Si la grenouille est infectée
			if( g.infectee ){
				// La grenouille est déclarée morte
				g.alive      = false;
				// Plus de points de vie
				g.pointDeVie = 0;
			// Sinon
			} else {
				// Lagrenouille est infectée
				g.infectee   = true;
				// La totalité de ses points de vie est divisée par 2
				g.pointDeVie = (g.pointDeVie) / 2;
				
			};
		}
	},
	
	/**
	 * Si la grenouille était infectée, elle ne l'est plus. elle gagne
	 * un point de vie.
	 */
	NENUPHARE_NUTRITIF {
		void doEffet(Grenouille g){
			// La grenouille est désinfectée
			g.infectee    = false;
			// La grenouille gagne 1 point de vie
			g.pointDeVie += 1;
			
		}
	},
	
	/**
	 * Si la grenouille était infectée, elle ne l'est plus. Elle voit ses
	 * points de vie multipliés par 2.
	 */
	NENUPHARE_DOPANT {
		void doEffet(Grenouille g){
			// La grenouille est désinfectée
			g.infectee    = false;
			// Multiplication par 2 de ses points de vie
			if(g.pointDeVie==0){
				g.pointDeVie++;
			};
			g.pointDeVie *= 2;
			
		}
	},
	
	/**
	 * Aucun effet, en aucune manière, sur la grenouille.
	 * 
	 * @param g L'instance de la grenouille.
	 */
	NENUPHARE {
		void doEffet(Grenouille g){
			// Aucun effet
			return;
		}
	};
	
	/**
	 * Méthode abstraite défini selon l'effet choisi sur la grenouille, pour
	 * l'élement en cours.
	 * 
	 * @param g L'instance de la grenouille.
	 */
	abstract void doEffet(Grenouille g);
	
}
