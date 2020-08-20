package br.com.mastertech.company.dto.mapper;

import br.com.mastertech.company.dto.CreateCompanyRequest;
import br.com.mastertech.company.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company toCompany(CreateCompanyRequest createCompanyRequest){
        Company company = new Company();

        company.setCnpj(createCompanyRequest.getCnpj());

        return company;
    }
}
