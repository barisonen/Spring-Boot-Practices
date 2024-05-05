package org.springbootpractices.embeddable.service;

import org.springbootpractices.embeddable.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company createCompany(Company company);
}
