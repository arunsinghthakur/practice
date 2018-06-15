package joker.j8;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,5,6,7,4}; 
		int s = 8*(8+1)/2;
		int s1 = 0;
		
		for(int i : a) {
			s1 += a[i];
		}
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s1-s);
	}
	
	

}
