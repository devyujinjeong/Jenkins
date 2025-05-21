package com.dbwls.jenkins.controller;

import com.dbwls.jenkins.dto.CalculatorDTO;
import com.dbwls.jenkins.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/health")
    public String healthCheck() {
        return "I'm alive";
    }

    @GetMapping("/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO) {
        log.info("핸들러 실행 여부 및 값 확인 : {}", calculatorDTO);

        System.out.println("과연?! 제대로 됐을끼ㅏ");
        /* Service 계층으로 기능 요청 */
        int result = calculatorService.plusTwoNumbers(calculatorDTO);

        calculatorDTO.setSum(result);

        return ResponseEntity.ok(calculatorDTO);
    }
}
