package modele;


/**
 * Enum de l'age des nénuphares, en prenant en compte les
 * nénuphares immortels.
 * 
 * @author Alexis LE GOADEC
 *
 */
public enum Age {

	IMMORTEL (-1),
	MORT     (0),
	PETIT    (1),
	MOYEN    (2),
	GRAND    (3);
	
	private int age;
	
	/**
	 * Constructeur de l'Enum, en fonction de la valeur
	 * numérique de l'age en cours.
	 * 
	 * @param age
	 */
	Age(int age){
		this.age = age;
	}
	
	int getAge(){
		return this.age;
	}

}
