import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ShowBoard extends JDialog implements ActionListener
{
	private JLabel tname, tsurname, tnumber, tstreet, tnr_home,tpostNumber,tpostOffice, tbonus, 
	tLname, tLsurname, tLnumber, tLstreet, tLnr_home, tLpostNumber, tLpostOffice, tLbonus;
	
	private JButton close;
	private String[] recordAdr;
	
	public ShowBoard(JFrame owner, List<Person> persons,String name, String surname)
	{
		super(owner, "Kontakt",true);
		setSize(600,700);
		setLocationRelativeTo(null);
		setLayout(null);
		for(Person person : persons) {
			if(person.surname.equals(surname) && person.name.equals(name)) {
		
		recordAdr=person.getAdres().split(" ");
		tLname = new JLabel("Imiê:");
		tLname.setBounds(70, 45, 120, 30);
		tLname.setFont(new Font("Serif", Font.BOLD, 20));
		add(tLname);
		
		tLsurname = new JLabel("Nazwisko:");
		tLsurname.setBounds(350, 45, 120, 30);
		tLsurname.setFont(new Font("Serif", Font.BOLD, 20));
		add(tLsurname);
		
		tLnumber = new JLabel("Telefon:");
		tLnumber.setBounds(70, 145, 120, 30);
		tLnumber.setFont(new Font("Serif", Font.BOLD, 20));
		add(tLnumber);
		
		tLstreet = new JLabel("Ulica:");
		tLstreet.setBounds(350, 145, 120, 30);
		tLstreet.setFont(new Font("Serif", Font.BOLD, 20));
		add(tLstreet);
		
		tLnr_home = new JLabel("Nr domu:");
		tLnr_home.setBounds(70, 245, 120, 30);
		tLnr_home.setFont(new Font("Serif", Font.BOLD, 20));
		add(tLnr_home);
		
		tLpostNumber = new JLabel("Kod pocztowy:");
		tLpostNumber.setBounds(350, 245, 150, 30);
		tLpostNumber.setFont(new Font("Serif", Font.BOLD, 20));
		add(tLpostNumber);
		
		tLpostOffice = new JLabel("Poczta:");
		tLpostOffice.setBounds(70, 345, 120, 30);
		tLpostOffice.setFont(new Font("Serif", Font.BOLD, 20));
		add(tLpostOffice);
		
		tLbonus = new JLabel("Inf. dod.:");
		tLbonus.setBounds(350, 345, 120, 30);
		tLbonus.setFont(new Font("Serif", Font.BOLD, 20));
		add(tLbonus);
		
		
		tname = new JLabel(person.name);
		tname.setBounds(70, 80, 120, 30);
		tname.setFont(new Font("Serif", Font.PLAIN, 20));
		add(tname);
		
		tsurname = new JLabel(person.surname);
		tsurname.setBounds(350, 80, 120, 30);
		tsurname.setFont(new Font("Serif", Font.PLAIN, 20));
		add(tsurname);
		
		tnumber = new JLabel(person.number);
		tnumber.setBounds(70, 180, 120, 30);
		tnumber.setFont(new Font("Serif", Font.PLAIN, 20));
		add(tnumber);
		
		tstreet = new JLabel(recordAdr[0]);
		tstreet.setBounds(350, 180, 120, 30);
		tstreet.setFont(new Font("Serif", Font.PLAIN, 20));
		add(tstreet);
		
		tnr_home = new JLabel(recordAdr[1]);
		tnr_home.setBounds(70, 280, 120, 30);
		tnr_home.setFont(new Font("Serif", Font.PLAIN, 20));
		add(tnr_home);
		
		tpostNumber = new JLabel(recordAdr[2]);
		tpostNumber.setBounds(350, 280, 120, 30);
		tpostNumber.setFont(new Font("Serif", Font.PLAIN, 20));
		add(tpostNumber);
		
		tpostOffice = new JLabel(recordAdr[3]);
		tpostOffice.setBounds(70, 380, 120, 30);
		tpostOffice.setFont(new Font("Serif", Font.PLAIN, 20));
		add(tpostOffice);
		
		tbonus = new JLabel(recordAdr[4]);
		tbonus.setBounds(350, 380, 220, 30);
		tbonus.setFont(new Font("Serif", Font.PLAIN, 20));
		add(tbonus);
		
		close = new JButton("Wyjscie");
		close.setBounds(200, 520, 150, 50);
		add(close);
		close.addActionListener(this);
			}	
		}
	}
	public  void clear()
	{
		tname.setText("");
		tsurname.setText("");
		tnumber.setText("");
		tstreet.setText("");
		tnr_home.setText("");
		tpostNumber.setText("");
		tpostOffice.setText("");
		tbonus.setText("");
		
	}
		
			
	
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if (z==close)
			clear();
			dispose();
		
	}

}
