package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.business.validators.CandidateValidator;
import kodlamaio.hrms.core.utilities.adapters.HrmsVerificationService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.business.ValidationTool;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private UserService userService;
    private VerificationService verificationService;
    private HrmsVerificationService hrmsVerificationService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserService userService,
                            VerificationService verificationService, HrmsVerificationService hrmsVerificationService) {
        this.candidateDao = candidateDao;
        this.userService = userService;
        this.verificationService = verificationService;
        this.hrmsVerificationService = hrmsVerificationService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
    }

    @Override
    public Result register(Candidate candidate) {
        var result = ValidationTool.run(CandidateValidator.checkIfEmptyFields(candidate));
        var verification = this.verificationService.checkIfCandidates(candidate.getEmail()).isSuccess();
        var businessResults = BusinessRules.run(checkIfCandidateEmailExists(candidate), checkIfCandidateIdentityNumberExists(candidate));

        if(result && verification && businessResults){
            if(this.hrmsVerificationService.checkIdentityNumberForUsers(candidate.getIdentityNumber())){
                var saveCandidate = this.candidateDao.save(candidate);
                this.userService.register(saveCandidate);
                this.verificationService.add(saveCandidate);
                return new SuccessResult("Kayıt başarılı");
            }
            return new ErrorResult("Vatandaşlık numarası 11 haneli olmak zorunda");
        }
        return new ErrorResult();
    }

    private boolean checkIfCandidateEmailExists(Candidate candidate){
        var candidates = candidateDao.findByEmail(candidate.getEmail());

        if(!candidates.isEmpty()){
            System.out.println("Bu e-posta adresi zaten mevcut");
            return false;
        }
        return true;
    }

    private boolean checkIfCandidateIdentityNumberExists(Candidate candidate){
        var candidates = candidateDao.findByIdentityNumber(candidate.getIdentityNumber());

        if(!candidates.isEmpty()){
            System.out.println("Bu vatandaşlık numarası zaten mevcut");
        }
        return true;
    }
}
