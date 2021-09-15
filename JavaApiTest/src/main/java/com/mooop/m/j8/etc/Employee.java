package com.mooop.m.j8.etc;

public interface Employee {
	
	void youAreFired();
	public static class Factory{
		private Factory() {}
		
		static  Employee build() {
			return new Employee() {
				public void youAreFired() {
					System.out.println("youAreFired");
				}
			};
		}
		
	}

}
