package br.com.mastertech.capitalvalidator.producer;

import br.com.mastertech.capitalvalidator.model.RegisteredCompany;
import br.com.mastertech.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CapitalValidatorProducer {

    @Autowired
    private KafkaTemplate<String, RegisteredCompany> producer;

    public void sendToKafka(RegisteredCompany registeredCompany){
        producer.send("spec4-felipe-gabriel-1", registeredCompany);
    }
}
