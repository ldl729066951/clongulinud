package com.castor.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DemoLombok implements Serializable{
	private String name;
	private int age;

}
