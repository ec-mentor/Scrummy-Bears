package academy.everyonecodes.java.data.repositories;

import academy.everyonecodes.java.data.Badges;
import academy.everyonecodes.java.data.BadgesEnum;
import academy.everyonecodes.java.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface BadgesRepository extends JpaRepository<Badges, Long>
{
    Set<Badges> findByUser(User user);
}
