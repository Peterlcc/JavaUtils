package com.peter.bean;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lcc
 * @date 2020/12/3 下午2:57
 */
@Slf4j
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result {
    private int operator;
    private int code;
    private Object response;
}
