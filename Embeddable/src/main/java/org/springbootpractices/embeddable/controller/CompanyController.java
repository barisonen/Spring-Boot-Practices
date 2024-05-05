package org.springbootpractices.embeddable.controller;

import lombok.RequiredArgsConstructor;
import org.springbootpractices.embeddable.model.Company;
import org.springbootpractices.embeddable.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<Company> getCompany() {
        return companyService.getAllCompanies();
    }

    @PostMapping
    private Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }
}
