package net.javacrud.springboot_restful_webservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDto {

    private long id;
    // User FirstName Should not be null or empty
    @NotEmpty(message = "User firstName Should not be empty")
    private String firstName;
    // User LastName Should not be null or empty
   @NotEmpty(message = "User LastName Should not be empty")
    private String lastName;
    // User Email Should not be null or empty
    //Email address should be valid
    @NotEmpty(message = "User email Should not be empty")
    @Email(message = "Email address should be valid")
    private String email;

    public UserDto(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto() {
    }
}
