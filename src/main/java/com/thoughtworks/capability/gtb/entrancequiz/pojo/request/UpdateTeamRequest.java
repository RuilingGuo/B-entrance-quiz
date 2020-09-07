package com.thoughtworks.capability.gtb.entrancequiz.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateTeamRequest {
    private Integer teamId;
    private String teamName;
}
