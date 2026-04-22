package ressources;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.sound.sampled.*;
import javax.sound.sampled.FloatControl;
import java.sql.*;

@SuppressWarnings("serial")
public class Rennspiel extends JFrame implements KeyListener {
    public Car car1;
    
    public Point mousePoint;
    public int playerid;
    public Rennstrecke rennstrecke;
    String url = "jdbc:sqlite:H:\\Programme\\Racing-Game-main\\Racing-Game-main\\Schmerz und Leid\\Schmerz und Leid\\assets\\database\\rennspiel.db";
    public int zeit;
    public int zeitms;

    Color bgcolor = new Color(255,255,255, 0);
    
    
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
			
			this.settingsButton.addActionListener(e -> MainFrame.showPanel("settings"));
			
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
		
		
		
		//ImageIcon continueButtonIcon = new ImageIcon(/*URL*/);
		//ImageIcon toggleButtonIcon = new ImageIcon(/*URL*/);
		
		JButton continueButton = new JButton("Continue"/*, continueButtonIcon*/);
		
		JToggleButton toggleButton1 = new JToggleButton("Toggle ButtonF1"/*, toggleButtonIcon*/);
		JToggleButton toggleButton2 = new JToggleButton("Toggle ButtonF2"/*, toggleButtonIcon*/);
		JToggleButton toggleButton3 = new JToggleButton("Toggle ButtonF3"/*, toggleButtonIcon*/);
		JToggleButton toggleButton4 = new JToggleButton("Toggle ButtonF4"/*, toggleButtonIcon*/);
		JToggleButton toggleButton5 = new JToggleButton("Toggle ButtonF5"/*, toggleButtonIcon*/);
		
		JToggleButton toggleButton6 = new JToggleButton("Toggle Button3"/*, toggleButtonIcon*/);
		JToggleButton toggleButton7 = new JToggleButton("Toggle Button4"/*, toggleButtonIcon*/);
		JToggleButton toggleButton8 = new JToggleButton("Toggle Button5"/*, toggleButtonIcon*/);
		
		ActionListener actionListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                AbstractButton abstractButton = (AbstractButton)actionEvent.getSource();
    
                boolean selected = abstractButton.getModel().isSelected();
                
                String name = "";
    
                if(selected == true) {
                	name = abstractButton.getText();
                	System.out.println(name );
                }
                
                

                
                
