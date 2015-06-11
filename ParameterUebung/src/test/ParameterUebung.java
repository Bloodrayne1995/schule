package test;

public class ParameterUebung {

	static int var5 = 3;
	static int var3 = 4;
	
	public static void main(String[] args) {
		int var3 = 3;
		int var4 = var3+2;
		var3 = machDies(var3);
		var4 = machDas(var4);
	}
	public static int machDies(int var1){
		var5 = var1;
		return var1;
	}
	public static int machDas(int var1){
		int var2;
		var2 = machDies(var1);
		return var2;
	}

}
