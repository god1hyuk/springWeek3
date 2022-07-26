package com.sparta.springweek3.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MemoRequestDto {
    private final String title;
    private final String username;
    private final String password;
    private final String content;
}
