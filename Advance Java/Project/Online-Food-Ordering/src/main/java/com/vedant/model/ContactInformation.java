package com.vedant.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInformation {

    private String email;
    private String mobile;
    private String twitter;
    private String instagram;
}