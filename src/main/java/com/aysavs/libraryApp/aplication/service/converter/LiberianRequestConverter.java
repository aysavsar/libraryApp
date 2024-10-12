package com.aysavs.libraryApp.aplication.service.converter;

import com.aysavs.libraryApp.aplication.service.request.CreateLiberianRequest;
import com.aysavs.libraryApp.domain.aggragate.liberian.Liberian;
import org.springframework.stereotype.Component;

@Component
public class LiberianRequestConverter {
    public Liberian convert(CreateLiberianRequest createLiberianRequest){
        Liberian liberian=new Liberian();
        liberian.setName(createLiberianRequest.getName());
        liberian.setSurname(createLiberianRequest.getSurname());
        liberian.setGsmNumber(createLiberianRequest.getGsmNumber());
        liberian.setMailAddress(createLiberianRequest.getMailAddress());
        return liberian;
    }
}
