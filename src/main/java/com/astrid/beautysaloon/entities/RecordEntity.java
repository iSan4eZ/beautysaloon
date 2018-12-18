package com.astrid.beautysaloon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Records")
public class RecordEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "worker_id")
  private WorkerEntity worker;

  @Column(name = "recordTime")
  private LocalDateTime recordTime;

  @Column(name = "price")
  private Double price;

  @Column(name = "jobType")
  private WorkerEntity.JobType jobType;

  @Column(name = "description")
  private String description;


}