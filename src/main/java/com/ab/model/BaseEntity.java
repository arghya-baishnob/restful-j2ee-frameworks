package com.ab.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @SequenceGenerator(name="seqId", sequenceName="library_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seqId")
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
