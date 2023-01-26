package com.maveric.balanceservice.entity;

import com.maveric.balanceservice.enums.Currency;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "balance")
public class Balance {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String _id;
    private String accountId;
    private Number amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = true)
    private Date updatedAt =new Date();
}
