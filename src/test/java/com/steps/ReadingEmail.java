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
	public void check_if_the_received_mail_is_correct_when_you_make_a_new_vacation_request(String lastName,
			String startDate, String endDate, String type) throws IOException {
		String templateUser = tools.emailTemplate(lastName, type, startDate, endDate);
		String a = templateUser.replaceAll("\\s", "");

		List<Mail> list = tools.readEmails(Constants.mailEvozon, Constants.passwordEvozon);
		boolean found = false;
		int i;
		for (i = 0; i < list.size(); i++) {
			String subject = list.get(i).getSubject();

			String msg = list.get(i).getcontent();
			String c = msg.replaceAll("\\s", "");
			if (a.contentEquals(c) && subject.contentEquals(tools.userEmailSubject()))
				found = true;
		}
		assertTrue("The email from user not found", found);

	}

	@Step
	public void check_if_dm_receives_the_correct_email_when_somebody_makes_a_new_vacation_request(String lastName,
			String startDate, String endDate, String type) {
		String templateDM = tools.dmEmailNewRequest(lastName, type, startDate, endDate);
		List<Mail> list = tools.readEmails(Constants.DMmailEvozon, Constants.DMpasswordEvozon);
		boolean found = false;
		int i;
		for (i = 0; i < list.size(); i++) {
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String c = msg.replaceAll("\\s", "");
			if (templateDM.contentEquals(c) && subject.contentEquals(tools.DMMailSubject()))
				found = true;
		}
		assertTrue("The email from user not found", found);
	}

	@Step
	public void check_if_the_received_mail_is_correct_when_you_has_approved_request(String lastName, String startDate,
			String endDate, String type) {
		String templateUser = tools.emailApproveTemplate(lastName, type, startDate, endDate);
		String a = templateUser.replaceAll("\\s", "");

		List<Mail> list = tools.readEmails(Constants.mailEvozon, Constants.passwordEvozon);
		boolean found = false;
		int i;
		for (i = 0; i < list.size(); i++) {
			String subject = list.get(i).getSubject();

			String msg = list.get(i).getcontent();
			String c = msg.replaceAll("\\s", "");
			if (a.contentEquals(c) && subject.contentEquals(tools.userMailSubjectWhenRequestApproved()))
				found = true;
		}
		assertTrue("The email from user not found", found);
	}

	@Step
	public void check_if_the_received_mail_is_correct_when_you_has_rejected_request(String lastName, String startDate,
			String endDate, String type) {

		String templateUser = tools.emailRejectTemplate(lastName, type, startDate, endDate);
		String a = templateUser.replaceAll("\\s", "");

		List<Mail> list = tools.readEmails(Constants.mailEvozon, Constants.passwordEvozon);
		boolean found = false;
		int i;
		for (i = 0; i < list.size(); i++) {
			String subject = list.get(i).getSubject();

			String msg = list.get(i).getcontent();
			String c = msg.replaceAll("\\s", "");
			if (a.contentEquals(c) && subject.contentEquals(tools.userEmailSubjectWhenRequestRejected()))
				found = true;
		}
		assertTrue("The email from user not found", found);

	}

	@Step
	public void check_if_dm_receives_the_correct_email_when_request_approved(String lastName, String startDate,
			String endDate, String type) {
		String templateDM = tools.dmEmailApprove(lastName, type, startDate, endDate);
		List<Mail> list = tools.readEmails(Constants.DMmailEvozon, Constants.DMpasswordEvozon);
		boolean found = false;
		int i;
		for (i = 0; i < list.size(); i++) {
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String c = msg.replaceAll("\\s", "");
			if (templateDM.contentEquals(c) && subject.contentEquals(tools.DMMailSubjectWhenRequestApproved()))
				found = true;
		}
		assertTrue("The email from user not found", found);

	}

	@Step
	public void check_if_dm_receives_the_correct_email_when_request_rejected(String lastName, String startDate,
			String endDate, String type) {
		String templateDM = tools.dmEmailReject(lastName, type, startDate, endDate);
		List<Mail> list = tools.readEmails(Constants.DMmailEvozon, Constants.DMpasswordEvozon);
		boolean found = false;
		int i;
		for (i = 0; i < list.size(); i++) {
			String subject = list.get(i).getSubject();
			String msg = list.get(i).getcontent();
			String c = msg.replaceAll("\\s", "");
			if (templateDM.contentEquals(c) && subject.contentEquals(tools.DMEmailSubjectWhenRequestRejected()))
				found = true;
		}
		assertTrue("The email from user not found", found);

	}
}
