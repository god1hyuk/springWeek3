package com.sparta.springweek3.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ValidDto {
    private String password;

    public ValidDto(MemoRequestDto requestDto) {
        this.password = requestDto.getPassword();
    }
}
