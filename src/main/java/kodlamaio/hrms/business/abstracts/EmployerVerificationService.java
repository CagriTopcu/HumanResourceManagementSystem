package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface EmployerVerificationService {
    Result add(User user);
}
