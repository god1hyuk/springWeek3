package com.sparta.springweek3.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class MemoResponseDto {

    private final Boolean success;
    private final String error;
    private final List<Memo> data;

    public MemoResponseDto(List<Memo> memoList) {
        this.success = false;
        this.error = null;
        this.data = memoList;
    }
}