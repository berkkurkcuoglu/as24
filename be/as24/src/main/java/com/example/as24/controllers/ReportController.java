package com.example.as24.controllers;

import com.example.as24.dtos.ContactReportDto;
import com.example.as24.enums.SellerType;
import com.example.as24.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(final ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report1")
    public Map<SellerType, Double> getReport1() {
        return reportService.getAveragePricePerSeller();
    }

    @GetMapping("/report2")
    public Map<String, Double> getReport2() {
        return reportService.getMakePercentage();
    }

    @GetMapping("/report3")
    public Double getReport3() {
        return reportService.getAveragePriceOf30thNtileMostContacted();
    }

    @GetMapping("/report4")
    public Map<String, List<ContactReportDto>> getReport4() {
        return reportService.getTop5MostContactedPerMonth();
    }
}
