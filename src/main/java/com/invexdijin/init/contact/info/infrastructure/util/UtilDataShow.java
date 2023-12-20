package com.invexdijin.init.contact.info.infrastructure.util;

import com.invexdijin.init.contact.info.infrastructure.model.in.InitSearchDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UtilDataShow {

    public InitSearchDto showFullNameWithAsterisk(InitSearchDto request) {
        String fullName = converterFullNameWithAsterisk(request.getFullName());
        String firstName = converterStringWithAsterisk(request.getFirstName());
        String lastName = converterStringWithAsterisk(request.getLastName());

        request.setFullName(fullName);
        request.setFirstName(firstName);
        request.setLastName(lastName);
        return request;
    }

    private String converterStringWithAsterisk(String originalWord) {
        String twoFirstLetters = originalWord.substring(0, Math.min(originalWord.length(), 2));

        return twoFirstLetters + "*".repeat(Math.max(0, originalWord.length() - 2));
    }

    private String converterFullNameWithAsterisk(String fullName){
        StringBuilder strFullName = new StringBuilder();
        String word[] = fullName.split(" ");
        Arrays.stream(word).forEach(w->{
            strFullName.append(converterStringWithAsterisk(w));
            strFullName.append(" ");
        });

        return strFullName.toString().trim();
    }
}
