package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.RequestCompany;
import peaksoft.dto.response.ResponseCompany;
import peaksoft.mapper.CompanyMapper;
import peaksoft.model.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImple implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;



    @Override
    public ResponseCompany saveCompany(RequestCompany companyRequest) {
        return  companyMapper.viewCompany(companyRepository.save(companyMapper.create(companyRequest)));
    }

    @Override
    public ResponseCompany updateCompany(Long id, RequestCompany companyRequest) {
    Company company1=companyRepository.findById(id).get();
    companyMapper.update(company1,companyRequest);
    return companyMapper.viewCompany(companyRepository.save(company1));
    }

    @Override
    public List<ResponseCompany>getAllCompanies(List<Company>companies) {
        List<Company>companyList=companyRepository.findAll();
        return companyMapper.viewCompanies(companyList);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public void removeCompanyById(Long id) {
        Company company=companyRepository.findById(id).get();
        companyRepository.deleteById(id);
        companyMapper.viewCompany(company);
    }
}

