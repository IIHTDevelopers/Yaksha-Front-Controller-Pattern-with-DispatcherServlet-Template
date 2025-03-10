package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.yaksha.assignment.utils.CustomParser;

public class EventControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testJstlTagPresenceInEventListJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/event-list.jsp";

		// Ensure the presence of JSTL c:forEach tag and a closing </td> tag
		boolean hasForEachTag = CustomParser.checkJspTagPresence(filePath, "<c:forEach");
		boolean hasTdClosingTag = CustomParser.checkJspTagPresence(filePath, "</td>");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasForEachTag && hasTdClosingTag, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInAddEventJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/add-event.jsp";

		// Check for form submission and input elements in add-event.jsp
		boolean hasFormTag = CustomParser.checkJspTagPresence(filePath, "<form");
		boolean hasInputTags = CustomParser.checkJspTagPresence(filePath, "<input");
		boolean hasTextareaTags = CustomParser.checkJspTagPresence(filePath, "<textarea");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasFormTag && hasInputTags && hasTextareaTags, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInEditEventJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/edit-event.jsp";

		// Check for form submission and input elements in edit-event.jsp
		boolean hasFormTag = CustomParser.checkJspTagPresence(filePath, "<form");
		boolean hasInputTags = CustomParser.checkJspTagPresence(filePath, "<input");
		boolean hasTextareaTags = CustomParser.checkJspTagPresence(filePath, "<textarea");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasFormTag && hasInputTags && hasTextareaTags, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInEditEventJspForClosure() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/edit-event.jsp";

		// Ensure that edit-event.jsp contains the correct JSP tags and HTML closure
		boolean hasFormClosingTag = CustomParser.isTagProperlyClosedInFile(filePath, "form");
		boolean hasInputClosingTag = CustomParser.isTagProperlyClosedInFile(filePath, "input");
		boolean hasTextareaClosingTag = CustomParser.isTagProperlyClosedInFile(filePath, "textarea");

		// Verify the page includes the correct JSP expression for closure
		yakshaAssert(currentTest(), hasFormClosingTag && hasInputClosingTag && hasTextareaClosingTag, businessTestFile);
	}

	@Test
	public void testEventListPageDynamicContent() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/event-list.jsp";

		// Check that the JSP dynamically renders event data by ensuring presence of
		// dynamic content like event name, event date, and event description
		boolean hasDynamicEventName = CustomParser.checkJspTagPresence(filePath, "${event.name}");
		boolean hasDynamicEventDate = CustomParser.checkJspTagPresence(filePath, "${event.date}");
		boolean hasDynamicEventDescription = CustomParser.checkJspTagPresence(filePath, "${event.description}");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasDynamicEventName && hasDynamicEventDate && hasDynamicEventDescription,
				businessTestFile);
	}

	@Test
	public void testEventDeleteUrlPresenceInEventListJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/event-list.jsp";

		// Check if the delete URL is present for each event
		boolean hasDeleteUrl = CustomParser.checkJspTagPresence(filePath, "/event/delete");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasDeleteUrl, businessTestFile);
	}

	@Test
	public void testEventEditUrlPresenceInEventListJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/event-list.jsp";

		// Check if the edit URL is present for each event
		boolean hasEditUrl = CustomParser.checkJspTagPresence(filePath, "/event/edit");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasEditUrl, businessTestFile);
	}
}
