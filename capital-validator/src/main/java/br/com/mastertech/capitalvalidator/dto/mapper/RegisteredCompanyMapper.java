package br.com.mastertech.capitalvalidator.dto.mapper;

import br.com.mastertech.capitalvalidator.dto.GetRegisteredCompanyResponse;
import br.com.mastertech.capitalvalidator.model.RegisteredCompany;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class RegisteredCompanyMapper {

    public RegisteredCompany toRegisteredCompany(GetRegisteredCompanyResponse registeredCompanyResponse){
        RegisteredCompany registeredCompany = new RegisteredCompany();

        registeredCompany.setId(registeredCompanyResponse.getId());
        registeredCompany.setCnpj(registeredCompanyResponse.getCnpj());
        registeredCompany.setCapital(new BigDecimal(registeredCompanyResponse.getCapital()));
        registeredCompany.setValid(registeredCompanyResponse.isValid());

        return registeredCompany;
    }

}
