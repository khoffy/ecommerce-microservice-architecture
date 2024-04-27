package koffitipoh.me.mshipping.services.Impl;

import koffitipoh.me.mshipping.dtos.ShippingBean;
import koffitipoh.me.mshipping.models.Shipping;
import koffitipoh.me.mshipping.repositories.ShippingRepository;
import koffitipoh.me.mshipping.services.ShippingService;
import koffitipoh.me.mshipping.utils.Status;
import koffitipoh.me.mshipping.web.exceptions.ShippingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShippingServiceImpl implements ShippingService {
    private ShippingRepository shippingRepository;

    @Override
    public Shipping save(ShippingBean shippingDto) {

        Shipping shipping = Shipping.builder()
                .orderId(shippingDto.getOrderId())
                .status(mapToStatus(shippingDto.getStatus()))
                .build();
        return shippingRepository.save(shipping);
    }

    @Override
    public List<Shipping> findAll() {
        shippingRepository.findAll();
        return shippingRepository.findAll();
    }

    @Override
    public Shipping getShippingById(long id) {
        Shipping shipping = shippingRepository.findById(id).orElse(null);
        if (Objects.isNull(shipping)) {
            throw new ShippingNotFoundException("Shipping with id " + id + " not found");
        }
        return shipping;
    }

    private Status mapToStatus(String shippingStatus) {
        return switch (shippingStatus) {
            case "ORDER_RECEIVED" -> Status.ORDER_RECEIVED;
            case "PROCESSING" -> Status.PROCESSING;
            case "IN_TRANSIT" -> Status.IN_TRANSIT;
            case "DELIVERED_ATTEMPT" -> Status.DELIVERY_ATTEMPTED;
            case "DELIVERED" -> Status.DELIVERED;
            default -> null;
        };
    }

    @Autowired
    public void setShippingRepository(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }
}
