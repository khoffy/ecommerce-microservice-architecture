package koffitipoh.me.mproduits.dao;

import koffitipoh.me.mproduits.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
}
