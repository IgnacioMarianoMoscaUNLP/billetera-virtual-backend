package com.ignaciomariano.billetera.billetera_virtual_backend;

import com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity.Account;
import com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity.Transaction;
import com.ignaciomariano.billetera.billetera_virtual_backend.domain.entity.User;
import com.ignaciomariano.billetera.billetera_virtual_backend.domain.repository.AccountRepository;
import com.ignaciomariano.billetera.billetera_virtual_backend.domain.repository.TransactionRepository;
import com.ignaciomariano.billetera.billetera_virtual_backend.domain.repository.UserRepository;
import com.ignaciomariano.billetera.billetera_virtual_backend.domain.valueObject.Money;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Component
@Profile("dev")
public class DevDataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public DevDataSeeder(
            UserRepository userRepository,
            AccountRepository accountRepository,
            TransactionRepository transactionRepository
    ) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (userRepository.count() > 0) {
            return;
        }

        User u1 = new User();
        u1.setDniNumber(30123456);
        u1.setFirstName("Ignacio");
        u1.setLastName("Mosca");
        u1.setEmail("ignacio@example.com");
        u1.setPassword("dev123");
        u1.setStatus("ACTIVE");

        User u2 = new User();
        u2.setDniNumber(28987654);
        u2.setFirstName("Sofia");
        u2.setLastName("Perez");
        u2.setEmail("sofia@example.com");
        u2.setPassword("dev123");
        u2.setStatus("ACTIVE");

        User u3 = new User();
        u3.setDniNumber(31765432);
        u3.setFirstName("Juan");
        u3.setLastName("Gomez");
        u3.setEmail("juan@example.com");
        u3.setPassword("dev123");
        u3.setStatus("ACTIVE");

        userRepository.saveAll(List.of(u1, u2, u3));

        Account a1 = new Account();
        a1.setCvu("0000003100000000000001");
        a1.setBalance(Money.of(new BigDecimal("150000.00"),"ARS"));
        a1.setAccountHolder(u1);

        Account a2 = new Account();
        a2.setCvu("0000003100000000000002");
        a2.setBalance(Money.of(new BigDecimal("85000.50"),"ARS"));
        a2.setAccountHolder(u2);

        Account a3 = new Account();
        a3.setCvu("0000003100000000000003");
        a3.setBalance(Money.of(new BigDecimal("12500.00"),"ARS"));
        a3.setAccountHolder(u3);

        accountRepository.saveAll(List.of(a1, a2, a3));

        Timestamp now = new Timestamp(System.currentTimeMillis());

        Transaction t1 = new Transaction();
        t1.setOriginAccount(a1);
        t1.setDestinationAccount(a2);
        t1.setOriginCvu(a1.getCvu());
        t1.setDestinationCvu(a2.getCvu());
        t1.setAmount(2500.00f);
        t1.setCreatedAt(now);
        t1.setStatus(true);
        t1.setComment("Transferencia de prueba");

        Transaction t2 = new Transaction();
        t2.setOriginAccount(a2);
        t2.setDestinationAccount(a3);
        t2.setOriginCvu(a2.getCvu());
        t2.setDestinationCvu(a3.getCvu());
        t2.setAmount(1200.00f);
        t2.setCreatedAt(now);
        t2.setStatus(true);
        t2.setComment("Pago de prueba");

        Transaction t3 = new Transaction();
        t3.setOriginAccount(a3);
        t3.setDestinationAccount(a1);
        t3.setOriginCvu(a3.getCvu());
        t3.setDestinationCvu(a1.getCvu());
        t3.setAmount(500.00f);
        t3.setCreatedAt(now);
        t3.setStatus(false);
        t3.setComment("Transferencia fallida (test) ");

        transactionRepository.saveAll(List.of(t1, t2, t3));
    }
}
