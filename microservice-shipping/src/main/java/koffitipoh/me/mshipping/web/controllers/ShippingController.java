package koffitipoh.me.mshipping.web.controllers;

import koffitipoh.me.mshipping.dtos.ShippingBean;
import koffitipoh.me.mshipping.models.Shipping;
import koffitipoh.me.mshipping.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

    private ShippingService shippingService;

    @PostMapping
    public Shipping createShipping(
            //@Valid
            ShippingBean shippingDto) {
        return shippingService.save(shippingDto);
    }

    @GetMapping
    public List<Shipping> getAllShippings() {
        return shippingService.findAll();
    }

    @Autowired
    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }
}
