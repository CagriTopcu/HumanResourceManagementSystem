package kodlamaio.hrms.hrmsVerification;

import org.springframework.stereotype.Service;

@Service
public class HrmsVerificationManager {
    public boolean checkIdentityNumber(String identityNumber){
        if(identityNumber.length() <= 11 && identityNumber.length() > 10){
            return true;
        }else {
            return false;
        }
    }
}
