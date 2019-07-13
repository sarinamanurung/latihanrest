package com.eksad.latihanrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//@Getter @Setter
//@EqualsAndHashCode

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity{
	
// lombok untuk melihat otomatis codingan yang dibikin
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@EqualsAndHashCode.Include
	
	@ApiModelProperty(
			value = "Nama Brand",
			dataType = "String",
			required = true
			)
	
	
	@Column(nullable = false)
	private String name;
	
	@ApiModelProperty(
			value = "Type Brand",
			dataType = "String",
			required = true
			)
	@Column(name = "product_type")
	private String productType;
		
	

	
}
