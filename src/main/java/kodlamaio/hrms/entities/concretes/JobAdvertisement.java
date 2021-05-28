package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_advertisement_id")
    private int jobAdvertisementId;

    //@Column(name = "employer_id")
    //private int employerId;

    //@Column(name = "job_position_id")
    //private int jobPositionId;

    //@Column(name = "city_id")
    //private int cityId;

    @Column(name = "job_advertisement_description")
    private String jobAdvertisementDescription;

    @Column(name = "job_salary_min")
    private int jobSalaryMin;

    @Column(name = "job_salary_max")
    private int jobSalaryMax;

    @Column(name = "number_of_open_job_positions")
    private int numberOfOpenJobPosition;

    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
}
