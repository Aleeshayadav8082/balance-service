package com.maveric.balanceservice.mapper;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.entity.Balance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BalanceMapperImpl implements BalanceMapper{
    @Override
    public Balance dtoToEntity(BalanceDto balanceDto) {
        return Balance.builder()
                ._id(balanceDto.get_id())
                .amount(balanceDto.getAmount())
                .accountId(balanceDto.getAccountId())
                .currency(balanceDto.getCurrency())
                .createdAt(balanceDto.getCreatedAt())
                .updatedAt(balanceDto.getUpdatedAt())
                .build();
    }

    @Override
    public BalanceDto entityToDto(Balance balance) {
        return BalanceDto.builder()
                ._id(balance.get_id())
                .amount(balance.getAmount())
                .accountId(balance.getAccountId())
                .currency(balance.getCurrency())
                .createdAt(balance.getCreatedAt())
                .updatedAt(balance.getUpdatedAt())
                .build();
    }

    @Override
    public List<Balance> dtoToEntity(List<BalanceDto> balanceDtos) {
        return balanceDtos.stream().map(balanceDto ->  Balance.builder()
                ._id(balanceDto.get_id())
                .accountId(balanceDto.getAccountId())
                .amount(balanceDto.getAmount())
                .currency(balanceDto.getCurrency())
                .createdAt(balanceDto.getCreatedAt())
                .updatedAt(balanceDto.getUpdatedAt())
                .build()
        ).toList();
    }

    @Override
    public List<BalanceDto> entityToDto(List<Balance> balances) {
        return balances.stream().map(balance ->  BalanceDto.builder()


                ._id(balance.get_id())
                .accountId(balance.getAccountId())
                .currency(balance.getCurrency())
                .amount(balance.getAmount())
                .createdAt(balance.getCreatedAt())
                .updatedAt(balance.getUpdatedAt())
                .build()
        ).toList();
    }
}