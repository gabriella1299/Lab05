package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model();
		List<String> anagrammi;
		anagrammi= m.getSoluzione("dog") ;
		System.out.println(anagrammi);

	}

}
