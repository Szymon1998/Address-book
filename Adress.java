public class Adress {
	
	
	String nr_home;
	String street;
	String postNumber;
	String postOffice;
	
	public Adress(String nr_home,String street,String postNumber,String postOffice) {
		this.nr_home=nr_home;
		this.street=street;
		this.postNumber=postNumber;
		this.postOffice=postOffice;
	}
	public String toString() {
		return nr_home+"\n"+street+"\n"+postNumber+"\n"+postOffice+"\n";
	}
	
	public String getAdress()
	{
		return nr_home+" "+street+" "+postNumber+" "+postOffice;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}