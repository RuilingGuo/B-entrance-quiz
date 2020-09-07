package com.thoughtworks.capability.gtb.entrancequiz.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private Integer id;
    private String name;
}
