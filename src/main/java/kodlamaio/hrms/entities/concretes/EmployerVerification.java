package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "employers_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerVerification {
    @Id
    @Column(name = "employer_id")
    private int employer_id;

    @Column(name = "confirm")
    private boolean confirm;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "active")
    private boolean active;
}
