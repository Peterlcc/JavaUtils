package com.peter.bean;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lcc
 * @date 2020/12/3 下午2:10
 * @description ros参数类
 */
@Slf4j
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Param {
    /*operator:0/1 #参数的操作类型，0代表get，1代表set*/
    private int operator;
    /*name:key #参数的key*/
    private String name;
    /*type:[0-4] #参数的值类型，分别为0-int/1-bool/2-uint/3-double/4-string*/
    private int type;
    /*value:val #参数的值*/
    private Object value;

    public Param(OperatorType operatorType,String name,ServiceType serviceType,Object value){
        this(operatorType.ordinal(),name,serviceType.ordinal(),value);
    }
}
