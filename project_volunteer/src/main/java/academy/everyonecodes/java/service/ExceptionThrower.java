package academy.everyonecodes.java.service;

import academy.everyonecodes.java.data.ErrorMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class ExceptionThrower
{
    private static String wrongRoles;
    private static String usernameNotFound;
    private static String activitiesNotFound;
    private static String endDateBeforeStartDate;
    private static String loggedInUserNotMatchingRequest;
    private static String noMatchingActivityFound;
    private static String noMatchingDraftFound;
    private static String deleteActivityWithParticipantsNotPossible;
    private static String editActivityWithApplicantsOrParticipantsNotPossible;
    private static String userNotInvolvedInActivity;
    private static String noStatusFound;
    private static String activityNotCompletedYet;
    private static String volunteerIsNotApplicant;

    private static String userNotAuthorizedToCompleteActivity;
    private static String activityAlreadyCompleted;
    private static String noParticipantsForActivity;
    private static String alreadyApplied;
    private static String editDeletedActivityNotPossible;
    private static String noVolunteerFound;
    public ExceptionThrower(@Value("${errorMessages.wrongRoles}") String wrongRoles,
                            @Value("${errorMessages.usernameNotFound}") String usernameNotFound,
                            @Value("${errorMessages.activitiesNotFound}") String activitiesNotFound,
                            @Value("${errorMessages.endDateBeforeStartDate}") String endDateBeforeStartDate,
                            @Value("${errorMessages.loggedInUserNotMatchingRequest}") String loggedInUserNotMatchingRequest,
                            @Value("${errorMessages.noMatchingActivityFound}") String noMatchingActivityFound,
                            @Value("${errorMessages.noMatchingDraftFound}") String noMatchingDraftFound,
                            @Value("${errorMessages.deleteActivityWithParticipantsNotPossible}") String deleteActivityWithParticipantsNotPossible,
                            @Value("${errorMessages.editActivityWithApplicantsOrParticipantsNotPossible}") String editActivityWithApplicantsOrParticipantsNotPossible,
                            @Value("${errorMessages.userNotInvolvedInActivity}") String userNotInvolvedInActivity,
                            @Value("${errorMessages.noStatusFound}") String noStatusFound,
                            @Value("${errorMessages.userNotAuthorizedToCompleteActivity}") String userNotAuthorizedToCompleteActivity,
                            @Value("${errorMessages.activityAlreadyCompleted}") String activityAlreadyCompleted,
                            @Value("${errorMessages.noParticipantsForActivity}") String noParticipantsForActivity,
                            @Value("${errorMessages.activityNotCompletedYet}") String activityNotCompletedYet,
                            @Value("${errorMessages.volunteerIsNotApplicant}") String volunteerIsNotApplicant,
                            @Value("${errorMessages.editDeletedActivityNotPossible}") String editDeletedActivityNotPossible,
                            @Value("${errorMessages.alreadyApplied}") String alreadyApplied,
                            @Value("${errorMessages.noVolunteerFound}") String noVolunteerFound)
    {
        ExceptionThrower.wrongRoles = wrongRoles;
        ExceptionThrower.usernameNotFound = usernameNotFound;
        ExceptionThrower.activitiesNotFound = activitiesNotFound;
        ExceptionThrower.endDateBeforeStartDate = endDateBeforeStartDate;
        ExceptionThrower.loggedInUserNotMatchingRequest = loggedInUserNotMatchingRequest;
        ExceptionThrower.noMatchingActivityFound = noMatchingActivityFound;
        ExceptionThrower.noMatchingDraftFound = noMatchingDraftFound;
        ExceptionThrower.deleteActivityWithParticipantsNotPossible = deleteActivityWithParticipantsNotPossible;
        ExceptionThrower.editActivityWithApplicantsOrParticipantsNotPossible = editActivityWithApplicantsOrParticipantsNotPossible;
        ExceptionThrower.userNotInvolvedInActivity = userNotInvolvedInActivity;
        ExceptionThrower.noStatusFound = noStatusFound;
        ExceptionThrower.activityNotCompletedYet = activityNotCompletedYet;
        ExceptionThrower.userNotAuthorizedToCompleteActivity = userNotAuthorizedToCompleteActivity;
        ExceptionThrower.activityAlreadyCompleted = activityAlreadyCompleted;
        ExceptionThrower.noParticipantsForActivity = noParticipantsForActivity;
        ExceptionThrower.volunteerIsNotApplicant = volunteerIsNotApplicant;
        ExceptionThrower.alreadyApplied = alreadyApplied;
        ExceptionThrower.editDeletedActivityNotPossible = editDeletedActivityNotPossible;
        ExceptionThrower.noVolunteerFound = noVolunteerFound;
    }

    public static void badRequest(ErrorMessage errorMessage)
    {
        String errorMessageString = extractString(errorMessage);
        throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, errorMessageString)
        {
        };
    }

    public static String extractString(ErrorMessage errorMessage)
    {
        String errorMessageString = "BAD_REQUEST: UNKNOWN ERROR";
        switch (errorMessage)
        {
            case WRONG_ROLES:
                errorMessageString = wrongRoles;
                break;
            case USERNAME_NOT_FOUND:
                errorMessageString = usernameNotFound;
                break;
            case ACTIVITIES_NOT_FOUND:
                errorMessageString = activitiesNotFound;
                break;
            case END_DATE_BEFORE_START_DATE:
                errorMessageString = endDateBeforeStartDate;
                break;
            case LOGGED_IN_USER_NOT_MATCHING_REQUEST:
                errorMessageString = loggedInUserNotMatchingRequest;
                break;
            case NO_MATCHING_ACTIVITY_FOUND:
                errorMessageString = noMatchingActivityFound;
                break;
            case NO_MATCHING_DRAFT_FOUND:
                errorMessageString = noMatchingDraftFound;
                break;
            case DELETE_ACTIVITY_WITH_PARTICIPANTS_NOT_POSSIBLE:
                errorMessageString = deleteActivityWithParticipantsNotPossible;
                break;
            case EDIT_ACTIVITY_WITH_APPLICANTS_OR_PARTICIPANTS_NOT_POSSIBLE:
                errorMessageString = editActivityWithApplicantsOrParticipantsNotPossible;
                break;
            case USER_NOT_INVOLVED_IN_ACTIVITY:
                errorMessageString = userNotInvolvedInActivity;
                break;
            case NO_STATUS_FOUND:
                errorMessageString = noStatusFound;
                break;
            case ACTIVITY_NOT_COMPLETED_YET:
                errorMessageString = activityNotCompletedYet;
                break;
            case USER_NOT_AUTHORIZED_TO_COMPLETE_ACTIVITY:
                errorMessageString = userNotAuthorizedToCompleteActivity;
                break;
            case ACTIVITY_ALREADY_COMPLETED:
                errorMessageString = activityAlreadyCompleted;
                break;
            case NO_PARTICIPANTS_FOR_ACTIVITY:
                errorMessageString = noParticipantsForActivity;
                break;
            case VOLUNTEER_IS_NOT_APPLICANT:
                errorMessageString = volunteerIsNotApplicant;
                break;
            case ALREADY_APPLIED:
                errorMessageString = alreadyApplied;
                break;
            case EDIT_DELETED_ACTIVITY_NOT_POSSIBLE:
                errorMessageString = editDeletedActivityNotPossible;
                break;
            case NO_VOLUNTEER_FOUND:
                errorMessageString = noVolunteerFound;
                break;

        }
        return errorMessageString;
    }
}
