package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerVerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerVerificationDao;
import kodlamaio.hrms.entities.concretes.EmployerVerification;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployerVerificationManager implements EmployerVerificationService {
    private EmployerVerificationDao employerVerificationDao;
    private EmployerVerification employerVerification;

    @Autowired
    public EmployerVerificationManager(EmployerVerificationDao employerVerificationDao) {
        this.employerVerificationDao = employerVerificationDao;
    }

    @Override
    public Result add(User user) {
        employerVerification = new EmployerVerification();
        employerVerification.setEmployer_id(user.getId());
        employerVerification.setConfirm(true);
        employerVerification.setCreate_date(new Date());

        this.employerVerificationDao.save(employerVerification);
        return new SuccessResult();
    }
}
