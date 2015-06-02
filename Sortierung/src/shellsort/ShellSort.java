package shellsort;

public class ShellSort {

	
	
	private int[] sortiere(int arr[], int schrittweite){
		int pos = 0;
		int save = 0;
		for(int i = schrittweite; i < arr.length; i++){
			save = arr[i];
			pos = i - schrittweite;
			//Tauschbedingung
			while((pos >= 0) && (save < arr[pos])){
				//tauschen
				arr[pos + schrittweite] = arr[pos];
				pos = pos - schrittweite;
				
			}
			arr[pos + schrittweite] = save;
		}
		
		return arr;
	}
	
	public int[] sort(int arr[],int schrittweiten[]){
		for(int x:schrittweiten){
			arr = sortiere(arr, x);
		}
		return arr;
	}
	
	public void showArray(int arr[]){
		for(int x:arr){
			System.out.print(x + " ");
		}
		System.out.println("");
	}
	
	public static void main(String args[]){
		
		int feld[] = { 7 , 4 , 1 , 8 , 5 , 2 , 9 , 6 , 3 , 0 };
		int schritte[] = { 4 , 2 , 1};
		ShellSort x = new ShellSort();
		//x.showArray(feld);
		x.showArray(x.sort(feld, schritte ));
		
	}
	
	
}
