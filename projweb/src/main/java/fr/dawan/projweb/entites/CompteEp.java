package fr.dawan.projweb.entites;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_comptesEp")
public class CompteEp extends CompteB {

	private float taux;

	public CompteEp() {
	}
	
	public CompteEp(long id, int version, String numero, float solde, float taux) {
		super(id, version, numero, solde);
		this.taux = taux;
	}	
	
	public float getTaux() {
		return taux;
	}


	
	
	
	
	public void setTaux(float taux) {
		this.taux = taux;
	}


}
