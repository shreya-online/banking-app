package com.example.banking.entity;

import com.example.banking.entity.enums.TransactionStatus;
import com.example.banking.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "transactions")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  //many transactions belong to one account.
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "transaction_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name = "transaction_ref_id", unique = true, nullable = false)
    private String referenceId;

    private String description;

    @CreationTimestamp
    @Column(name = "transaction_created_at")
    private LocalDateTime createdAt;
}
