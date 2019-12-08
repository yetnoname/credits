package com.credits.demo.entities;

import javax.persistence.*;

@Entity
@Table
public class Credit {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double sum;

    @Column
    private String term;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
