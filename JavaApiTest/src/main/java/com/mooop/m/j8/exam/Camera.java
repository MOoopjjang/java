package com.mooop.m.j8.exam;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {
	
	private Function<Color, Color> filter;
	
	
	public Camera() {
		setFilter();
	}
	
	
	public Color capture(final Color inputColor) {
		final Color processedColor = filter.apply(inputColor);
		
		  // ... more processing of color...
		
		return processedColor;
	}
	
	
	public void setFilter(final Function<Color , Color>... filters) {
		
		filter = Stream.of(filters)
						.reduce((filter , next)->filter.compose(next))
						.orElse(color->color);
	}

}
