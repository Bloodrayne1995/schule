package suchen;

public class NaivSearch implements SuchInterfaceInteger {

	@Override
	public boolean suche(int[] liste, int suchWert) {
		for(int i:liste){
			if(suchWert == i){
				return true;
			}
		}
		return false;
	}

	@Override
	public String getName() {
		return "Naives Suchen";
	}

}
