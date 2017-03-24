package org.printer;

public class TestClass {
	public static void main(String[] args) {
		Printer print = new Printer();
		
		Paper paper = new A4Paper();
		InkBox inkBox = new CInkBox();
		
		print.setInkBox(inkBox);
		print.setPaper(paper);
		
		print.print();
	}
}
