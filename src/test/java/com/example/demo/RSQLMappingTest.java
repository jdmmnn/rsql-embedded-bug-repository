package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.AddressHistoryEntity;
import com.example.demo.repository.AccountRepository;
import io.github.perplexhub.rsql.RSQLCommonSupport;
import io.github.perplexhub.rsql.RSQLJPASupport;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {MySQLContainerConfig.class, DemoApplication.class})
class RSQLMappingTest {

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    void cleanupBeforeTest() {
        accountRepository.deleteAll();
    }

    @Test
    void testSearchForActiveSince() { // this is only a simple query test

        // Given
        AccountEntity account1 = new AccountEntity("account-ident-0");

        account1.setAddressHistory(
                List.of(
                        new AddressHistoryEntity(
                                account1,
                                OffsetDateTime.of(2024, 7, 1, 0, 0, 0, 0, ZoneOffset.UTC),
                                new AddressEntity("Name 1", "some address 1"),
                                new AddressEntity("Name 1", "some other address 2")),
                        new AddressHistoryEntity(
                                account1,
                                OffsetDateTime.of(1900, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
                                new AddressEntity("Name 1", "old address 1"),
                                new AddressEntity("Name 1", "old address 1"))));
        accountRepository.save(account1);

        // When
        List<AccountEntity> result = accountRepository.findAll(RSQLJPASupport.rsql("addressHistory.activeSince=ge=2024-06-01T00:00:00Z"));

        // Then
        assertThat(result).hasSize(1);
    }

    @Test
    void testSearchInListWhichContainEmbeddedClass() {
        // Given
        AccountEntity account1 = new AccountEntity("account-ident-1");

        account1.setAddressHistory(
                List.of(
                        new AddressHistoryEntity(
                                account1,
                                OffsetDateTime.of(2024, 7, 1, 0, 0, 0, 0, ZoneOffset.UTC),
                                new AddressEntity("Name 1", "some address 1"),
                                new AddressEntity("Name 1", "some other address 2")),
                        new AddressHistoryEntity(
                                account1,
                                OffsetDateTime.of(1900, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
                                new AddressEntity("Name 1", "old address 1"),
                                new AddressEntity("Name 1", "old address 1"))));
        accountRepository.save(account1);

        // When
        List<AccountEntity> result = accountRepository.findAll(RSQLJPASupport.rsql("addressHistory.invoiceAddress.name=='Name 1'"));

        // Then
        assertThat(result).hasSize(1);
    }

    @Test
    void testSearchInListWhichContainEmbeddedClassWithRSQLMapping() {
        // Given
        RSQLCommonSupport.addMapping(AccountEntity.class, "invoiceAddress", "addressHistory.invoiceAddress");

        AccountEntity account1 = new AccountEntity("account-ident-2");

        account1.setAddressHistory(
                List.of(
                        new AddressHistoryEntity(
                                account1,
                                OffsetDateTime.of(2024, 7, 1, 0, 0, 0, 0, ZoneOffset.UTC),
                                new AddressEntity("Name 1", "some address 1"),
                                new AddressEntity("Name 1", "some other address 2")),
                        new AddressHistoryEntity(
                                account1,
                                OffsetDateTime.of(1900, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
                                new AddressEntity("Name 1", "old address 1"),
                                new AddressEntity("Name 1", "old address 1"))));
        accountRepository.save(account1);

        // When
        List<AccountEntity> result = accountRepository.findAll(RSQLJPASupport.rsql("invoiceAddress.name=='Name 1'"));
        // error: 'Unknown property: name from entity com.example.demo.entity.AccountEntity'

        // Then
        assertThat(result).hasSize(1);
    }
}
