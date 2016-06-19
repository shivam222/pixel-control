import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;



class effect1  
{
	
	JFrame fr=new JFrame();
	JPanel p1=new JPanel();
    JPanel p2=new JPanel();
	JButton b1=new JButton("enter");
   	JLabel imageLabel1 = new JLabel();
	JSlider red=new JSlider(0,250,100);
	JLabel l1=new JLabel("range of row--");
	JTextField fr1 =new JTextField();
	JTextField fr2 =new JTextField();
	JLabel l2=new JLabel("range of column--");
	JTextField fl1 =new JTextField();
	JTextField fl2 =new JTextField();
	int k;
	JTextField[] field=new JTextField[4];
	Checkbox cb1=new Checkbox("red",null,true);
	Checkbox cb2=new Checkbox("green");
	Checkbox cb3=new Checkbox("blue");
	
	
	public effect1()
	{
		fr.setSize(1000,1000);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setTitle("PiXel ChANgeR");
		fr.setLayout(new BorderLayout());
		
		p2.setLayout(new GridLayout(0,4,2,2));
		//fr1.setcolumn(3);
		p2.add(b1);
		p2.add(l1);
		p2.add(fr1);
		p2.add(fr2);
		p2.add(l2);
		p2.add(fl1);
		p2.add(fl2);
		p2.add(b1);
		p2.add(cb1);
		p2.add(cb2);
		p2.add(cb3);
		
		field[0]=fr1;
		field[1]=fr2;
		field[2]=fl1;
		field[3]=fl2;
		
		
		/*for(k=0;k<4;k++)
		{field[k].addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
			                                                  NOT IN USE RIGHT NOW SO PASS OVER IT.
			System.out.println(field[k].getText());
            String text = field[k].getText();
            int length = text.length();
            if (length ==4) {
               
          e.consume();
            }
        
		}});}*/
		
		
		p2.add(red);
		
		
		red.setMinorTickSpacing(10);
		red.setMajorTickSpacing(50);
		red.setPaintTicks(true);
		red.setPaintLabels(true);
		
		
		
		fr.add(p1,BorderLayout.NORTH);
	    fr.add(p2,BorderLayout.SOUTH);

    }
	public void effect2()
	{
		
		JFileChooser fc=new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("E:/zayn"));
		fc.setDialogTitle("Choose your Image");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        fc.setFileFilter(filter);
		fr.add(fc);
		
	    int returnVal = fc.showOpenDialog(fr);          
        if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				
                ImageIcon image = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
				
                imageLabel1.setIcon(image);
                 				
                p1.add(imageLabel1);
			    imageLabel1.setVisible(true);
				fr.setVisible(true);
				
				
				
				

			 b1.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {    
				imageLabel1.setVisible(false);
				
				BufferedImage work1 = new BufferedImage(
                image.getIconWidth(),
                image.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
                Graphics g = work1.createGraphics();
                // paint the Icon to the BufferedImage.
                image.paintIcon(null, g, 0,0);
                g.dispose();
				
				
                 int height=work1.getHeight();
                 int width=work1.getWidth();
				 System.out.println(height);
				 System.out.println(width);
				 
				String row1=fr1.getText();
				String row2=fr2.getText();
			    String col1=fl1.getText();
				String col2=fl2.getText();
				
				Integer ro1=Integer.valueOf(row1);
				Integer ro2=Integer.valueOf(row2);
				Integer co1=Integer.valueOf(col1);
				Integer co2=Integer.valueOf(col2);
				 
                  for(int i=ro1;i<ro2;i++)
                    {
                        for(int j=co1;j<co2;j++)
                        {
                            Color c= new Color(work1.getRGB(j,i));
							Color c2;
                            
                           if(cb2.getState()){
							   c2=new Color(c.getRed(),red.getValue(),c.getBlue());}
						   else if(cb3.getState()){
							    c2=new Color(c.getRed(),c.getGreen(),red.getValue());}
                           else {
							    c2=new Color(red.getValue(),c.getGreen(),c.getGreen());}										  
                                          
								int co=c2.getRGB();  
                                work1.setRGB(j,i,co);
                        }
                    }
					ImageIcon image2 = new ImageIcon(work1);
                    imageLabel1.setIcon(image2);
					
                   // p1.add(imageLabel2);
                    imageLabel1.setVisible(true);					
            }
			});			
			}}}
			
	class effect4
	{
		public static void main(String str[])
		{
			effect1 ef1=new effect1();
			ef1.effect2();
		}
	}
		
	
	

