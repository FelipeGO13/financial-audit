package br.com.mastertech.company.controller;

import br.com.mastertech.company.dto.CreateCompanyRequest;
import br.com.mastertech.company.dto.mapper.CompanyMapper;
import br.com.mastertech.company.model.Company;
import br.com.mastertech.company.producer.CompanyProducer;
import br.com.mastertech.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/empresa")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyProducer companyProducer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@Valid @RequestBody CreateCompanyRequest createCompanyRequest){
        Company company = companyService.create(companyMapper.toCompany(createCompanyRequest));
        companyProducer.sendToKafka(company);
        return company;
    }
}
