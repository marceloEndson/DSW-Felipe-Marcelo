package times;

import java.util.List;

import model.Times;

public interface ITimesDAO {
	
	public Times getTime(int id);
	
	public List<Times> lista();	

}
