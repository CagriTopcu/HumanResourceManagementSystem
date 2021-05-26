package kodlamaio.hrms.business.validators;

import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateValidator {
    public static boolean checkIfEmptyFields(Candidate candidate){
        if(candidate.getFirst_name().isEmpty() && candidate.getLast_name().isEmpty() && candidate.getIdentityNumber().isEmpty() &&
            candidate.getYear_of_birth().toString().isEmpty() && candidate.getPassword().isEmpty() && candidate.getConfirm_password().isEmpty()){
            return false;
        }
        return true;
    }
}
