package withgui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		MainFrame d = new MainFrame();
		d.createGui();
	}
	
	public void createGui(){
		
	}
	
	public JPanel getSchein(int scheinArt){
		JPanel d = new JPanel();
		d.setLayout(new BorderLayout());
		ImageIcon schein = null;
		schein = new ImageIcon(String.valueOf(scheinArt) + ".jpg");
		if(schein != null){
//			d.add(schein,BorderLayout.NORTH);
		}
		return d;
	}

}
