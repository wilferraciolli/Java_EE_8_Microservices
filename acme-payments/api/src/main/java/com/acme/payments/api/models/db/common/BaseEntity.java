package com.acme.payments.api.models.db.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Base entity.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    private void onCreate() {
        Date date = new Date();

        this.setUpdatedAt(date);
        this.setCreatedAt(date);
    }

    @PreUpdate
    private void onUpdate() {
        this.setUpdatedAt(new Date());
    }

    /**
     * Gets id.
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets created at.
     * @return the created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     * @param createdAt the created at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     * @return the updated at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
