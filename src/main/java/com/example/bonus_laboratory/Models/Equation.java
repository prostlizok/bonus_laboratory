package com.example.bonus_laboratory.Models;

import jakarta.persistence.*;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;

@Entity
@Table(name= "Equations")
public class Equation {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String surface_name;

    // All indexes
    @Column(nullable = false)
    private double a11;
    @Column(nullable = false)
    private double a12;
    @Column(nullable = false)
    private double a13;
    @Column(nullable = false)
    private double a22;
    @Column(nullable = false)
    private double a23;
    @Column(nullable = false)
    private double a33;
    @Column(nullable = false)
    private double a1;
    @Column(nullable = false)
    private double a2;
    @Column(nullable = false)
    private double a3;
    @Column(nullable = false)
    private double a0;

    // Getters and Setters
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSurface_name() {
        return surface_name;
    }

    public void setSurface_name(String surface_name) {
        this.surface_name = surface_name;
    }

    public double getA11() {
        return a11;
    }

    public void setA11(double a11) {
        this.a11 = a11;
    }

    public double getA12() {
        return a12;
    }

    public void setA12(double a12) {
        this.a12 = a12;
    }

    public double getA13() {
        return a13;
    }

    public void setA13(double a13) {
        this.a13 = a13;
    }

    public double getA22() {
        return a22;
    }

    public void setA22(double a22) {
        this.a22 = a22;
    }

    public double getA23() {
        return a23;
    }

    public void setA23(double a23) {
        this.a23 = a23;
    }

    public double getA33() {
        return a33;
    }

    public void setA33(double a33) {
        this.a33 = a33;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }

    public double getA0() {
        return a0;
    }

    public void setA0(double a0) {
        this.a0 = a0;
    }

    // Constructors
    public Equation(){}

    public Equation(double a11, double a22, double a33, double a12, double a13, double a23, double a1, double a2, double a3, double a0) {
        this.a11 = a11;
        this.a12 = a12/2;
        this.a13 = a13/2;
        this.a22 = a22;
        this.a23 = a23/2;
        this.a33 = a33;
        this.a1 = a1/2;
        this.a2 = a2/2;
        this.a3 = a3/2;
        this.a0 = a0;
    }

    public String EquationWriter(){
        return this.a11+"x²"+ " + " + this.a22+"y²" + " + " +this.a33+"z²"+" + " +
                "2⋅"+this.a12+"xy"+" + " +"2⋅"+this.a13+"xz"+" + " +"2⋅"+this.a23+"yz" +" + " +
                "2⋅"+this.a1+"x"+" + " +"2⋅"+this.a2+"y"+" + " +"2⋅"+this.a3+"z" + " + "+this.a0 +" = 0";
    }
}
