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
import java.io.*;
import javax.imageio.*;
import java.io.File;


class effect1  
{
	
	JFrame fr=new JFrame();
	JPanel p1=new JPanel();
    JPanel p2=new JPanel();
	JButton b1=new JButton("see effect");
	JButton b5=new JButton("save");
	JButton b2=new JButton("create your own");
	JButton b9=new JButton("scale half");
	JButton b10=new JButton("ThresHolding");
    JLabel imageLabel1 = new JLabel();
	JSlider red=new JSlider(0,250,100);
	JLabel l1=new JLabel("range of row--");
	JTextField fr1 =new JTextField();
	JTextField fr2 =new JTextField();
	JLabel l2=new JLabel("range of column--");
	JTextField fl1 =new JTextField();
	JTextField fl2 =new JTextField();
	int k,widic,heiic;
	JTextField[] field=new JTextField[4];
	Checkbox cb1=new Checkbox("red",null,true);
	Checkbox cb2=new Checkbox("green");
	Checkbox cb3=new Checkbox("blue");
	BufferedImage work1,work2,workResize;
	int IMG_HEIGHT,IMG_WIDTH,height2,width2;
                     
	//create your own elements//
	JLabel l3=new JLabel("range of color to be converted--");
	JLabel l4=new JLabel("color");
	JTextField f11 =new JTextField();
	JTextField f12 =new JTextField();
	JTextField f13 =new JTextField();
	JTextField f14 =new JTextField();
	JTextField f15 =new JTextField();
	JTextField f16 =new JTextField();
	JButton b7=new JButton("Watch");
	JButton b8=new JButton("save");
	Checkbox below=new Checkbox("below this range");

	
	
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
		p2.add(red);
		p2.add(b1);
		p2.add(cb1);
		p2.add(cb2);
		p2.add(cb3);
        p2.add(b5);
		p2.add(b2);
		p2.add(b10);
		p2.add(b9);
		//create your own elements.//
		
	    field[0]=fr1;
		field[1]=fr2;
		field[2]=fl1;
		field[3]=fl2;
		
	    red.setMinorTickSpacing(10);
		red.setMajorTickSpacing(50);
		red.setPaintTicks(true);
		red.setPaintLabels(true);
		
