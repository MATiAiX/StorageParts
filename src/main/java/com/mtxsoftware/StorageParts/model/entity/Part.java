package com.mtxsoftware.StorageParts.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "part", schema = "test", catalog = "")
public class Part {

    public Part(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private Integer count;

    @Column(name = "necessary")
    private Boolean necessary;

    public Part(String name, Integer count, Boolean necessary) {
        this.name = name;
        this.count = count;
        this.necessary = necessary;
    }

    public Part(Long id, String name, Integer count, Boolean necessary) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.necessary = necessary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getNecessary() {
        return necessary;
    }

    public void setNecessary(Boolean necessary) {
        this.necessary = necessary;
    }


}
