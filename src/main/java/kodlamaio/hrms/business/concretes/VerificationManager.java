package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.VerificationDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VerificationManager implements VerificationService {
    private VerificationDao verificationDao;
    private Verification verification;

    @Autowired
    public VerificationManager(VerificationDao verificationDao) {
        this.verificationDao = verificationDao;
    }

    @Override
    public Result add(User user) {
        verification = new Verification();
        verification.setUser_id(user.getId());
        verification.setConfirm(true);
        verification.setCreate_date(new Date());

        this.sendVerificationMail();
        this.verifiedUser();

        this.verificationDao.save(verification);
        return new SuccessResult();
    }

    @Override
    public DataResult<Boolean> checkIfCandidates(String... emails) {
        for(String email : emails){
            if(email.contains("@gmail") || email.contains("@hotmail") || email.contains("@outlook")){
                return new SuccessDataResult<Boolean>();
            }
        }
        System.out.println("Hata");
        return new ErrorDataResult<Boolean>();
    }

    @Override
    public Result sendVerificationMail() {
        System.out.println("Doğrulama bağlantısı e-posta adresinize gönderildi");
        return new SuccessResult();
    }

    @Override
    public Result verifiedUser() {
        System.out.println("Doğrulama başarılı");
        return new SuccessResult();
    }

    @Override
    public Result noVerifiedUser() {
        System.out.println("Doğrulama başarısız");
        return new SuccessResult();
    }
}
