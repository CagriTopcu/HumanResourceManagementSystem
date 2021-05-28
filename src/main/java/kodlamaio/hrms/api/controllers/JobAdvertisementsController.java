package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getbyactive")
    public DataResult<List<JobAdvertisement>> getByActive(){
        return this.jobAdvertisementService.findByActiveTrue();
    }

    @GetMapping("/findByActiveTrueOrderByCreateDateAsc")
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateAsc(){
        return this.jobAdvertisementService.findByActiveTrueOrderByCreateDateAsc();
    }

    @GetMapping("/findByActiveTrueOrderByCreateDateDesc")
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateDesc(){
        return this.jobAdvertisementService.findByActiveTrueOrderByCreateDateDesc();
    }

    @GetMapping("/findByActiveTrueAndEmployer")
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployer(@RequestParam int employerId){
        return this.jobAdvertisementService.findByActiveTrueAndEmployer(employerId);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.update(jobAdvertisement);
    }
}
