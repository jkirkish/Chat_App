package coderscampus.com.Assignment_14.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.domain.Channel;

@Repository
public interface ChannelRepository1 extends JpaRepository<Channel, Long> {

	void save(Optional<Channel> channel);

}
