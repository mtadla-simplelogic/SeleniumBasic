package ch4_ModernTesterBasic;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex6_Tables extends TestBase {

    @Test
    public void shouldPrintAllDataForFirstPeak() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        WebElement firstRow = rows.get(0);

        System.out.println(firstRow.getText());
    }

    @Test
    public void shouldPrintNameAndHeightForFirstPeak() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        // wszystkie wiersze
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        // pobieramy pierwszy wiersz
        WebElement firstRow = rows.get(0);

        // wyszukujemy wszystkie elementy 'td' wewnatrz pierwszego wiersza
        List<WebElement> rowCells = firstRow.findElements(By.cssSelector("td"));

        // wyszukuje jeden element 'th' w wierszu
        WebElement rank = firstRow.findElement(By.cssSelector("th"));

        // z listy elementow 'td' bierzemy zerowy -> nazwe
        String peakName = rowCells.get(0).getText();

        // z listy elementow 'td' bierzemy trzeci -> wysokosc
        String peakHeight = rowCells.get(3).getText();

        System.out.println("Peak rank: " + rank.getText());
        System.out.println("Peak name: " + peakName);
        System.out.println("Peak height: " + peakHeight);
    }

    @Test
    public void shouldPrintNameAndHeightForFifthPeakWithXpath() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        // pobieramy pierwszy wiersz
        WebElement firstRow = driver.findElement(By.xpath("//tbody//tr[5]"));

        // wyszukuje jeden element 'th' w wierszu
        WebElement rank = firstRow.findElement(By.cssSelector("th"));

        // z listy elementow 'td' bierzemy zerowy -> nazwe
        // wyszukuj element w elementcie XPATHem musimy dodać kropkę przed //,
        // lub całkowicie pominąć // W innym przypadku elementy będą szukane na całej stronie HTML

        // a więc musimy zrobić (By.xpath(".//td[1]") lub (By.xpath("td[1]")

        String peakName = firstRow.findElement(By.xpath(".//td[1]")).getText();

        // z listy elementow 'td' bierzemy trzeci -> wysokosc
        String peakHeight = firstRow.findElement(By.xpath(".//td[4]")).getText();

        System.out.println("Peak rank: " + rank.getText());
        System.out.println("Peak name: " + peakName);
        System.out.println("Peak height: " + peakHeight);
    }

    @Test
    public void shouldPrintAllMountainsNamesAnHeights () {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        Assert.assertTrue(rows.size() > 0);

        for (WebElement row : rows) {
            String peak = row.findElements(By.cssSelector("td")).get(0).getText();
            // zamiana "4600" -> 4600
            int height = Integer.parseInt(row.findElement(By.xpath("td[4]")).getText());

            System.out.println(peak + " has height: " + height);
        }

    }
}
