package academy.everyonecodes.java.data;

import java.util.Objects;
import java.util.Optional;

public class ProfileDTO
{
    private Long id;
    private String username;
    private String fullName;
    private Optional<String> companyName;
    private int age;
    private Optional<String> description;

    public ProfileDTO()
    {
    }

    public ProfileDTO(String username, String fullName, int age)
    {
        this.username = username;
        this.fullName = fullName;
        this.age = age;
    }

    public ProfileDTO(String username, String fullName, int age, Optional<String> description)
    {
        this.username = username;
        this.fullName = fullName;
        this.age = age;
        this.description = description;
    }

    public ProfileDTO(String username, String fullName, Optional<String> companyName, Optional<String> description)
    {
        this.username = username;
        this.fullName = fullName;
        this.companyName = companyName;
        this.description = description;
    }

    public ProfileDTO(String username, String fullName, Optional<String> companyName, int age, Optional<String> description)
    {
        this.username = username;
        this.fullName = fullName;
        this.companyName = companyName;
        this.age = age;
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public Optional<String> getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(Optional<String> companyName)
    {
        this.companyName = companyName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Optional<String> getDescription()
    {
        return description;
    }

    public void setDescription(Optional<String> description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDTO that = (ProfileDTO) o;
        return age == that.age && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(fullName, that.fullName) && Objects.equals(companyName, that.companyName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, username, fullName, companyName, age, description);
    }
}
