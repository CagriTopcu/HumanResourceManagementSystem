package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        var result = this.jobAdvertisementDao.findById(jobAdvertisement.getJobAdvertisementId()).get();
        result.setActive(false);
        jobAdvertisementDao.save(result);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrue(),"Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByCreateDateAsc(), "Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByCreateDateDesc(), "Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployer(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueAndEmployerId(employerId), "Data listelendi");
    }
}
