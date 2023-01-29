import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


//swing
public class AccountFrame extends JFrame {
    JLabel accountNumberLBL, ownerLBL, balanceLBL, cityLBL, genderLBL, amountLBL;
    JTextField accountNumberTXT, ownerTXT, balanceTXT, amountTXT;
    JComboBox<City> citiesCMB;

    JButton newBTN, saveBTN, showBTN, quitBTN, depositBTN, withdrawBTN;
    JRadioButton maleRDB, femaleRDB;
    ButtonGroup genderBTNGRP;

    JList<Account> accountsLST;
    JPanel p1, p2, p3, p4, p5;

    Set<Account> accountSet = new TreeSet<>();
    Account account, x;
    boolean newRec = true;

    //Combobox data
    DefaultComboBoxModel<City> citiesCMBMDL;
    DefaultListModel<Account> accountLSTMDL;

    // Tabledata

    JTable table;
    DefaultTableModel tableModel;

    ArrayList<Tranaction> transList = new ArrayList<>();

    public AccountFrame(){
        super("Account operations ");
        setLayout(null);
        setSize(600, 400);

            //labels
            accountNumberLBL = new JLabel("Account Number");
            ownerLBL = new JLabel("Owner");
            balanceLBL = new JLabel("Balance");
            cityLBL = new JLabel("City");
            genderLBL = new JLabel("Gender");
            amountLBL = new JLabel("Amount");

            //text

            accountNumberTXT = new JTextField(); accountNumberTXT.setEnabled(false);
            ownerTXT = new JTextField();
            balanceTXT = new JTextField(); balanceTXT.setEnabled(false);
            amountTXT = new JTextField(); amountTXT.setPreferredSize(new Dimension(150, 25));

            //ComboBox
            citiesCMBMDL = new DefaultComboBoxModel<>();
            citiesCMBMDL.addElement(null);
            citiesCMBMDL.addElement(new City("Brooklen", "New York"));
            citiesCMBMDL.addElement(new City("Dothan", "Alabama"));
            citiesCMBMDL.addElement(new City("Atlanta", "Virginia"));
            citiesCMBMDL.addElement(new City("Miami", "Florida"));

            //data JCMB
            citiesCMB = new JComboBox<>(citiesCMBMDL);

            //Buttons
            maleRDB = new JRadioButton("Male", true);
            femaleRDB = new JRadioButton("Female");
            genderBTNGRP = new ButtonGroup();
            genderBTNGRP.add(maleRDB);
            genderBTNGRP.add(femaleRDB);

            newBTN = new JButton("New");
            saveBTN = new JButton("Save");
            showBTN = new JButton("Show");
            quitBTN = new JButton("Quit");
            depositBTN = new JButton("Deposit");
            withdrawBTN = new JButton("Withdraw");

            //Table
            accountLSTMDL= new DefaultListModel<>();
            accountsLST = new JList<>(accountLSTMDL);

            //Panels

            p1 = new JPanel(); p1.setBounds(5, 5, 300, 150);
            p1.setLayout(new GridLayout(5, 2));

            p2 = new JPanel(); p2.setBounds(5, 155, 300, 40);
            p2.setLayout(new FlowLayout());

            p3 = new JPanel(); p3.setBounds(5, 195, 600, 40);
            p3.setLayout(new FlowLayout());

            p4 = new JPanel(); p4.setBounds(300, 5, 300, 190);
            p4.setLayout(new BorderLayout());

            p5 = new JPanel(); p5.setBounds(5, 240, 500, 120);
            p5.setLayout(new BorderLayout());

            //Adding components to panel

            p1.add(accountNumberLBL);
            p1.add(accountNumberTXT);
            p1.add(ownerLBL);
            p1.add(ownerTXT);
            p1.add(balanceLBL);
            p1.add(balanceTXT);
            p1.add(cityLBL);
            p1.add(citiesCMB);
            p1.add(maleRDB);
            p1.add(femaleRDB);

            p2.add(newBTN);
            p2.add(saveBTN);
            p2.add(showBTN);
            p2.add(quitBTN);

            p3.add(amountLBL);
            p3.add(amountTXT);
            p3.add(depositBTN);
            p3.add(withdrawBTN);

            p4.add(accountsLST);



            //Adding Panels to fame

            add(p1);
            add(p2);
            add(p3);
            add(p4);
            add(p5);
            // Table

            tableModel = new DefaultTableModel();
            table = new JTable(tableModel);
            tableModel.addColumn("TransactionNumber");
            tableModel.addColumn("TransactionDate");
            tableModel.addColumn("TransactionType");
            tableModel.addColumn("TransactionAmount");

            JScrollPane scrollPane = new JScrollPane(table);
            p5.add(scrollPane);
















    }






    public static void main(String[] args){
        AccountFrame af = new AccountFrame();
        af.setVisible(true);
        af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