		p2.setPreferredSize(new Dimension(50,150));		
		fr.add(p1,BorderLayout.NORTH);
	    fr.add(p2,BorderLayout.SOUTH);

    }
	public void effect2()
	{
		
		JFileChooser fc=new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("E:/zayn"));
		fc.setDialogTitle("Choose your Image");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & png Images", "jpg", "gif","png");
        fc.setFileFilter(filter);
		fr.add(fc);
		
	    int returnVal = fc.showOpenDialog(fr);          
        if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				
                ImageIcon image = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
				
                imageLabel1.setIcon(image);
				
                 widic=image.getIconWidth();
                 heiic=image.getIconHeight();
                if(widic>1000 ||heiic>600)
				{ 
			    System.out.println("Hey Boy This Image Is Bigger Then My Container.Try with a small one.");
			    System.exit(1);
				}					
                p1.add(imageLabel1);
			    imageLabel1.setVisible(true);
				fr.setVisible(true);
				
			b9.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					imageLabel1.setVisible(false);
					 work1 = new BufferedImage(
                     image.getIconWidth(),
                     image.getIconHeight(),
                     BufferedImage.TYPE_INT_RGB);
                     Graphics g = work1.createGraphics();
                     // paint the Icon to the BufferedImage.
                     image.paintIcon(null, g, 0,0);
                      g.dispose();
					  height2=work1.getHeight();
                      width2=work1.getWidth();
					  IMG_HEIGHT=height2/2;
                      IMG_WIDTH=width2/2;					  
					  //code snippet for resizing
					 
					  int type = work1.getType() == 0? BufferedImage.TYPE_INT_ARGB : work1.getType();
			           workResize = resizeImage(work1, type,IMG_WIDTH,IMG_HEIGHT);
		              
					  ImageIcon imageResize = new ImageIcon(workResize);
					  imageLabel1.setIcon(imageResize);
                      imageLabel1.setVisible(true);
		
				}
			});
				
				
				
		    b1.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {    
				imageLabel1.setVisible(false);
				
				 work1 = new BufferedImage(
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
                           else if(cb1.getState()){
							    c2=new Color(red.getValue(),c.getGreen(),c.getBlue());}	
                            else{
								c2=new Color(c.getRed(),c.getGreen(),c.getBlue());}
															
                                          
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
			
			b10.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					imageLabel1.setVisible(false);
					 work1 = new BufferedImage(
                     image.getIconWidth(),
                     image.getIconHeight(),
                     BufferedImage.TYPE_INT_RGB);
                     Graphics g = work1.createGraphics();
                     // paint the Icon to the BufferedImage.
                     image.paintIcon(null, g, 0,0);
                      g.dispose();
					  height2=work1.getHeight();
                      width2=work1.getWidth();					  
					  //code snippet for thresholding.
					  for(int i=0;i<height2;i++)
                    {
                        for(int j=0;j<width2;j++)
                        {
                            Color c= new Color(work1.getRGB(j,i));
							Color c2;
                            
                           if(c.getRed()>=127&&c.getBlue()>=127&&c.getGreen()>=127){
							   c2=new Color(255,255,255);
						   }
						  else if(c.getRed()>=127&&c.getBlue()>=127&&c.getGreen()<127){
							   c2=new Color(255,255,255);
						   }
						   else if(c.getRed()>=127&&c.getBlue()<127&&c.getGreen()>=127){
							   c2=new Color(255,255,255);
						   }
						  else if(c.getRed()<127&&c.getBlue()>=127&&c.getGreen()>=127){
							   c2=new Color(255,255,255);
						   }
						   else{
							     c2=new Color(0,0,0);
						   }
						  
						   int cx=c2.getRGB();
						   work1.setRGB(j,i,cx);
						   
                        }
                    }
					ImageIcon image2 = new ImageIcon(work1);
                    imageLabel1.setIcon(image2);
					
                    imageLabel1.setVisible(true);
					
				}
			});

           b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
			{
                 try{
				    File output= new File("work1.jpg");
                    ImageIO.write(work1,"jpg",output);
			         }
				catch(Exception e2)
			          {  }	
			  }});
			b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
			{
                 try{
				    File output= new File("work2.jpg");
                    ImageIO.write(work2,"jpg",output);
			         }
				catch(Exception e2)
			          {  }	
			  }});

          b2.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				    p2.removeAll();
                    p2.revalidate();
					p2.add(l3);
					p2.add(f11);
					p2.add(f12);
					p2.add(f13);
					p2.add(l4);
					p2.add(f14);
					p2.add(f15);
					p2.add(f16);
					p2.add(b7);
					p2.add(b8);
					p2.add(below);
				  
			  }
		  });
		  b7.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				    work2 = new BufferedImage(
                    image.getIconWidth(),
                    image.getIconHeight(),
                    BufferedImage.TYPE_INT_RGB);
                    Graphics g = work2.createGraphics();
                    // paint the Icon to the BufferedImage.
                    image.paintIcon(null, g, 0,0);
                    g.dispose();
				    imageLabel1.setIcon(null);
                    imageLabel1.revalidate();
					String s1=f11.getText();
					String s2=f12.getText();
					String s3=f13.getText();
					String s4=f14.getText();
					String s5=f15.getText();
					String s6=f16.getText();
					Integer f11v=Integer.valueOf(s1);
					Integer f12v=Integer.valueOf(s2);
					Integer f13v=Integer.valueOf(s3);
					Integer f14v=Integer.valueOf(s4);
					Integer f15v=Integer.valueOf(s5);
					Integer f16v=Integer.valueOf(s6);

					for(int v=0;v<heiic;v++)
					{
						for(int d=0;d<widic;d++)
						{
							Color pitch = new Color(work2.getRGB(d,v));
							Color pitch2;
							if(!(below.getState())){
							if(pitch.getRed()>=f11v&&pitch.getGreen()>=f12v&&pitch.getBlue()>=f13v)
							{
								pitch2=new Color(f14v,f15v,f16v);
							}
							else{
								pitch2=new Color(pitch.getRed(),pitch.getGreen(),pitch.getBlue());
							}
							}
							else{
							if(pitch.getRed()<=f11v&&pitch.getGreen()<=f12v&&pitch.getBlue()<=f13v)
							{
								pitch2=new Color(f14v,f15v,f16v);
							}
							else{
								pitch2=new Color(pitch.getRed(),pitch.getGreen(),pitch.getBlue());
							}	
							}
							int pitcher=pitch2.getRGB();
							work2.setRGB(d,v,pitcher);
						}
					}
					ImageIcon image3 = new ImageIcon(work2);
					imageLabel1.setIcon(image3);
				   
		   }
		  });
			
			}}
						  
					  //defining function resize image.
					  private static BufferedImage resizeImage(BufferedImage work1, int type,int w,int h){
	                  BufferedImage resizedImage = new BufferedImage(w,h, type);
	                  Graphics g = resizedImage.createGraphics();
	                  g.drawImage(work1, 0, 0, w, h, null);
	                  g.dispose();
		              return resizedImage;
    }
	}
			
	class effect4
	{
		public static void main(String str[])
		{
			effect1 ef1=new effect1();
			ef1.effect2();
		}
	}
		
	
	

