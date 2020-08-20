package br.com.mastertech.capitalvalidator.service;

import br.com.mastertech.capitalvalidator.dto.GetRegisteredCompanyResponse;
import br.com.mastertech.capitalvalidator.dto.mapper.RegisteredCompanyMapper;
import br.com.mastertech.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CapitalValidatorService {

    private static final String CAPITAL_API_URI =  "https://www.receitaws.com.br/v1/cnpj/";
    private static final BigDecimal CAPITAL_LIMIT =  new BigDecimal(1000000.00);

    public GetRegisteredCompanyResponse getByCNPJ(Company company){
        RestTemplate restTemplate = new RestTemplate();

        String completeCapitalUri = CAPITAL_API_URI.concat(company.getCnpj().toString());

        GetRegisteredCompanyResponse registeredCompanyResponse = restTemplate.getForObject(completeCapitalUri, GetRegisteredCompanyResponse.class);

        registeredCompanyResponse.setId(company.getId());
        registeredCompanyResponse.setValid(false);
        if(new BigDecimal(registeredCompanyResponse.getCapital()).compareTo(CAPITAL_LIMIT) > -1){
            registeredCompanyResponse.setValid(true);
        }

        registeredCompanyResponse.setId(company.getId());

        return registeredCompanyResponse;
    }
}
