package academy.everyonecodes.java.service;

import academy.everyonecodes.java.data.ProfileDTO;
import org.springframework.stereotype.Service;

@Service
public class UserToProfileDTOTranslator
{
    public ProfileDTO toDTO(User user)
    {
        return new ProfileDTO(
                user.getUsername(),
                user.getFirstName() + " " + user.getLastName(),
                user.getCompanyName(),
                ageCalculator.calculate(user),
                user.getDescription()
                );
    }
}
