package koffitipoh.me.clientui.controller;

import jakarta.annotation.PostConstruct;
import koffitipoh.me.clientui.beans.ProductBean;
import koffitipoh.me.clientui.beans.ShippingBean;
import koffitipoh.me.clientui.proxies.MicroserviceProductsProxy;
import koffitipoh.me.clientui.proxies.MicroserviceShippingsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shippings")
public class ClientShippingController {

    private MicroserviceShippingsProxy shippingsProxy;

    @PostMapping
    public String create(@RequestBody ShippingBean shippingBean, Model model) {
        ShippingBean shippingBeanCreated = shippingsProxy.create(shippingBean);
        model.addAttribute("shippingBeanCreated", shippingBeanCreated);
        return "shippings";
    }
    
    @GetMapping
    public String accueil(Model model) {
        List<ShippingBean> shippings = shippingsProxy.shippingsList();
        model.addAttribute("shippings", shippings);
        return "shippings";
    }

    @GetMapping("/details-shipping/{id}")
    public String shippingSheet(@PathVariable int id,  Model model){
    ShippingBean shipping = shippingsProxy.getShippingById(id);
    model.addAttribute("shipping", shipping);
    return "shipping-sheet";
  }

    @Autowired
    public void setShippingsProxy(MicroserviceShippingsProxy shippingsProxy) {
        this.shippingsProxy = shippingsProxy;
    }    
}
