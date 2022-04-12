package hr.vitrader.vitraderweb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

    @ManyToOne
    @JoinColumn(name = "trade_type_id", referencedColumnName = "id")
    private TradeType tradeType;

    @Column(name = "trade_amount")
    private double tradeAmount;
}
