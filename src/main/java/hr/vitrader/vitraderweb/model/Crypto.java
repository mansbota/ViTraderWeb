package hr.vitrader.vitraderweb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "crypto")
public class Crypto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name")
    private String name;
}
