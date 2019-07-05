package com.eksad.latihanrest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "product_grocery")
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "product_id")
@DiscriminatorValue("Grocery")

public class ProductGrocery extends Product {
	
	@Column(name = "expiry_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date expiryDate;


}
