package com.expeditors.validations.medicalfacility.dto;

import com.expeditors.validations.medicalfacility.model.Patient;
import com.expeditors.validations.medicalfacility.model.formats.StateFormat;
import com.expeditors.validations.medicalfacility.validation.ValidAddress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PatientRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private Integer age;
    private String email;

    @ValidAddress(value = StateFormat.ANSI)
    private Address address;

    @NotBlank
    @Pattern(regexp = "[0-9]{3}-[0-9]{2}-[0-9]{4}")
    private String ssn;

    public Patient toEntity() {
        return Patient.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .age(age)
                .email(email)
                .build();
    }
}
