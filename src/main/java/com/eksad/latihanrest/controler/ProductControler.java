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
import com.eksad.latihanrest.dao.ProductDao;
import com.eksad.latihanrest.model.Brand;
import com.eksad.latihanrest.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/product")
@Api(tags = "Product")
public class ProductControler {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	BrandDao brandDao;
	
	@ApiOperation(
			value = " Mangambil Data Berdasarkan Id",
			notes = "Return data with JSON", 
			tags ="Get Data API"
			)
	@GetMapping("getByBrandId/{brandId}")
	public List<Product> getByBrandId(@PathVariable Long brandId) {
		List<Product> result = new ArrayList<Product>();
		productDao.findByBrandId(brandId).forEach(result::add);
		return result;
	
	}
	
	@ApiOperation(
			value = " Menyimpan Data",
			notes = "Return data with JSON", 
			tags ="Data Manipulation API"
			)
	@PostMapping(value = "save")
	public Product save(@RequestBody Product product) {
		
		Brand brand = brandDao.findById(product.getBrandId()).orElse(null);
		if (brand != null) {
			product.setBrand(brand);
			return productDao.save(product);
		}
		
		return null;
		
	}
	
	@ApiOperation(
			value = " Update Data",
			notes = "Return data with JSON", 
			tags ="Data Manipulation API"
			)
	
	@PutMapping(value ="update/{id}")
	public String update(@RequestBody Product product,@PathVariable Long id) {
		Product productSelected = productDao.findById(id).orElse(null);
		
		if(productSelected != null) {
			productSelected.setName(product.getName());
			//productSelected.setBrandId(product.getBrandId());
			productSelected.setBrand(product.getBrand());
			productSelected.setPrice(product.getPrice());
			
			productDao.save(productSelected);
			return "Berhasil Memperbaharui";
		}else {
			return "Gagal Memperbaharui";
		}
	}
	
	@ApiOperation(
			value = " Menghapus Data",
			notes = "Return data with JSON", 
			tags ="Data Manipulation API"
			)
	@DeleteMapping(value ="delete/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		productDao.deleteById(id);
		result.put("message","Berhasil di hapus");
		return result;
	}
	
	@ApiOperation(
			value = " Mangambil Data Berdasarkan Name",
			notes = "Return data with JSON", 
			tags ="Get Data API"
			)
	@GetMapping(value ="search/{name}")
	public List<Product> search(@PathVariable String name){
		List<Product> result = new ArrayList<Product>();
		productDao.findByName(name).forEach(result::add);
		
		return result;
		};

}
