package hr.vitrader.vitraderweb.bootstrap;

import hr.vitrader.vitraderweb.model.*;
import hr.vitrader.vitraderweb.model.enums.TradeType;
import hr.vitrader.vitraderweb.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final CryptoRepository cryptoRepository;
    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final TradeRepository tradeRepository;

    @Override
    public void run(String... args) throws Exception {

        Person person1 = Person.builder()
                .id(1L)
                .dateOfBirth(LocalDate.now())
                .emailAddress("email@smt.com")
                .firstName("John")
                .lastName("Smith")
                .build();

        Person person2 = Person.builder()
                .id(2L)
                .dateOfBirth(LocalDate.now())
                .emailAddress("email2@smt.com")
                .firstName("Jack")
                .lastName("McJacky")
                .build();

        personRepository.save(person1);
        personRepository.save(person2);

        Crypto crypto1 = Crypto.builder()
                .id(1L)
                .name("bitcoin")
                .ticker("BTC")
                .build();

        Crypto crypto2 = Crypto.builder()
                .id(2L)
                .name("ethereum")
                .ticker("ETH")
                .build();

        cryptoRepository.save(crypto1);
        cryptoRepository.save(crypto2);

        User user1 = User.builder()
                .id(1L)
                .userName("JohnAccount")
                .dateCreated(LocalDate.now())
                .dollarsAmount(1000)
                .password("JohnPass")
                .person(person1)
                .build();

        User user2 = User.builder()
                .id(2L)
                .userName("JackAccount")
                .dateCreated(LocalDate.now())
                .dollarsAmount(2000)
                .password("JackPass")
                .person(person2)
                .build();

        userRepository.save(user1);
        userRepository.save(user2);

        Trade trade1 = Trade.builder()
                .id(1L)
                .tradeType(TradeType.BUY)
                .crypto(crypto1)
                .cryptoAmount(0.1)
                .dollarsAmount(100)
                .user(user1)
                .build();

        Trade trade2 = Trade.builder()
                .id(2L)
                .tradeType(TradeType.BUY)
                .crypto(crypto2)
                .cryptoAmount(0.5)
                .dollarsAmount(400)
                .user(user2)
                .build();

        tradeRepository.save(trade1);
        tradeRepository.save(trade2);

        Position position1 = Position.builder()
                .id(1L)
                .crypto(crypto1)
                .amount(0.1)
                .user(user1)
                .build();

        Position position2 = Position.builder()
                .id(2L)
                .crypto(crypto2)
                .amount(0.5)
                .user(user2)
                .build();

        positionRepository.save(position1);
        positionRepository.save(position2);

        user1.setPositions(new ArrayList<>());
        user1.setTrades(new ArrayList<>());
        user2.setTrades(new ArrayList<>());
        user2.setPositions(new ArrayList<>());

        user1.getPositions().add(position1);
        user1.getTrades().add(trade1);
        user2.getTrades().add(trade2);
        user2.getPositions().add(position2);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
