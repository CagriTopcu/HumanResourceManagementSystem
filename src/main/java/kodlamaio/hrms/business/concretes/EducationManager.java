package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Başarıyla eklendi");
    }

    @Override
    public DataResult<List<Education>> findAllByOrderByGraduationDateAsc() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAllByOrderByGraduationDateAsc());
    }

    @Override
    public DataResult<List<Education>> findAllByOrderByGraduationDateDesc() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAllByOrderByGraduationDateDesc());
    }
}
