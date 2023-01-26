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
            genderBTNGRP.add(maleRDB);
            genderBTNGRP.add(femaleRDB);

            newBTN = new JButton("New");
            saveBTN = new JButton("Save");
            showBTN = new JButton("Show");
            quitBTN = new JButton("Quit");
            depositBTN = new JButton("Deposit");
            withdrawBTN = new JButton("Withdraw");









    }






    public static void main(String[] args){
        AccountFrame af = new AccountFrame();
        af.setVisible(true);
        af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
