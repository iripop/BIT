package com.steps;

import static org.junit.Assert.assertTrue;

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
import javax.validation.constraints.AssertTrue;

import com.pages.LogInPage;
import com.pages.Mail;
import com.pages.MailRequestPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import tools.Constants;
//@RunWith(ThucydidesRunner.class)
public class ReadingEmail extends ScenarioSteps {
	NewVacationRequestPage newVacationPage;
	  LogInPage logInPage;
	  MailRequestPage mailPage;
	  
	@Step
	public String check_if_the_request_was_made(String type,String startDate,String endDate){
		ReadingEmail email =new ReadingEmail();
		List<Mail> list = mailPage.read(Constants.DMmailEvozon,Constants.DMpasswordEvozon);
	//	String text = mailPage.getMail(type, startDate, endDate);
		boolean found = false;
		String text=null;
		int i;
		for(i=0;i<list.size();i++){
			String msg = list.get(i).getcontent();
			String subject = list.get(i).getSubject();
			if(subject.compareTo(mailPage.getSubjectDM())==0 && msg.contains(type) && msg.contains(startDate) && msg.contains(endDate)) {found =true;
			text = msg;}
			}
		assertTrue("The email from dm not found", found);
		return text;
		
	}
	@Step
	public String check_if_user_has_email(String type,String startDate,String endDate){
		ReadingEmail email =new ReadingEmail();
		List<Mail> list = mailPage.read(Constants.mailEvozon,Constants.passwordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			if(subject.compareTo(mailPage.getSubjectUser())==0 && msg.contains(type) && msg.contains(startDate) && msg.contains(endDate)) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@StepGroup
	public void receive_email_when_dm_approve(){
		String text1 = user_receive_email_when_dm_approve();
		String text2 = dm_receive_email_when_dm_approve();

	}
	@Step
	public String user_receive_email_when_dm_approve(){
		ReadingEmail email =new ReadingEmail();
		List<Mail> list = mailPage.read(Constants.mailEvozon,Constants.passwordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String end = mailPage.getEndDate();
			String start = mailPage.getStartDate();
			if(subject.compareTo(mailPage.getSubjectApproveUser())==0  && msg.contains(start) && msg.contains(end) && msg.contains("Approved")) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@Step
	public String dm_receive_email_when_dm_approve(){
		ReadingEmail email =new ReadingEmail();
		List<Mail> list = mailPage.read(Constants.DMmailEvozon,Constants.DMpasswordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String end = mailPage.getEndDate();
			String start = mailPage.getStartDate();
			if(subject.compareTo(mailPage.getSubjectApproveDM())==0  && msg.contains(start) && msg.contains(end) && msg.contains("Approved")) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@StepGroup
	public void receive_email_when_dm_reject(){
		String text1 = user_receive_email_when_dm_reject();
		String text2 = dm_receive_email_when_dm_reject();

	}
	@Step
	public String user_receive_email_when_dm_reject(){
		ReadingEmail email =new ReadingEmail();
		List<Mail> list = mailPage.read(Constants.mailEvozon,Constants.passwordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String end = mailPage.getEndDate();
			String start = mailPage.getStartDate();
			if(subject.compareTo(mailPage.getSubjectRejectUser())==0  && msg.contains(start) && msg.contains(end) && msg.contains("Rejected")) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@Step
	public String dm_receive_email_when_dm_reject(){
		ReadingEmail email =new ReadingEmail();
		List<Mail> list = mailPage.read(Constants.DMmailEvozon,Constants.DMpasswordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String end = mailPage.getEndDate();
			String start = mailPage.getStartDate();
			if(subject.compareTo(mailPage.getSubjectRejectDM())==0  && msg.contains(start) && msg.contains(end) && msg.contains("Rejected")) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}

}
