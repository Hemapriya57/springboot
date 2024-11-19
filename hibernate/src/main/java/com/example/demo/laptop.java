package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pc")
public class laptop {
    @Id
    @Column(name="pc_model")
    private String lapmodel;
    @Column(name="pc_price")
    private int lapprice;
    @Column(name="pc_memory")
    private int lapmemory;

    public laptop(String lapmodel, int lapprice, int lapmemory) {
        
        this.lapmodel = lapmodel;
        this.lapprice = lapprice;
        this.lapmemory = lapmemory;
    }
    public laptop() {
    }
    
    @Override
    public String toString() {
        return "laptop [lapmodel=" + lapmodel + ", lapprice=" + lapprice + ", lapmemory=" + lapmemory + "]";
    }
    public String getLapmodel() {
        return lapmodel;
    }
    public void setLapmodel(String lapmodel) {
        this.lapmodel = lapmodel;
    }
    public int getLapprice() {
        return lapprice;
    }
    public void setLapprice(int lapprice) {
        this.lapprice = lapprice;
    }
    public int getLapmemory() {
        return lapmemory;
    }
    public void setLapmemory(int lapmemory) {
        this.lapmemory = lapmemory;
    }
    
}
