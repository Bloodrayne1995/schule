package shellsort;

public class ShellSort2 {

	
	public int[] sortiere (int arr[], int schrittweite){
		int save = 0;
		int pos = 0;
		for(int i = schrittweite; i < arr.length; i++){
			pos = i-schrittweite;
			save = arr[i];
			
			while ((pos >= 0) && (save < arr[pos])){
				arr[pos + schrittweite] = arr[pos];
				pos = pos -schrittweite;
			}
			
			arr[pos + schrittweite] = save;
		}
		return arr;
	}
	
	
	public int[] sort(int arr[], int scrittweite[]){
		for(int x: scrittweite){
			arr = sortiere(arr, x);
		}
		return arr;
	}
	
}
