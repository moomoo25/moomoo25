import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import	java.awt.Toolkit;
import	java.awt.*;
import javax.swing.JPanel;
import java.awt.image.*;
import java.io.File;


public class GamePanel extends JPanel {
	private int i = 0;
	private BufferedImage bi;	
	Graphics2D big;
	JLabel background;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	Image img;
	public GamePanel() {
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		
		big.setBackground(Color.black);
		
		
	}

	public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 400, 600);
		
		big.setColor(Color.WHITE);		
		big.drawString(String.format("%08d", reporter.getScore()), 300, 20);
		big.drawString(String.format("%d", GameEngine.i), 250, 20);
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}