package hr.vitrader.vitraderweb.model;

import hr.vitrader.vitraderweb.model.enums.TradeType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "crypto_id", referencedColumnName = "id")
    private Crypto crypto;

    @Enumerated(value = EnumType.STRING)
    private TradeType tradeType;

    @Column(name = "crypto_amount")
    private double cryptoAmount;

    @Column(name = "dollars_amount")
    private double dollarsAmount;
}
