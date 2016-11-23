package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="fruits")
public class Fruit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_fruit;
	@Column(length=50)
	private String name_fruit;
	@Column(length=50)
	private String color;
	@Temporal(TemporalType.DATE)
	@Column(name="date_arrive")
	private Date dateArrive;
	@Column (name="quantity")
	private int quantity;
	
	public Fruit(String name_fruit,String color, Date dateArrive, int quantity ){
		super();
		this.name_fruit= name_fruit;
		this.color=color;
		this.dateArrive=dateArrive;
		this.quantity=quantity;
	}
	
	public Fruit(){
		this("","", new Date(),0);
	}

	public int getId_fruit() {
		return id_fruit;
	}

	public void setId_fruit(int id_fruit) {
		this.id_fruit = id_fruit;
	}

	public String getName_fruit() {
		return name_fruit;
	}

	public void setName_fruit(String name_fruit) {
		this.name_fruit = name_fruit;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Fruit [id_fruit=" + id_fruit + ", name_fruit=" + name_fruit + ", color=" + color + ", dateArrive=" + dateArrive
				+ ", quantity=" + quantity + "]";
	}
	
	
}
