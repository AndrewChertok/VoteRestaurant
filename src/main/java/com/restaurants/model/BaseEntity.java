package com.restaurants.model;


import org.hibernate.Hibernate;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity {

    public static final int START_SEQ = 16;

    @Id
    @SequenceGenerator(name = "MAIN_SEQ", sequenceName = "MAIN_SEQ", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAIN_SEQ")
    @Access(value = AccessType.PROPERTY)
    protected Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? 0 : getId();
    }


    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), getId());
    }

}
