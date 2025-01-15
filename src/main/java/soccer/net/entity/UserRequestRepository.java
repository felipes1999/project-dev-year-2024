package soccer.net.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Embeddable
@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Long>{
}
