import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class EditBoard extends JDialog implements ActionListener
{
	private JButton save,close;
	private JTextField tname, tsurname, tnumber, tstreet, tnr_home,tpostNumber,tpostOffice, tbonus;
	private JRadioButton rPrivate, rFamily, rFirm;
	private ButtonGroup relation;
	private String[] recordAdr;
	private String Ename,Esurname, Evalue;
	public EditBoard(JFrame owner, List<Person> persons,String name, String surname,String value)
	{
		super(owner, "Dodawanie",true);
		setSize(600,700);
		setLocationRelativeTo(null);
		setLayout(null);
		
		relation = new ButtonGroup();
		Ename = name;
		Esurname=surname;
		Evalue=value;
		for(Person person : persons) {
			if(person.surname.equals(surname) && person.name.equals(name)) {
				
		recordAdr=person.getAdres().split(" ");
		
		tname = new JTextField(person.name);
		tname.setBounds(50, 50, 120, 30);
		add(tname);
		
		tsurname = new JTextField(person.surname);
		tsurname.setBounds(300, 50, 120, 30);
		add(tsurname);
		
		tnumber = new JTextField(person.number);
		tnumber.setBounds(50, 100, 120, 30);
		add(tnumber);
		
		tstreet = new JTextField(recordAdr[0]);
		tstreet.setBounds(300, 100, 120, 30);
		add(tstreet);
		
		tnr_home = new JTextField(recordAdr[1]);
		tnr_home.setBounds(50, 150, 120, 30);
		add(tnr_home);
		
		tpostNumber = new JTextField(recordAdr[2]);
		tpostNumber.setBounds(300, 150, 120, 30);
		add(tpostNumber);
		
		tpostOffice = new JTextField(recordAdr[3]);
		tpostOffice.setBounds(50, 200, 120, 30);
		add(tpostOffice);
		
		tbonus = new JTextField(recordAdr[4]);
		tbonus.setBounds(180, 320, 200, 30);
		add(tbonus);
		
		rPrivate = new JRadioButton("Prywatne", true);
		rPrivate.setBounds(100,260,100,30);
		relation.add(rPrivate);
		add(rPrivate);
		rPrivate.addActionListener(this);
		
		rFirm = new JRadioButton("Firmowe", false);
		rFirm.setBounds(250,260,100,30);
		relation.add(rFirm);
		add(rFirm);
		rFirm.addActionListener(this);
		
		rFamily = new JRadioButton("Rodzina", false);
		rFamily.setBounds(400,260,200,30);
		relation.add(rFamily);
		add(rFamily);
		rFamily.addActionListener(this);
		
		save = new JButton("Zapisz");
		close = new JButton("Wyjscie");
		close.setBounds(300, 520, 150, 50);
		add(close);
		close.addActionListener(this);
		save.setBounds(80, 520, 150, 50);
		add(save);
		close.addActionListener(this);
		save.addActionListener(this);
		
	}
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if (z==close)
			dispose();
		if (z==save) {
			Board.manager.RemoveFromList(Board.persons, Ename,Esurname);
			Board.names.removeElement(Evalue);
			if (rPrivate.isSelected()) 
			{
				Board.persons.add(new PrivatePerson(tname.getText(),tsurname.getText(),tnumber.getText(),tbonus.getText(),tnr_home.getText(),tstreet.getText(),tpostNumber.getText(),tpostOffice.getText()));
				Board.names.addElement(tname.getText()+" " +tsurname.getText());
				dispose();
			}
			else if (rFirm.isSelected()) 
			{
				
				Board.persons.add(new BuisnessPerson(tname.getText(),tsurname.getText(),tnumber.getText(),tbonus.getText(),tnr_home.getText(),tstreet.getText(),tpostNumber.getText(),tpostOffice.getText()));
				Board.names.addElement(tname.getText()+" " +tsurname.getText());
				dispose();
			}
			else {
				Board.persons.add(new FamilyPerson(tname.getText(),tsurname.getText(),tnumber.getText(),tbonus.getText(),tnr_home.getText(),tstreet.getText(),tpostNumber.getText(),tpostOffice.getText()));
				Board.names.addElement(tname.getText()+" " +tsurname.getText());
				dispose();
			}
		if (z==rPrivate)
			tbonus.setText("Data urodzin");
		else if (z==rFirm)
			tbonus.setText("Adres e-mail");
		else if(z==rFamily)
			tbonus.setText("Relacja");
			

		
		}
	}
}


