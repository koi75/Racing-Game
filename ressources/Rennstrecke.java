package ressources;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Rennstrecke {
    public BufferedImage track;
    public BufferedImage background;

    Rennstrecke() throws IOException {
    	//Absolute Path
        //this.track = ImageIO.read(new File("H:\\Programme\\erstesProjekt\\Schmerz und Leid\\ressources\\Track1.png"));
        //this.background = ImageIO.read(new File("H:\\Programme\\erstesProjekt\\Schmerz und Leid\\ressources\\TrackBG1.png"));
        //this.track = ImageIO.read(new File("C:\\Users\\minhk\\Downloads\\Track.png"));
        //this.background = ImageIO.read(new File("C:\\Users\\minhk\\Downloads\\TrackBG.png"));
    	
    	//Relative Path
    	this.track = ImageIO.read(new File("Schmerz und Leid\\assets\\images\\Track1.png"));
        this.background = ImageIO.read(new File("Schmerz und Leid\\assets\\images\\TrackBG1.png"));
    }

    public boolean checkStillOnTrack(Car car){
        if(car.x <= 0 || car.x >= 1920 || car.y >= 1080 || car.y <= 0){
            return false;
        }
        Color col = new Color(this.track.getRGB(car.x, car.y));

        if(col.getBlue() == 0 && col.getRed() == 0 && col.getGreen() == 0){
            return true;
        }
        return false;
    }

    public boolean checkLap(Car car){
        if(car.x <= 0 || car.x >= 1920 || car.y >= 1080 || car.y <= 0){
            return false;
        }
        Color col = new Color(this.track.getRGB(car.x, car.y));

        if(col.getBlue() == 0 && col.getRed() == 255 && col.getGreen() == 255){
            return true;
        }
        return false;
    }

    public boolean speedBoost(Car car){
        if(car.x <= 0 || car.x >= 1920 || car.y >= 1080 || car.y <= 0){
            return false;
        }
        Color col = new Color(this.background.getRGB(car.x, car.y));

        if(col.getBlue() == 0 && col.getRed() == 0 && col.getGreen() == 255){
            return true;
        }
        return false;
    }
}
