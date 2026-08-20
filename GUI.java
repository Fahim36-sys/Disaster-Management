import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
public class GUI implements ActionListener {
    JFrame frame;
    Font font15 = new Font("Arial", Font.PLAIN, 15);
    JButton addCitizenButton;
    JButton addDisasterButton;
    JButton addDisasterReportButton;

    public GUI(){
        frame = new JFrame("Disaster Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 700);
        frame.getContentPane().setBackground(new Color(81, 136, 150));
        frame.setResizable(false);
		frame.setLayout(null);
        JLabel titleLabel = createLabel("Disaster Management System", 300, 20, 400, 30);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        addCitizenButton = createButton("Add Citizen", 50, 50, 150, 30);
        addDisasterButton = createButton("Add Disaster", 50, 100, 150, 30);
        addDisasterReportButton = createButton("Add Disaster Report", 50, 150, 150, 30);
        addCitizenButton.addActionListener(this);
        addDisasterButton.addActionListener(this);
        addDisasterReportButton.addActionListener(this);
        
		frame.setVisible(true);
    }

	JLabel createLabel(String text,int x,int y,int w,int h){
		JLabel component = new JLabel(text);
		component.setBounds(x, y, w, h);
		component.setFont(font15);
		frame.add(component);
		return component;
	}
	JTextField createField(String text,int x,int y,int w,int h){
		JTextField component = new JTextField(text);
		component.setBounds(x, y, w, h);
		component.setFont(font15);
		frame.add(component);
		return component;
	}
	JButton createButton(String text, int x, int y, int w, int h){
		JButton component = new JButton(text);
		component.setBounds(x, y, w, h);
		component.setFont(font15);
		frame.add(component);
		return component;
	}
    JTextField createTextField(String text, int x, int y, int w, int h){
        JTextField field = new JTextField(text);
        field.setBounds(x, y, w, h);
        field.setFont(font15);
        frame.add(field);
        return field;
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==addCitizenButton) {
            openWindow("CitizenGUI");
        } else if (e.getSource()==addDisasterButton) {
            openWindow("DisasterGUI");
        } else if (e.getSource() == addDisasterReportButton) {
            openWindow("DisasterReportGUI");
        }
    }
    // Method to open the requested window.
    private void openWindow(String className) {
        try {
            Class<?> windowClass = Class.forName(className);
            windowClass.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException ex) {
            ex.printStackTrace();
        }
    }
}
