package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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
	public List<Mail> readEmails(String userEmail,String password){
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
            int nr = inbox.getMessageCount();
           // System.out.println("Nr="+nr);
            int i;
            Message[] messages = inbox.getMessages();
            for (i=0; i < messages.length;i++) 
            {
            	Message msg =  messages[i];
            Address[] in = msg.getFrom();
            for (Address address : in) {

            //   System.out.println("FROM:" + address.toString());
            } 

            //	System.out.println("SENT DATE:" + msg.getSentDate());
          //  	System.out.println("SUBJECT:" + msg.getSubject());
           // 	System.out.println("CONTENT:" + msg.getContent());
            Mail m = new Mail(msg.getSubject(), msg.getContent().toString());
            email.add(m);
            
            }
        }
         catch (Exception mex) {
            mex.printStackTrace();
        }
        
        return email;
	}
	public boolean compare(String text1,String text2){
		boolean found=true;
		int p=0,i=0;
		while(found){
			char c1 = text1.charAt(i);
			char c2 = text2.charAt(i);
			if(c1!=c2){
				found=false;
				p=i;
			}
			i++;
		}
		return found;
	}
	public String readFromFile(String path) throws IOException{
		String text = null;
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		text = new String(data, "UTF-8");
		return text;
	}
	public void writeToFile(String text,String path) throws IOException{
		 BufferedWriter output = null;
	        try {
	            File file = new File(path);
	            output = new BufferedWriter(new FileWriter(file));
	            output.write(text);
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        } finally {
	            if ( output != null ) output.close();
	        }
	}
	public String emailTemplate(String lastName,String type,String startDate,String endDate){
		String textM = new String();
		textM = "Dear "+lastName+",\n<br /> <br />\n\n\n			You have submitted a new "+type+". Your holiday interval is: <strong>"+startDate+" - "+endDate+"</strong>.\n		<br />\n					Please check if the request was approved before going on holiday, if not please contact your vacation approver, <b>Gabriel Cretu</b>.\n\n\n\n<!--\n<br/> <br/> \n\nCheers,\n<br /> \nThe EvoPortal Team\n--><br/> <br/> Cheers, <br /> The EvoPortal Team\n\n";
		System.out.println(textM);
		return textM;
	}
	
		public String userEmailSubject(){
			String subject = "You have submitted a new Vacation Request";
			return subject;
		}
		public String DMMailSubject(){
			String subject = "New Vacation Request submitted by Pop Irina";
			return subject;
		}
		public String userEmailSubjectWhenRequestRejected(){
			String subject = "Vacation Request Rejected";
			return subject;
		}
		public String DMEmailSubjectWhenRequestRejected(){
			String subject = "Pop Irina Vacation Request Rejected";
			return subject;
		}
		public String DMMailSubjectWhenRequestApproved(){
			String subject = "Pop Irina Vacation Request Approved";
			return subject;
		}
		
		public String userMailSubjectWhenRequestApproved() {
			// TODO Auto-generated method stub
			String subject = "Vacation Request Approved";
			return subject;
		}
		
		
   }

