package kodlamaio.hrms.business.validators;

import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator {
    public static boolean checkIfEmptyFields(Employer employer){
        if(employer.getCompany_name().isEmpty() && employer.getPhone().isEmpty() && employer.getCreate_date().toString().isEmpty() &&
            employer.getWebsite().isEmpty()){
            return false;
        }
        return true;
    }
}
