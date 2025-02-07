package vr.projects.sunnycompass.restapi.csv;

import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import vr.projects.sunnycompass.csv.CSVService;
import vr.projects.sunnycompass.restapi.RestResponse;

@RestController
@RequestMapping(path = "/api/v1/csvs")
@RequiredArgsConstructor
public class CSVController {

    private final CSVService service;

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public RestResponse processCsv() throws IOException, CsvException {
        // "D:\New folder\accountactivity_dec_24.csv"
        final String samplePath = "D:\\New folder\\accountactivity_dec_24.csv";
        final var processedOp = service.parse(samplePath);
        return RestResponse.success(processedOp);
    }
}
