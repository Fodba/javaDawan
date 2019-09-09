package fr.dawan.projweb.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name="t_tests")
public class QcmTest implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date datePassage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Qcm qcm;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;
	
	private int score; 

	
	@Version
	private int version;


	public QcmTest() {
		super();
	}


	public QcmTest(long id, Date datePassage, Qcm qcm, Client client, int score, int version) {
		super();
		this.id = id;
		this.datePassage = datePassage;
		this.qcm = qcm;
		this.client = client;
		this.score = score;
		this.version = version;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getDatePassage() {
		return datePassage;
	}


	public void setDatePassage(Date datePassage) {
		this.datePassage = datePassage;
	}


	public Qcm getQcm() {
		return qcm;
	}


	public void setQcm(Qcm qcm) {
		this.qcm = qcm;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		QcmTest other = (QcmTest) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
}
