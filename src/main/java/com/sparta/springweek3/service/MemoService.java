package com.sparta.springweek3.service;

import com.sparta.springweek3.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService <T> {

    private final MemoRepository memoRepository;

    // Password Validation
    @Transactional
    public boolean confirm(Long id, ValidDto validDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        String memoPassword = memo.getPassword();
        String dtoPassword = validDto.getPassword();
        return memoPassword.equals(dtoPassword) ? true : false;
    }

    // Get
    @Transactional
    public MemoResponseDto getMemos(T memos) {
        MemoResponseDto responseDto = new MemoResponseDto(memos);
        responseDto.setSuccess(true);
        return responseDto;
    }

    // Update
    @Transactional
    public Memo update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo;
    }
}
