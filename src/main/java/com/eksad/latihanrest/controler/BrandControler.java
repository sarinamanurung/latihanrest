package com.eksad.latihanrest.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.model.Brand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/brand")
@Api(tags = "Brand")
public class BrandControler {
	
	@Autowired
	BrandDao brandDao;
	
	@ApiOperation(
			value = " Mangambil Data",
			notes = "Return data with JSON", 
			tags ="Get Data API"
			)	
	@GetMapping("getAll")
	public List <Brand> getAll() {
		
		List<Brand>result = new ArrayList<>();
		
		brandDao.findAll().forEach(result::add);
		
		return result;
	}
	
	@ApiOperation(
			value = " Mangambil Data Berdasarkan Id",
			notes = "Return data with JSON", 
			tags ="Get Data API"
			)
	@GetMapping("getOne/{id}")
	public Brand getOne(@PathVariable Long id) {
		
		return brandDao.findById(id).orElse(null);
				
	}
	
	
	@ApiOperation(
			value = " Menyimpan Data",
			notes = "Return data with JSON", 
			tags ="Data Manipulation API"
			)
	@PostMapping(value = "save")
	public Brand save(@RequestBody Brand brand) { //untuk membaca data dalam postman dalam bentuk brand
		try {
			
			return brandDao.save(brand);
		} catch (Exception e) {
		
			e.printStackTrace();
			return null;
		}
	}
	
	
	@ApiOperation(
			value = " Update Data",
			notes = "Return data with JSON", 
			tags ="Data Manipulation API"
			)
	
	@PutMapping(value ="update/{id}")
	public Brand update(@RequestBody Brand brand, @PathVariable Long id) {
		
		Brand brandSelected = brandDao.findById(id).orElse(null);
		if (brandSelected!= null) {
			brandSelected.setName(brand.getName());
			brandSelected.setProductType(brand.getProductType());
			
			brandDao.save(brandSelected);
			return brandDao.save(brandSelected);
		}
		else {
			return null;
		}
		
				
	}
	
	@ApiOperation(
			value = " Menghapus Data",
			notes = "Return data with JSON", 
			tags ="Data Manipulation API"
			)
	
	@DeleteMapping(value ="delete/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		brandDao.deleteById(id);
		result.put("message", "Berhasil Dihapus");
		return result;
	}
	
}


