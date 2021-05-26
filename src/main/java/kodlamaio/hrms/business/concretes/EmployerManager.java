package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.EmployerVerificationService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.business.validators.EmployerValidator;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.business.ValidationTool;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private UserService userService;
    private VerificationService verificationService;
    private EmployerVerificationService employerVerificationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService,
                           VerificationService verificationService, EmployerVerificationService employerVerificationService) {
        this.employerDao = employerDao;
        this.userService = userService;
        this.verificationService = verificationService;
        this.employerVerificationService = employerVerificationService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
    }

    @Override
    public Result register(Employer employer) {
        var result = ValidationTool.run(EmployerValidator.checkIfEmptyFields(employer));
        var businessResult = BusinessRules.run(checkIfEmployerEmailExists(employer));

        if(result & businessResult){
            var saveEmployer = employerDao.save(employer);
            this.userService.register(saveEmployer);
            this.verificationService.add(saveEmployer);
            this.employerVerificationService.add(saveEmployer);
            System.out.println("Kayıt başarılı");
            return new SuccessResult();
        }
        return new ErrorResult();
    }

    private boolean checkIfEmployerEmailExists(Employer employer){
        var employers = employerDao.findByEmail(employer.getEmail());

        if(!employers.isEmpty()){
            System.out.println("Bu e-posta adresi zaten mevcut");
            return false;
        }
        return true;
    }
}
