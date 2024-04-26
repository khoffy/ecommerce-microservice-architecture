package koffitipoh.me.mproduits.web.controller;

import koffitipoh.me.mproduits.config.ApplicationPropertiesConfiguration;
import koffitipoh.me.mproduits.dao.ProductDao;
import koffitipoh.me.mproduits.model.Product;
import koffitipoh.me.mproduits.web.exceptions.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    ProductDao productDao;

    private ApplicationPropertiesConfiguration appProperties;

    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/products")
    public List<Product> productsList(){

        List<Product> products = productDao.findAll();

        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

        log.info("Getting list of products");

        return products.subList(0, appProperties.getLimitOfProducts());

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/products/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {

        Optional<Product> product = productDao.findById(id);

        if(product.isEmpty())  throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

        return product;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setAppProperties(ApplicationPropertiesConfiguration appProperties) {
        this.appProperties = appProperties;
    }
    
}

