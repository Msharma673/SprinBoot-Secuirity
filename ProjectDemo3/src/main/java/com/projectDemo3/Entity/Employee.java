package com.projectDemo3.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Employee")
@Data
public class Employee {

		@Id
		@Column(name = "ID")
		@GeneratedValue(strategy =GenerationType.AUTO)
		private Long id;
		
		@Column(name="NAME")
		private String name;
		
		@Column(name="DEPT")
		private String dept;
		
		@Column(name="CITY")
		private String city;
		
		@Column(name="STATE")
		private String state;
		
		@Column(name="POSITION")
		private String position;
		
		@Column(name="AGE")
		private String age;
		
	

}
