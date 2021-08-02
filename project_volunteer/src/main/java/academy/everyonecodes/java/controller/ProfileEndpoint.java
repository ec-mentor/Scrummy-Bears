package academy.everyonecodes.java.controller;

import academy.everyonecodes.java.data.ProfileDTO;
import academy.everyonecodes.java.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ProfileEndpoint
{
    private final ProfileService profileService;

    public ProfileEndpoint(ProfileService profileService)
    {
        this.profileService = profileService;
    }

    @GetMapping
    public ProfileDTO get(@RequestBody User user)
    {
        return profileService.get();
    }
}
