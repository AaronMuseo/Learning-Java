package Calculator;

/**
 *
 * @author aaron
 */

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CalcGUI extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label mainlbl = new Label();
        mainlbl.setText("Calculator");
        
        Label instructlbl = new Label();
        instructlbl.setText("Enter 2 numbers and an operator");
        
        TextField txt = new TextField();
        
        Button compute = new Button();
        compute.setText("Calculate");
        
        compute.setOnAction(e ->{
            String input = txt.getText().trim();//this is to get the text from the input and stor it in String input
            Calc calc = new Calc();
            double result = 0;
            String message = "";
            
            try{
                if(input.contains("+")){
                    
                    String[] parts = input.split("\\+");
                    // parse float converts string to float
                    //parts[n] accesses the nth part of the string after the split
                    //trim removes any white or extra spaces from the beginning
                    float num1 = Float.parseFloat(parts[0].trim());
                    float num2 = Float.parseFloat(parts[1].trim());
                    result = calc.addition(num1,num2);
                    
                }else if(input.contains("-")){
                    
                    String [] parts = input.split("\\-");
                    float num1 = Float.parseFloat(parts[0].trim());
                    float num2 = Float.parseFloat(parts[1].trim());
                    result = calc.subtraction(num1, num2);
                    
                }else if(input.contains("*")){
                    
                    String [] parts = input.split("\\*");
                    float num1 = Float.parseFloat(parts[0].trim());
                    float num2 = Float.parseFloat(parts[1].trim());
                    result = calc.subtraction(num1, num2);
                    
                }else if(input.contains("/")){
                    
                    String[] parts = input.split("\\/");
                    float num1 = Float.parseFloat(parts[0].trim());
                    float num2 = Float.parseFloat(parts[1].trim());
                    result = calc.division(num1, num2);
                    
                }else{
                    message = "Invalid Operator usage!! Use +,-,*, or /.";
                }
                if(message.isEmpty()){
                    message = "Result: " + result;
                }
                
            }catch(Exception ex){
                
                message = "Error: " + ex.getMessage();
            }
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Result");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
            
        });
        
        VBox root = new VBox();
        root.getChildren().addAll(mainlbl, instructlbl, txt, compute);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        
        launch(args);
        
    }
    
    
}
