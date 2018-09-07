package com.castor.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class DemoLombok implements Serializable {
	private String name;
	private int age;
}