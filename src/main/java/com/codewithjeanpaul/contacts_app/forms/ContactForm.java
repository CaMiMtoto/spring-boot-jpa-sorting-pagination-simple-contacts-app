package com.codewithjeanpaul.contacts_app.forms;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ContactForm {

    @NotBlank(message = "Name is required")
    @Min(value = 3, message = "Name must be at least 3 characters")
    private String name;

    @Email(message = "Email is invalid")
    private String email;

    @NotBlank(message = "Phone is required")
    @NotNull(message = "Phone is required")
    @Min(value = 10, message = "Phone must be at least 10 characters")
    @Max(value = 20, message = "Phone must be at most 20 characters")
    private String phone;
    private String address;
}
