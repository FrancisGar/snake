import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//needs massive aesthetic rewrites

public class PlayerSelectScreen extends JPanel {
	JButton go;
	JButton quit;
	MainWindow mw;
	
	JRadioButton opt1;
	JRadioButton opt2;
	JRadioButton opt3;
	
	public void quitButtonActionListener(){
		mw.showCard("One");
	}
	
	public void goButtonActionListener(){
		playerOptions();
		mw.s4.setUpPlayers();
		mw.showCard("Three");
	}
	
	public void playerOptions(){
		int m = 5;
		if(opt1.isSelected() == true)
		    m = 1;
		else if(opt2.isSelected() == true)
			m = 2;
		else if(opt3.isSelected() == true)
			m = 3;
	    mw.s4.setMaxPlayers(m);
	}
	
	public PlayerSelectScreen(MainWindow mw){
                //variables extraídas
		BoxLayout lay = new BoxLayout(this, BoxLayout.PAGE_AXIS);
                JLabel select = new JLabel("Select Players: ");
                JLabel defaultt = new JLabel("Default: 1Player");
                JRadioButton o1 = new JRadioButton("1 Player(Default)");
                JRadioButton o2 = new JRadioButton("2 Players");
                JRadioButton o3 = new JRadioButton("3 Players");
                ActionListener addThis = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				playerOptions();
			}
		};
                JButton gogo = new JButton("Customize Board");
                JButton quitquit = new JButton("Back");
                ActionListener addThat = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				goButtonActionListener();
			}
		};
                ActionListener addThose = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				 quitButtonActionListener();
			}
		};
            
                this.mw = mw;
                
		setLayout(lay);
		
		JLabel mess = select;
		add(mess);
		
		JLabel uc = defaultt;
		add(uc);
		
		//set up radio buttons
		
		opt1 = o1;
		opt1.setSelected(true);
		
		opt2 = o2;
		opt3 = o3;
		
		ButtonGroup grp = new ButtonGroup();
		grp.add(opt1);
		grp.add(opt2);
		grp.add(opt3);
		
		add(opt1);
		add(opt2);
		add(opt3);

		opt1.addActionListener(addThis);
		opt2.addActionListener(addThis);
		opt3.addActionListener(addThis);
		
		go = gogo;
		quit = quitquit;	
		
		go.addActionListener(addThat);
		
		quit.addActionListener(addThose);
		
		add(go);
		add(quit);
		
	}
	

}
