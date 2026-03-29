package shopcontrol.inventory.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import shopcontrol.inventory.entity.Channel;
import shopcontrol.inventory.repository.ChannelRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ChannelRepositoryTest {

    @Autowired
    private ChannelRepository channelRepository;

    @BeforeEach
    public void setUp() {
        Channel channel = new Channel();
        channel.setName("name");
        channel.setType(Channel.ChannelType.SHOPIFY);
        channel.setShopUrl("shopUrl");
        channel.setApiKey("apiKey");
        channel.setActive(true);
        channelRepository.save(channel);
    }

    @Test
    public void insertChannel() {
        assertThat(channelRepository.findAll()).hasSize(1);
    }

    @Test
    public void findByName() {
        var found = channelRepository.findByName("name");
        assertThat(found).isPresent();
        assertThat(found.get().getType()).isEqualTo(Channel.ChannelType.SHOPIFY);
    }

    @Test
    public void findByType() {
        var found = channelRepository.findByType(Channel.ChannelType.SHOPIFY);
        assertThat(found).hasSize(1);
        assertThat(found.get(0).getName()).isEqualTo("name");
    }

    @Test
    public void findByShopUrl() {
        var found = channelRepository.findByShopUrl("shopUrl");
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("name");
    }

    @Test
    public void findByApiKey() {
        var found = channelRepository.findByApiKey("apiKey");
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("name");
    }

    @Test
    public void findByActive() {
        var found = channelRepository.findByActive(true);
        assertThat(found).hasSize(1);
        assertThat(found.get(0).getName()).isEqualTo("name");
    }
}
