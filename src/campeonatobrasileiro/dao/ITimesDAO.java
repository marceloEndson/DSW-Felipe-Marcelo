package campeonatobrasileiro.dao;

import java.util.List;

import campeonatobrasileiro.model.Times;

public interface ITimesDAO {
	
	public Times getTime(int id);
	
	public List<Times> getLista();	

}