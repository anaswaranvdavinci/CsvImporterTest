package com.test.controller;

import com.test.bean.Student;
import com.test.service.DataImportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Optional;

@RestController
public class HomeController {

    @Inject
    private DataImportService ss;

    /**
     * GET  /metrics/studentid -> get the "student" object.
     */
    @RequestMapping(value = "/students/{rollNo}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudent(@PathVariable("rollNo") Long rollNo) {
        //log.debug("REST request to get Metric : {}", metricId);
        Optional<Student> studentDTO = ss.getStudent(rollNo);

        return studentDTO
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/report")
    public String greeting() {
        return "Hello";

    }
}
