package com.devoir.devoir.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "soumissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soumission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fichierUrl;

    @Column(precision = 5, scale = 2)
    private Double note;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    @Column
    private LocalDateTime dateSoumission = LocalDateTime.now();

    @Column
    private LocalDateTime dateCorrection;

    // Relations
    @ManyToOne
    @JoinColumn(name = "devoir_id", nullable = false)
    private Devoir devoir;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "corrected_by")
    private User correctedBy;
}