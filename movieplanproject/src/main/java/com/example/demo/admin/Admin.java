package com.example.demo.admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Entity
@Data
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int adminid;
private String name;
private String password;


}
