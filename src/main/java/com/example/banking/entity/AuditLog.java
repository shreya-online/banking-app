package com.example.banking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "audit_logs")
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "audit_action", nullable = false)
    private AuditAction auditAction;

    //stores the human-readable description of what happened.
    private String details;

    @CreationTimestamp
    @Column(name = "audit_created_at", updatable = false)
    private LocalDateTime createdAt;
}
