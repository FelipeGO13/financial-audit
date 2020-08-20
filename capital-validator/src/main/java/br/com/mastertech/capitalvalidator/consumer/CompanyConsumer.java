package br.com.mastertech.capitalvalidator.consumer;

import br.com.mastertech.capitalvalidator.dto.mapper.RegisteredCompanyMapper;
import br.com.mastertech.capitalvalidator.model.RegisteredCompany;
import br.com.mastertech.capitalvalidator.producer.CapitalValidatorProducer;
import br.com.mastertech.capitalvalidator.service.CapitalValidatorService;
import br.com.mastertech.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CompanyConsumer {

    @Autowired
    private CapitalValidatorService capitalValidatorService;

    @Autowired
    private RegisteredCompanyMapper registeredCompanyMapper;

    @Autowired
    private CapitalValidatorProducer capitalValidatorProducer;

    @KafkaListener(topics = "spec4-felipe-gabriel-2", groupId = "felioso")
    public void receive(@Payload Company company){
        RegisteredCompany registeredCompany = registeredCompanyMapper.toRegisteredCompany(capitalValidatorService.getByCNPJ(company));
        sendRegisteredCompany(registeredCompany);
    }

    public void sendRegisteredCompany(RegisteredCompany registeredCompany){
        capitalValidatorProducer.sendToKafka(registeredCompany);
    }

}
