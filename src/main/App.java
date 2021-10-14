import com.pdfunit.AssertThat;
import com.pdfunit.filter.page.PagesToUse;
import com.pdfunit.filter.region.PageRegion;
import com.pdfunit.validators.TextValidator;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class App {
    public static void main(String[] args) {
        System.out.println("app");

//        Locale locale = new Locale("en", "AU");

//        ResourceBundle bundle = ResourceBundle.getBundle("resources/messages_pt_BR.properties", locale);
       // System.out.println(bundle.getString("welcome"));
        //C:\dev\pro...unit\resources\example-files\helloWorld_signed.pdf

        new App().whenPageRegionHasExpectedtext_thenSuccess();
    }

    @Test
    void metodo(){
        whenPageRegionHasExpectedtext_thenSuccess();
    }

    public void whenPageRegionHasExpectedtext_thenSuccess() {
        String filename = getFilePath("src/main/resources/example-files/helloWorld_signed.pdf");
        int leftX = 0;
        int upperY = 0;
        int width = 200;
        int height = 200;
        PageRegion regionTitle = new PageRegion(leftX, upperY, width, height);

        TextValidator x = AssertThat.document(filename)
                .restrictedTo(PagesToUse.getPage(1))
                .restrictedTo(regionTitle)
                .hasText()
                .containing("Hello");

//        System.out.println(x.toString());
//        System.out.println(x.hasNoText());
    }

    private String getFilePath(String s) {
        return s;
    }
}
