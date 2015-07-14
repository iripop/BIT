package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MyRequestsPage extends PageObject{
	 
	@FindBy(css="div.carousel-slider li a[href*='menuItem=my-requests']")
	    private WebElementFacade myRequestsButton;
	
	/*@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_HOLIDAYCheckbox']")
    private WebElementFacade holidayInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_VACATION_WITHOUT_PAYMENTCheckbox']")
    private WebElementFacade vacationWithoutPaymentInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_SPECIAL_VACATIONCheckbox']")
    private WebElementFacade specialVacationInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_SICK_LEAVECheckbox']")
    private WebElementFacade sickLeaveInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_MATERNITY_LEAVECheckbox']")
    private WebElementFacade maternityLeaveInput;

	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_FIFTHCheckbox']")
    private WebElementFacade fifthInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_TENTHCheckbox']")
    private WebElementFacade tenthInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_TWENTIETHCheckbox']")
    private WebElementFacade twentiethInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_FIFTIETHCheckbox']")
    private WebElementFacade fiftiethInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_RESTCheckbox']")
    private WebElementFacade restInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_PENDINGCheckbox']")
    private WebElementFacade pendingInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_APPROVEDCheckbox']")
    private WebElementFacade approvedInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_CANCELLEDCheckbox']")
    private WebElementFacade cancelledInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_REJECTEDCheckbox']")
    private WebElementFacade rejectInput;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_WITHDRAWNCheckbox']")
    private WebElementFacade withdrawInput;
	*/
	@FindBy(css = "div[class='filter-content'] span[class='aui-field aui-field-choice'] label")
	private List<WebElement> filterList;


	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
    private WebElementFacade applyButton;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_futureVacationsCheckbox']")
    private WebElementFacade showFutureVacationsInput;
	
	public void checkIfMyRequestsExists(){
    	boolean found = false;
    	if(myRequestsButton.isPresent()){
    		found = true;
    	}
    	Assert.assertTrue("Element not found", found);
    }
	
	public void open_my_requests() {
		element(myRequestsButton).waitUntilVisible();
	    myRequestsButton.click();
	}
	
	
	
	public void selectFiletersFromList(String filter){
		boolean found = false;
		for(WebElement element:filterList){
			if(element.getText().contentEquals(filter)){
				found=true;
				element(myRequestsButton).waitUntilVisible();
				element.click();
			break;
			}
			Assert.assertTrue("Filter was not found", found);
		}
		
	}
	public void apply_filters() {
		element(applyButton).waitUntilVisible();
	    applyButton.click();
	    element(applyButton).waitUntilVisible();
	}
	public void showFutureVacations() {
		element(showFutureVacationsInput).waitUntilVisible();
		showFutureVacationsInput.click();
	   
	}
}
