package com.examapp.controllers;


import com.examapp.exceptions.CenterNotFoundException;
import com.examapp.exceptions.ExamNotFoundException;
import com.examapp.model.ExamCenter;
import com.examapp.service.ICenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CenterController {

    private Logger logger = LoggerFactory.getLogger(ExamController.class);

    ICenterService centerService;

    @Autowired
    public void setCenterService(ICenterService centerService) {
        this.centerService = centerService;
    }

    @PostMapping("/admin/centers")
    ResponseEntity<ExamCenter> addExamCenter(@RequestBody ExamCenter center) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding center");
        ExamCenter centers = centerService.addExamCenter(center);
        return ResponseEntity.status(HttpStatus.CREATED).body(centers);
    }

    @PutMapping("/admin/centers")
    ResponseEntity<Void> updateCenter(@RequestBody ExamCenter center) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating center");
        centerService.updateCenter(center);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @DeleteMapping("/admin/centers/{centerId}")
    ResponseEntity<String> deleteCenter(@PathVariable("centerId") int centerId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting center");
        centerService.deleteCenter(centerId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/centers/centerId/{centerId}")
    ResponseEntity<ExamCenter> getById(@PathVariable("centerId") int centerId) {
        logger.debug("get by Id method");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "center Id ");
        ExamCenter center = centerService.getById(centerId);
        logger.info("Got one exam details " + center);
        return ResponseEntity.ok().headers(headers).body(center);

    }

    @GetMapping("/centers")
    ResponseEntity<List<ExamCenter>> getAll() {
        logger.debug("inside get all questions");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all centers");
        headers.add("info", "center details");
        List<ExamCenter> centers = centerService.getAll();
        logger.info("Got all questions: " + centers);
        ResponseEntity<List<ExamCenter>> centerResponse = new ResponseEntity(centers, headers, HttpStatus.OK);
        return centerResponse;

    }

    @GetMapping("/centers/location/{location}")
    ResponseEntity<List<ExamCenter>> getByLocation(@PathVariable("location") String location) throws ExamNotFoundException {
        logger.debug("inside get by location details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by location");
        List<ExamCenter> centers = centerService.getByLocation(location);
        logger.info("Got exam details by name and topic: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);

    }

    @GetMapping("/centers/centerName/{centerName}")
    ResponseEntity<List<ExamCenter>> getByCenterName(@PathVariable("centerName") String centerName) throws ExamNotFoundException {

        logger.debug("inside get details by center name ");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by center name");
        List<ExamCenter> centers = centerService.getByCenterName(centerName);
        logger.info("Got exam details by center name: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);

    }

    @GetMapping("centers/examName/{examName}/center/{center}")
    ResponseEntity<List<ExamCenter>> getByExCenter(@PathVariable("examName") String examName,@PathVariable("center") String center) throws ExamNotFoundException {
        logger.debug("inside get by center and exam  details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by center and exam name");
        List<ExamCenter> centers = centerService.getByExCenter(examName, center);
        logger.info("Got exam details by name and center: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);
    }

    @GetMapping("centers/examName/{examName}/location/{location}")
    ResponseEntity<List<ExamCenter>> getByExLocation(@PathVariable("examName") String examName,@PathVariable("location") String location) throws CenterNotFoundException{
        logger.debug("get by location and exam details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by location and exam name");
        List<ExamCenter> centers = centerService.getByExLocation(examName, location);
        logger.info("Got exam details by name and location: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);
    }

    @GetMapping("centers/examName/{examName}/university/{university}")
    ResponseEntity<List<ExamCenter>> getByExamUni(@PathVariable("examName") String examName,@PathVariable("university") String university) throws CenterNotFoundException{
        logger.debug("inside get by university and exam  details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by university and exam name");
        List<ExamCenter> centers = centerService.getByExamUni(examName, university);
        logger.info("Got exam details by name and university: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);
    }

    @GetMapping("centers/examName/{examName}/marks/{marks}")
    ResponseEntity<List<ExamCenter>> getByExamMarks(@PathVariable("examName") String examName,@PathVariable("marks") int marks) throws CenterNotFoundException{
        logger.debug("inside get by center and exam  details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by center and exam name");
        List<ExamCenter> centers = centerService.getByExamMarks(examName, marks);
        logger.info("Got exam details by name and center: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);
    }

    @GetMapping("centers/subject/{subject}/examName/{examName}/university/{university}")
    ResponseEntity<List<ExamCenter>> getByUniCentSub(@PathVariable("subject") String subject,@PathVariable("examName") String examName,@PathVariable("university") String university) throws CenterNotFoundException{
        logger.debug("inside get by subject, university and exam  details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by subject, university and exam name");
        List<ExamCenter> centers = centerService.getByUniCentSub(subject, examName, university);
        logger.info("Got exam details by subject, university: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);
    }

    @GetMapping("centers/examName/{examName}/center/{center}/university/{university}")
    ResponseEntity<List<ExamCenter>> getByExCentUni(@PathVariable("examName") String examName,@PathVariable("center") String center,@PathVariable("university") String university) throws CenterNotFoundException{
        logger.debug("inside get by center and exam details and university");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by center and exam name");
        List<ExamCenter> centers = centerService.getByExCentUni(examName, center, university);
        logger.info("Got exam details by name and center: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);
    }

    @GetMapping("centers/location/{location}/examName/{examName}/subject/{subject}")
    ResponseEntity<List<ExamCenter>> getByLocSubNam(@PathVariable("location") String location,@PathVariable("examName") String examName,@PathVariable("subject") String subject) throws CenterNotFoundException{
        logger.debug("inside get by location,subject and exam  details");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting by location,subject and exam name");
        List<ExamCenter> centers = centerService.getByLocSubNam(location, examName, subject);
        logger.info("Got exam details by location,subject and center: " + centers);
        return ResponseEntity.ok().headers(headers).body(centers);
    }


}
