package com.maveric.balanceservice.dto;

import com.maveric.balanceservice.enums.Currency;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor

@AllArgsConstructor(access= AccessLevel.PUBLIC)
public class BalanceDto {
    private String  _id;
    @NotNull(message = "accountId should not be empty")

    private String accountId;
    @NotNull(message = "amount should not be empty")
    @Min(value =0,message = "ammount should not le lesser than 0")
    //    @Min(value = 0,message = "Amount shouldn't be lesser than zero")
    private Number amount;
    //    @Valid
//    @NotNull(message = "Currency is mandatory INR/DOLLAR/EURO ")
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = true)
    private Date updatedAt =new Date();


}