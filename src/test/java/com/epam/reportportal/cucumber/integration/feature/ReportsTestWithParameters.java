/*
 *  Copyright 2020 EPAM Systems
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.epam.reportportal.cucumber.integration.feature;

import com.epam.reportportal.annotations.ParameterKey;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportsTestWithParameters {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReportsTestWithParameters.class);

	@Given("It is test with parameters")
	public void infoLevel() {
		LOGGER.info("It is test with parameters");
	}

	@When("I have parameter (\\w+)")
	public void iHaveParameterStr(String str) {
		LOGGER.info("String parameter {}", str);
	}

	@When("I have a docstring parameter:")
	public void iHaveParameterDocstring(String str) {
		iHaveParameterStr(str);
	}

	@Then("I emit number (\\d+) on level info")
	public void infoLevel(int parameters) {
		LOGGER.info("Test with parameters: " + parameters);
	}

	@Given("It is a step with an integer parameter (\\d+)")
	public void iHaveAnIntInlineParameter(int parameter) {
		LOGGER.info("Integer parameter: " + parameter);
	}

	@When("I have a step with a string parameter (\\w+)")
	public void iHaveAnStrInlineParameter(String str) {
		LOGGER.info("String parameter {}", str);
	}

	@When("I have a step with a named string parameter (\\w+)")
	public void iHaveANamedStrInlineParameter(@ParameterKey("my name") String str) {
		LOGGER.info("String parameter {}", str);
	}
}
