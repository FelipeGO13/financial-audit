package br.com.mastertech.company.dto;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;

public class CreateCompanyRequest {

    @NotNull
    @CNPJ
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
