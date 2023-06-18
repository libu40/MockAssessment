package com.mock.assessment.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor
@Table(name = "branch")
@EntityListeners(AuditingEntityListener.class)
public class Branch implements Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int id;

  @Column(name = "name", unique = true)
  private String name;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedAt;

  @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
  private Set<Employee> employee;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Employee> getEmployee() {
    return employee;
  }

  public void setEmployee(Set<Employee> employee) {
    this.employee = employee;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Branch(String name, Date createdAt, Date updatedAt, Set<Employee> employee) {
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.employee = employee;
  }
}
