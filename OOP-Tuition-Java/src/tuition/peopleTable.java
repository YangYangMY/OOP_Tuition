package tuition;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class peopleTable {
    JFrame frame;
    JTable table;
    
    public peopleTable(People[] peopleArr)
    {
        // Frame initialization
        frame = new JFrame();
 
        // Frame Title
        frame.setTitle("List");
        /*
        String[][] data = new String[Student.getStuNum()][8];
        data[0][8] = new String((((Student[])peopleArr)[0].getStuID()), (peopleArr[0].getName()), ((peopleArr[0].getAge()).toString()),
                                ((peopleArr[0].getSex()).toString()), (peopleArr[0].getPhoneNum()), (peopleArr[0].getEmail()), (((Student[])peopleArr)[0].getDescription()),
                                ((((Student[])peopleArr)[0].getBalance()).toString()));
        // Data to be displayed in the JTable
        for (int i = 0; i < Student.getStuNum(); i++) {
            data[i][8] = new data((((Student[])peopleArr)[i].getStuID()), (peopleArr[i].getName()), ((peopleArr[i].getAge()).toString()),
                                ((peopleArr[i].getSex()).toString()), (peopleArr[i].getPhoneNum()), (peopleArr[i].getEmail()), (((Student[])peopleArr)[i].getDescription()),
                                ((((Student[])peopleArr)[i].getBalance()).toString()));
        }
        String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
        };
        
        // Column Names
        String[] columnNames = { "ID", "Name", "Age", "Sex", "Phone Number", "Email", "Description", "Balance"};
 
        // Initializing the JTable
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
 
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        // Frame Size
        frame.setSize(500, 200);
        // Frame Visible = true
        frame.setVisible(true);
*/
    }
}
