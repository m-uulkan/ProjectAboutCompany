package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.RequestCompany;
import peaksoft.dto.response.ResponseCompany;
import peaksoft.model.Company;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapper {

    public Company create(RequestCompany companyRequest) {
        Company company = new Company();
        company.setNameOfCompany(companyRequest.getNameOfCompany());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

        return company;

    }
    public void update(Company company, RequestCompany companyRequest){
        company.setNameOfCompany(companyRequest.getNameOfCompany());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }

    public ResponseCompany viewCompany(Company company){
        if(company==null){
            return null;
        }
        ResponseCompany companyResponse=new ResponseCompany();
        if(company.getId() !=null){
            companyResponse.setId(String.valueOf(company.getId()));
        }
        companyResponse.setNameOfCompany(company.getNameOfCompany());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        return companyResponse;
    }

    public List<ResponseCompany> viewCompanies(List<Company>companies){
        List<ResponseCompany>responses=new ArrayList<>();
        for(Company c:companies){
            responses.add(viewCompany(c));
        }
        return responses;
    }


}
