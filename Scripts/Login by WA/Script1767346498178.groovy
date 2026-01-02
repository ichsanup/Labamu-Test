import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile



Mobile.startExistingApplication("id.co.labamu.app") 
TestObject widget = findTestObject('Object Repository/btn-Widget-While') 
if (Mobile.waitForElementPresent(widget, 5)) { 
	Mobile.tap(widget, 10) 
	println("Widget muncul, berhasil ditap") 
} else { 
	println("Widget tidak muncul, lanjut step berikutnya") 
}
TestObject edtWA = findTestObject('Object Repository/edt-WA')
TestObject chkAgreement   = findTestObject('Object Repository/btn-CheckBox')
TestObject btnMasuk       = findTestObject('Object Repository/btn-Masuk')
Mobile.waitForElementPresent(edtWA, 10)
Mobile.tap(edtWA, 10)
Mobile.setText(edtWA, wa,10)
Mobile.tap(chkAgreement, 10)
Mobile.waitForElementAttributeValue(
    btnMasuk,
    'enabled',
    'true',
    10
)
Mobile.verifyElementAttributeValue(
    btnMasuk,
    'enabled',
    'true',
    0
)
Mobile.tap(btnMasuk, 10)
Mobile.closeApplication()


