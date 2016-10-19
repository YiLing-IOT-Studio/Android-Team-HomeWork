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
		  System.out.println("日一二三四五六");
		  Calendar 日历 =Calendar.getInstance();
		  日历.set(year, month,1);
		  int 星期几=日历.get(Calendar.DAY_OF_WEEK)-1;
		  String a[]=new String[星期几+31];
		  for(int i=0;i<星期几;i++){
			  a[i]="**";
		  }
		  for(int i=星期几,n=1;i<星期几+31;i++){
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
