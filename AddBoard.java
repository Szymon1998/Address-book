import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
class AddBoard extends JDialog implements ActionListener
{
	private JButton save,close;
	private JTextField name, surname, number, street, nr_home, postNumber,postOffice, bonus;
	private JRadioButton rprivate, rFamily, rfirm;
	private ButtonGroup relation;
	
	public AddBoard(JFrame owner, List<Person> persons)
	{
		super(owner, "Dodawanie",true);
		setSize(600,700);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		relation = new ButtonGroup();
		
		name = new JTextField("Imie");
		name.setBounds(50, 50, 120, 30);
		add(name);
		
		surname = new JTextField("Nazwisko");
		surname.setBounds(300, 50, 120, 30);
		add(surname);
		
		number = new JTextField("Telefon");
		number.setBounds(50, 100, 120, 30);
		add(number);
		
		street = new JTextField("Ulica");
		street.setBounds(300, 100, 120, 30);
		add(street);
		
		nr_home = new JTextField("Nr domu");
		nr_home.setBounds(50, 150, 120, 30);
		add(nr_home);
		
		postNumber = new JTextField("Nr pocztowy");
		postNumber.setBounds(300, 150, 120, 30);
		add(postNumber);
		
		postOffice = new JTextField("Poczta");
		postOffice.setBounds(50, 200, 120, 30);
		add(postOffice);
		
		bonus = new JTextField("Data urodzin");
		bonus.setBounds(180, 320, 200, 30);
		add(bonus);
		
		rprivate = new JRadioButton("Prywatne", true);
		rprivate.setBounds(100,260,100,30);
		relation.add(rprivate);
		add(rprivate);
		rprivate.addActionListener(this);
		
		rfirm = new JRadioButton("Firmowe", false);
		rfirm.setBounds(250,260,100,30);
		relation.add(rfirm);
		add(rfirm);
		rfirm.addActionListener(this);
		
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
	
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if (z==close)
			dispose();
		if (z==save) {
			if (rprivate.isSelected()) 
			{
				Board.persons.add(new PrivatePerson(name.getText(),surname.getText(),number.getText(),bonus.getText(),street.getText(),nr_home.getText(),postNumber.getText(),postOffice.getText()));
				Board.names.addElement(name.getText()+" " +surname.getText());
				dispose();
			}
			else if (rfirm.isSelected()) 
			{
				
				Board.persons.add(new BuisnessPerson(name.getText(),surname.getText(),number.getText(),bonus.getText(),street.getText(),nr_home.getText(),postNumber.getText(),postOffice.getText()));
				Board.names.addElement(name.getText()+" " +surname.getText());
				dispose();
			}
			else {
				Board.persons.add(new FamilyPerson(name.getText(),surname.getText(),number.getText(),bonus.getText(),street.getText(),nr_home.getText(),postNumber.getText(),postOffice.getText()));
				Board.names.addElement(name.getText()+" " +surname.getText());
				dispose();
			}
			
			
			};
		if (z==rprivate)
			bonus.setText("Data urodzin");
		else if (z==rfirm)
			bonus.setText("Adres e-mail");
		else if(z==rFamily)
			bonus.setText("Relacja");
			

		
	}
	
}