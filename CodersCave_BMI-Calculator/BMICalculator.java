package BMIcalculater;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class BMICalculater {

    public JFrame frame;
    public JPanel panel;
    public JLabel weightLabel, heightLabel, resultLabel, categoryLabel ,genderLabel;
    public JTextField weightField, heightField;
    public JButton calculateButton;
    private JComboBox<String> genderComboBox;
    public BMICalculater() {
        frame = new JFrame("Your Health Body Mass Index Calculator");
        panel = new JPanel();
        panel.setLayout(new GridLayout(12, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setBackground(Color.LIGHT_GRAY);
        
        weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();
        heightLabel = new JLabel("Height (feet):");
        heightField = new JTextField();
        genderLabel = new JLabel("Gender (M/F):");

        String[] genderOptions = {"Select","Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genderOptions);                         //amazing function
//        ageLable = new JLabel("Age (Years):");
//        ageField = new JTextField();
        calculateButton = new JButton("Calculate BMI");
        resultLabel = new JLabel("");
        categoryLabel = new JLabel("");
        resultLabel.setForeground(Color.red);
        categoryLabel.setForeground(Color.red);
        calculateButton.setForeground(new Color(54, 64, 63));
        calculateButton.setBackground(new Color(129, 115, 115));
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(genderLabel); 
        panel.add(genderComboBox);
        
//        panel.add(ageField);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(calculateButton);
        panel.add(resultLabel);
        panel.add(categoryLabel);

        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
}
    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText())/3.28084;
            String Gender = genderComboBox.getSelectedItem().toString();
            
            System.out.println(Gender);
            System.out.println(height);
            double bmi = weight / (height * height);
            DecimalFormat df = new DecimalFormat("#.##");
            String bmiString = df.format(bmi);

            resultLabel.setText("Your BMI Is: " + bmiString);

            String category;
            if(bmi < 15){
                category = "You are in 'Very severely underweight' Category";

            }else if(bmi >= 15 && bmi < 16){
            	category = "You are in 'Severely underweight' Category";

            }else if(bmi >= 16 && bmi < 18.5){
            	category = "You are in 'Underweight' Category";

            }else if(bmi >= 18.5 && bmi < 25){
            	category = "You are in 'Normal (healthy weight)' Category";

            }else if(bmi >= 25 && bmi < 30){
            	category = "You are in 'Overweight' Category";

            }else if(bmi >= 30 && bmi < 35){
            	category = "You are in 'Moderately obese' Category";

            }else if(bmi >= 35 && bmi < 40){
            	category = "You are in 'Severely obese' Category";

            }else 
            	category = "You are in 'Very severely obese' Category";
            
            categoryLabel.setText("Category: " + category);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter numbers.");
            categoryLabel.setText("");
        }
    }
      
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BMICalculater();
            }
        });
    }
}
