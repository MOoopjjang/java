package com.mooop.m.j8.exam;

import java.awt.Color;
import java.util.function.Consumer;

public class ExamMain {
	
	
	public static void main(String[] args) {
		final Camera camera = new Camera();
		final Consumer<String> printCaptured = 
				(filterInfo)->System.out.println(String.format("with %s: %s", filterInfo,camera.capture(new Color(200,100,200))));
	}

}
