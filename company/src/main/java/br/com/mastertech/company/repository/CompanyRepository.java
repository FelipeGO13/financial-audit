package br.com.mastertech.company.repository;

import br.com.mastertech.company.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
