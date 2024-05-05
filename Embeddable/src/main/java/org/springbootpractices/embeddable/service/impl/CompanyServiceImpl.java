package org.springbootpractices.embeddable.service.impl;

import lombok.RequiredArgsConstructor;
import org.springbootpractices.embeddable.model.Company;
import org.springbootpractices.embeddable.repository.CompanyRepository;
import org.springbootpractices.embeddable.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }
}
