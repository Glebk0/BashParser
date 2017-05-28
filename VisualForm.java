import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class VisualForm extends JFrame{

    JButton findGuitars;
    JList guitarsList;
    VisualForm.VisualFormActionListener action = new VisualForm.VisualFormActionListener();


    public VisualForm(String s){
        super(s);
        this.setLayout(new FlowLayout());
        this.findGuitars = new JButton("Вывести список гитар");
        this.guitarsList = new JList();
        this.add(this.findGuitars);
        this.add(this.guitarsList);
        this.findGuitars.addActionListener(this.action);
        guitarsList.setLayoutOrientation(JList.VERTICAL);
    }

    public class VisualFormActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                if(e.getSource() == VisualForm.this.findGuitars) {
                        guitarsList.setListData(ExecutorMain.guitarsList);
                }
            } catch (Exception e1) {
            }

        }
    }
}
