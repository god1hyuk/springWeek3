package com.sparta.springweek3.service;

import com.sparta.springweek3.models.Memo;
import com.sparta.springweek3.models.MemoRepository;
import com.sparta.springweek3.models.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    // Password Validation
    @Transactional
    public boolean confirm(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );

        String memoPassword = memo.getPassword();
        String dtoPassword = requestDto.getPassword();

        if (memoPassword.equals(dtoPassword)) {
            return true;
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
    }



    // Update
    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        boolean valid = confirm(id, requestDto);

        if (valid) {
            Memo memo = memoRepository.findById(id).orElseThrow(
                    () -> new NullPointerException("아이디가 존재하지 않습니다.")
            );
            memo.update(requestDto);
            return memo.getId();
        } else {
            return 0L;
        }
    }

}
