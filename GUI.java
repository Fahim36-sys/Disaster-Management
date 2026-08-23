import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
public class GUI implements ActionListener {
    JFrame frame;
    Image AiubLogo=new ImageIcon("AiubLogo.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    Font font15 = new Font("Arial", Font.PLAIN, 15);
    JLabel CitizenNameLabel,CitizenAgeLabel,CitizenAddressLabel,CitizenPhoneLabel,DisasterTypeLabel,DisasterLocationLabel,DisasterDateLabel,DisasterReportIdLabel,DisasterReportDateTimeLabel,DisasterReportDescriptionLabel,TextAreaLabel,TextAreaLabel2,AiublogoLabel;
    JButton addCitizenButton,addDisasterButton,disasterReportButton,teamInfoButton,damageAssesmentButton;
    JButton createTeamButton,deleteTeamButton,assignResponderButton,removeResponderButton,updateReportButton;
    JLabel[] inputLabels;
    JTextField[] inputFields;
    JTextArea reportArea,teamInfoArea;
    List<ResponseTeam> teams = new ArrayList<>();
    ResponseTeam selectedTeam;
    Citizen currentCitizen;
    Disaster currentDisaster;
    DisasterReport currentDisasterReport;
    DamageAssesment currentDamageAssesment=new DamageAssesment(0,0);
    String activeMenu="";
    public GUI(){
        frame = new JFrame("Disaster Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //rgb(9, 121, 4)
        frame.setSize(1600, 700);
        frame.getContentPane().setBackground(new Color(81, 136, 150));
        frame.setResizable(false);
		frame.setLayout(null);
        JLabel titleLabel=createLabel("Disaster Management System",300,6,400,30);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("Arial",Font.BOLD,24));
        AiublogoLabel=createLabel("", 48, 300, 400, 400);
        AiublogoLabel.setIcon(new ImageIcon(AiubLogo));
        AiublogoLabel.setBackground(null);
        addCitizenButton=createButton("Add Citizen", 50, 50, 150, 30);
        addDisasterButton=createButton("Add Disaster", 50, 100, 150, 30);
        disasterReportButton=createButton("Disaster Report", 50, 150, 150, 30);
        teamInfoButton=createButton("Team Info", 50, 200, 150, 30);
        damageAssesmentButton=createButton("Damage\n Assessment", 50, 250, 150,50);
        damageAssesmentButton.setFont(new Font("Arial",Font.PLAIN,14));
        createTeamButton=createButton("Create Team", 230, 320, 150, 40);
        createTeamButton.setBackground(new Color(15, 192, 142));
        deleteTeamButton=createButton("Delete Team", 410, 320, 150, 40);
        deleteTeamButton.setBackground(new Color(190, 99, 66));
        assignResponderButton=createButton("Assign Responder", 410, 380, 170, 30);
        removeResponderButton=createButton("Remove Responder", 230, 380, 170, 30);
        removeResponderButton.setForeground(Color.RED);
        assignResponderButton.setForeground(Color.BLUE);
        updateReportButton=createButton("Update Report", 250, 580, 270, 40);
        updateReportButton.setBackground(new Color(15, 192, 142));
        updateReportButton.setForeground(Color.WHITE);
        CitizenNameLabel=createLabel("Citizen Name:", 250, 50, 150, 30);
        CitizenAgeLabel=createLabel("Citizen Age:", 250, 100, 150, 30);
        CitizenAddressLabel=createLabel("Citizen Address:", 250, 150, 150, 30);
        CitizenPhoneLabel=createLabel("Citizen Phone:", 250, 200, 150, 30);
        DisasterTypeLabel=createLabel("Citizen Report Type:", 250, 250, 150, 30);
        CitizenNameLabel.setForeground(Color.WHITE);
        CitizenNameLabel.setFont(new Font("Arial",Font.BOLD,15));
        CitizenAgeLabel.setForeground(Color.WHITE);
        CitizenAgeLabel.setFont(new Font("Arial",Font.BOLD,15));
        CitizenAddressLabel.setForeground(Color.WHITE);
        CitizenAddressLabel.setFont(new Font("Arial",Font.BOLD,15));
        CitizenPhoneLabel.setForeground(Color.WHITE);
        CitizenPhoneLabel.setFont(new Font("Arial",Font.BOLD,15));
        DisasterTypeLabel.setForeground(Color.WHITE);
        DisasterTypeLabel.setFont(new Font("Arial", Font.BOLD,15));
        TextAreaLabel=createLabel("Disaster Report Details:",650,20,250,30);
        TextAreaLabel.setForeground(Color.blue);
        TextAreaLabel.setFont(new Font("Arial",Font.BOLD,15));
        inputFields=new JTextField[]{
            createField("",410,50,200,30),
            createField("",410,100,200,30),
            createField("",410,150,200,30),
            createField("",410,200,200,30),
            createField("",410,250,200,30)
        };
        inputLabels=new JLabel[]{CitizenNameLabel,CitizenAgeLabel,CitizenAddressLabel,CitizenPhoneLabel, DisasterTypeLabel};
        reportArea=createTextArea(650, 50, 450, 580);
        reportArea.setText("Welcome!\nClick a menu to continue.");
        teamInfoArea=createTextArea(1120, 50, 450, 580);
        TextAreaLabel2=createLabel("Team Info:", 1130, 20, 200, 30);
        TextAreaLabel2.setForeground(Color.BLUE);
        TextAreaLabel2.setFont(new Font("Arial",Font.BOLD,15));
        addCitizenButton.addActionListener(this);
        addDisasterButton.addActionListener(this);
        disasterReportButton.addActionListener(this);
        teamInfoButton.addActionListener(this);
        damageAssesmentButton.addActionListener(this);
        createTeamButton.addActionListener(this);
        deleteTeamButton.addActionListener(this);
        assignResponderButton.addActionListener(this);
        removeResponderButton.addActionListener(this);
        updateReportButton.addActionListener(this);
        setInputPanelVisible(false);
        setTeamControlsVisible(false);
		frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addDisasterButton){showDisasterInputs();}
        else if(e.getSource()==addCitizenButton){showCitizenInputs();}
        else if(e.getSource()==disasterReportButton){showDisasterReportInputs();}
        else if(e.getSource()==teamInfoButton){showTeamInputs();}
        else if(e.getSource()==damageAssesmentButton){showDamageAssessmentInputs();}
        else if(e.getSource()==createTeamButton){createTeam();}
        else if(e.getSource()==deleteTeamButton){deleteTeam();}
        else if(e.getSource()==assignResponderButton){assignResponder();}
        else if(e.getSource()==removeResponderButton){removeResponder();}
        else if(e.getSource()==updateReportButton){updateReport();}
    }
    void updateReport(){
        if(activeMenu.equals("citizen")){updateCitizenReport();}
        else if(activeMenu.equals("disaster")){updateDisasterReport();}
        else if(activeMenu.equals("report")){generateReport();}
        else if(activeMenu.equals("team")){updateTeamInfoArea();}
        else if(activeMenu.equals("damage")){updateDamageAssessment();}
        else{showMessage("Select a menu before updating the report.");}
    }
    void updateCitizenReport(){
        String citizenId=inputFields[0].getText().trim();
        String name=inputFields[1].getText().trim();
        String phone=inputFields[3].getText().trim();
        String reportType=inputFields[4].getText().trim();
        if(citizenId.isEmpty()||name.isEmpty()||phone.isEmpty()||reportType.isEmpty()){
            showMessage("Complete the citizen fields before updating the report.");
            return;
        }
        currentCitizen=new Citizen(citizenId,reportType,name,phone);
        if(currentDisasterReport!=null){
            currentDisasterReport.setcitizen(currentCitizen);
        }
        updateReportArea();
    }
    void updateDisasterReport(){
        String disasterId=inputFields[0].getText().trim();
        String type=inputFields[1].getText().trim();
        String severity=inputFields[2].getText().trim();
        if(disasterId.isEmpty()||type.isEmpty()||severity.isEmpty()){
            showMessage("Complete the disaster fields before updating the report.");
            return;
        }
        ResponseTeam team=findTeam(inputFields[3].getText().trim());
        currentDisaster=new Disaster(disasterId,type,severity,team==null?selectedTeam:team);
        if(currentDisasterReport!=null){
            currentDisasterReport.setdisaster(currentDisaster);
        }
        updateReportArea();
    }
    void generateReport(){
        String reportId=inputFields[0].getText().trim();
        String reportDate=inputFields[1].getText().trim();
        String description=inputFields[2].getText().trim();
        String disasterId=inputFields[3].getText().trim();
        if(reportId.isEmpty()||reportDate.isEmpty()||description.isEmpty()
                ||disasterId.isEmpty()){
            showMessage("Complete all disaster report fields before generating the report.");
            return;
        }
        if(currentCitizen==null){
            showMessage("Add and update the citizen information before updating the disaster report.");
            return;
        }
        if(currentDisaster==null){
            currentDisaster=new Disaster(disasterId,"Not specified","Not specified",selectedTeam);
        }
        currentDisasterReport=new DisasterReport(reportId,reportDate,description,currentCitizen,currentDisaster);
        updateReportArea();
    }
    void updateDamageAssessment(){
        double estimatedDamageCost;
        int affectedPeople;
        try{
            estimatedDamageCost=Double.parseDouble(inputFields[0].getText().trim());
            affectedPeople=Integer.parseInt(inputFields[1].getText().trim());
        }
        catch(NumberFormatException ex){
            showMessage("Enter a valid damage cost and number of affected people.");
            return;
        }
        if(estimatedDamageCost<0||affectedPeople<0){
            showMessage("Damage cost and affected people cannot be negative.");
            return;
        }
        currentDamageAssesment=new DamageAssesment(estimatedDamageCost,affectedPeople);
        updateReportArea();
    }
    void updateReportArea(){
        StringBuilder reportText=new StringBuilder();
        if(currentDisasterReport!=null){
            reportText.append(currentDisasterReport.getDisplayText());
        }
        else{
            reportText.append("DISASTER REPORT\n  Not updated");
            if(currentCitizen!=null){
                reportText.append("\n\n").append(currentCitizen.getDisplayText());
            }
            if(currentDisaster!=null){
                reportText.append("\n\n").append(currentDisaster.getDisplayText());
            }
        }
        reportText.append("\n\n").append(currentDamageAssesment.getDisplayText());
        reportArea.setText(reportText.toString());
    }
    void showDisasterInputs(){
        activeMenu="disaster";
        setInputPanelVisible(true);
        String[] labels={"Disaster ID:", "Disaster Type:", "Severity:","Response Team:"};
        setTeamControlsVisible(false);
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
        activeMenu="citizen";
        setInputPanelVisible(true);
        String[] labels={"Citizen ID:","Citizen Name:","Citizen Age:","Citizen Phone:","Citizen Report Type:"};
        setTeamControlsVisible(false);
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
    void showDisasterReportInputs(){
        activeMenu="report";
        setInputPanelVisible(true);
        String[] labels={"Report ID:","Report Date and Time: ","Description:"};
        setTeamControlsVisible(false);
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
    void showDamageAssessmentInputs(){
        activeMenu="damage";
        setInputPanelVisible(true);
        setTeamControlsVisible(false);
        String[] labels={"Estimated Damage Cost:","Affected People:"};
        for(int i=0;i<inputLabels.length;i++){
            boolean visible=i<labels.length;
            inputLabels[i].setVisible(visible);
            inputFields[i].setVisible(visible);
            if(visible){
                inputLabels[i].setText(labels[i]);
                inputFields[i].setText("");
            }
        }
        updateReportArea();
        refreshInputPanel();
    }
    void showTeamInputs(){
        activeMenu="team";
        setInputPanelVisible(true);
        String[] labels={"Team ID:","Team Name:","Team Members:","Responder ID:","Responder Name:"};
        for(int i=0;i<inputLabels.length;i++){
            inputLabels[i].setVisible(true);
            inputFields[i].setVisible(true);
            inputLabels[i].setText(labels[i]);
            inputFields[i].setText("");
        }
        setTeamControlsVisible(true);
        updateTeamInfoArea();
        refreshInputPanel();
    }
    void createTeam(){
        String teamId=inputFields[0].getText().trim();
        String teamName=inputFields[1].getText().trim();
        int memberCount;
        try{memberCount=Integer.parseInt(inputFields[2].getText().trim());}
        catch(NumberFormatException ex){
            showMessage("Team Members must be a number.");
            return;
        }
        if(teamId.isEmpty()||teamName.isEmpty()||memberCount<1){
            showMessage("Enter a team ID, team name, and a positive member count.");
            return;
        }
        if(findTeam(teamId)!=null){
            showMessage("That team ID already exists.");
            return;
        }
        selectedTeam=new ResponseTeam(teamId,teamName,String.valueOf(memberCount),new Responder[memberCount],new TeamLeader());
        teams.add(selectedTeam);
        updateTeamInfoArea();
    }
    void deleteTeam(){
        ResponseTeam team=findTeam(inputFields[0].getText().trim());
        if(team==null){
            showMessage("Enter an existing team ID.");
            return;
        }
        teams.remove(team);
        selectedTeam=teams.isEmpty()?null:teams.get(0);
        updateTeamInfoArea();
    }
    void assignResponder(){
        ResponseTeam team=findTeam(inputFields[0].getText().trim());
        String responderId=inputFields[3].getText().trim();
        String responderName=inputFields[4].getText().trim();
        if(team==null||responderId.isEmpty()||responderName.isEmpty()){
            showMessage("Enter an existing team ID, responder ID, and responder name.");
            return;
        }
        selectedTeam=team;
        team.assignResponder(new Responder(responderId,"General","Available",responderName,""));
        updateTeamInfoArea();
    }
    void removeResponder(){
        ResponseTeam team=findTeam(inputFields[0].getText().trim());
        String responderId=inputFields[3].getText().trim();
        if(team==null||responderId.isEmpty()){
            showMessage("Enter an existing team ID and responder ID.");
            return;
        }
        selectedTeam=team;
        team.removeResponder(responderId);
        updateTeamInfoArea();
    }
    ResponseTeam findTeam(String teamId){
        for(ResponseTeam team:teams){
            if(team.getteamid().equals(teamId)){
                return team;
            }
        }
        return null;
    }
    void updateTeamInfoArea(){
        teamInfoArea.setText("");
        if(teams.isEmpty()){
            teamInfoArea.append("No teams created.\n");
            return;
        }
        for(ResponseTeam team:teams){
            teamInfoArea.append("Team ID: "+team.getteamid()+"\n");
            teamInfoArea.append("Team Name: "+team.getteamname()+"\n");
            teamInfoArea.append("Members: "+team.getnumberOfTeamMembers()+"\n");
            teamInfoArea.append("Responders:\n");
            for(Responder responder:team.getResponders()){
                if(responder!=null){
                    teamInfoArea.append("  "+responder.getresponderid()+" - "+responder.getname()+"\n");
                }
            }
            teamInfoArea.append("\n");
        }
    }
    void setTeamControlsVisible(boolean visible){
        createTeamButton.setVisible(visible);
        deleteTeamButton.setVisible(visible);
        assignResponderButton.setVisible(visible);
        removeResponderButton.setVisible(visible);
    }
    void setInputPanelVisible(boolean visible){
        for(int i=0;i<inputLabels.length;i++){
            inputLabels[i].setVisible(visible);
            inputFields[i].setVisible(visible);
        }
        updateReportButton.setVisible(visible);
    }
    void showMessage(String message){
        JOptionPane.showMessageDialog(frame,message);
    }
    void refreshInputPanel(){
        frame.revalidate();
        frame.repaint();
    }
    int x=10,y=0,w=150,h=30,vGap=h+10;
	JLabel createLabel(String text,int x,int y,int w,int h){   //rgb(9, 124, 212)
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
        JTextArea component=new JTextArea();
        component.setFont(new Font("Arial", Font.PLAIN,18));
        component.setLineWrap(true);
        component.setWrapStyleWord(true);
        JScrollPane scrollPane=new JScrollPane(component);
        scrollPane.setBounds(x,y,w,h);
        frame.add(scrollPane);
        component.setEditable(false);
        component.setBackground(Color.white);
        component.setForeground(new Color(9,124,212));
        return component;
    }
}
