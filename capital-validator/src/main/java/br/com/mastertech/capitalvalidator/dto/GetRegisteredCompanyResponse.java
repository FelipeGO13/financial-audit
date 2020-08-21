package br.com.mastertech.capitalvalidator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRegisteredCompanyResponse {

    private Long id;

    private String cnpj;

    @JsonProperty("capital_social")
    private String capital;

    private boolean valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
