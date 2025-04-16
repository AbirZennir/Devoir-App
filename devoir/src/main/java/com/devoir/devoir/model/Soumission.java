package com.devoir.devoir.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "soumissions")
public class Soumission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "devoir_id", nullable = false)
    private Devoir devoir;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "fichier_url", length = 255)
    private String fichierUrl;

    private Double note;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    @Column(name = "date_soumission", updatable = false)
    private LocalDateTime dateSoumission = LocalDateTime.now();
}