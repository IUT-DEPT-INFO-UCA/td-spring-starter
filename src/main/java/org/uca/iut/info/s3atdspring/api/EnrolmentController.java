package org.uca.iut.info.s3atdspring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uca.iut.info.s3atdspring.service.EnrolmentService;
import org.uca.iut.info.s3atdspring.service.data.EnrolmentRequest;
import org.uca.iut.info.s3atdspring.service.data.EnrolmentResponse;

@RestController
@RequestMapping("/api/enrolments")
public class EnrolmentController {

    @Autowired
    private EnrolmentService enrolmentService;

    @PostMapping
    public EnrolmentResponse enroll(@RequestBody EnrolmentRequest request) {

        return enrolmentService.enroll(request);
    }
}
