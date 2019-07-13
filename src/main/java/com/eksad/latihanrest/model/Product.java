package com.eksad.latihanrest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "product")

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Product {
	
	
//	identity, auto, sequence
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,
//		generator = "product_id")
//	@SequenceGenerator(name = "product_id",
//		sequenceName = "product_id_seq",
//		allocationSize = 1)
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	lazy melakukan query ke relasi jika dibutuhkan
//	jika one to many dan many to many tipe yang digunakan lazy
//	many to one dan one to one eager
	
	@ManyToOne
//	(fetch = FetchType.EAGER)
	@JoinColumn(name ="brand_id")
	private Brand brand;
	
//	Transient agar variabel tidak dibaca di dalam database
	
	@ApiModelProperty(
			value = "Brand Id Di Product",
			dataType = "String",
			required = true
			)
	@Transient
	private Long brandId;
	
	
	@ApiModelProperty(
			value = "Nama Product",
			dataType = "String",
			required = true
			)
	@Column(nullable = false)
	private String name;
	
	
	@ApiModelProperty(
			value = "Harga Product",
			dataType = "BigDecimal",
			required = true
			)
	@Column(nullable = false)
	private BigDecimal price;
	
	

}
