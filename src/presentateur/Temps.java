package presentateur;

import javax.swing.JProgressBar;
import java.util.Timer;
import vue.Vue;

/**
 * Cette classe dérive l'élément de barre de progression
 * afin d'afficher le temps restant de la partie en cours.
 * 
 * @author Alexis LE GOADEC
 *
 */
public class Temps extends JProgressBar {

	private static final long serialVersionUID = 1L;

	Vue vue;
	Timer timer;
	TempsTask tmp;
	Presentateur presentateur;

	/**
	 * Constructeur initialisant la barre de progression
	 * ainsi que les timers
	 * @param vue La vue en cours
	 * @param presentateur Le présentateur en cours
	 */
	public Temps(Vue vue, Presentateur presentateur){
		super(JProgressBar.VERTICAL, 0, 60);
		this.presentateur = presentateur;
		this.timer = new Timer();
		this.tmp = new TempsTask(this);
		this.vue = vue;
	}
	
	/**
	 * Démarrer le décomptage
	 */
	public void startBar(){
		this.timer = new Timer();
		this.tmp   = new TempsTask(this);
		timer.scheduleAtFixedRate(this.tmp, 10, 1000);
	}
	
	/**
	 * Arrêter le temps et réinitialiser le timer.
	 */
	public synchronized void stopBar(){
		this.timer.cancel();
		this.timer.purge();
		this.timer = null;
		this.tmp   = null;
		this.setValue(0);
	}

}
