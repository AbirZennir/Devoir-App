package com.devoir.devoir.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column
    private String type; // NEW_DEVOIR, GRADE, REMINDER

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isRead = false;

    @Column
    private Integer relatedEntityId;

    @Column
    private String relatedEntityType;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Relations
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}