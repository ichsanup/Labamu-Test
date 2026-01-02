import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	LoginPage loginPage = new LoginPage()
	
	@Given("I visited the application")
	def openApk() {
		Mobile.startExistingApplication("id.co.labamu.app") 
		TestObject widget = findTestObject('Object Repository/btn-Widget-While') 
		if (Mobile.waitForElementPresent(widget, 5)) { 
			Mobile.tap(widget, 10) 
			println("Widget muncul, berhasil ditap") 
		} else { 
			println("Widget tidak muncul, lanjut step berikutnya") 
		}
	}

	@When("I input the (.*)")
	def inputData(String Email) {
		//Without POM
//		TestObject btnEmailOption = findTestObject('Object Repository/btn-text-Email-Option')
//		TestObject inputEmail     = findTestObject('Object Repository/edt-Input-Email')
//		TestObject chkAgreement   = findTestObject('Object Repository/btn-CheckBox')
//		TestObject btnMasuk       = findTestObject('Object Repository/btn-Masuk')
//		Mobile.waitForElementPresent(btnEmailOption, 10)
//		Mobile.tap(btnEmailOption, 10)
//		Mobile.waitForElementPresent(inputEmail, 10)
//		Mobile.tap(inputEmail, 10)
//		Mobile.setText(inputEmail, Email,10)
//		Mobile.tap(chkAgreement, 10)
		
		//With POM
		loginPage.tapEmailOption()
		loginPage.enterEmail(Email)
		loginPage.checkAgreement()
	}

	@Then("I click login button")
	def loginButton() {
		//Without POM
//		TestObject btnMasuk       = findTestObject('Object Repository/btn-Masuk')
//		Mobile.waitForElementAttributeValue(
//			btnMasuk,
//			'enabled',
//			'true',
//			10
//		)
//		Mobile.verifyElementAttributeValue(
//			btnMasuk,
//			'enabled',
//			'true',
//			10
//		)
//		Mobile.tap(btnMasuk, 10)
//		Mobile.closeApplication()
		
		//With POM
		loginPage.clickLogin()
		Mobile.closeApplication()
	}
}