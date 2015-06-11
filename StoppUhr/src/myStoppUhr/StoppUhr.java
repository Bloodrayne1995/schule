package myStoppUhr;

public class StoppUhr implements Runnable{

	private int milliseconds = 0;
	private boolean run_while = true;
	private boolean use_system = false;
	
	private long startTime = 0;
	private long stoppTime = 0;
	private long time = 0;
	
	@Override
	public void run() {
		while(run_while){
			milliseconds++;
			try{
				Thread.sleep(1);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	public void useSystem(boolean x){
		use_system = x;
	}
	
	public void start(){
		if(!use_system){
			milliseconds = 0;
			run_while = true;
			new Thread(this).start();
		}else{
			startTime = System.nanoTime();
		}
	}
	
	public void stop(){
		if(!use_system){
			run_while = false;
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				
			}
		}else{
			stoppTime = System.nanoTime();
			time = stoppTime - startTime;
		}
	}
	
	public int getSeconds(){
		if(use_system){
			return (int) (((time / 1000) / 1000) / 1000);
		}else{
			return milliseconds / 1000;
		}
	}
	
	public int getMilliSec(){
		if(use_system){
			return (int) (time / 1000);
		}else{
			return milliseconds;
		}
	}
	
	public long getNanoTime(){
		return time;
	}
	
	public String toString(){
		if(use_system){
			String ret = "";
			long rest = time;
			int sekunde = (int) (rest / Math.pow(1000, 3));
			rest = (long) (time % (Math.pow(1000, 3)));
			int milli = (int) (rest / Math.pow(1000, 2));
			rest = (long) (time % (Math.pow(1000, 2)));
			int mikro = (int) (rest / Math.pow(1000,1));
			rest = (long) (time % (Math.pow(1000, 1)));
			
			ret += sekunde + " Sekunden\t";
			ret += milli + " Millisekunden\t";
			ret += mikro + " Mikrosekunden\t";
			ret += rest + " Nanosekunden";
			return ret;
		}else{
			return "StoppUhr-Klasse";
		}
		
	}
	
	public int getMikro(){
		if(use_system){
			return (int) ((time / 1000) / 1000);
		}else{
			return milliseconds * 1000;
		}
	}

}
