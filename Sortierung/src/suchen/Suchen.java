package suchen;


public class Suchen {

	public boolean bin(int list[], int suchwert){
		int mitte = (0 + list.length) / 2;
		if(list[mitte] == suchwert){
			return true;
		}else{
			int liste2[];
			if(list[mitte] > suchwert){
				liste2 = new int[mitte];
				for(int i = 0; i < mitte; i++){
					liste2[i] = list[i];
				}
			}else{
				liste2 = new int[mitte + 1];
				for(int i = mitte; i < list.length; i++){
					int pos = i - mitte;
					liste2[pos] = list[i];
				}
			}
			if(liste2.length > 0){
				return bin(liste2, suchwert);
			}else{
				return false;
			}
		}
	}
	
	public boolean naiv(int list[], int suchWert){
		for(int i:list){
			if(suchWert == i){
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
