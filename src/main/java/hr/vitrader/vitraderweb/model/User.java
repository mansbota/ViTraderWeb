package hr.vitrader.vitraderweb.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "dollars_amount")
    private double dollarsAmount;

    @OneToMany(mappedBy = "user")
    private List<Trade> trades;

    @OneToMany(mappedBy = "user")
    private List<Position> positions;
}
