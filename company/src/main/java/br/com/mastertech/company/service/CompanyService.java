package br.com.mastertech.company.service;

import br.com.mastertech.company.model.Company;
import br.com.mastertech.company.producer.CompanyProducer;
import br.com.mastertech.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company create(Company company){
        return companyRepository.save(company);
    }
}
