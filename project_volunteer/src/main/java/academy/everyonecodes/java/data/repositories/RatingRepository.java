package academy.everyonecodes.java.data.repositories;

import academy.everyonecodes.java.data.Activity;
import academy.everyonecodes.java.data.Rating;
import academy.everyonecodes.java.data.RatingId;
import academy.everyonecodes.java.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, RatingId> {
	List<Rating> findByUser_Id(Long id);

	Optional<Rating> findByActivityAndUser(Activity activity, User user);
}
