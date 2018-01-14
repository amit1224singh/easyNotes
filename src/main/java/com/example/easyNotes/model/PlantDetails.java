package com.example.easyNotes.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plant")
@EntityListeners(AuditingEntityListener.class)
public class PlantDetails implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(nullable = false)
    private String habit;

    @Column(nullable = false)
    private String family;

    @Column(nullable = false)
    private String genus;

    @Column(nullable = false)
    private String species;

    @Column
    private String  synonyms;

    @Column
    private  String localName;

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @Column(name = "leaf_arrangement")
    private String leafArrangement;

    @Column(name = "leaf_type")
    private String leafType;

    @Column(name = "leaf_shape")
    private String leafShape;

    @Column(name = "leaf_base")
    private String leafBase;

    @Column(name = "leaf_tip")
    private String leafTip;

    @Column(name = "leaf_margin")
    private String leafMargin;

    @Column(name = "fruit_type")
    private String fruitType;

    @Column(name = "flower_colour")
    private String flowerColour;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    public String getLeafArrangement() {
        return leafArrangement;
    }

    public void setLeafArrangement(String leafArrangement) {
        this.leafArrangement = leafArrangement;
    }

    public String getLeafType() {
        return leafType;
    }

    public void setLeafType(String leafType) {
        this.leafType = leafType;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public String getFlowerColour() {
        return flowerColour;
    }

    public void setFlowerColour(String flowerColour) {
        this.flowerColour = flowerColour;
    }

    public String getLeafShape() {
        return leafShape;
    }

    public void setLeafShape(String leafShape) {
        this.leafShape = leafShape;
    }

    public String getLeafBase() {
        return leafBase;
    }

    public void setLeafBase(String leafBase) {
        this.leafBase = leafBase;
    }

    public String getLeafTip() {
        return leafTip;
    }

    public void setLeafTip(String leafTip) {
        this.leafTip = leafTip;
    }

    public String getLeafMargin() {
        return leafMargin;
    }

    public void setLeafMargin(String leafMargin) {
        this.leafMargin = leafMargin;
    }
}
