package shopcontrol.inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;

    private String name;

    private String ean;

    @Enumerated(EnumType.STRING)
    private SalesChannel source;

    private Instant createdAt;

    private Instant updatedAt;

    public enum SalesChannel {
        SHOPIFY, AMAZON, EBAY
    }
}
