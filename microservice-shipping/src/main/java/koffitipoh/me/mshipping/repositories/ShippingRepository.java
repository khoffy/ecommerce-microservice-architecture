package koffitipoh.me.mshipping.repositories;

import koffitipoh.me.mshipping.models.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
