package academy.everyonecodes.java.data.ProfileDTOs;

import academy.everyonecodes.java.data.Role;

import java.util.Objects;
import java.util.Set;

public class VolunteerProfileDTO extends ProfileDTO
{
    private String fullName;
    private int age;

    public VolunteerProfileDTO(String username, String email, Set<Role> roles, String fullName, int age)
    {
        super(username, email, roles);
        this.fullName = fullName;
        this.age = age;
    }

    public VolunteerProfileDTO(String username, String postalCode, String city, String street, String streetNumber, String email, String telephoneNumber, String description, Set<Role> roles, String fullName, int age)
    {
        super(username, postalCode, city, street, streetNumber, email, telephoneNumber, description, roles);
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VolunteerProfileDTO that = (VolunteerProfileDTO) o;
        return age == that.age && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), fullName, age);
    }
}
