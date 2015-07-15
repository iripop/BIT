package com.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

import com.pages.LogInPage;
import com.pages.MailRequestPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import tools.Constants;
//@RunWith(ThucydidesRunner.class)
public class ReadingEmail extends ScenarioSteps {
	NewVacationRequestPage newVacationPage;
	  LogInPage logInPage;
	  MailRequestPage mailPage;
	  // String textM = "Dear Bianca,\n<br /> <br />\n\n\n			You have submitted a new Vacation Request. Your holiday interval is: <strong>19/08/2015 - 19/08/2015</strong>.\n		<br />\n					Please check if the request was approved before going on holiday, if not please contact your vacation approver, <b>Gabriel Cretu</b>.\n\n\n\n<!--\n<br/> <br/> \n\nCheers,\n<br /> \nThe EvoPortal Team\n--><br/> <br/> Cheers, <br /> The EvoPortal Team\n\n";

	/*public List<String> read(){
		List<String> email = new ArrayList<String>();
		Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imap.host", "imap.evozon.com");
        props.setProperty("mail.imap.port", "993");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("mail.evozon.com", Constants.mailEvozon, Constants.passwordEvozon);
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

               System.out.println("FROM:" + address.toString());
            } 

            	System.out.println("SENT DATE:" + msg.getSentDate());
            	System.out.println("SUBJECT:" + msg.getSubject());
            	System.out.println("CONTENT:" + msg.getContent());
            	email.add(msg.getContent().toString());
            }
        }
         catch (Exception mex) {
            mex.printStackTrace();
        }
        
        return email;
	}
	public static void main(String args[]){
		ReadingEmail email =new ReadingEmail();
		List<String> list = email.read();
		int i;
		System.out.println("Aici");
    //	System.out.println(textM);
		//for(i=0;i<list.size();i++){
		//	System.out.println(list.get(i));
		//}
		//System.out.println(textM);
	}
	*/
	@Step
	public void check_if_the_request_was_made(String type,String startDate,String endDate){
		ReadingEmail email =new ReadingEmail();
		List<String> list = mailPage.read();
		String text = mailPage.getMail(type, startDate, endDate);
		System.out.println(text);
		System.out.println(text.length());
		System.out.println(list.get(0));
		System.out.println(list.get(0).length());
		int i=mailPage.compare(text, list.get(0));
		System.out.println(i);
		
	}
}
