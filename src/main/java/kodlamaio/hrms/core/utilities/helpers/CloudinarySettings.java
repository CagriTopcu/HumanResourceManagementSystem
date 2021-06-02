package kodlamaio.hrms.core.utilities.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudinarySettings {
    private String cloudName;
    private String apiKey;
    private String apiSecret;
}
