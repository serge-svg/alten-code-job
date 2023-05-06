package svg.altencodejob;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Prices API", version = "1.0", description = "Prices API Information"))
public class AltenCodeJobAssessment {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}