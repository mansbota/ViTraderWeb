package hr.vitrader.vitraderweb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "trade_type")
public class TradeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @ManyToOne
    private Crypto tradedForCrypto;

    @Column(name = "amount_traded_for")
    private double amountTradedFor;
}
