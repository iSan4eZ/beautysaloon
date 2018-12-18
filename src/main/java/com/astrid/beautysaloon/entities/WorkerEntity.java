package com.astrid.beautysaloon.entities;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Workers")
public class WorkerEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String sname;

  @Column(name = "schedule")
  @OneToMany(
      mappedBy = "worker",
      cascade = CascadeType.ALL
  )
  private List<RecordEntity> schedule = Lists.newArrayList();

  @Column(name = "job_types")
  @Enumerated(EnumType.STRING)
  @ElementCollection(targetClass = JobType.class)
  private List<JobType> availableJobTypes = Lists.newArrayList();

  public enum JobType{
    SPA,
    WAXING,
    PIERCING,
    TANNING,
    MANICURE,
    PEDICURE,
    MAKE_UP,
    HAIRCUT,
    HAIR_REMOVAL
  }
}