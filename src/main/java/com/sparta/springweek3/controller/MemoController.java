package com.sparta.springweek3.controller;

import com.sparta.springweek3.models.Memo;
import com.sparta.springweek3.models.MemoRepository;
import com.sparta.springweek3.models.MemoRequestDto;
import com.sparta.springweek3.models.MemoResponseDto;
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

    // Find all
    @GetMapping("/api/memos")
    public MemoResponseDto getAllMemos() {
        List<Memo> memoList = memoRepository.findAllByOrderByModifiedAtDesc();
        MemoResponseDto responseDto = new MemoResponseDto(memoList);
        return responseDto;
    }

    // Find one
    @GetMapping("/api/memos/{id}")
    public Optional<Memo> getMemo(@PathVariable Long id) {
        return memoRepository.findById(id);
    }

    // Post
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    // Password Validation
    @PostMapping("/api/memos/{id}")
    public boolean confirmPassword(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.confirm(id, requestDto);
    }

    // Update
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    // Delete
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMomo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoRepository.deleteById(id);
        return id;
    }

}
