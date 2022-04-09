package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.RequestCompany;
import peaksoft.dto.response.ResponseCompany;
import peaksoft.model.Company;
import peaksoft.service.serviceImple.CompanyServiceImple;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyServiceImple service;

    @PostMapping
    public ResponseCompany create(@RequestBody RequestCompany companyRequest) {
        return service.saveCompany(companyRequest);

    }

    @PutMapping("/update/{id}")
    public ResponseCompany update(@PathVariable Long id, @RequestBody RequestCompany companyRequest) {
       return service.updateCompany(id, companyRequest);
    }

    @DeleteMapping("{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        service.removeCompanyById(id);
    }

    @GetMapping("{id}")
    public Company getCompanyById(@PathVariable ("id")Long id) {
        return service.getCompanyById(id);
    }
    @GetMapping("/all")
    public List<ResponseCompany> getCompanies(@RequestBody List<Company> companies){
        return service.getAllCompanies(companies);
    }
}


