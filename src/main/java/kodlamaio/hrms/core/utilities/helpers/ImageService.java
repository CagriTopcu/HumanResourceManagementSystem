package kodlamaio.hrms.core.utilities.helpers;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageService {
    DataResult<Map> save(MultipartFile file);
}
