package primzahlen;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import myStoppUhr.StoppUhr;

public class ErgebnisDaten implements Runnable{

	private StoppUhr zeiten[] = null;
	private ArrayList<ActionListener> onFinish = new ArrayList<ActionListener >();
	private boolean use_modern = true;
	
	public ErgebnisDaten(int obergrenze, boolean use_modern){
		if(zeiten == null){
			zeiten = new StoppUhr[obergrenze];
		}
		for(int i = 0; i < zeiten.length; i++){
			zeiten[i] = new StoppUhr();
			zeiten[i].useSystem(true);
		}
		this.use_modern = use_modern;
	}
	
	public void addActionListener(ActionListener d){
		onFinish.add(d);
	}
	
	public void run(){
		for(int i = 2; i < zeiten.length;i++){
			Primzahlen x = new Primzahlen();
			x.setObergrenze(i);
			x.initFeld();
			zeiten[i].start();
			if(use_modern){
				x.berechnePrimzahlenModern();
			}else{
				x.berechnePrimzahlenClassic();
			}
			zeiten[i].stop();
		}
		triggerActionListeners();
	}
	
	private void triggerActionListeners(){
		ActionEvent x = new ActionEvent(this, 0, String.valueOf(use_modern));
		for(ActionListener d:onFinish){
			d.actionPerformed(x);
		}
	}
	
	
	public int getObegrenze(){
		return zeiten.length;
	}
	
	public int getTime(int index){
		return (int) zeiten[index].getMikro();
	}


}
