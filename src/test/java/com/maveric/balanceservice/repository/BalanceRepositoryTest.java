package com.maveric.balanceservice.repository;

import com.maveric.balanceservice.entity.Balance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static com.maveric.balanceservice.BalanceServiceApplicationTests.getBalance;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest


public class BalanceRepositoryTest {
    @Autowired
    BalanceRepository repository;

    @Test
    public void testSave() {
        Balance balance = repository.save(getBalance());

        assertEquals("123",balance.getAccountId());
    }

    @Test
    public void testFindAll() {
        List<Balance> balances = repository.findAll();
        assertNotNull(balances);
        assert(balances.size()>0);

    }


}
