package presentateur;

import java.util.TimerTask;

/**
 * 
 * Cette classe dérive le timer, afin d'adapter la tache à
 * appliquer à chaque Top.
 * 
 * @author Alexis LE GOADEC
 *
 */
public class TempsTask extends TimerTask {

	Temps temps;
	int   taskValue;
	
	/**
	 * Constructeur, précisant la barre de progression à
	 * gérer en paramètre.
	 * @param temps La référence de la barre de progression à gérer.
	 */
	public TempsTask(Temps temps){
		this.temps = temps;
	}
	
	/**
	 * Méthode appelée à chaque Top du chronomètre. Cette méthode
	 * incrémente la barre de progression, ainsi que les éléments
	 * du jeu.
	 */
	public void run(){
		
		taskValue = this.temps.getValue();
		
		if(taskValue==this.temps.getMaximum()){
			this.cbChronoPerdu();
			return;
		}
		
		this.temps.presentateur.cbActualiser();
		this.temps.setValue(taskValue + 1);
	}

	/**
	 * Si le temps d'une partie a dépassé une minute, cette méthode
	 * avertie l'utilisateur et déclare la partie perdue.
	 */
	public synchronized void cbChronoPerdu(){
		this.temps.presentateur.gameReload(this.temps.presentateur.getCurrentResolution());
		this.temps.vue.msgPerdu();
		return;
	}
	
}
