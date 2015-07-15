package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import tools.Constants;


public class MailRequestPage extends PageObject {
	public String getMail(String type,String startDate,String endDate){
		 String textM = "Dear Bianca,\n<br /> <br />\n\n\n			You have submitted a new "+type+". Your holiday interval is: <strong>"+startDate+" - "+endDate+"</strong>.\n		<br />\n					Please check if the request was approved before going on holiday, if not please contact your vacation approver, <b>Gabriel Cretu</b>.\n\n\n\n<!--\n<br/> <br/> \n\nCheers,\n<br /> \nThe EvoPortal Team\n--><br/> <br/> Cheers, <br /> The EvoPortal Team\n\n";
		 return textM;
	}
	public List<String> read(){
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

            //   System.out.println("FROM:" + address.toString());
            } 

            //	System.out.println("SENT DATE:" + msg.getSentDate());
          //  	System.out.println("SUBJECT:" + msg.getSubject());
           // 	System.out.println("CONTENT:" + msg.getContent());
            	email.add(msg.getContent().toString());
            }
        }
         catch (Exception mex) {
            mex.printStackTrace();
        }
        
        return email;
	}
		public String getSubject(){
			String subject = "You have submitted a new Vacation Request";
			return subject;
		}
		public int compare(String text1,String text2){
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
			return p;
		}
    }
