public abstract class Person {
	
	String name;
	String surname;
	String number;
	
	
	public Person(String name,String surname,String number) {
		this.name=name;
		this.surname=surname;
		this.number=number;
		
	}

	//public abstract void EditPerson();
	
	public abstract String toString();
	public abstract String toString2();
	public abstract String getAdres();
	public abstract void deleteAdr();
	public static void main(String[] args) {
	}
		// TODO Auto-generated method stub

	

}