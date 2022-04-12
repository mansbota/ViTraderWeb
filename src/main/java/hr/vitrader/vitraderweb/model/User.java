package hr.vitrader.vitraderweb.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;

    @Column(name = "username")
    private String userName;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "is_validated")
    private boolean isValidated;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "user")
    private List<Trade> trades;

    @OneToMany(mappedBy = "user")
    private List<Position> positions;
}
