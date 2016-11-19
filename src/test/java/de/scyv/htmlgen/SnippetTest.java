package de.scyv.htmlgen;

import org.junit.Test;

import de.scyv.htmlgen.api.Body;
import de.scyv.htmlgen.api.Div;
import de.scyv.htmlgen.api.Html;
import de.scyv.htmlgen.api.Table;
import de.scyv.htmlgen.api.Tbody;
import de.scyv.htmlgen.api.Tr;
import org.junit.Assert;

/**
 * Test for generating a HTML Snippet with the html-gen
 */
public class SnippetTest {

    @Test
    public void testSnippet() {

        Html html = new Html();
        html.head().title().text("SWAT 2016");
        Body body = html.body();
        body.h1().text("SWAT rocks!");;
        Table table = body.p().table();
        table.setCellspacing("0");
        table.setCellpadding("0");
        Tr headRow = table.thead().tr();
        headRow.th().text("1");
        headRow.th().text("2");
        headRow.th().text("3");

        Tbody tableBody = table.tbody();
        Tr row1 = tableBody.tr();
        row1.td().text("1");
        row1.td().text("2");
        row1.td().text("3");

        Tbody tableBody2 = table.tbody();
        Tr row2 = tableBody2.tr();
        row2.td().text("4");
        row2.td().text("5");
        row2.td().text("6");

        body.table().tr().td().text("Lorem ipsum dolor sit amet");

        body.br();

        Div div1 = body.div();
        div1.setClass("lorem ipsum dolor");
        div1.setStyle("color:#ccc");
        Div div2 = div1.div();
        div2.text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore");
        div2.div();
        div2.text("et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.");
        div1.text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore");

        StringBuilder expected = new StringBuilder();

        expected.append("<html><head><title>SWAT 2016</title></head><body>");
        expected.append("<h1>SWAT rocks!</h1>");
        expected.append("<p><table cellspacing=\"0\" cellpadding=\"0\"><thead><tr><th>1</th>");
        expected.append("<th>2</th><th>3</th></tr></thead><tbody><tr><td>1</td>");
        expected.append("<td>2</td><td>3</td></tr></tbody><tbody><tr><td>4</td>");
        expected.append("<td>5</td><td>6</td></tr></tbody></table></p>");
        expected.append("<table><tr><td>Lorem ipsum dolor sit amet</td></tr></table>");
        expected.append("<br/>");
        expected.append("<div class=\"lorem ipsum dolor\" style=\"color:#ccc\"><div>Lorem ipsum ");
        expected.append("dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod ");
        expected.append("tempor invidunt ut labore<div/>et dolore magna aliquyam erat, sed ");
        expected.append("diam voluptua. At vero eos et accusam et justo duo dolores et ea ");
        expected.append("rebum.</div>Lorem ipsum dolor sit amet, consetetur sadipscing ");
        expected.append("elitr, sed diam nonumy eirmod tempor invidunt ut labore</div>");
        expected.append("</body></html>");

        System.out.println(html.toHTML());
        Assert.assertEquals(expected.toString(), html.toHTML());

    }

}
