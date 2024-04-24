package koffitipoh.me.clientui.controller;

import java.util.List;

import koffitipoh.me.clientui.proxies.MicroserviceProduitsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import koffitipoh.me.clientui.beans.ProductBean;
import koffitipoh.me.clientui.proxies.MicroserviceProduitsProxy;

@Controller
public class ClientController {

    private MicroserviceProduitsProxy produitsProxy;
    
    @GetMapping("/")
    public String accueil(Model model) {
        List<ProductBean> produits = produitsProxy.listeDesProduits();
        model.addAttribute("produits", produits);
        return "Accueil";
    }

    @GetMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id,  Model model){
    ProductBean produit = produitsProxy.recupererUnProduit(id);
    model.addAttribute("produit", produit);
    return "FicheProduit";
  }

    @Autowired
    public void setProduitsProxy(MicroserviceProduitsProxy produitsProxy) {
        this.produitsProxy = produitsProxy;
    }    
}
