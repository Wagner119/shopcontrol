package shopcontrol.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopcontrol.inventory.entity.Channel;

import java.util.List;
import java.util.Optional;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Optional<Channel> findByName(String name);

    List<Channel> findByType(Channel.ChannelType type);

    Optional<Channel> findByShopUrl(String shopUrl);

    Optional<Channel> findByApiKey(String apiKey);

    List<Channel> findByActive(boolean active);
}
