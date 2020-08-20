package br.com.mastertech.companyregister;

import br.com.mastertech.capitalvalidator.model.RegisteredCompany;
import com.opencsv.CSVWriter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class RegisteredCompanyConsumer {

    public static final String CSV_FILE_NAME = "registered_companies.csv";

    @KafkaListener(topics = "spec4-felipe-gabriel-1", groupId = "felioso")
    public void receive(@Payload RegisteredCompany registeredCompany) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_NAME, true));
        String registeredCompanyData = new StringBuilder()
                .append(registeredCompany.getId())
                .append(",")
                .append(registeredCompany.getCnpj())
                .append(",")
                .append(registeredCompany.isValid()).toString();

        writer.writeNext(registeredCompanyData.split(","));
        writer.close();
    }
}
