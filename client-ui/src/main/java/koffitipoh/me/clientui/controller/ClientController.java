package koffitipoh.me.clientui.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import koffitipoh.me.clientui.beans.ProductBean;
import koffitipoh.me.clientui.proxies.MicroserviceProductsProxy;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/products")
public class ClientController {

    private MicroserviceProductsProxy productsProxy;
    
    @GetMapping
    public String accueil(Model model) {
        log.info("Getting list of products from client ui microservice");
        List<ProductBean> products = productsProxy.productsList();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/{id}")
    public String ficheProduit(@PathVariable int id,  Model model){
    ProductBean product = productsProxy.getProductById(id);
    model.addAttribute("product", product);
    return "product-sheet";
  }

    @Autowired
    public void setProductsProxy(MicroserviceProductsProxy productsProxy) {
        this.productsProxy = productsProxy;
    }    
}
