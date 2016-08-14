package dto;

public class CounterDto {
	private static int count;
	public static synchronized int getCount(){
		count++;
		return count;
	}
}
