package academy.everyonecodes.java.service;

import academy.everyonecodes.java.data.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class AgeCalculator
{
    public Optional<Integer> calculate(User user) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = user.getDateOfBirth().orElse(null);
        if ((birthDate != null) && (currentDate != null)) {
            return Optional.of(Period.between(birthDate, currentDate).getYears());
        } else {
            return Optional.empty();
        }
    }
}
