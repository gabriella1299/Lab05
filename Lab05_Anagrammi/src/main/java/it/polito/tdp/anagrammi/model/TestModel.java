package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestModel {

	public static void main(String[] args) {
		Model m = new Model();
		Set<String> anagrammi;
		anagrammi= m.getSoluzione("dog") ;
		System.out.println(anagrammi);

	}

}
