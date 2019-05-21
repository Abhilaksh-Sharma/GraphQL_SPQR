package practice.springboot.graphql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import practice.springboot.graphql.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	List<Optional<Product>> findByName(String name);
	
	List<Optional<Product>> findByCost(String cost);

	List<Optional<Product>> findByCost(Integer cost);

}
