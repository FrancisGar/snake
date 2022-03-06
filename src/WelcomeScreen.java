import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class WelcomeScreen extends JPanel{
        JLabel title;
	JButton go;
	JButton quit;
	
	MainWindow mw;
	
        public WelcomeScreen(MainWindow mw){
		this.mw = mw;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		title = new JLabel();
		add(title);
		
		//add formatting here
		
		go = new JButton("New Game");
		quit = new JButton("Quit");	
		
		go.addActionListener(addMe);
		
		quit.addActionListener(addMe);
		
		add(go);
		add(quit);
	}
        
	public void setTitle(String t){
		title.setText(t);
	}
        
        final ActionListener addMe = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				goButtonActionListener();
			}
		};
	
	public void quitButtonActionListener(){
		if(JOptionPane.showConfirmDialog(this, "Are you sure?") == JOptionPane.OK_OPTION)
	        System.exit(0);
	}
	
	public void goButtonActionListener(){
		mw.showCard("Two");
	}
}
