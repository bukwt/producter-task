package com.task.in.model;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "player")
public class Player implements Serializable{
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String surname;

  private String position;

  public Player(Long id, String name, String surname, String position) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.position = position;
  }

  public Player() {
  }

  public Player(String name, String surname, String position) {
    this.name=name;
    this.surname=surname;
    this.position=position;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "Player[id=" + id + ", name=" + name + ", surname=" + surname + ", position="+ position +"]";
  }

}