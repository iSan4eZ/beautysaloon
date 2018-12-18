package com.astrid.beautysaloon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Workers")
public class WorkerEntity {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String sname;
}