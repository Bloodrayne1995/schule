package rekursion;

public class Rekursion implements Runnable{

	
	public int erg = -1;
	public int zahl = -1;
	public boolean fertig = false;
	boolean show = false;
	int t = 0;
	
	public int fib(int x){
		if (x==1){
			
			return 1;
			
		}else if(x<=0){
			
			return 0;
			
		}else{
			int y = fib(x-1) + fib(x-2);
			
			return y;
			
		}
	}
	
	
	public int fibMT(int zahl){
		if(zahl % 2 == 0){
			Rekursion x1 = new Rekursion();
			Rekursion x2 = new Rekursion();
			x1.zahl = zahl / 2;
			x2.zahl = zahl / 2;
			
			new Thread(x1).start();
			new Thread(x2).start();
			
			while(!x1.fertig && !x2.fertig){
				//nichts
			}
			
			return (x1.erg  * 2) + x2.erg;
		}else{
			return fib(zahl);
		}
	}


	public void run() {
		erg = fib(zahl);
		fertig = true;
	}

}
