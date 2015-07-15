package com;

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

import tools.Constants;
//@RunWith(ThucydidesRunner.class)
public class ReadingEmail {
	public List<String> read(){
		List<String> email = new ArrayList<String>();
		Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imap.host", "imap.evozon.com");
        props.setProperty("mail.imap.port", "993");
  //      props.setProperty("mail.imap.connectiontimeout", "5000");
   //     props.setProperty("mail.imap.timeout", "5000");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("mail.evozon.com", Constants.mailEvozon, Constants.passwordEvozon);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            int nr = inbox.getMessageCount();
            System.out.println("Nr="+nr);
            int i;
            Message[] messages = inbox.getMessages();
            for (i=0; i < messages.length;i++) 
            {
            	Message msg =  messages[i];
            Address[] in = msg.getFrom();
            for (Address address : in) {
               System.out.println("FROM:" + address.toString());
            } 
            //Multipart mp = (Multipart) msg.getContent();
           // BodyPart bp = mp.getBodyPart(0);
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
		for(i=0;i<list.size();i++){
	//		System.out.println(list.get(i));
		}
	}
	

}
