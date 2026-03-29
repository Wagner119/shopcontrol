package shopcontrol.inventory.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import shopcontrol.inventory.entity.Product;
import shopcontrol.inventory.repository.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void insertProduct() {
        Product product = new Product();
        product.setSku("sku");
        product.setName("name");
        product.setEan("ean");
        product.setSource(Product.SalesChannel.SHOPIFY);

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
        product.setSource(Product.SalesChannel.SHOPIFY);
        productRepository.save(product);

        var found = productRepository.findBySku("sku");

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("name");
    }
}
