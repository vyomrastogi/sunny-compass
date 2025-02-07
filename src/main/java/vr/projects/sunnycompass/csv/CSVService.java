package vr.projects.sunnycompass.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CSVService {

    private final ApplicationEventPublisher publisher;

    public List<TransactionEntry> parse(final String filePath) throws IOException, CsvException {
        final var csvReader = new CSVReader(new FileReader(filePath));
        final List<String[]> allLines = csvReader.readAll();
        try {
            final var entries = allLines.parallelStream()
                    .map(row -> new TransactionEntry(
                            row[0],
                            row[1],
                            getDoubleFromString(row[2]),
                            getDoubleFromString(row[3]),
                            getDoubleFromString(row[4]),
                            row[5]))
                    .toList();
            publisher.publishEvent(new CSVProcessedEvent(entries, filePath));
            return entries;
        } finally {
            csvReader.close();
        }
    }

    private Double getDoubleFromString(final String doubleString) {
        final Double debit =
                doubleString != null && !doubleString.isBlank() ? Double.valueOf(doubleString) : Double.valueOf(0);
        return debit;
    }
}
