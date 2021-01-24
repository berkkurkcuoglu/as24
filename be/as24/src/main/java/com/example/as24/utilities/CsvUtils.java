package com.example.as24.utilities;

import com.example.as24.exceptions.CsvParsingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvUtils {

    public static <T> MappingIterator<T> parseCsv(MultipartFile file, Class T) {
        if (file.isEmpty()) {
            throw new CsvParsingException("Csv is empty.");
        }

        CsvSchema csvSchema = CsvSchema
                .emptySchema()
                .withHeader();
        try {
            return new CsvMapper()
                    .readerFor(T)
                    .with(csvSchema)
                    .readValues(file.getInputStream());
        } catch (IOException exception) {
            throw new CsvParsingException("Csv format is not compatible.", exception);
        }
    }

    public static <T> List<T> convertIteratorToList(MappingIterator<?> mappingIterator,
                                                    Function<Object, T> mapper) {
        try {
            return mappingIterator
                    .readAll()
                    .stream()
                    .map(mapper)
                    .collect(Collectors.toList());
        } catch (IOException exception) {
            throw new CsvParsingException("Csv format is not compatible.", exception);
        }
    }
}
