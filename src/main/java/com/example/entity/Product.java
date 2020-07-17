package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table( name= "product")
public class Product  implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private String name;
    private String description;
    private float price;

	@ManyToOne
	@JoinColumn(name = "id")
    private Category category;
 
    public Product() {
    }
 
    public Product(String name, String description, float price,
            Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
 

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

}
