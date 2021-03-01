package thiJava;

class intWrap{
	int x;
}

public class thiJava{
	public static void main(String[] args) {
		intWrap i = new intWrap();
		i.x  = 10;
		intWrap j = new intWrap();
		j.x = 20;
		swap(i,j);
		System.out.println(i.x +" "+j.x);
	}
	public static void swap(intWrap i , intWrap j) {
		int t = i.x;
		i.x=j.x;
		j.x=t;
	}

}
