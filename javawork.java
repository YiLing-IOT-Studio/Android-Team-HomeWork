import java.util.*;

public class JavaWork {
	public static void main(String[] args) {

		  int year,month;
		  try{
			  year=Integer.parseInt(args[0]);
			  month=Integer.parseInt(args[1]+1);
		  }
		  catch(NumberFormatException e){
			  year=2004;
			  month=1;
		  }
		  System.out.println("��һ����������");
		  Calendar ���� =Calendar.getInstance();
		  ����.set(year, month,1);
		  int ���ڼ�=����.get(Calendar.DAY_OF_WEEK)-1;
		  String a[]=new String[���ڼ�+31];
		  for(int i=0;i<���ڼ�;i++){
			  a[i]="**";
		  }
		  for(int i=���ڼ�,n=1;i<���ڼ�+31;i++){
			  if(n<=9){
				  a[i]=String.valueOf(n)+" ";
			  }
			  else{
				  a[i]=String.valueOf(n);
			  }
			  n++;
		  }
		  for(int i=0;i<a.length;i++){
			  if(i%7==0){
				  System.out.println(" ");
			  }
			  System.out.println(" "+a[i]);
		  }
	  
	}
}
