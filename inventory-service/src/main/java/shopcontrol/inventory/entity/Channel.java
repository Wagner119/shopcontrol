package shopcontrol.inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "channel")
@Getter
@Setter
@NoArgsConstructor
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ChannelType type;

    private String shopUrl;

    private String apiKey;

    private boolean active;

    public enum ChannelType {
        SHOPIFY, AMAZON, EBAY
    }
}
