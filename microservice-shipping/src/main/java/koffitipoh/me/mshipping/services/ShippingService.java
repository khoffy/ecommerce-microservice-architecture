package koffitipoh.me.mshipping.services;

import koffitipoh.me.mshipping.dtos.ShippingBean;
import koffitipoh.me.mshipping.models.Shipping;

import java.util.List;

public interface ShippingService {
    Shipping save(ShippingBean shippingDto);
    List<Shipping> findAll();
    Shipping getShippingById(long id);
}
