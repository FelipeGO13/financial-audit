package br.com.mastertech.company.producer;

import br.com.mastertech.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CompanyProducer {

    @Autowired
    private KafkaTemplate<String, Company> producer;

    public void sendToKafka(Company company){
        producer.send("spec4-felipe-gabriel-2", company);
    }
}
