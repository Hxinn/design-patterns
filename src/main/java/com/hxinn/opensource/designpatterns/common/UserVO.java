package com.hxinn.opensource.designpatterns.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String name;
    private Integer age;
    private Integer sex;
}
