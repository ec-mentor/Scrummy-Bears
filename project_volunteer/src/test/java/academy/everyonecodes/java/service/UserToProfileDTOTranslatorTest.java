package academy.everyonecodes.java.service;

import academy.everyonecodes.java.data.ProfileDTO;
import academy.everyonecodes.java.data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.Year;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserToProfileDTOTranslatorTest
{
    @Autowired
    private UserToProfileDTOTranslator userToProfileDTOTranslator;

    @MockBean
    private AgeCalculator ageCalculator;

    @Test
    void get_everything_existing()
    {
        ProfileDTO profileDTO = new ProfileDTO(
                "name",
                "First Last",
                Optional.of("company"),
                Optional.of(69),
                Optional.of("description")
                );
        User user = new User(
                "name",
                "First",
                "Last",
                Optional.of("company"),
                LocalDate.of(2021, 8, 2),
                Optional.of("description")
        );

        Mockito.when(ageCalculator.calculate(user))
                .thenReturn(Optional.of(69));

        var expected = profileDTO;
        var actual = userToProfileDTOTranslator.toDTO(user);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get_no_company()
    {
        ProfileDTO profileDTO = new ProfileDTO(
                "name",
                "First Last",
                Optional.empty(),
                Optional.of(69),
                Optional.of("description")
        );
        User user = new User(
                "name",
                "First",
                "Last",
                Optional.empty(),
                LocalDate.of(2021, 8, 2),
                Optional.of("description")
        );

        Mockito.when(ageCalculator.calculate(user))
                .thenReturn(Optional.of(69));

        var expected = profileDTO;
        var actual = userToProfileDTOTranslator.toDTO(user);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get_no_age()
    {
        ProfileDTO profileDTO = new ProfileDTO(
                "name",
                "First Last",
                Optional.of("company"),
                Optional.empty(),
                Optional.of("description")
        );
        User user = new User(
                "name",
                "First",
                "Last",
                Optional.of("company"),
                Optional.empty(),
                Optional.of("description")
        );

        Mockito.when(ageCalculator.calculate(user))
                .thenReturn(Optional.empty());

        var expected = profileDTO;
        var actual = userToProfileDTOTranslator.toDTO(user);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get_no_description()
    {
        ProfileDTO profileDTO = new ProfileDTO(
                "name",
                "First Last",
                Optional.of("company"),
                Optional.of(69),
                Optional.empty()
        );
        User user = new User(
                "name",
                "First",
                "Last",
                Optional.of("company"),
                LocalDate.of(2021, 8, 2),
                Optional.empty()
        );

        Mockito.when(ageCalculator.calculate(user))
                .thenReturn(Optional.of(69));

        var expected = profileDTO;
        var actual = userToProfileDTOTranslator.toDTO(user);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get_only_mandatory()
    {
        ProfileDTO profileDTO = new ProfileDTO(
                "name",
                "First Last",
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        );
        User user = new User(
                "name",
                "First",
                "Last",
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        );

        Mockito.when(ageCalculator.calculate(user))
                .thenReturn(Optional.empty());

        var expected = profileDTO;
        var actual = userToProfileDTOTranslator.toDTO(user);
        Assertions.assertEquals(expected, actual);
    }
}