package dsAlgo_StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import static dsAlgo_Utilities.DsAlgoUtil.snooze;
import static dsAlgo_Constants.DsAlgoConstant.*;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.ALandingPage;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.DLoginPage;
import dsAlgo_PageObject.IQueuePage;
import dsAlgo_Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IQueuePage_SD {
	private ALandingPage landingPage = new ALandingPage(DriverFactory.getDriver());
	private BHomePage homePage = new BHomePage(DriverFactory.getDriver());
	private DLoginPage loginPage = new DLoginPage(DriverFactory.getDriver());
	private IQueuePage qPage = new IQueuePage(DriverFactory.getDriver());

	String expectedResult = null;
	
	/* @TS_queue_02 */
	@Given("The user is on homepage")
	public void the_user_is_on_homepage() {
		homePage.homepage();
	}

	@When("The user clicks the queue item from the drop down menu")
	public void the_user_clicks_the_queue_item_from_the_drop_down_menu() {
		qPage.clickOnQueueItem();
	}

	@Then("The user be directed to Queue Data Structure Page")
	public void the_user_be_directed_to_queue_data_structure_page() {// modification on feature flile
		//String actualURL = DriverFactory.getDriver().getCurrentUrl();
		//System.out.println("actualURL  = " + actualURL);
	}

	/* @TS_queue_03 */
	@Given("The user is on queue page")
	public void the_user_in_queue_page() {
		qPage.navigateToQueuePage();
	}

	@When("The user clicks on Implementation of queue in python link")
	public void the_user_clicks_on_implementation_of_queue_in_python_link() {
		qPage.clickOnImplementationQueuePythonLink();
	}

	@Then("The user should be directed to Implementation of Queue in Python page")
	public void the_user_should_be_directed_to_implementation_of_queue_in_python_page() {
		String actualURL = DriverFactory.getDriver().getCurrentUrl();
		System.out.println("actualURL  = " + actualURL);
	}
	/* @TS_queue_04 */

	@Given("The user is on Implementation of queue in python link page")
	public void the_user_is_in_implementation_of_queue_in_python_link_page() {
		qPage.navigateToImplementationQueuePythonLink();
		snooze(1);
	}

	@When("The user clicks on Tryhere link")
	public void the_user_clicks_on_tryhere_link() {
		qPage.clickOnTryHereLink();
	}

	@Then("The user navigates to Editor page with Run button")
	public void the_user_navigates_to_editor_page_with_run_button() {

		String currentUrl = DriverFactory.getDriver().getCurrentUrl();
		System.out.println("currentUrl = "+ currentUrl);
		assertEquals(currentUrl,tryEditor);
	}
	/* @TS_queue_05 */
	@Given("The user is on a page having an Editor with a Run button to test")
	public void the_user_is_in_a_page_having_an_editor_with_a_run_button_to_test() {
		DriverFactory.getDriver().get(tryEditor);
		snooze(1);
	}

	@When("The user enters valid python code in Editor from sheet {string} and {int}")
	public void the_user_enters_valid_python_code_in_editor_from_sheet_and(String sheetName, Integer int1rowNumber) throws InvalidFormatException, IOException {
		ExcelReader excel=new ExcelReader();
	    List<Map<String,String>> list=excel.getData(XL_DATA_FILE_PATH,sheetName);
	    Map<String,String> dataMap = list.get(int1rowNumber);
	    String pythonCode = dataMap.get("pythonCode");
	    expectedResult  = dataMap.get("Result");
	    System.out.println("expected = "+ expectedResult);

	    qPage.sendPythonCode(pythonCode);
	}

	@When("clicks run button")
	public void clicks_run_button() {
		qPage.clickOnRunButton();
	}

	@Then("The user is presented with the result after run button is clicked")
	public void the_user_is_presented_with_the_result_after_run_button_is_clicked() {
	    String actualResult = qPage.getActualResult();
	    System.out.println("actualResult = "+ actualResult);
	    assertEquals(actualResult, expectedResult);
	}
	/* @TS_queue_06 */
	@When("The user enters invalid python code in Editor from sheet {string} and {int}")
	public void the_user_enters_invalid_python_code_in_editor_from_sheet_and(String Sheet2, Integer int1rowNumber) throws InvalidFormatException, IOException {
		ExcelReader excel=new ExcelReader();
	    List<Map<String,String>> list=excel.getData(XL_DATA_FILE_PATH,Sheet2);
	    Map<String,String> dataMap = list.get(int1rowNumber);
	    String pythonCode = dataMap.get("pythonCode");
	    expectedResult  = dataMap.get("Result");

	    qPage.sendPythonCode(pythonCode);
	}
	

	@Then("The user gets an error message")
	public void the_user_gets_an_error_message() {
		String errorMessage = qPage.getAlertMessage();
		System.out.println("errorMessage = "+errorMessage);
		System.out.println("driver.getTitle() = "+ DriverFactory.getDriver().getTitle());
		assertEquals(errorMessage, expectedResult);
	}
	/* @TS_queue_07 */
	@Given("The user in editor page and navigates to the queue page")
	public void the_user_in_editor_page_and_navigates_to_the_queue_page() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/queue/");
	}

	@When("The user clicks on Implementation using collections deque link")
	public void the_user_clicks_on_implementation_using_collections_deque_link() {
		qPage.clickOnImpUsingCollLink();
	}

	@Then("The user should be redirected to Implementation using collections deque page")
	public void the_user_should_be_redirected_to_implementation_using_collections_deque_page() {
		qPage.navigateToImplementationCollectionsDeque();
	}
	/* @TS_queue_08 */
	@Given("The user in implementation using collections page")
	public void the_user_in_implementation_using_collections_page() {
		qPage.clickOnImpUsingCollLink();
	}

	@When("The user clicks on Implementation using array link")
	public void the_user_clicks_on_implementation_using_array_link() {
		qPage.clickOnImplementationUsingArray();
	}

	@Then("The user should be redirected to Implementation using array page")
	public void the_user_should_be_redirected_to_implementation_using_array_page() {
		qPage.navigateToImplementationUsingArray();
	}
	/* @TS_queue_09 */
	@Given("The user on implementation using array page")
	public void the_user_in_implementation_using_array_page() {
		
	}

	@When("The user clicks on Queue Operations link")
	public void the_user_clicks_on_queue_operations_link() {
		qPage.clickOnQueueOperationsLink();
	}

	@Then("The user should be redirected to Queue Operations page")
	public void the_user_should_be_redirected_to_queue_operations_page() {
		qPage.navigateToQueueOperationsLink();
	}
	/* @TS_queue_10 */
	@Given("The user is on Queue Operations page")
	public void the_user_in_queue_operations_page() {
		qPage.navigateToQueueOperationsLink();
	}

	@Given("The user is on Editor page and navigates to QueueOp page")
	public void the_user_is_in_editor_page_and_navigates_to_queue_op_page() {
		qPage.clickOnTryHereLink();
		qPage.navigateToQueueOperationsLink();
		
	}

	@When("the user clicks on Practice Questions")
	public void the_user_clicks_on_practice_questions() {
		qPage.clickOnPracticeQuestionsLink();
	}

	@Then("The user is directed to Practice page")
	public void the_user_is_directed_to_practice_page() {
		qPage.navigateToPracticeQuestionsLink();
	}
}

/*@Given("The user on Queue Operations page")
public void the_user_on_queue_operations_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}*/
