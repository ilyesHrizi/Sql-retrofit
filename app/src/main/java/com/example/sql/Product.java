package com.example.sql;

public class Product {
    Integer Id;
    String name;
    Integer qte;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Product(Integer id, String name, Integer qte) {
        super();
        this.Id=id;
        this.name = name;
        this.qte = qte;
    }
}
