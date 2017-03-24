package org.printer;

public class Printer {
	private InkBox inkBox;
	private Paper paper;
	/**
	 * @return the inkBox
	 */
	public InkBox getInkBox() {
		return inkBox;
	}
	/**
	 * @param inkBox the inkBox to set
	 */
	public void setInkBox(InkBox inkBox) {
		this.inkBox = inkBox;
	}
	/**
	 * @return the paper
	 */
	public Paper getPaper() {
		return paper;
	}
	/**
	 * @param paper the paper to set
	 */
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	public void print() {
		System.out.println("paper is " + paper.size() + ", color is " + inkBox.color());
	}
	
}
