package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.hrmsVerification.HrmsVerificationManager;
import org.springframework.stereotype.Service;

@Service
public class HrmsVerificationManagerAdapter implements HrmsVerificationService {
    private HrmsVerificationManager hrmsVerificationManager;

    public HrmsVerificationManagerAdapter(HrmsVerificationManager hrmsVerificationManager) {
        this.hrmsVerificationManager = hrmsVerificationManager;
    }

    @Override
    public boolean checkIdentityNumberForUsers(String identityNumber) {
        return this.hrmsVerificationManager.checkIdentityNumber(identityNumber);
    }
}
