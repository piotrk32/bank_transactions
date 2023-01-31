package project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
        super("project.Account operations ");
        setLayout(null);
        setSize(600, 400);

            //labels
            accountNumberLBL = new JLabel("Account Number");
            ownerLBL = new JLabel("Owner");
            balanceLBL = new JLabel("Balance");
            cityLBL = new JLabel("project.City");
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

            // Methods

             newBTN.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     accountNumberTXT.setText("");
                     ownerLBL.setText("");
                     citiesCMB.setSelectedIndex(0);
                     maleRDB.setSelected(true);
                     balanceTXT.setText("");
                     amountTXT.setText("");
                     newRec = true;
                 }
             });

             saveBTN.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     //New record/ insertion
                     if (newRec){
                         if (ownerTXT.getText().length() !=0){
                             account = new Account(
                                     ownerTXT.getText(),
                                     (City) citiesCMB.getSelectedItem(),
                                     maleRDB.isSelected()? 'M' : 'F');
                             accountNumberTXT.setText(String.valueOf(account.accountNumber));
                             accountSet.add(account);
                             accountLSTMDL.addElement(account);
                             newRec = false;
                         }
                         else{
                             JOptionPane.showMessageDialog(null, "You must fill all fields");
                         }
                     }
                     //Updating
                     else{
                         accountSet.remove(account);

                         int a = Integer.parseInt(accountNumberTXT.getText());
                         String o = ownerTXT.getText();
                         City c = (City) citiesCMB.getSelectedItem();

                         char g = maleRDB.isSelected()? 'M' : 'F';
                         double b = Double.parseDouble(balanceTXT.getText());
                         //get data from selected index
                         account = new Account(a, o, c, g, b);
                         accountSet.add(account);
                         accountLSTMDL.setElementAt(account, accountsLST.getSelectedIndex());
                         newRec = false;
                     }
                 }

             });
             //show button

            showBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = "";
                    Iterator<Account> it = accountSet.iterator();
                    while(it.hasNext()){
                        s += it.next().toString() + "\n";
                        JOptionPane.showMessageDialog(null, s);
                    }
                }
            });
            //deposit button
            depositBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!newRec && amountTXT.getText().length() !=0){
                        //Adding transaction to table
                        Tranaction t = new Tranaction(account, LocalDate.now(),
                                'D', Double.parseDouble(amountTXT.getText()));

                        DisplayTransactionsInTable(t);
                        //Perform deposit from account
                        account.deposit(Double.parseDouble(amountTXT.getText()));
                        balanceTXT.setText(String.valueOf(account.balance));
                    }
                }
            });

















    }

    private void DisplayTransactionsInTable(Tranaction t) {
        //Displaing data into table
        tableModel.addRow(new Object[]{
                t.getTransactionNumber(),
                t.getDate(),
                t.getOperation(),
                t.getAmount()
        });
        //Adding object to arraylist
        transList.add(t);
    }


//    public static void main(String[] args){
//        project.AccountFrame af = new project.AccountFrame();
//        af.setVisible(true);
//        af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    }
}
