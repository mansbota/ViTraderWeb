package hr.vitrader.vitraderweb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "crypto_id", referencedColumnName = "id")
    private Crypto crypto;

    @Column(name = "amount")
    private double amount;
}
