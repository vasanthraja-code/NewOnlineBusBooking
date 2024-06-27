package daoclasses;

import java.util.ArrayList;

import dtoclasses.PassengerDTO;

public class PassengerDAO {
	public static ArrayList<PassengerDTO> list=new ArrayList<PassengerDTO>();
	public ArrayList<PassengerDTO> addPassengers(PassengerDTO pObj) {
		list.add(pObj);
		return list;
	}

}
