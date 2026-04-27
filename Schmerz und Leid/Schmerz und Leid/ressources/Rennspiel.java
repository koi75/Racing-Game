package ressources;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.sound.sampled.*;
import javax.sound.sampled.FloatControl;

@SuppressWarnings("serial")
public class Rennspiel extends JFrame{
    public Car car1;
    
    public Point mousePoint;
    
    public Rennstrecke rennstrecke;
    
    public int playerId;
    public int mapId;
    
    public int zeit;
    public int zeitms;

    Color bgcolor = new Color(255,255,255, 0);
    
    public boolean check1;
    
    
    //Panels
    //---------------------------------------------------------------------------------//
    
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);
    
	public class StartPanel extends JPanel {
		ImageIcon startButtonIcon = new ImageIcon("Schmerz und Leid\\assets\\images\\startIcon.png");
		//ImageIcon settingsButtonIcon = new ImageIcon(/*URL*/);
		//ImageIcon exitButtonIcon = new ImageIcon(/*URL*/);
		
		JButton startButton = new JButton(startButtonIcon);
		JButton settingsButton = new JButton("Settings"/*, settingsButtonIcon*/);
		JButton exitButton = new JButton("Exit"/*, settingsButtonIcon*/);
		
		StartPanel(Rennspiel MainFrame){
			this.setBackground(new Color(100, 100, 100));
			
			this.startButton.addActionListener(e -> MainFrame.showPanel("choice"));
			
			this.settingsButton.addActionListener(e -> MainFrame.showPanel("leader"));
			
			this.exitButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });
			
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			this.startButton.setAlignmentX(CENTER_ALIGNMENT);
			this.settingsButton.setAlignmentX(CENTER_ALIGNMENT);
			this.exitButton.setAlignmentX(CENTER_ALIGNMENT);
			
			this.add(Box.createRigidArea(new Dimension(0, 300)));
			this.add(startButton);
			this.add(Box.createRigidArea(new Dimension(0, 40)));
			this.add(settingsButton);
			this.add(Box.createRigidArea(new Dimension(0, 40)));
			this.add(exitButton);
			
			
			Dimension size = new Dimension(300, 80);
			this.startButton.setMaximumSize(size);
			this.settingsButton.setMaximumSize(size);
			this.exitButton.setMaximumSize(size);
		}
		
		@Override
		public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
		}
	}
	
	public class SettingPanel extends JPanel {
		SettingPanel(){
			this.setBackground(new Color(100, 100, 100));
		}
	}
	
	public class ChoicePanel extends JPanel {
		JPanel TopPanel;
		
		JPanel MiddlePanel;
		JPanel MiddlePanelSub1;
		JPanel MiddlePanelSub2;
		
		JPanel BottomPanel;
		
		JLabel titleLabel;
		
		//ImageIcon continueButtonIcon = new ImageIcon(/*URL*/);
		ImageIcon toggleButtonIcon1 = new ImageIcon("Schmerz und Leid\\assets\\images\\Paul.jpeg");
		ImageIcon toggleButtonIcon2 = new ImageIcon("Schmerz und Leid\\assets\\images\\Theo.jpeg");
		ImageIcon toggleButtonIcon3 = new ImageIcon("Schmerz und Leid\\assets\\images\\Khoi.jpeg");
		ImageIcon toggleButtonIcon4 = new ImageIcon("Schmerz und Leid\\assets\\images\\Lilija.jpeg");
		ImageIcon toggleButtonIcon5 = new ImageIcon("Schmerz und Leid\\assets\\images\\Tim.jpeg");
		
		ImageIcon toggleButtonIcon1SW = new ImageIcon("Schmerz und Leid\\assets\\images\\Paul - SW.jpg");
		ImageIcon toggleButtonIcon2SW = new ImageIcon("Schmerz und Leid\\assets\\images\\Theo - SW.jpg");
		ImageIcon toggleButtonIcon3SW = new ImageIcon("Schmerz und Leid\\assets\\images\\Khoi - SW.jpg");
		ImageIcon toggleButtonIcon4SW = new ImageIcon("Schmerz und Leid\\assets\\images\\Lilija - SW.jpg");
		ImageIcon toggleButtonIcon5SW = new ImageIcon("Schmerz und Leid\\assets\\images\\Tim - SW.jpg");
		
		JButton continueButton;
		
		JToggleButton toggleButton1;
		JToggleButton toggleButton2;
		JToggleButton toggleButton3;
		JToggleButton toggleButton4;
		JToggleButton toggleButton5;
		JToggleButton toggleButton6;
		JToggleButton toggleButton7;
		JToggleButton toggleButton8;
		
		ButtonGroup buttonGroup1 = new ButtonGroup();
		ButtonGroup buttonGroup2 = new ButtonGroup();
		
		private void createTopPanel() {
			TopPanel = new JPanel();
            TopPanel.setLayout(new GridBagLayout());
            TopPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

            titleLabel = new JLabel("Choose your Driver and Map!");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 36));

            TopPanel.add(titleLabel);
		}
		
		private void createMiddlePanel() {

		    MiddlePanel = new JPanel();
		    MiddlePanel.setLayout(new GridLayout(2, 1));

		    MiddlePanelSub1 = new JPanel();
		    MiddlePanelSub2 = new JPanel();

		    MiddlePanelSub1.setLayout(new GridLayout(1, 5, 60, 0));
		    MiddlePanelSub1.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));

		    MiddlePanelSub2.setLayout(new GridLayout(1, 3, 100, 0));
		    MiddlePanelSub2.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));

		    toggleButton1 = new JToggleButton();
		    toggleButton2 = new JToggleButton();
		    toggleButton3 = new JToggleButton();
		    toggleButton4 = new JToggleButton();
		    toggleButton5 = new JToggleButton();

		    toggleButton6 = new JToggleButton("Toggle Button6");
		    toggleButton7 = new JToggleButton("Toggle Button7");
		    toggleButton8 = new JToggleButton("Toggle Button8");
		    
		    toggleButton1.setActionCommand("1");
		    toggleButton1.addActionListener(actionListener);
		    toggleButton2.setActionCommand("2");
		    toggleButton2.addActionListener(actionListener);
		    toggleButton3.setActionCommand("3");
		    toggleButton3.addActionListener(actionListener);
		    toggleButton4.setActionCommand("4");
		    toggleButton4.addActionListener(actionListener);
		    toggleButton5.setActionCommand("5");
		    toggleButton5.addActionListener(actionListener);

		    buttonGroup1 = new ButtonGroup();
		    buttonGroup1.add(toggleButton1);
		    buttonGroup1.add(toggleButton2);
		    buttonGroup1.add(toggleButton3);
		    buttonGroup1.add(toggleButton4);
		    buttonGroup1.add(toggleButton5);

		    buttonGroup2 = new ButtonGroup();
		    buttonGroup2.add(toggleButton6);
		    buttonGroup2.add(toggleButton7);
		    buttonGroup2.add(toggleButton8);
		    
		    styleButton(toggleButton1);
		    styleButton(toggleButton2);
		    styleButton(toggleButton3);
		    styleButton(toggleButton4);
		    styleButton(toggleButton5);
		    styleButton(toggleButton6);
		    styleButton(toggleButton7);
		    styleButton(toggleButton8);

		    MiddlePanelSub1.add(toggleButton1);
		    MiddlePanelSub1.add(toggleButton2);
		    MiddlePanelSub1.add(toggleButton3);
		    MiddlePanelSub1.add(toggleButton4);
		    MiddlePanelSub1.add(toggleButton5);
		    
		    MiddlePanelSub2.add(toggleButton6);
		    MiddlePanelSub2.add(toggleButton7);
		    MiddlePanelSub2.add(toggleButton8);

		    MiddlePanel.add(MiddlePanelSub1);
		    MiddlePanel.add(MiddlePanelSub2);
		    
		    setAutoScaledIcon(toggleButton1, toggleButtonIcon1SW, toggleButtonIcon1);
		    setAutoScaledIcon(toggleButton2, toggleButtonIcon2SW, toggleButtonIcon2);
		    setAutoScaledIcon(toggleButton3, toggleButtonIcon3SW, toggleButtonIcon3);
		    setAutoScaledIcon(toggleButton4, toggleButtonIcon4SW, toggleButtonIcon4);
		    setAutoScaledIcon(toggleButton5, toggleButtonIcon5SW, toggleButtonIcon5);
		}
		
		private void createBottomPanel(Rennspiel MainFrame) {
            BottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            BottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

            continueButton = new JButton("Continue");
            continueButton.setFont(new Font("Arial", Font.BOLD, 20));
            continueButton.addActionListener(e -> MainFrame.showPanel("game"));
            
            continueButton.setPreferredSize(new Dimension(300, 80));
            
            BottomPanel.add(continueButton);
        }
		
		private void styleButton(JToggleButton button) {
		    button.setPreferredSize(new Dimension(140, 80)); // rectangle shape
		    button.setFocusPainted(false);
		    button.setContentAreaFilled(true);
		    button.setBorderPainted(true);
		}
		
		private void setAutoScaledIcon(JToggleButton button, ImageIcon normal, ImageIcon selected) {

		    button.addComponentListener(new ComponentAdapter() {
		        @Override
		        public void componentResized(ComponentEvent e) {

		            int w = button.getWidth();
		            int h = button.getHeight();

		            if (w <= 0 || h <= 0) return;

		            Image scaledNormal = normal.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		            Image scaledSelected = selected.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);

		            button.setIcon(new ImageIcon(scaledNormal));
		            button.setSelectedIcon(new ImageIcon(scaledSelected));
		        }
		    });
		}

		ChoicePanel(Rennspiel MainFrame){
			setLayout(new BorderLayout());

            createTopPanel();
            createMiddlePanel();
            createBottomPanel(MainFrame);

            add(TopPanel, BorderLayout.NORTH);
            add(MiddlePanel, BorderLayout.CENTER);
            add(BottomPanel, BorderLayout.SOUTH);
		}
		
		String url = "jdbc:sqlite:Schmerz und Leid\\assets\\database\\rennspiel.db";
		
		//Button Number should not go over 9
		ActionListener actionListener = new ActionListener() {
		    public void actionPerformed(ActionEvent actionEvent) {
		        try {
		            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();

		            if (!abstractButton.getModel().isSelected()) {
		                return;
		            }

		            int fid = Integer.parseInt(abstractButton.getActionCommand());

		            String sql = "select * from fahrer where fid = " + fid;

		            try (Connection conn = DriverManager.getConnection(url);
		                 Statement st = conn.createStatement();
		                 ResultSet result = st.executeQuery(sql)) {

		                while (result.next()) {
		                    int id = result.getInt("fid");
		                    String name = result.getString("name");
		                    String skill = result.getString("skill");
		                    String team = result.getString("team");

		                    System.out.println(id + " " + name + " " + skill + " " + team);
		                    playerId = id;
		                }
		            }

		        } catch (SQLException e) {
		            System.out.println("Datenbankverbindung gescheitert.");
		            e.printStackTrace();
		        }
		    }
		};
	}
	
	public class LeaderPanel extends JPanel {
		JLabel erster = new JLabel();
		JLabel zweiter = new JLabel();
		JLabel dritter = new JLabel();
		JLabel vierter = new JLabel();
		JLabel fuenfter = new JLabel();
		
		JLabel erster2 = new JLabel();
		JLabel zweiter2 = new JLabel();
		JLabel dritter2 = new JLabel();
		JLabel vierter2 = new JLabel();
		JLabel fuenfter2 = new JLabel();
		
		JLabel tabellenkopf = new JLabel();
		JLabel tabellenkopf2 = new JLabel();
		
		ImageIcon platz1;
		ImageIcon platz2;
		ImageIcon platz3;
		ImageIcon platz4;
		ImageIcon platz5;
		
		JLabel bild1 = new JLabel();
		JLabel bild2 = new JLabel();
		JLabel bild3 = new JLabel();
		JLabel bild4 = new JLabel();
		JLabel bild5 = new JLabel();

		JButton weiter = new JButton("Weiter");
		JButton retry = new JButton("Nochmal");
		
		int x = 1;
		
		String url;
		
		LeaderPanel(Rennspiel MainFrame){
			this.setBackground(new Color(100,100,100));
			this.setLayout(null);
			
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			
			panel1.setLayout(null);
			panel1.setBounds(0,0, 1920 / 2, 1080);
			panel2.setLayout(null);
			panel2.setBounds(1920 / 2,0, 1920 / 2, 1080);
			
			weiter.setBounds(panel2.getWidth() - 300,panel2.getHeight() - 300, 200 ,100);
			this.weiter.addActionListener(e -> MainFrame.showPanel("start"));
			
			retry.setBounds(100,panel1.getHeight() - 300, 200 ,100);
			this.retry.addActionListener(e -> MainFrame.showPanel("game"));
			
			bild1 = new JLabel(platz1);
			bild1.setBounds(300, 150,100,100);
			bild2 = new JLabel();
			bild3 = new JLabel();
			bild4 = new JLabel();
			bild5 = new JLabel();
			
			
			setup(erster, panel1);
			setup(zweiter, panel1);
			setup(dritter, panel1);
			setup(vierter, panel1);
			setup(fuenfter, panel1);
			setup(tabellenkopf, panel1);
			
			setup2(erster2, panel2);
			setup2(zweiter2, panel2);
			setup2(dritter2, panel2);
			setup2(vierter2, panel2);
			setup2(fuenfter2, panel2);
			setup2(tabellenkopf2, panel2);
			
			tabellenkopf.setBounds(400, 80, 1920 / 2 - 400, 50);
			erster.setBounds(400,150,1920 / 2 - 400, 80);
            zweiter.setBounds(400,300,1920 / 2 - 400, 80); 
            dritter.setBounds(400,450,1920 / 2 - 400, 80);
            vierter.setBounds(400,600,1920 / 2 - 400, 80);
            fuenfter.setBounds(400,750,1920 / 2 - 400, 80);
            
			tabellenkopf2.setBounds(0, 80, 1920 / 2 - 400, 50);
            erster2.setBounds(0,150,1920 / 2 - 400, 80);
            zweiter2.setBounds(0,300,1920 / 2 - 400, 80); 
            dritter2.setBounds(0,450,1920 / 2 - 400, 80);
            vierter2.setBounds(0,600,1920 / 2 - 400, 80);
            fuenfter2.setBounds(0,750,1920 / 2 - 400, 80);

            tabellenkopf.setText("   Platz:     Fahrer:");
            tabellenkopf2.setText("Team:          Zeit:     ");
			tabellenkopf.setBackground(Color.LIGHT_GRAY);
			tabellenkopf2.setBackground(Color.LIGHT_GRAY);
            
			panel2.add(weiter);
			panel1.add(retry);
			panel1.add(bild1);
			
			this.add(panel1);
			this.add(panel2);
			
			url = "jdbc:sqlite:Schmerz und Leid\\assets\\database\\rennspiel.db";
			updatebord();
		}
		
		public void updatebord()
		{
			try{
	            Connection conn = DriverManager.getConnection(url);
	            String sql = "select * from leaderbord, fahrer where leaderbord.fid = fahrer.fid and platz = "+ x;
	            Statement st = conn.createStatement();
	            ResultSet result = st.executeQuery(sql);
	            
	            while(result.next()){
	                int platz = result.getInt("platz");
	                String fahrer = result.getString("name");
	                String zeit = result.getString("zeit");
	                String team = result.getString("team");
	                
	                switch(platz) {
	                case 1: erster.setText("     " + platz + "          " + fahrer);
	                		erster2.setText(team + 	"   " + zeit + "   ");
	                		erster.setBackground(new Color(204,204,0));
	                		erster2.setBackground(new Color(204,204,0));
	                		platz1 = new ImageIcon("Schmerz und Leid\\assets\\images\\" + fahrer + ".jpeg");
	                		bild1.setIcon(platz1);
	                	break;
	                case 2: zweiter.setText("     " + platz + "          " + fahrer);
            				zweiter2.setText(team + 	"   " + zeit + "   ");
	                		zweiter.setBackground(new Color(210,210,210));
	                		zweiter2.setBackground(new Color(210,210,210));
	                		platz2 = new ImageIcon("Schmerz und Leid\\assets\\images\\" + fahrer + ".jpeg");
	                		bild2.setIcon(platz2);
	                	break;
	                case 3: dritter.setText("     " + platz + "          " + fahrer);
            				dritter2.setText(team + 	"   " + zeit + "   ");
	                		dritter.setBackground(new Color(204,102,0));
	                		dritter2.setBackground(new Color(204,102,0));
	                		platz3 = new ImageIcon("Schmerz und Leid\\assets\\images\\" + fahrer + ".jpeg");
	                		bild3.setIcon(platz3);
                		break;
	                case 4: vierter.setText("     " + platz + "          " + fahrer);
	                		vierter2.setText(team + 	"   " + zeit + "   ");
	                		vierter.setBackground(Color.LIGHT_GRAY);
	                		vierter2.setBackground(Color.LIGHT_GRAY);
	                		platz4 = new ImageIcon("Schmerz und Leid\\assets\\images\\" + fahrer + ".jpeg");
	                		bild4.setIcon(platz4);
                		break;
	                case 5: fuenfter.setText("     " + platz + "          " + fahrer);
	                		fuenfter2.setText(team + 	"   " + zeit + "   ");
	                		fuenfter.setBackground(Color.LIGHT_GRAY);
	                		fuenfter2.setBackground(Color.LIGHT_GRAY);
	                		platz5 = new ImageIcon("Schmerz und Leid\\assets\\images\\" + fahrer + ".jpeg");
	                		bild5.setIcon(platz5);
                		break;
	                }
	            }
	            
	            if(x < 5)
	            {
	            	x = x + 1;
	            	updatebord();
	            }

	        }catch(SQLException e){
	            System.out.println("Datenbankverbindung gescheitert.");
	            e.printStackTrace();
	        }
	        System.out.println();
		}
		
		public void setup(JLabel x, JPanel panel)
		{
			x.setFont(new Font("", Font.BOLD, 25));
	        x.setOpaque(true);
			panel.add(x);
		}
		
		public void setup2(JLabel x, JPanel panel)
		{
			x.setFont(new Font("", Font.BOLD, 25));
	        x.setOpaque(true);
			x.setHorizontalAlignment(4);
			panel.add(x);
		}
	}

    public class GamePanel extends JPanel {
        GamePanel() {
    		
        }

        @Override
        public  void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            
            if((rennstrecke.track != null) && (rennstrecke.background != null)) {
                g2d.drawImage(rennstrecke.track, 0, 0, getWidth(), getHeight(), car1.x - 320, car1.y - 180, car1.x + 320, car1.y + 180, bgcolor, null);
                g2d.drawImage(rennstrecke.background, 0, 0, getWidth(), getHeight(), car1.x - 320, car1.y - 180, car1.x + 320, car1.y + 180, null);
            }

            mousePoint = getMousePosition(); //Foren und ChatGPT
            if (mousePoint != null) { 
                int cx = getWidth() / 2;
                int cy = getHeight() / 2;

                double angle = Math.atan2(mousePoint.y - cy, mousePoint.x - cx);

                AffineTransform old = g2d.getTransform();

                if(car1.geschwindigkeit != 0){
                    g2d.rotate(angle, cx, cy);
                }

                g2d.drawImage(car1.carI, cx - car1.carI.getWidth()/2, cy - car1.carI.getHeight()/2, bgcolor, null);

                g2d.setTransform(old);

                g2d.setColor(Color.RED);
                g2d.setFont(new Font("Arial", Font.BOLD, 72));
                g2d.drawString(Integer.toString((int)(car1.geschwindigkeit * 10)), getWidth() - 100, getHeight() - 100);
                g2d.drawString(Integer.toString(car1.lap), getWidth() - 100, getHeight() - getHeight() + 100);
                g2d.drawString(Integer.toString(zeit), 100, getHeight() - getHeight() + 100);
            } 
            else {
                g2d.drawImage(car1.carI, getWidth()/2 - car1.carI.getWidth()/2, getHeight()/2 - car1.carI.getHeight()/2, bgcolor, null);
            }
        }
    }
    
    public void showPanel(String name) {
    	cardLayout.show(mainPanel, name);

        SwingUtilities.invokeLater(() -> {
            mainPanel.requestFocusInWindow();
        });
    }
    //---------------------------------------------------------------------------------//
    
    StartPanel sp;
	SettingPanel stp;
	GamePanel gp;
	LeaderPanel lp;
	ChoicePanel chp;
    
    Rennspiel(Car car1, Rennstrecke rennstrecke) {
    	this.setTitle("Rennspiel");
    	this.setIconImage(car1.carI);
    	
    	this.sp = new StartPanel(this);
    	this.stp = new SettingPanel();
    	this.gp = new GamePanel();
    	this.lp = new LeaderPanel(this);
    	this.chp = new ChoicePanel(this);

    	mainPanel.add(sp, "start");
    	mainPanel.add(stp, "settings");
    	mainPanel.add(gp, "game");
    	mainPanel.add(chp, "choice");
    	mainPanel.add(lp, "leader");

    	this.setContentPane(mainPanel);

    	this.car1 = car1;
    	this.rennstrecke = rennstrecke;
    	this.zeit = 0;
    	this.zeitms = 0;

        this.setSize(1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setBackground(new Color(0, 67, 0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.toFront();
        this.requestFocus();
    }
    
    
    //Inputs - Controls
    //---------------------------------------------------------------------------------//
    
    InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = mainPanel.getActionMap();
    
    public void Movement() {
    	if(check1 == false) {
	        actionMap.put("keyW", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	car1.Steigung("Oben");
	            }
	        });
	        actionMap.put("keyS", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	car1.Steigung("Unten");
	            }
	        });
	        
	        check1 = true;
    	}
        
        inputMap.put(KeyStroke.getKeyStroke("pressed W"), "keyW");
        inputMap.put(KeyStroke.getKeyStroke("pressed S"), "keyS");
    }

    public Point getMouse(){
        Point point = getMousePosition();
        return point;
    }
    //---------------------------------------------------------------------------------//
    

    public void setVolume(double d, Clip clip) {
        if (d < 0f || d > 1f)
            throw new IllegalArgumentException("Volume not valid: " + d);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
        gainControl.setValue(20f * (float) Math.log10(d));
    }
    
    public void Timer() {
    	this.zeitms = this.zeitms + 20;
    	if(this.zeitms >= 1000) {
    		this.zeitms = 0;
    		this.zeit = this.zeit + 1;
    	}
    }

    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException { 	
    	//System.out.println(System.getProperty("user.dir"));
    	
    	BufferedImage carI = ImageIO.read(new File("Schmerz und Leid\\assets\\images\\car1.png"));
    	Car car1 = new Car(1000, 920, carI); //x = 785, y = 860
        Rennstrecke rennstrecke = new Rennstrecke();

        Rennspiel rsp = new Rennspiel(car1, rennstrecke);
        
    	rsp.Movement();
        
        rsp.mousePoint = rsp.getMouse(); 

        int cx = rsp.getWidth() / 2;
        int cy = rsp.getHeight() / 2;
        
        //Audio:
        File audioFile = new File("Schmerz und Leid\\assets\\sound\\raceSound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        Clip clip = AudioSystem.getClip();
        
        int delay = 20;
        ActionListener taskPerformer = new ActionListener() {                                                                                      
            @Override
            public void actionPerformed(ActionEvent evt) { 
            	if(car1.lap == 0) {
            		rsp.Timer();
            	}
            	if(car1.geschwindigkeit != 0) {
            		try {
            			/*if(!clip.isActive()) {
            				clip.open(audioStream);
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                            rsp.setVolume(0, clip);
            			}
            			else if(clip.isActive()) {
            				rsp.setVolume(car1.geschwindigkeit/10, clip);
            				//System.out.println("Clip level: " + clip.getLevel());
            			}*/
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            	}
            	if(car1.geschwindigkeit == 0) {
            		//rsp.setVolume(0, clip);
                }
                if(rsp.mousePoint != null){
                    car1.movement(Math.atan2(rsp.mousePoint.y - cy, rsp.mousePoint.x - cx));
                    if(!rennstrecke.checkStillOnTrack(car1)){
                        car1.geschwindigkeit = (car1.geschwindigkeit * 0.95);
                        car1.MAX_SPEED = 8;
                    }
                    else {
                    	car1.MAX_SPEED = 10;
                    }
                    if(rennstrecke.checkLap(car1)){
                        car1.lap += 1;
                        if(car1.lap == 3) {
                        	
                        }
                    }
                    if(rennstrecke.speedBoost(car1)){
                        if(car1.geschwindigkeit >= 10){
                        	car1.MAX_SPEED = 20;
                            car1.geschwindigkeit = car1.geschwindigkeit * 3;
                        }
                    }
                    else {
                    	car1.MAX_SPEED = 10;
                    }
                }
                rsp.repaint();
            }
        };
        new Timer(delay, taskPerformer).start();
    }
}
