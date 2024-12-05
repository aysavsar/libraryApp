package com.aysavs.libraryApp.aplication.service.request.member;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String mailAddress;

    @NotBlank
    private String job;

    private long gsmNumber;

    private String status;
}
