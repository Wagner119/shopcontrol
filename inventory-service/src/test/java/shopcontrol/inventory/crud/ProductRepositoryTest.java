package shopcontrol.inventory.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import shopcontrol.inventory.entity.Channel;
import shopcontrol.inventory.entity.Product;
import shopcontrol.inventory.repository.ChannelRepository;
import shopcontrol.inventory.repository.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ChannelRepository channelRepository;

    private Channel channel;

    @BeforeEach
    public void setUp() {
        channel = new Channel();
        channel.setName("name");
        channel.setType(Channel.ChannelType.SHOPIFY);
        channel.setShopUrl("shopUrl");
        channel.setApiKey("apiKey");
        channel.setActive(true);
        channel = channelRepository.save(channel);
    }

    @Test
    public void insertProduct() {
        Product product = new Product();
        product.setSku("sku");
        product.setName("name");
        product.setEan("ean");
        product.setChannel(channel);

        Product saved = productRepository.save(product);

        assertThat(saved.getId()).isNotNull();
        assertThat(productRepository.findById(saved.getId())).isPresent();
    }

    @Test
    public void findBySku() {
        Product product = new Product();
        product.setSku("sku");
        product.setName("name");
        product.setEan("ean");
        product.setChannel(channel);
        productRepository.save(product);

        var found = productRepository.findBySku("sku");

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("name");
    }

    @Test
    public void findByName() {
        Product product = new Product();
        product.setSku("sku");
        product.setName("name");
        product.setEan("ean");
        product.setChannel(channel);
        productRepository.save(product);

        var found = productRepository.findByName("name");

        assertThat(found).isPresent();
        assertThat(found.get().getSku()).isEqualTo("sku");
    }

    @Test
    public void findByEan() {
        Product product = new Product();
        product.setSku("sku");
        product.setName("name");
        product.setEan("ean");
        product.setChannel(channel);
        productRepository.save(product);

        var found = productRepository.findByEan("ean");

        assertThat(found).isPresent();
        assertThat(found.get().getSku()).isEqualTo("sku");
    }
}
