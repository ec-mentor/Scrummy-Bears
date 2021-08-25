package academy.everyonecodes.java.service;

import academy.everyonecodes.java.data.Activity;
import academy.everyonecodes.java.data.ErrorMessage;
import academy.everyonecodes.java.data.User;
import academy.everyonecodes.java.data.repositories.ActivityRepository;
import academy.everyonecodes.java.data.repositories.UserRepository;
import academy.everyonecodes.java.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class StatusService
{
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private final EmailServiceImpl emailService;
    private final String subjectAccepted;
    private final String textAccepted;

    private final String subjectRejected;
    private final String textRejected;

    public StatusService(ActivityRepository activityRepository, UserRepository userRepository, EmailServiceImpl emailService, @Value("${acceptedVolunteerEmail.subject}") String subjectAccepted, @Value("${acceptedVolunteerEmail.text}") String textAccepted, @Value("${rejectedVolunteerEmail.subject}") String subjectRejected, @Value("${rejectedVolunteerEmail.text}") String textRejected)
    {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.subjectAccepted = subjectAccepted;
        this.textAccepted = textAccepted;
        this.subjectRejected = subjectRejected;
        this.textRejected = textRejected;
    }

    public Activity acceptVolunteer(Long activityId, Long userId)
    {
        User user = getUser(userId);
        authenticateLoggedInUserEqualsObjectOwner(user.getUsername());
        Activity activity = getActivity(activityId);
        Set<User> applicants = activity.getApplicants();
        String activityTitle = activity.getTitle();
        if (!applicants.contains(user))
            ExceptionThrower.badRequest(ErrorMessage.VOLUNTEER_IS_NOT_APPLICANT);
        activity.getParticipants().add(user);
        applicants.remove(user);
        emailService.sendSimpleMessage(user.getEmailAddress(), subjectAccepted, textAccepted + activityTitle);
        applicants.stream()
                .forEach(rejectedVolunteer -> emailService.sendSimpleMessage(rejectedVolunteer.getEmailAddress(), subjectRejected, textRejected + activityTitle));
        return activity;
    }

    private User getUser(Long userId)
    {
        Optional<User> oUser = userRepository.findById(userId);
        User user = new User();
        if (oUser.isEmpty())
            ExceptionThrower.badRequest(ErrorMessage.USERNAME_NOT_FOUND);
        else
            user = oUser.get();
        return user;
    }

    private Activity getActivity(Long activityId)
    {
        Optional<Activity> oActivity = activityRepository.findById(activityId);
        Activity activity = new Activity();
        if (oActivity.isEmpty())
            ExceptionThrower.badRequest(ErrorMessage.NO_MATCHING_ACTIVITY_FOUND);
        else
            activity = oActivity.get();
        return activity;
    }

    private String getAuthenticatedName()
    {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private void authenticateLoggedInUserEqualsObjectOwner(String organizerUsername)
    {
        if (!getAuthenticatedName().equals(organizerUsername))
            ExceptionThrower.badRequest(ErrorMessage.LOGGED_IN_USER_NOT_MATCHING_REQUEST);
    }
}