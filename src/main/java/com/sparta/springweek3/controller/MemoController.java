package com.sparta.springweek3.controller;

import com.sparta.springweek3.models.*;
import com.sparta.springweek3.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // Get all memos
    @GetMapping("/api/memos")
    public MemoResponseDto getAllMemos() {
        List<Memo> memos = memoRepository.findAllByOrderByModifiedAtDesc();
        return memoService.getMemos(memos);
    }

    // Password Validation
    @PostMapping("/api/memos/{id}")
    public MemoResponseDto confirmPassword(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        ValidDto validDto = new ValidDto(requestDto);
        MemoResponseDto responseDto = new MemoResponseDto(memoService.confirm(id, validDto));
        responseDto.setSuccess(true);
        return responseDto;
    }

    // Post memo
    @PostMapping("/api/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        MemoResponseDto responseDto = new MemoResponseDto(memoRepository.save(memo));
        responseDto.setSuccess(true);
        return responseDto;
    }

    // Get memo
    @GetMapping("/api/memos/{id}")
    public MemoResponseDto getMemo(@PathVariable Long id) {
        Optional<Memo> memo = memoRepository.findById(id);
        return memoService.getMemos(memo);
    }

    // Update memo
    @PutMapping("/api/memos/{id}")
    public MemoResponseDto updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        MemoResponseDto responseDto = new MemoResponseDto(memoService.update(id, requestDto));
        responseDto.setSuccess(true);
        return responseDto;
    }

    // Delete memo
    @DeleteMapping("/api/memos/{id}")
    public MemoResponseDto deleteMomo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        MemoResponseDto responseDto = new MemoResponseDto(true);
        responseDto.setSuccess(true);
        return responseDto;
    }
}
