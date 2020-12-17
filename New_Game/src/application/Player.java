package application;

public class Player {
	private int curr_scr;
	private int max_scr;
	private int total_stars;
	public Player(int curr_scr, int max_scr, int total_stars) {
		super();
		this.setCurr_scr(curr_scr);
		this.setMax_scr(max_scr);
		this.setTotal_stars(total_stars);
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
	
}
