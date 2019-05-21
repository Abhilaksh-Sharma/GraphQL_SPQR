package practice.springboot.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import practice.springboot.graphql.model.Product;
import practice.springboot.graphql.repository.ProductRepository;

@Service
@GraphQLApi
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GraphQLMutation(name="createProduct")
	public String createProduct(String id,String name,Integer cost) {
		productRepository.save(new Product(id,name,cost));
		return "OK";
	}
	
	@GraphQLMutation(name="updateProduct")
	public String updateProduct(String id,String name,Integer cost) {
		productRepository.save(new Product(id,name,cost));
		return "UPDATED";
	}
	
	@GraphQLMutation(name="deleteProduct")
	public String deleteProduct(String id) {
		productRepository.deleteById(id);
		return "DELETED";
	}
	 
	@GraphQLQuery(name="products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@GraphQLQuery(name="getProductById")
	public Optional<Product> getProductByID(String id) {
		return productRepository.findById(id);
	}
	
	@GraphQLQuery(name="getProductByName")
	public List<Optional<Product>> getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	@GraphQLQuery(name="getProductByCost")
	public List<Optional<Product>> getProductByCost(Integer cost) {
		return productRepository.findByCost(cost);
	}

}
