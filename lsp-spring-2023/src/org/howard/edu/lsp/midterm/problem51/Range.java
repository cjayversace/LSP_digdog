package org.howard.edu.lsp.midterm.problem51;

public interface Range {
	
	public class EmptyRangeException extends Exception {
		public EmptyRangeException(String error) {
			super(error);
		}
	}
		
	public boolean contains(int value);
	
	public boolean overlaps(Range other) throws EmptyRangeException;
	
	public int size();
	
	public int get_upper();
	
	public int get_lower();
}
