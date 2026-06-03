package com.hari.ai_secure_platform.controller;
import com.hari.ai_secure_platform.service.AnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.hari.ai_secure_platform.model.AnalysisResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


@RestController
@RequestMapping("/api")
@Tag(name = "Log Analysis API", description = "API for analyzing logs and detecting sensitive data")
public class AnalysisController {

    private final AnalysisService analyzerService;

    public AnalysisController(AnalysisService analyzerService) {
        this.analyzerService = analyzerService;
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }
    @Operation(
            summary = "Analyze logs",
            description = "Scans input logs and detects sensitive data such as emails, passwords, and API keys."
    )
    @PostMapping("/analyze")
    public AnalysisResponse analyze(@RequestBody Map<String, String> request) {

        String content = request.get("content");

        if (content == null || content.trim().isEmpty()) {
            throw new RuntimeException("Content must not be empty");
        }

        return analyzerService.analyze(content);
    }

    // 🔥 ADD THIS METHOD HERE
    @PostMapping("/analyze/file")
    public AnalysisResponse analyzeFile(@RequestParam("file") MultipartFile file) {

        try {
            String content;
            String filename = file.getOriginalFilename();

            if (filename.endsWith(".txt") || filename.endsWith(".log")) {
                content = new String(file.getBytes());
            }
            else if (filename.endsWith(".pdf")) {
                content = extractTextFromPDF(file);
            }
            else {
                throw new RuntimeException("Unsupported file type");
            }

            return analyzerService.analyze(content);

        } catch (Exception e) {
            throw new RuntimeException("File processing failed: " + e.getMessage());
        }
    }

    // 🔥 ADD THIS METHOD ALSO (STEP 3)
    private String extractTextFromPDF(MultipartFile file) {
        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read PDF");
        }
    }
}
