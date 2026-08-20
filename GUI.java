import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI implements ActionListener {
    JFrame frame;
    Font font15 = new Font("Arial", Font.PLAIN, 15);
    JLabel CitizenNameLabel, CitizenAgeLabel, CitizenAddressLabel, CitizenPhoneLabel, DisasterTypeLabel, DisasterLocationLabel, DisasterDateLabel, DisasterReportIdLabel, DisasterReportDateTimeLabel, DisasterReportDescriptionLabel,TextAreaLabel,TextAreaLabel2;
    JButton addCitizenButton, addDisasterButton, disasterReportButton, teamInfoButton;
    JLabel[] inputLabels;
    JTextField[] inputFields;
    public GUI(){
        frame = new JFrame("Disaster Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //click this box rgb(0,0,0)
        frame.setSize(1700, 700);
        frame.getContentPane().setBackground(new Color(81, 136, 150));
        frame.setResizable(false);
		frame.setLayout(null);
        JLabel titleLabel=createLabel("Disaster Management System",300,6,400,30);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("Arial",Font.BOLD,24));
        addCitizenButton=createButton("Add Citizen", 50, 50, 150, 30);
        addDisasterButton=createButton("Add Disaster", 50, 100, 150, 30);
        disasterReportButton=createButton("Disaster Report", 50, 150, 150, 30);
        teamInfoButton=createButton("Team Info", 50, 200, 150, 30);
        CitizenNameLabel=createLabel("Citizen Name:", 250, 50, 150, 30);
        CitizenAgeLabel=createLabel("Citizen Age:", 250, 100, 150, 30);
        CitizenAddressLabel=createLabel("Citizen Address:", 250, 150, 150, 30);
        CitizenPhoneLabel=createLabel("Citizen Phone:", 250, 200, 150, 30);
        DisasterTypeLabel=createLabel("Citizen Report Type:", 250, 250, 150, 30);
        CitizenNameLabel.setForeground(Color.WHITE);
        CitizenNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        CitizenAgeLabel.setForeground(Color.WHITE);
        CitizenAgeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        CitizenAddressLabel.setForeground(Color.WHITE);
        CitizenAddressLabel.setFont(new Font("Arial", Font.BOLD, 15));
        CitizenPhoneLabel.setForeground(Color.WHITE);
        CitizenPhoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        DisasterTypeLabel.setForeground(Color.WHITE);
        DisasterTypeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        TextAreaLabel=createLabel("Disaster Report Details:", 700, 20, 200, 30);
        TextAreaLabel.setForeground(Color.blue);
        TextAreaLabel.setFont(new Font("Arial",Font.BOLD,15));
        inputFields=new JTextField[]{
            createField("", 410, 50, 200, 30),
            createField("", 410, 100, 200, 30),
            createField("", 410, 150, 200, 30),
            createField("", 410, 200, 200, 30),
            createField("", 410, 250, 200, 30)
        };
        inputLabels=new JLabel[]{CitizenNameLabel, CitizenAgeLabel, CitizenAddressLabel, CitizenPhoneLabel, DisasterTypeLabel};
        createTextArea(700, 50, 450, 550);
        createTextArea(1170, 50, 450, 550);
        TextAreaLabel2=createLabel("Team Info:", 1180, 20, 200, 30);
        TextAreaLabel2.setForeground(Color.BLUE);
        TextAreaLabel2.setFont(new Font("Arial",Font.BOLD,15));
        addCitizenButton.addActionListener(this);
        addDisasterButton.addActionListener(this);
        disasterReportButton.addActionListener(this);
        teamInfoButton.addActionListener(this);
		frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addDisasterButton){
            showDisasterInputs();
        } else if(e.getSource()==addCitizenButton){
            showCitizenInputs();
        } else if(e.getSource()==disasterReportButton){
            showDisasterReportInputs();
        } else if(e.getSource()==teamInfoButton){
            showTeamInputs();
        }
    }
    void showDisasterInputs(){
        String[] labels={"Disaster ID:", "Disaster Type:", "Severity:"};
        for(int i=0;i<inputLabels.length;i++){
            boolean visible=i<labels.length;
            inputLabels[i].setVisible(visible);
            inputFields[i].setVisible(visible);
            if(visible){
                inputLabels[i].setText(labels[i]);
                inputFields[i].setText("");
            }
        }
        refreshInputPanel();
    }
    void showCitizenInputs(){
        String[] labels={"Citizen Name:", "Citizen Age:", "Citizen Address:", "Citizen Phone:", "Citizen Report Type:"};
        for(int i=0;i<inputLabels.length;i++){
            inputLabels[i].setVisible(true);
            inputFields[i].setVisible(true);
            inputLabels[i].setText(labels[i]);
            inputFields[i].setText("");
        }
        refreshInputPanel();
    }
    void showDisasterReportInputs(){
        String[] labels={"Report ID:", "Report Date and Time:", "Description:", "Citizen ID:", "Disaster ID:"};
        for(int i=0;i<inputLabels.length;i++){
            inputLabels[i].setVisible(true);
            inputFields[i].setVisible(true);
            inputLabels[i].setText(labels[i]);
            inputFields[i].setText("");
        }
        refreshInputPanel();
    }
    void showTeamInputs(){
        String[] labels={"Team ID:", "Team Name:", "Team Members:"};
        for(int i=0;i<inputLabels.length;i++){
            boolean visible=i<labels.length;
            inputLabels[i].setVisible(visible);
            inputFields[i].setVisible(visible);
            if(visible){
                inputLabels[i].setText(labels[i]);
                inputFields[i].setText("");
            }
        }
        refreshInputPanel();
    }
    void refreshInputPanel(){
        frame.revalidate();
        frame.repaint();
    }
    int x=10,y=0,w=150,h=30,vGap=h+10;
	JLabel createLabel(String text,int x,int y,int w,int h){   //click this box rgb(9, 124, 212)
		JLabel component = new JLabel(text);
		component.setBounds(x,y,w,h);
		component.setFont(font15);
		frame.add(component);
		return component;
	}
    JButton createButton(String text,int x,int y,int w,int h){
        JButton component = new JButton(text);
        component.setBounds(x,y,w,h);
        component.setFont(font15);
        frame.add(component);
        return component;
    }
	JTextField createField(String text,int x,int y,int w,int h){
		JTextField component = new JTextField(text);
		component.setBounds(x,y,w,h);
		component.setFont(font15);
		frame.add(component);
		return component;
	}
    JTextArea createTextArea(int x,int y,int w,int h){
        JTextArea component = new JTextArea();
        component.setFont(font15);
        component.setLineWrap(true);
        component.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setBounds(x, y, w, h);
        frame.add(scrollPane);
        component.setEditable(true);
        component.setBackground(Color.white);
        component.setForeground(new Color(9,124,212));
        return component;
    }
}
