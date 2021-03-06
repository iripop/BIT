package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class EmailTool {
	public List<Mail> readEmails(String userEmail, String password) {
		List<Mail> email = new ArrayList<Mail>();
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		props.setProperty("mail.imap.host", "imap.evozon.com");
		props.setProperty("mail.imap.port", "993");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("mail.evozon.com", userEmail, password);
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			int i;
			Message[] messages = inbox.getMessages();
			for (i = 0; i < messages.length; i++) {
				Message msg = messages[i];
				Mail m = new Mail(msg.getSubject(), msg.getContent().toString());
				email.add(m);

			}
		} catch (Exception mex) {
			mex.printStackTrace();
		}

		return email;
	}



	public String readFromFile(String path) throws IOException {
		String text = null;
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		text = new String(data, "UTF-8");
		return text;
	}
	public boolean read(String path1,String path2) throws IOException{
		BufferedReader br1 = new BufferedReader(new FileReader("template.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("receiveMail.txt"));
		boolean ok=true;
		try {
	        StringBuilder sb = new StringBuilder();
	        String line1 = br1.readLine();
	        String line2 = br2.readLine();
	        while (line1 != null && line2!=null) {
	            System.out.println(line1.length());
	            System.out.println(line2.length());
	            if(line1.length()!=line2.length()) return false;
	            else{
	            	for(int i=0;i<line1.length();i++){
	            	char c1 = line1.charAt(i);
	    			char c2 = line2.charAt(i);
	    			if(c1!=c2) ok=false;
	            	}
	            }
	            line1 = br1.readLine();
	            line2 = br2.readLine();
	        }
	    } finally {
	        br1.close();
	        br2.close();
	    }
	    return ok;
	}

	public void writeToFile(String text, String path) throws IOException {
		BufferedWriter output = null;
		try {
			File file = new File(path);
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null)
				output.close();
		}
	}

	public String emailTemplate(String lastName, String type, String startDate, String endDate) {
		String textM = "Dear"+lastName+",<br/><br/>Youhavesubmittedanew"+type+".Yourholidayintervalis:<strong>"+startDate+"-"+endDate+"</strong>.<br/>Pleasecheckiftherequestwasapprovedbeforegoingonholiday,ifnotpleasecontactyourvacationapprover,<b>BiancaIanc1</b>.<!--<br/><br/>Cheers,<br/>TheEvoPortalTeam--><br/><br/>Cheers,<br/>TheEvoPortalTeam";
		String text = textM.replaceAll("\\s", "");
	//	String textM="Dear " + lastName + ",\r\n<br /> <br />\r\n\r\n\r\n";
		//You have submitted a new " + type+ ". Your holiday interval is: <strong>" + startDate + " - " + endDate	+ "</strong>.\r\n		<br />\r\n					Please check if the request was approved before going on holiday, if not please contact your vacation approver, <b>Bianca Ianc1</b>.\r\n                        ";
		//\r\n\r\n\r\n<!-- \r\n<br/> <br/> \r\n\r\nCheers, \r\n<br /> \r\nThe EvoPortal Team\r\n--><br/> <br/> Cheers, <br /> The EvoPortal Team\r\n";
		//\r\n\r\n<";
		
		
		return text;
	}
	public String emailApproveTemplate(String lastName,String type,String startDate,String endDate){
		String text = "Dear "+lastName+", <br/> <br/>Your "+type+" in interval: <strong>"+startDate+"</strong> - <strong>"+endDate+"</strong> has been <strong>Approved</strong>.<br/> <br/> Cheers, <br /> The EvoPortal Team";
		return text;
	}
	public String emailRejectTemplate(String lastName,String type,String startDate,String endDate){
		String text = "Dear Pop Irina, <br/> <br/>The "+type+" you have submitted for the interval: <strong>"+startDate+"</strong> - <strong>"+endDate+"</strong> has been <strong>Rejected</strong>.<br/> <br/> Cheers, <br /> The EvoPortal Team";
		return text;
	}
	public String dmEmailNewRequest(String lastName,String type,String startDate,String endDate){
		String text ="Dear"+lastName+",<br/><br/><b>PopIrina</b>hassubmitteda<i>"+type+"</i>.<br/>Theuserwillbeonvacationinthefollowingperiod:<strong>"+startDate+"-"+endDate+"</strong>.<br/>Pleaseapproveorrejectthis<ahref='http://172.22.4.88:9091/vacation?p_p_auth=l5ZXletH&p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&_evovacation_WAR_EvoVacationportlet_menuItem=inbox&_evovacation_WAR_EvoVacationportlet_inboxState=inbox-view-vacation&_evovacation_WAR_EvoVacationportlet_backMenuItem=inbox&_evovacation_WAR_EvoVacationportlet_vacationId=20846'>here</a>.<br/><!--<br/><br/>Cheers,<br/>TheEvoPortalTeam--><br/><br/>Cheers,<br/>TheEvoPortalTeam";
		String c = text.replaceAll("\\s", "");
		return c;
	}
	public String dmEmailApprove(String lastName,String type,String startDate,String endDate){
		String text = "Dear"+lastName+",<br/><br/>The"+type+"submittedby<strong>PopIrina</strong>(ininterval:<strong>"+startDate+"</strong>-<strong>"+endDate+"</strong>)<br/>hasbeen<strong>Approved</strong>.<br/><br/>Cheers,<br/>TheEvoPortalTeam";
		String c = text.replaceAll("\\s", "");
		return c;
	}
	public String dmEmailReject(String lastName,String type,String startDate,String endDate){
		String text = "Dear"+lastName+",<br/><br/>The"+type+"submittedby<strong>PopIrina</strong>(ininterval:<strong>"+startDate+"</strong>-<strong>"+endDate+"</strong>)hasbeen<strong>Rejected</strong>.<br/><br/>Cheers,<br/>TheEvoPortalTeam";
		String c = text.replaceAll("\\s", "");
		return c;
	}
	public String userEmailSubject() {
		String subject = "You have submitted a new Vacation Request";
		return subject;
	}

	public String DMMailSubject() {
		String subject = "New Vacation Request submitted by Pop Irina";
		return subject;
	}

	public String userEmailSubjectWhenRequestRejected() {
		String subject = "Vacation Request Rejected";
		return subject;
	}

	public String DMEmailSubjectWhenRequestRejected() {
		String subject = "Pop Irina Vacation Request Rejected";
		return subject;
	}

	public String DMMailSubjectWhenRequestApproved() {
		String subject = "Pop Irina Vacation Request Approved";
		return subject;
	}

	public String userMailSubjectWhenRequestApproved() {
		// TODO Auto-generated method stub
		String subject = "Vacation Request Approved";
		return subject;
	}

}
