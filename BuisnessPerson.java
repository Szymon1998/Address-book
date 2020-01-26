public class BuisnessPerson extends Person {
	
	String emailAdress;
	String type="b";
	Adress adresy;
	public BuisnessPerson(String name,String surname,String number,String emailAdress,String nr_home,String street,String postNumber,String postOffice) {
		super(name,surname,number);
		this.emailAdress=emailAdress;
		adresy =new Adress(nr_home,street, postNumber,postOffice);
	}
	
	public String toString() {
		return "Imiê: "+name+"\nNazwisko:"+surname+"\nNumer telefonu: "+number+"\nemail: "+emailAdress+"\n";
	}
	public String toString2() {
		return type+"\n"+name+"\n"+surname+"\n"+number+"\n"+emailAdress+"\n"+adresy.toString();
	}
	public String getAdres()
	{
		return adresy.getAdress()+" "+emailAdress;
	}
	public void deleteAdr()
	{
		adresy = null;
	}

}