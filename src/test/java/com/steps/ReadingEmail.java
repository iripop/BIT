package com.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.xalan.xsltc.compiler.sym;

import com.pages.LogInPage;
import com.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import tools.Constants;
import tools.EmailTool;
import tools.Mail;
//@RunWith(ThucydidesRunner.class)
public class ReadingEmail extends ScenarioSteps {
	NewVacationRequestPage newVacationPage;
	  LogInPage logInPage;
	  EmailTool tools = new EmailTool();
	  
	@Step
	public String check_if_DM_receives_email_when_a_request_is_made(String type,String startDate,String endDate){
		List<Mail> list = tools.readEmails(Constants.DMmailEvozon,Constants.DMpasswordEvozon);
		boolean found = false;
		String text=null;
		int i;
		for(i=0;i<list.size();i++){
			String msg = list.get(i).getcontent();
			String subject = list.get(i).getSubject();
			if(subject.compareTo(tools.DMMailSubject())==0 && msg.contains(type) && msg.contains(startDate) && msg.contains(endDate)) {found =true;
			text = msg;}
			}
		assertTrue("The email from dm not found", found);
		return text;
		
	}
	@Step
	public String check_if_user_receives_email_when_he_makes_a_request(String type,String startDate,String endDate){
		List<Mail> list = tools.readEmails(Constants.mailEvozon,Constants.passwordEvozon);
		int i;
	
		boolean found = false;
		//int i;
		String text="";
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			if(subject.compareTo(tools.userEmailSubject())==0 && msg.contains(type) && msg.contains(startDate) && msg.contains(endDate)) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@StepGroup
	public void receive_email_when_dm_approve(String startDate,String endDate){
		user_receives_email_when_dm_approve(startDate,endDate);
		dm_receives_email_when_dm_approve(startDate,endDate);

	}
	@Step
	public String user_receives_email_when_dm_approve(String startDate,String endDate){
		List<Mail> list = tools.readEmails(Constants.mailEvozon,Constants.passwordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String end = startDate;
			String start = endDate;
			if(subject.compareTo(tools.userMailSubjectWhenRequestApproved())==0  && msg.contains(start) && msg.contains(end) && msg.contains("Approved")) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@Step
	public String dm_receives_email_when_dm_approve(String startDate,String endDate){
		List<Mail> list = tools.readEmails(Constants.DMmailEvozon,Constants.DMpasswordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String end = startDate;
			String start = endDate;
			if(subject.compareTo(tools.DMMailSubjectWhenRequestApproved())==0  && msg.contains(start) && msg.contains(end) && msg.contains("Approved")) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@StepGroup
	public void receive_email_when_dm_reject(String startDate,String endDate){
		user_receives_email_when_dm_reject(startDate,endDate);
		dm_receives_email_when_dm_reject(startDate,endDate);

	}
	@Step
	public String user_receives_email_when_dm_reject(String startDate,String endDate){
		List<Mail> list = tools.readEmails(Constants.mailEvozon,Constants.passwordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String end = startDate;
			String start = endDate;
			if(subject.compareTo(tools.userEmailSubjectWhenRequestRejected())==0  && msg.contains(start) && msg.contains(end) && msg.contains("Rejected")) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@Step
	public String dm_receives_email_when_dm_reject(String startDate,String endDate){
		List<Mail> list = tools.readEmails(Constants.DMmailEvozon,Constants.DMpasswordEvozon);
		boolean found = false;
		int i;
		String text=null;
		for(i=0;i<list.size();i++){
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String end = startDate;
			String start = endDate;
			if(subject.compareTo(tools.DMEmailSubjectWhenRequestRejected())==0  && msg.contains(start) && msg.contains(end) && msg.contains("Rejected")) {found =true;
					text = msg;}
		}
		assertTrue("The email from user not found", found);
		return text;
	}
	@StepGroup
	public void check_if_the_receive_mail_is_correct_when_you_make_a_new_vacation_request(String lastName,String startDate,String endDate,String type) throws IOException{	
		String text = tools.emailTemplate(lastName, type, startDate, endDate);

		String mail = check_if_user_receives_email_when_he_makes_a_request(type, startDate, endDate);
		String c = mail.replaceAll("\\s", "");
		assertTrue("The email is not correct", text.contentEquals(c));
	}

	@Step
	public void check_if_the_received_mail_is_correct_when_you_has_approved_request(String lastName,String startDate,String endDate,String type){
		String mail = user_receives_email_when_dm_approve(startDate, endDate);
		String template = tools.emailApproveTemplate(lastName, type, startDate, endDate);
		String c = mail.replaceAll("\\s", "");
		String a = template.replaceAll("\\s", "");
		assertTrue("The email is not correct",a.contentEquals(c));
	}
	@Step
	public void check_if_the_received_mail_is_correct_when_you_has_rejected_request(String lastName,String startDate,String endDate,String type){
		String mail = user_receives_email_when_dm_reject(startDate, endDate);
		String template = tools.emailRejectTemplate(lastName, type, startDate, endDate);
		String c = mail.replaceAll("\\s", "");
		String a = template.replaceAll("\\s", "");
		assertTrue("The email is not correct",a.contentEquals(c));	
	}
}
