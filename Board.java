import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Board extends JFrame implements ActionListener {
	private JButton edit, close,addM,deleteM,showM,save;
	private AddBoard addBoard;
	private ShowBoard showBoard;
	private EditBoard editBoard;
	private JList list;
	public static PhoneManager manager = new PhoneManager();
	public static List<Person> persons = new ArrayList<>();
	public static DefaultListModel names = new DefaultListModel<>();
	public Board() throws FileNotFoundException, IOException
	{
		
		manager.GetFromFile(persons);
		setList(names);
		menu();
	}
	public void menu ()
	{
		
		setSize(600,700);
		setLocationRelativeTo(null);
		setTitle("Ksiazka adresowa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		
       
		list = new JList<>(names);
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFixedCellHeight(30);
        
        JScrollPane sc = new JScrollPane(list);
        sc.setBounds(50,100,200,350);
        add(sc);
        
        
		addM = new JButton("Dodaj");
		deleteM = new JButton("Usun");
		edit = new JButton("Edytuj");
		showM = new JButton("Wyswietl");
		save = new JButton("Zapisz");
		close = new JButton("Wyjscie");
		showM.setBounds(350, 150, 150, 30);
		add(showM);
		showM.addActionListener(this);
		
		addM.setBounds(350, 220, 150, 30);
		add(addM);
		addM.addActionListener(this);
		
		deleteM.setBounds(350, 290, 150, 30);
		add(deleteM);
		deleteM.addActionListener(this);
		
		edit.setBounds(350, 360, 150, 30);
		add(edit);
		edit.addActionListener(this);
		
		save.setBounds(80, 520, 150, 50);
		add(save);
		save.addActionListener(this);
		
		close.setBounds(300, 520, 150, 50);
		add(close);
		close.addActionListener(this);
		
		setVisible(true);
	}
	public String getName()
	{
		String person = (String) list.getSelectedValue();
		return person.substring(0, person.indexOf(' '));
	}
	public String getSurname()
	{
		String person = (String) list.getSelectedValue();
		return person.substring(person.lastIndexOf(" ")+1);
	}
	
	public boolean notSelected() {
		return list.isSelectionEmpty();
	}
	public void setList(DefaultListModel names)
	{
		for(Person p : persons) names.addElement(p.name + " " + p.surname);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==addM)
		{
			addBoard = new AddBoard(this, persons);
			addBoard.setVisible(true);
		}
		else if (source==showM && !notSelected())
		{
			showBoard = new ShowBoard(this, persons, getName(),getSurname());
			showBoard.setVisible(true);
		}
		else if (source==edit && !notSelected())
		{
			editBoard = new EditBoard(this, persons, getName(),getSurname(),(String)list.getSelectedValue());
			editBoard.setVisible(true);
		}
		else if (source==deleteM && !notSelected())
		{
			manager.RemoveFromList(persons, getName(),getSurname());
			names.removeElement((String)list.getSelectedValue());
		}
		else if (source==save)
		{
			try {
				manager.SaveToFile(persons);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (source==close)
		{
			dispose();
		}
	}

}



