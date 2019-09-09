package fr.dawan.projweb.entites;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SalarieId implements Serializable {

	private String matricule;
	private String codeDepartement;
	
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeDepartement == null) ? 0 : codeDepartement.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalarieId other = (SalarieId) obj;
		if (codeDepartement == null) {
			if (other.codeDepartement != null)
				return false;
		} else if (!codeDepartement.equals(other.codeDepartement))
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		return true;
	}
	
	
}
