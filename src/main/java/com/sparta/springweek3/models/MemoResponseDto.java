package com.sparta.springweek3.models;

import lombok.*;

@Setter
@Getter
//@RequiredArgsConstructor
public class MemoResponseDto <T> {

    private boolean success;
    private final T data;
    private String error;

    public MemoResponseDto(T memos) {
        this.data = memos;
    }
}