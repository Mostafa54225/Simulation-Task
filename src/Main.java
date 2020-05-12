import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static JPanel contentPanel;
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Manager");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel, choicesPanel;

        // Main Panel for the page
        mainPanel = new JPanel(new GridLayout(2, 1));

        JLabel arriveLabel = new JLabel("µ");
        JTextField arriveField = new JTextField( 12);
        JLabel servedLabel = new JLabel("λ");
        JTextField servedField = new JTextField(12);
        // Choices Panel for the buttons
        choicesPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 45,50));
        JPanel areaPanel = new JPanel(new FlowLayout());

        JButton avgNumber = new JButton("Average Number[L]");
        JButton avgTime = new JButton("Average Time[W]");
        JButton avgNumberQueue = new JButton("Average Number(Queue[Lq])");
        JButton avgTimeQueue = new JButton("Average Time(Queue)[Wq]");
        JButton utilizationFactor = new JButton("utilization factor[ρ]");
        JButton percentIdleTime = new JButton("percent idle time[P0]");
        JButton probability = new JButton("probability");
        JTextArea area = new JTextArea(20,20);
        area.setEditable(false);
        // Content Panel



        // Action Button (List)
        avgNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Processing process = new Processing();
                if(verify(servedField, arriveField)){
                    double a = Double.parseDouble(servedField.getText());
                    double b = Double.parseDouble(arriveField.getText());
                    double result = process.avgNumberSystem(a, b);
                    result = Math.round(result*100.0)/100.0;
                    area.setText(String.valueOf(result));
                }else {
                    JOptionPane.showMessageDialog(null, "Fill All Inputs please!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        avgTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Processing process = new Processing();
                if(verify(servedField, arriveField)){
                    double a = Double.parseDouble(servedField.getText());
                    double b = Double.parseDouble(arriveField.getText());
                    double result = process.avgTimeSystem(a, b);
                    result = Math.round(result*100.0)/100.0;
                    area.setText(String.valueOf(result));
                }else {
                    JOptionPane.showMessageDialog(null, "Fill All Inputs please!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        avgNumberQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Processing process = new Processing();
                if(verify(servedField, arriveField)){
                    double a = Double.parseDouble(servedField.getText());
                    double b = Double.parseDouble(arriveField.getText());
                    double result = process.avgNumberQueue(a, b);
                    result = Math.round(result*100.0)/100.0;
                    area.setText(String.valueOf(result));
                }else {
                    JOptionPane.showMessageDialog(null, "Fill All Inputs please!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        avgTimeQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Processing process = new Processing();
                if(verify(servedField, arriveField)){
                    double a = Double.parseDouble(servedField.getText());
                    double b = Double.parseDouble(arriveField.getText());
                    double result = process.avgTimeQueue(a, b);
                    result = Math.round(result*100.0)/100.0;
                    area.setText(String.valueOf(result));
                }else {
                    JOptionPane.showMessageDialog(null, "Fill All Inputs please!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        utilizationFactor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Processing process = new Processing();
                if(verify(servedField, arriveField)){
                    double a = Double.parseDouble(servedField.getText());
                    double b = Double.parseDouble(arriveField.getText());
                    double result = process.utilizationFactor(a, b);
                    result = Math.round(result*100.0)/100.0;
                    area.setText(String.valueOf(result));
                }else {
                    JOptionPane.showMessageDialog(null, "Fill All Inputs please!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        percentIdleTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Processing process = new Processing();
                if(verify(servedField, arriveField)){
                    double a = Double.parseDouble(servedField.getText());
                    double b = Double.parseDouble(arriveField.getText());
                    double result = process.percentIdleTime(a, b);
                    result = Math.round(result*100.0)/100.0;
                    area.setText(String.valueOf(result));
                }else {
                    JOptionPane.showMessageDialog(null, "Fill All Inputs please!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        probability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                area.setText("");
                Processing process = new Processing();
                if(verify(servedField, arriveField)){
                    double a = Double.parseDouble(servedField.getText());
                    double b = Double.parseDouble(arriveField.getText());
                    double result[] = process.probability(7,a, b);
                    for(int i = 0; i <= 7; i++){
                        double number = Math.round(result[i]*1000.0)/1000.0;
                        area.append("K = " + i + " ==> " + String.valueOf(number) + "\n");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Fill All Inputs please!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        // Add Components to the panel
        choicesPanel.add(arriveLabel);
        choicesPanel.add(arriveField);
        choicesPanel.add(servedLabel);
        choicesPanel.add(servedField);
        choicesPanel.add(avgNumber);
        choicesPanel.add(avgTime);
        choicesPanel.add(avgNumberQueue);
        choicesPanel.add(avgTimeQueue);
        choicesPanel.add(utilizationFactor);
        choicesPanel.add(percentIdleTime);
        choicesPanel.add(probability);

        areaPanel.add(area);


        mainPanel.add(choicesPanel);
        mainPanel.add(areaPanel);
        frame.add(mainPanel);
        frame.setSize(640,650);
        frame.setVisible(true);
    }
    public static boolean verify(JTextField t1, JTextField t2){
        return !t1.getText().equals("") && !t2.getText().equals("");
    }
}