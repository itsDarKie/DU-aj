/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anglictina;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Jay
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label slovo,score,l1,l2,l3,l4,l5,l6;
    @FXML
    private ImageView i1,i2,i3,i4,i5,i6;
    @FXML
    private Button hadej;
    @FXML
    private Tooltip t0,t1,t2,t3,t4,t5;
    
    List<String> anglictina = new ArrayList<String>();
    List<String> cestina = new ArrayList<String>();
    
    int spravne = 0;
    int spatne = 0;
    int celkem =  0;
    
    boolean hadam = false;
    
    Random rand = new Random(); 
    int poradi = 0;
    
    public void vygenerujCislo(int puvodni)
    {
        poradi = rand.nextInt(5 - 0 + 1) + 0;
        if(poradi == puvodni)
            vygenerujCislo(puvodni);
    }
    
    @FXML
    public void hadej()
    {
        hadej.setVisible(true);
        vygenerujCislo(poradi);
        slovo.setText(anglictina.get(poradi));

        
        slovo.setVisible(true);
        score.setVisible(true);
        
        i1.setVisible(true);
        i2.setVisible(true);
        i3.setVisible(true);
        i4.setVisible(true);
        i5.setVisible(true);
        i6.setVisible(true);
        
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);
        l5.setVisible(true);
        l6.setVisible(true);
        
        hadam = true;
    }
    
    @FXML
    public void vyhodnot(MouseEvent event)
    {
        if(hadam)
        {
            String pomocny = event.getPickResult().getIntersectedNode().getId();
            String hadany = pomocny.substring(1);
            celkem++;
            if(slovo.getText().equals(anglictina.get(Integer.parseInt(hadany)-1)))
            {
                spravne++;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ano!");
                alert.setHeaderText("Obrázek je správný.");
                alert.setContentText(slovo.getText() +" je v překladu "+ cestina.get(Integer.parseInt(hadany)-1));
                alert.showAndWait();
            }
            else
            {
                spatne++;
                String spravneSlovo = "";
                for(int i =0;i<6;i++)
                {
                    if(slovo.getText().equals(anglictina.get(i)))
                        spravneSlovo = cestina.get(i);
                }
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ne!");
                alert.setHeaderText("Obrázek je chybný.");
                alert.setContentText(slovo.getText() +" je v překladu "+ spravneSlovo+", a ne "+cestina.get(Integer.parseInt(hadany)-1));
                alert.showAndWait();
            }
            score.setText("SKÓRE:    ANO: "+ spravne+"      NE: " + spatne + "      |    CELKEM POKUSŮ: " + celkem);

            hadej.setVisible(true);

            slovo.setVisible(false);

            i1.setVisible(true);
            i2.setVisible(true);
            i3.setVisible(true);
            i4.setVisible(true);
            i5.setVisible(true);
            i6.setVisible(true);

            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            l5.setVisible(true);
            l6.setVisible(true);
            
            hadam = false;
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        anglictina.add("tea");
        anglictina.add("box");
        anglictina.add("window");
        anglictina.add("table");
        anglictina.add("chips");
        anglictina.add("beer");
        
        cestina.add("čaj");
        cestina.add("krabice");
        cestina.add("okno");
        cestina.add("stůl");
        cestina.add("brambůrky");
        cestina.add("pivo");
        
        t0.setText(cestina.get(0));
        t1.setText(cestina.get(1));
        t2.setText(cestina.get(2));
        t3.setText(cestina.get(3));
        t4.setText(cestina.get(4));
        t5.setText(cestina.get(5));

    }    
    
}
