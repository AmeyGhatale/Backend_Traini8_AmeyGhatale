package com.buyogo.Traini8.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "training_centre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TrainingCenter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotBlank(message = "Center Name is required")
    @Size(max = 40, message = "Center Name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center Code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    private Address address;

    @Min(value = 0, message = "Student Capacity should be a positive number")
    private int studentCapacity;

    private List<String> coursesOffered;

    private Long createdOn;

    @Email(message = "Email should be valid")
    private String contactEmail;

    @Pattern(regexp = "^\\+?[0-9. ()-]{10,25}$", message = "Phone number is invalid")
    private String contactPhone;

    @PrePersist
    public void prePersist() {
        createdOn = Instant.now().getEpochSecond();
    }

}
