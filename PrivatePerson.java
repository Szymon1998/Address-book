public class PrivatePerson extends Person{
	

	String dateOfBirthdays;
	String type="p";
	Adress adresy;
	public PrivatePerson(String name,String surname,String number,String dateOfBirthdays,String nr_home,String street,String postNumber,String postOffice) {
		super(name,surname,number);
		this.dateOfBirthdays=dateOfBirthdays;
		adresy =new Adress(nr_home,street, postNumber,postOffice);
	
	}
	public String toString() {
		return "Imis: "+name+"\nnazwisko:"+surname+"\nNumer telefonu: "+number+"\ndata urodzin: "+dateOfBirthdays+"\n";
	}
	public String toString2() {
		return type+"\n"+name+"\n"+surname+"\n"+number+"\n"+dateOfBirthdays+"\n"+adresy.toString();
	}
	public String getAdres()
	{
		return adresy.getAdress()+" "+ dateOfBirthdays;
	}
	public void deleteAdr()
	{
		adresy = null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}