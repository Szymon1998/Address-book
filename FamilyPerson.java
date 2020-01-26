public class FamilyPerson extends Person {

	
	String typeOfFamily;
	String type="f";
	Adress adresy;
	public FamilyPerson(String name,String surname,String number,String typeOfFamily,String nr_home,String street,String postNumber,String postOffice) {
		super(name,surname,number);
		this.typeOfFamily=typeOfFamily;
		adresy =new Adress(nr_home,street, postNumber,postOffice);
	
	}
		
	public String toString() {
		return "Imis: "+name+"\nnazwisko:"+surname+"\nNumer telefonu: "+number+"\ntyp rodziny: "+typeOfFamily+"\n";
	}
	
	public String toString2() {
		return type+"\n"+name+"\n"+surname+"\n"+number+"\n"+typeOfFamily+"\n"+adresy.toString();
	}
	
	public String getAdres()
	{
		return adresy.getAdress()+" "+ typeOfFamily;
	}
	public void deleteAdr()
	{
		adresy = null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}