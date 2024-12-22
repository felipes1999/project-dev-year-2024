package soccer.net.entity;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRequestRepository extends JpaRepository<UserRequest, Long>{
}
