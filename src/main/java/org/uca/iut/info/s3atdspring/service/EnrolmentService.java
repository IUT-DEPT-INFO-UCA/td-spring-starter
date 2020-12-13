package org.uca.iut.info.s3atdspring.service;

import org.uca.iut.info.s3atdspring.service.data.EnrolmentRequest;
import org.uca.iut.info.s3atdspring.service.data.EnrolmentResponse;

public interface EnrolmentService {

    public EnrolmentResponse enroll(EnrolmentRequest request);
}
