package peaksoft.service;

import peaksoft.dto.RequestCompany;
import peaksoft.dto.response.ResponseCompany;
import peaksoft.model.Company;

import java.util.List;

public interface CompanyService {
    ResponseCompany saveCompany(RequestCompany company);
    ResponseCompany updateCompany(Long id,RequestCompany company);
    List<ResponseCompany> getAllCompanies(List<Company>companies);
    Company getCompanyById(Long id);
    void removeCompanyById(Long id);
}
