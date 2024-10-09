package com.buyogo.Traini8.DTO;

import com.buyogo.Traini8.Model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TrainingCenterDTO {

    private String centerName;

    private String centerCode;

    private Address address;

    private int studentCapacity;

    private List<String> coursesOffered;

    private Long createdOn;

    private String contactEmail;

    private String contactPhone;
}
