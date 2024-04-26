package koffitipoh.me.mshipping.dtos;

import lombok.*;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ShippingBean {
    private long id;

    private String orderId;

    private String status;
}
