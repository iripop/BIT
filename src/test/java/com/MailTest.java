package com;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import tools.Constants;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.NewVacationRequestPage;
import com.steps.ApproveRejectRequestsSteps;
import com.steps.EndUserSteps;
import com.steps.LogOutSteps;
import com.steps.NewVacationRequestsSteps;
import com.steps.ReadingEmail;

@RunWith(ThucydidesRunner.class)
// @RunWith(SerenityParameterizedRunner.class)
// @UseTestDataFrom("/resources/data.csv")
public class MailTest {
	String username, password;
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.defaultURL)
	public Pages pages;

	@Steps
	public EndUserSteps endUser;

	@Steps
	public NewVacationRequestsSteps newVacationSteps;

	@Steps
	public ReadingEmail emailSteps;

	@Steps
	public ApproveRejectRequestsSteps approveRejectSteps;

	@Steps
	LogOutSteps logOutSteps;

	@Test
	public void verify_if_mail_sent_when_new_vacation_request_is_made() throws IOException {
		endUser.openHomePage();
		endUser.logInAsUser(Constants.Username, Constants.Userpassword);
		endUser.goToVacationMenu();
		newVacationSteps.accessNewVacationRequestPage();
		newVacationSteps.accessNewVacationRequestWithSuccess();
		newVacationSteps.createNewHolidayRequest(8, "December", 2015, 8, "December", 2015);

		emailSteps.check_if_the_received_mail_is_correct_when_you_make_a_new_vacation_request(Constants.UserLastName,
				"08/12/2015", "08/12/2015", "Vacation Request");
		emailSteps.check_if_dm_receives_the_correct_email_when_somebody_makes_a_new_vacation_request(
				Constants.DMlastName, "08/12/2015", "08/12/2015", "Vacation Request");
	}
/*
	@Test
	public void verify_if_mail_sent_when_vacation_is_approved() {
		endUser.is_the_home_page();
		endUser.login(Constants.Username, Constants.Userpassword);
		endUser.go_to_vacation_menu();

		newVacationSteps.go_to_new_vacation_request_page();
		newVacationSteps.create_a_new_vacation_without_payment(10, "December", 2015, 10, "December", 2015);

		logOutSteps.logOut();

		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		approveRejectSteps.view_vacation_requests_assigned_to_me();
		approveRejectSteps.access_inbox_with_success();
		approveRejectSteps.approve_the_selected_request("Pop Irina", "10/12/2015", "10/12/2015",
				"Vacation Without Payment");
		emailSteps.check_if_the_received_mail_is_correct_when_you_has_approved_request("Pop", "10/December/2015",
				"10/December/2015", "Vacation Request");
		emailSteps.check_if_dm_receives_the_correct_email_when_request_approved(Constants.DMlastName,
				"10/December/2015", "10/December/2015", "Vacation Request");
	}

	@Test
	public void verify_if_mail_sent_when_vacation_is_rejected() {
		endUser.is_the_home_page();
		endUser.login(Constants.Username, Constants.Userpassword);
		endUser.go_to_vacation_menu();

		newVacationSteps.go_to_new_vacation_request_page();
		newVacationSteps.create_a_new_vacation_without_payment(2, "December", 2015, 2, "December", 2015);

		logOutSteps.logOut();

		endUser.is_the_home_page();
		endUser.login(Constants.DMname, Constants.DMpassword);
		endUser.go_to_vacation_menu();
		approveRejectSteps.view_vacation_requests_assigned_to_me();
		approveRejectSteps.access_inbox_with_success();
		approveRejectSteps.reject_the_selected_request("Pop Irina", "02/12/2015", "02/12/2015",
				"Vacation Without Payment");
		emailSteps.check_if_the_received_mail_is_correct_when_you_has_rejected_request("Pop", "2/December/2015",
				"2/December/2015", "Vacation Request");
		emailSteps.check_if_dm_receives_the_correct_email_when_request_rejected(Constants.DMlastName, "2/December/2015",
				"2/December/2015", "Vacation Request");
	}

	@After
	public void close_browser() {
		pages.getDriver().close();
	}
*/
}