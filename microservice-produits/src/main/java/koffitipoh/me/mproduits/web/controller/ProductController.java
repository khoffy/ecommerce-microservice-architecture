package koffitipoh.me.mproduits.web.controller;

import koffitipoh.me.mproduits.config.ApplicationPropertiesConfiguration;
import koffitipoh.me.mproduits.dao.ProductDao;
import koffitipoh.me.mproduits.model.Product;
import koffitipoh.me.mproduits.web.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductDao productDao;

    private ApplicationPropertiesConfiguration appProperties;

    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/produits")
    public List<Product> listeDesProduits(){

        List<Product> products = productDao.findAll();

        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

        return products.subList(0, appProperties.getLimitDeProduits());

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/produits/{id}")
    public Optional<Product> recupererUnProduit(@PathVariable int id) {

        Optional<Product> product = productDao.findById(id);

        if(!product.isPresent())  throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

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

