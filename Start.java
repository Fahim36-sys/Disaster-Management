import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import DisasterReport.*;
import ResponseTeam.*;

public class Start{
    public static void main(String[] args){GUI gui=new GUI();}
    public static void saveDisasterReport(DisasterReport report,DamageAssesment damageAssesment){
        try{
            FileWriter file=new FileWriter("Info/DisasterReport.txt");
            file.write(report.getDisplayText());
            file.write("\n\n"+damageAssesment.getDisplayText());
            file.close();
        }
        catch(IOException ex){
            System.out.println("Could not save the disaster report.");
        }
    }

    public static void saveTeamInfo(List<ResponseTeam> teams){
        try{
            FileWriter file=new FileWriter("Info/TeamInfo.txt");
            for(ResponseTeam team:teams){
                file.write("Team ID: "+team.getteamid()+"\n");
                file.write("Team Name: "+team.getteamname()+"\n");
                file.write("Members: "+team.getnumberOfTeamMembers()+"\n");
                file.write("Responders:\n");
                for(Responder responder:team.getResponders()){
                    if(responder!=null){
                        file.write("  "+responder.getresponderid()+" - "+responder.getname()+"\n");
                    }
                }
                file.write("\n");
            }
            file.close();
        }
        catch(IOException ex){
            System.out.println("Could not save the team information.");
        }
    }

    public static ArrayList<ResponseTeam> loadTeamInfo(){
        ArrayList<ResponseTeam> teams=new ArrayList<>();
        try{
            Scanner file=new Scanner(new File("Info/TeamInfo.txt"));
            String teamId="";
            String teamName="";
            int memberCount=0;
            ArrayList<Responder> responders=new ArrayList<>();
            while(file.hasNextLine()){
                String line=file.nextLine();
                if(line.startsWith("Team ID: ")){
                    if(!teamId.isEmpty()){addLoadedTeam(teams,teamId,teamName,memberCount,responders);}
                    teamId=line.substring(9);
                    teamName="";
                    memberCount=0;
                    responders=new ArrayList<>();
                }
                else if(line.startsWith("Team Name: ")){teamName=line.substring(11);}
                else if(line.startsWith("Members: ")){
                    try{memberCount=Integer.parseInt(line.substring(9));}
                    catch(NumberFormatException ex){memberCount=0;}
                }
                else if(line.startsWith("  ")&&line.contains(" - ")){
                    String[] responderInfo=line.trim().split(" - ",2);
                    responders.add(new Responder(responderInfo[0],"General","Available",responderInfo[1],""));
                }
            }
            if(!teamId.isEmpty()){addLoadedTeam(teams,teamId,teamName,memberCount,responders);}
            file.close();
        }
        catch(IOException ex){
        }
        return teams;
    }

    static void addLoadedTeam(ArrayList<ResponseTeam> teams,String teamId,String teamName,int memberCount,ArrayList<Responder> responders){
        if(memberCount<responders.size()){memberCount=responders.size();}
        ResponseTeam team=new ResponseTeam(teamId,teamName,String.valueOf(memberCount),new Responder[memberCount],new TeamLeader());
        for(int i=0;i<responders.size();i++){team.getResponders()[i]=responders.get(i);}
        teams.add(team);
    }

    public static DisasterReport loadDisasterReport(List<ResponseTeam> teams){
        String reportId="";
        String reportDate="";
        String description="";
        String citizenId="";
        String citizenName="";
        String citizenPhone="";
        String reportType="";
        String disasterId="";
        String disasterType="";
        String severity="";
        String teamName="";
        try{
            Scanner file=new Scanner(new File("Info/DisasterReport.txt"));
            while(file.hasNextLine()){
                String line=file.nextLine();
                if(line.startsWith("Report ID: ")){reportId=line.substring(11);}
                else if(line.startsWith("Date and Time: ")){reportDate=line.substring(15);}
                else if(line.startsWith("Description: ")){description=line.substring(13);}
                else if(line.startsWith("  Citizen ID: ")){citizenId=line.substring(14);}
                else if(line.startsWith("  Name: ")){citizenName=line.substring(8);}
                else if(line.startsWith("  Phone: ")){citizenPhone=line.substring(9);}
                else if(line.startsWith("  Report Type: ")){reportType=line.substring(15);}
                else if(line.startsWith("  Disaster ID: ")){disasterId=line.substring(15);}
                else if(line.startsWith("  Type: ")){disasterType=line.substring(8);}
                else if(line.startsWith("  Severity: ")){severity=line.substring(12);}
                else if(line.startsWith("  Response Team: ")){teamName=line.substring(17);}
            }
            file.close();
        }
        catch(IOException ex){
        }
        if(reportId.isEmpty()){return null;}
        Citizen citizen=new Citizen(citizenId,reportType,citizenName,citizenPhone);
        ResponseTeam team=findTeamByName(teams,teamName);
        Disaster disaster=new Disaster(disasterId,disasterType,severity,team);
        return new DisasterReport(reportId,reportDate,description,citizen,disaster);
    }

    public static DamageAssesment loadDamageAssesment(){
        double estimatedDamageCost=0;
        int affectedPeople=0;
        try{
            Scanner file=new Scanner(new File("Info/DisasterReport.txt"));
            while(file.hasNextLine()){
                String line=file.nextLine();
                if(line.startsWith("  Estimated Damage Cost: ")){
                    try{estimatedDamageCost=Double.parseDouble(line.substring("  Estimated Damage Cost: ".length()));}
                    catch(NumberFormatException ex){estimatedDamageCost=0;}
                }
                else if(line.startsWith("  Affected People: ")){
                    try{affectedPeople=Integer.parseInt(line.substring("  Affected People: ".length()));}
                    catch(NumberFormatException ex){affectedPeople=0;}
                }
            }
            file.close();
        }
        catch(IOException ex){
        }
        return new DamageAssesment(estimatedDamageCost,affectedPeople);
    }

    static ResponseTeam findTeamByName(List<ResponseTeam> teams,String teamName){
        for(ResponseTeam team:teams){
            if(team.getteamname().equals(teamName)){return team;}
        }
        return null;
    }
}