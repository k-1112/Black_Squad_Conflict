package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags="",features="C:\\Users\\kmuralidharan\\Downloads\\BlackSquad_PilotProject 4\\BlackSquad_PilotProject_1\\Thomascook\\src\\test\\resources\\features\\login.feature",glue ="com.stepDefinitions",plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class runnerLogin {
		
}
