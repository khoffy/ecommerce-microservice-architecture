package koffitipoh.me.mshipping.models;

import jakarta.persistence.*;
import koffitipoh.me.mshipping.utils.Status;
import lombok.*;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@ToString @Builder
@Entity
public class Shipping {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String orderId;

    @Enumerated(EnumType.STRING)
    private Status status;
}
