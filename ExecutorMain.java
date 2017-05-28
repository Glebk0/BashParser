import javax.swing.JList;
import java.awt.Component;

public class ExecutorMain {

    public static String[] guitarsList = new String[30];

    public static void main(String[] args){
        DataBaseConnecter dbc = new DataBaseConnecter();
        dbc.getValues();
        for (int i=0; i < dbc.brandCount; i++){
            for (int j=0; j < dbc.modelCount; j++) {
                for (int k = 0; k < dbc.availabilityCount; k++) {
                    if(dbc.model_id[k] == dbc.Mid[j]){
                        if (dbc.brand_id[j] == dbc.Bid[i]){
                            guitarsList[k] = (dbc.Mid[j] + ". " + dbc.brand[i] + " " + dbc.model[j] + " quantity is: " + dbc.quantity[k]);
                        }
                    }
                }
            }
        }
        VisualForm vf = new VisualForm("Guitars Availability In The Storage");
        vf.setVisible(true);
        vf.setDefaultCloseOperation(3);
        vf.setSize(300, 600);
        vf.setResizable(false);
        vf.setLocationRelativeTo((Component)null);
    }
}
