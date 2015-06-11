package shellsort;

public class ShellSort3 {

	
	public int[] sortiere(int arr[], int schrittweite){
		int pos = 0;
		int save = 0;
		
		for(int i = schrittweite; i < arr.length; i++){
			pos = i - schrittweite;
			save = arr[i];
			
			while ((pos >= 0) && (save <arr[pos])){
				arr[pos + schrittweite] = arr[pos];
				pos -= schrittweite;
			}
			
			arr[pos + schrittweite] = save;
		}
		return arr;
	}
	
	
	public int[] sort(int arr[], int sw[]){
		for(int x:sw){
			arr = sortiere(arr,x);
		}
		return arr;
	}
	
}