                switch(name) {
                case "Toggle ButtonF1":
                		try{ 
                			Connection conn = DriverManager.getConnection(url); 
                			String sql = "select * from fahrer where fid = 1";
                			Statement st = conn.createStatement();
                			ResultSet result = st.executeQuery(sql); 
                			while(result.next()){ 
                				int fid = result.getInt("fid");
                				String namef = result.getString("name");
                				String skill = result.getString("skill");
                				String team = result.getString("team");
                				System.out.println(fid + " " + namef + " " + skill + " " + team); 
                       	 		playerid = fid;
                       	 	} 
                       	 }
                		catch(SQLException e){ 
                			System.out.println("Datenbankverbindung gescheitert."); 
                			e.printStackTrace(); 
                       	} 
                		break;
                		
                		
                	case "Toggle ButtonF2":
                		try{ 
                			Connection conn = DriverManager.getConnection(url); 
                			String sql = "select * from fahrer where fid = 2"; 
                			Statement st = conn.createStatement(); 
                			ResultSet result = st.executeQuery(sql); 
                			while(result.next()){ 
                				int fid = result.getInt("fid"); 
                				String namef = result.getString("name"); 
                				String skill = result.getString("skill");
                				String team = result.getString("team");
                				System.out.println(fid + " " + namef + " " + skill + " " + team);  
                				playerid = fid;
                			} 
                		}
                		catch(SQLException e){ 
                			System.out.println("Datenbankverbindung gescheitert."); 
                			e.printStackTrace(); 
                		} 
                		break;
                		
                		
                	case "Toggle ButtonF3":
                		try{ 
                			Connection conn = DriverManager.getConnection(url); 
                			String sql = "select * from fahrer where fid = 3"; 
                			Statement st = conn.createStatement(); 
                			ResultSet result = st.executeQuery(sql); 
                			while(result.next()){ 
                				int fid = result.getInt("fid"); 
                				String namef = result.getString("name"); 
                				String skill = result.getString("skill");
                				String team = result.getString("team");
                				System.out.println(fid + " " + namef + " " + skill + " " + team);
                				playerid = fid;
                			} 
                		}
                		catch(SQLException e){ 
                			System.out.println("Datenbankverbindung gescheitert."); 
                			e.printStackTrace(); 
                		} 
                		break;
                		
                		
                	case "Toggle ButtonF4":
                		try{ 
                			Connection conn = DriverManager.getConnection(url); 
                			String sql = "select * from fahrer where fid = 4"; 
                			Statement st = conn.createStatement(); 
                			ResultSet result = st.executeQuery(sql); 
                			while(result.next()){ 
                				int fid = result.getInt("fid"); 
                				String namef = result.getString("name"); 
                				String skill = result.getString("skill");
                				String team = result.getString("team");
                				System.out.println(fid + " " + namef + " " + skill + " " + team);
                				playerid = fid;
                			} 
                		}
                		catch(SQLException e){ 
                			System.out.println("Datenbankverbindung gescheitert."); 
                			e.printStackTrace(); 
                		} 
                		break;
                		
                		
                	case "Toggle ButtonF5":
                		try{ 
                			Connection conn = DriverManager.getConnection(url); 
                			String sql = "select * from fahrer where fid = 5"; 
                			Statement st = conn.createStatement(); 
                			ResultSet result = st.executeQuery(sql); 
                			while(result.next()){ 
                				int fid = result.getInt("fid"); 
                				String namef = result.getString("name"); 
                				String skill = result.getString("skill");
                				String team = result.getString("team");       
                				System.out.println(fid + " " + namef + " " + skill + " " + team); 
                				playerid = fid;
                			} 
                		}
                		catch(SQLException e){ 
                			System.out.println("Datenbankverbindung gescheitert."); 
                			e.printStackTrace(); 
                		} 
                		break;
                }
            }
        };
		
		ChoicePanel(Rennspiel MainFrame){
			this.setBackground(new Color(100, 100, 100));
			
			this.continueButton.addActionListener(e -> MainFrame.showPanel("game"));
			
			this.toggleButton1.addActionListener(actionListener);
			this.toggleButton2.addActionListener(actionListener);
			this.toggleButton3.addActionListener(actionListener);
			this.toggleButton4.addActionListener(actionListener);
			this.toggleButton5.addActionListener(actionListener);
			this.toggleButton6.addActionListener(actionListener);
			this.toggleButton7.addActionListener(actionListener);
			this.toggleButton8.addActionListener(actionListener);

			this.setLayout(new BorderLayout());

			JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
			northPanel.add(Box.createRigidArea(new Dimension(70, 100)));
			northPanel.add(toggleButton1);	
			northPanel.add(Box.createRigidArea(new Dimension(70, 100)));
			northPanel.add(toggleButton2);	
			northPanel.add(Box.createRigidArea(new Dimension(70, 100)));
			northPanel.add(toggleButton3);	
			northPanel.add(Box.createRigidArea(new Dimension(70, 100)));
			northPanel.add(toggleButton4);	
			northPanel.add(Box.createRigidArea(new Dimension(70, 100)));
			northPanel.add(toggleButton5);	
			northPanel.setPreferredSize(new Dimension(1920, 450));

			toggleButton1.setMaximumSize(new Dimension(300, 300));
			toggleButton1.setPreferredSize(new Dimension(300, 300));
			toggleButton2.setMaximumSize(new Dimension(300, 300));
			toggleButton2.setPreferredSize(new Dimension(300, 300));
			toggleButton3.setMaximumSize(new Dimension(300, 300));
			toggleButton3.setPreferredSize(new Dimension(300, 300));
			toggleButton4.setMaximumSize(new Dimension(300, 300));
			toggleButton4.setPreferredSize(new Dimension(300, 300));
			toggleButton5.setMaximumSize(new Dimension(300, 300));
			toggleButton5.setPreferredSize(new Dimension(300, 300));
			
			JPanel centralPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.X_AXIS));
			centralPanel.add(Box.createRigidArea(new Dimension(175, 100)));
			centralPanel.add(toggleButton6);	
			centralPanel.add(Box.createRigidArea(new Dimension(175, 100)));
			centralPanel.add(toggleButton7);	
			centralPanel.add(Box.createRigidArea(new Dimension(175, 100)));
			centralPanel.add(toggleButton8);	
			centralPanel.setPreferredSize(new Dimension(1920, 450));
			
			toggleButton6.setMaximumSize(new Dimension(400, 300));
			toggleButton6.setPreferredSize(new Dimension(400, 300));
			toggleButton7.setMaximumSize(new Dimension(400, 300));
			toggleButton7.setPreferredSize(new Dimension(400, 300));
			toggleButton8.setMaximumSize(new Dimension(400, 300));
			toggleButton8.setPreferredSize(new Dimension(400, 300));
			
			JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			southPanel.add(continueButton);
			southPanel.setPreferredSize(new Dimension(1920, 100));
			continueButton.setPreferredSize(new Dimension(1900, 90));
			
			this.add(northPanel, BorderLayout.NORTH);
			this.add(centralPanel, BorderLayout.CENTER);
			this.add(southPanel, BorderLayout.SOUTH);
		}
		
		@Override
		public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
		}
	}
	
	public class LeaderPanel extends JPanel {
		LeaderPanel(){
			this.setBackground(new Color(100,100,100));
		}
	}

    public class GamePanel extends JPanel {
        GamePanel() {
    		
        }

        @Override
        public  void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            g2d.drawImage(rennstrecke.track, 0, 0, getWidth(), getHeight(), car1.x - 320, car1.y - 180, car1.x + 320, car1.y + 180, bgcolor, null);
            g2d.drawImage(rennstrecke.background, 0, 0, getWidth(), getHeight(), car1.x - 320, car1.y - 180, car1.x + 320, car1.y + 180, null);

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
    	this.lp = new LeaderPanel();
    	this.chp = new ChoicePanel(this);

    	mainPanel.add(sp, "start");
    	mainPanel.add(stp, "settings");
    	mainPanel.add(gp, "game");
    	mainPanel.add(chp, "choice");

    	this.setContentPane(mainPanel);

    	this.car1 = car1;
    	this.rennstrecke = rennstrecke;
    	this.zeit = 0;
    	this.zeitms = 0;

        this.setSize(1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setBackground(new Color(0, 67, 0));
        this.addKeyListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.toFront();
        this.requestFocus();
    }
    
    
    //Inputs - Controls
    //---------------------------------------------------------------------------------//
    
    InputMap inputMap = mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = mainPanel.getActionMap();
    
    public void Movement() {
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
        
        inputMap.put(KeyStroke.getKeyStroke("pressed W"), "keyW");
        inputMap.put(KeyStroke.getKeyStroke("pressed S"), "keyS");
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                this.car1.Steigung("Oben");
                break;
            case KeyEvent.VK_S:
                this.car1.Steigung("Unten");
                break;
            default:
                break;
        }
        //System.out.println("Key pressed: " + KeyEvent.getKeyText(keyCode));*/
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
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
        //BufferedImage carI = ImageIO.read(new File("H:\\Programme\\erstesProjekt\\Schmerz und Leid\\ressources\\car1.png"));
        //BufferedImage carI = ImageIO.read(new File("C:\\Users\\minhk\\Downloads\\car1.png"));
    	//System.out.println(System.getProperty("user.dir"));
    	
    	BufferedImage carI = ImageIO.read(new File("Schmerz und Leid\\assets\\images\\car1.png"));
    	Car car1 = new Car(1000, 920, carI); //x = 785, y = 860
        Rennstrecke rennstrecke = new Rennstrecke();

        Rennspiel rsp = new Rennspiel(car1, rennstrecke);
        
        rsp.mousePoint = rsp.getMouse(); 

        int cx = rsp.getWidth() / 2;
        int cy = rsp.getHeight() / 2;
        
        //Audio:
        //File audioFile = new File("H:\\Programme\\erstesProjekt\\Schmerz und Leid\\ressources\\raceSound.wav");
        File audioFile = new File("Schmerz und Leid\\assets\\sound\\raceSound.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        Clip clip = AudioSystem.getClip();
        
        int delay = 20;
        ActionListener taskPerformer = new ActionListener() {                                                                                      
            @Override
            public void actionPerformed(ActionEvent evt) { 
            	rsp.Movement();
            	if(car1.lap == 0) {
            		rsp.Timer();
            	}
            	if(car1.geschwindigkeit != 0) {
            		try {
            			if(!clip.isActive()) {
            				clip.open(audioStream);
                            clip.start();
                            rsp.setVolume(0, clip);
            			}
            			else if(clip.isActive()) {
            				rsp.setVolume(car1.geschwindigkeit/10, clip);
            				//System.out.println("Clip level: " + clip.getLevel());
            			}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            	}
            	if(car1.geschwindigkeit == 0) {
                	clip.stop();
                	clip.close();
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
                        if(car1.geschwindigkeit == 10){
                            car1.geschwindigkeit = car1.geschwindigkeit * 3;
                        }
                    }
                }
                rsp.repaint();
            }
        };
        new Timer(delay, taskPerformer).start();
    }
}