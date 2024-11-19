package com.ilearn.chk.studentbarcode.controller;

import com.google.zxing.WriterException;
import com.ilearn.chk.studentbarcode.model.Student;
import com.ilearn.chk.studentbarcode.repository.StudentRepository;
import com.ilearn.chk.studentbarcode.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BarcodeService barcodeService;

    @GetMapping("/{id}/barcode")
    public ResponseEntity<byte[]> getStudentBarcode(@PathVariable Long id) throws WriterException, IOException {

        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        String barcodeText = "Name: " + student.getName() + ", Email: " + student.getEmail();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(barcodeService.generateBarcodeImage(barcodeText), "png", baos);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=student-barcode.png");

        return ResponseEntity.ok().headers(headers).body(baos.toByteArray());
    }
}

