package com.devoir.devoir.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "devoirs")
public class Devoir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer maxPoints; // Nombre maximum de points pour ce devoir

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy; // Relation vers l'enseignant qui a créé le devoir

    @OneToMany(mappedBy = "devoir", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Soumission> soumissions = new ArrayList<>(); // Liste des soumissions associées au devoir

    // Constructeurs
    public Devoir() {
        // Constructeur par défaut requis par JPA
    }

    public Devoir(String titre, String description, Integer maxPoints, User createdBy) {
        this.titre = titre;
        this.description = description;
        this.maxPoints = maxPoints;
        this.createdBy = createdBy;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Soumission> getSoumissions() {
        return soumissions;
    }

    public void setSoumissions(List<Soumission> soumissions) {
        this.soumissions = soumissions;
    }

    // Méthode pour ajouter une soumission au devoir
    public void addSoumission(Soumission soumission) {
        soumissions.add(soumission);
        soumission.setDevoir(this); // Mettre à jour la relation bidirectionnelle
    }

    // Méthode pour supprimer une soumission du devoir
    public void removeSoumission(Soumission soumission) {
        soumissions.remove(soumission);
        soumission.setDevoir(null); // Mettre à jour la relation bidirectionnelle
    }

    // Méthode métier : Vérifier si le devoir est valide
    public boolean isValid() {
        return titre != null && !titre.isEmpty() && maxPoints != null && maxPoints > 0;
    }

    // Méthode toString pour un affichage facile
    @Override
    public String toString() {
        return "Devoir{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", maxPoints=" + maxPoints +
                ", createdBy=" + (createdBy != null ? createdBy.getId() : "null") +
                '}';
    }
}