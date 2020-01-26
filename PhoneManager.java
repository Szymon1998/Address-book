import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;



public class PhoneManager  {
	
	public void GetFromFile(List<Person> persons)throws IOException,FileNotFoundException  {
		String filePath = "contact.txt";
		
		BufferedReader plik2 = null;
        try {
            plik2 = new BufferedReader(new InputStreamReader(
            		new FileInputStream(filePath), "UTF-8"));
            String m,n,o,p,r,s,t;
            String l = plik2.readLine();
            while (l != null) {
            	if (l.equals("f")) {
                l = plik2.readLine();
                m = plik2.readLine();
                 n= plik2.readLine();
                o = plik2.readLine();
               p = plik2.readLine();
                r = plik2.readLine();
                s = plik2.readLine();
                t = plik2.readLine();
                persons.add(new FamilyPerson(l,m,n,o,p,r,s,t));
                l = plik2.readLine();
            }
            	else if(l.equals("b")) {
            		   l = plik2.readLine();
                       m = plik2.readLine();
                        n= plik2.readLine();
                       o = plik2.readLine();
                      p = plik2.readLine();
                       r = plik2.readLine();
                       s = plik2.readLine();
                       t = plik2.readLine();
                       persons.add(new BuisnessPerson(l,m,n,o,p,r,s,t));
                       l = plik2.readLine();
            	}
            	else if(l.equals("p")) {
         		   l = plik2.readLine();
                    m = plik2.readLine();
                     n= plik2.readLine();
                    o = plik2.readLine();
                   p = plik2.readLine();
                    r = plik2.readLine();
                    s = plik2.readLine();
                    t = plik2.readLine();
                    persons.add(new PrivatePerson(l,m,n,o,p,r,s,t));
                    l = plik2.readLine();
         	}
            }
            	
        } finally {
            if (plik2 != null) {
                plik2.close();
            }
        }
    }
	public void RemoveFromList(List<Person>persons, String name, String surname) throws NoSuchElementException
	{
		Iterator<Person>itr=persons.iterator();
		while(itr.hasNext()) {
			Person tmp = itr.next();
			if(tmp.surname.equals(surname) && tmp.name.equals(name)) {
				itr.remove();
				break;
			}
		}
	}
		
	public void SaveToFile(List<Person>persons)throws IOException,FileNotFoundException{
		  
		String filePath = "contact.txt";
			
		PrintWriter writer = new PrintWriter(filePath, "UTF-8");
		
		 for(Person person : persons) {
			
		
				   String str =person.toString2();
			
				    writer.write(str);
				     
				  
				}
		  writer.close();
		}
	
	public static void main(String[] args)throws IOException,FileNotFoundException  {
		
	}

}