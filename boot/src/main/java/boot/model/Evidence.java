package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="evidence")
public class Evidence  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=8)
	private String code;
	@Column (name="association_id")
	private int association_id;
	@Column (name="dbxref_id")
	private int dbxref_id;
	@Column(length=255)
	private String seq_acc;
	
	public Evidence(String code, int association_id, int dbxref_id, String seq_acc){
		super();
		this.code=code;
		this.association_id=association_id;
		this.dbxref_id=dbxref_id;
		this.seq_acc=seq_acc;
	}
	
	public Evidence(){
		this("",0,0,"");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAssociation_id() {
		return association_id;
	}

	public void setAssociation_id(int association_id) {
		this.association_id = association_id;
	}

	public int getDbxref_id() {
		return dbxref_id;
	}

	public void setDbxref_id(int dbxref_id) {
		this.dbxref_id = dbxref_id;
	}

	public String getSeq_acc() {
		return seq_acc;
	}

	public void setSeq_acc(String seq_acc) {
		this.seq_acc = seq_acc;
	}
	
	@Override
	public String toString() {
		return "Evidence [id=" + id + ", code=" + code + ", association_id=" + association_id + ", dbxref_id=" + dbxref_id
				+ ", seq_acc=" + seq_acc + "]";
	}
}
