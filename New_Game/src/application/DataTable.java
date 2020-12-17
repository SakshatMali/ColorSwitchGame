package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataTable implements Serializable{
	private static final long serialVersionUID = 1L;
	private int curr_scr;
	private int max_scr;
	private int total_stars;
	private int num_obst1;
	private int num_obst2;
	private double ball_x;
	private double ball_y;
	private double obst_y;
	private int star_present;
	private int clr_present;
	
	public DataTable(int curr_scr, int max_scr, int total_stars, int num_obst1, int num_obst2, double ball_x,double ball_y, double obst_y,int star_present,int clr_present) {
		super();
		this.curr_scr = curr_scr;
		this.max_scr = max_scr;
		this.total_stars = total_stars;
		this.num_obst1 = num_obst1;
		this.num_obst2 = num_obst2;
		this.ball_x=ball_x;
		this.ball_y=ball_y;
		this.obst_y=obst_y;
		this.star_present=star_present;
		this.clr_present=clr_present;
	}
	
	public void serialize() {
		  try{    
			  	PauseDialogBoxController pdc = new PauseDialogBoxController();
			  	FileOutputStream file = new FileOutputStream("LoadGame"+(pdc.getSave_count()%7)+".txt");
	            ObjectOutputStream out = new ObjectOutputStream(file);  
	            out.writeObject(this); 
	            out.close(); 
	            file.close();  
	            System.out.println("Datatable Object has been serialized");
	        } 
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	}
	public DataTable deserialize(int sv_cnt) {
		DataTable datatable=null;
		 try{    
			 	PauseDialogBoxController pdc = new PauseDialogBoxController();
			 	FileInputStream file = new FileInputStream("LoadGame"+(sv_cnt)+".txt");
	            ObjectInputStream in = new ObjectInputStream(file); 
	            datatable = (DataTable)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	            total_stars = datatable.getTotal_stars();
	            SaveController.setStar_text(total_stars);
	              
	            System.out.println("Datatable Object has been deserialized "); 
	        } 
	        
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	        catch(ClassNotFoundException ex) { 
	            System.out.println("ClassNotFoundException is caught"); 
	        }
		 return datatable;
		
	}
	
	
	public void serialize_resume() {
		  try{    
	            FileOutputStream file = new FileOutputStream("ResumeFile.txt"); 
	            ObjectOutputStream out = new ObjectOutputStream(file);  
	            out.writeObject(this); 
	            out.close(); 
	            file.close();  
	            System.out.println("Resume Object has been serialized");
	        } 
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	}
	
	public DataTable deserialize_resume() {
		DataTable datatable=null;
		 try{    
			 	
	            FileInputStream file = new FileInputStream("ResumeFile.txt"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	            datatable = (DataTable)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	            System.out.println("Resume Object has been deserialized "); 
	        } 
	        
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	        catch(ClassNotFoundException ex) { 
	            System.out.println("ClassNotFoundException is caught"); 
	        }
		 return datatable;
		
	}
	
	public void serialize_max_scr() {
		  try{    
	            FileOutputStream file = new FileOutputStream("Max_Scr_File.txt"); 
	            ObjectOutputStream out = new ObjectOutputStream(file);  
	            out.writeObject(this); 
	            out.close(); 
	            file.close();  
	            System.out.println("Max Scr Object has been serialized");
	        } 
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	}
	
	public DataTable deserialize_max_scr() {
		DataTable datatable=null;
		 try{    
	            FileInputStream file = new FileInputStream("Max_Scr_File.txt"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	            datatable = (DataTable)in.readObject(); 
	              
	            in.close(); 
	            file.close(); 
	            System.out.println("Max Scr Object has been deserialized "); 
	        } 
	        
	        catch(IOException ex) { 
	            System.out.println("IOException is caught"); 
	        } 
	        catch(ClassNotFoundException ex) { 
	            System.out.println("ClassNotFoundException is caught"); 
	        }
		 return datatable;
		
	}
	public int getCurr_scr() {
		return curr_scr;
	}
	public void setCurr_scr(int curr_scr) {
		this.curr_scr = curr_scr;
	}
	public int getMax_scr() {
		return max_scr;
	}
	public void setMax_scr(int max_scr) {
		this.max_scr = max_scr;
	}
	public int getTotal_stars() {
		return total_stars;
	}
	public void setTotal_stars(int total_stars) {
		this.total_stars = total_stars;
	}
	public int getNum_obst1() {
		return num_obst1;
	}
	public void setNum_obst1(int num_obst1) {
		this.num_obst1 = num_obst1;
	}
	public int getNum_obst2() {
		return num_obst2;
	}
	public void setNum_obst2(int num_obst2) {
		this.num_obst2 = num_obst2;
	}

	public double getBall_x() {
		return ball_x;
	}

	public void setBall_x(double ball_x) {
		this.ball_x = ball_x;
	}

	public double getBall_y() {
		return ball_y;
	}

	public void setBall_y(double ball_y) {
		this.ball_y = ball_y;
	}

	public double getObst_y() {
		return obst_y;
	}

	public void setObst_y(double obst_y) {
		this.obst_y = obst_y;
	}

	public int getStar_present() {
		return star_present;
	}

	public void setStar_present(int star_present) {
		this.star_present = star_present;
	}

	public int getClr_present() {
		return clr_present;
	}

	public void setClr_present(int clr_present) {
		this.clr_present = clr_present;
	}
}
