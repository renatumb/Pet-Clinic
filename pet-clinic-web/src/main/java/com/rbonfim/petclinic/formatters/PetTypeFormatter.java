package com.rbonfim.petclinic.formatters;

import com.rbonfim.petclinic.model.PetType;
import com.rbonfim.petclinic.service.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String s, Locale locale) throws ParseException {
        for (PetType petType : petTypeService.findAll()) {
            if (petType.getName().toLowerCase().equals(s.toLowerCase()))
                return petType;
        }
        throw new ParseException("type not found" + s, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
