package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao){
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var businessResult = BusinessRules.run(checkIfJobPositionExists(jobPosition));
        if(businessResult){
            this.jobPositionDao.save(jobPosition);
            System.out.println("İş pozisyonu eklendi");
            return new SuccessResult();
        }
        return new ErrorResult();
    }

    private boolean checkIfJobPositionExists(JobPosition jobPosition){
        var jobPositions = jobPositionDao.findAll();

        for(JobPosition checkJobPosition : jobPositions){
            if(checkJobPosition.getName() == jobPosition.getName()){
                System.out.println("Bu iş pozisyonu zaten mevcut");
            }
        }
        return true;
    }

}
