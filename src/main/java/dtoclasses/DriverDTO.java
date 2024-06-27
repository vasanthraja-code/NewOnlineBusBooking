package dtoclasses;

public class DriverDTO {
	private int driverId;
	private String driverName;
	private int phoneNumber;
	public DriverDTO(int driverId, String driverName, int phoneNumber) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.phoneNumber = phoneNumber;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
