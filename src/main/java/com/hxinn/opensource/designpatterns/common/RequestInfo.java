package com.hxinn.opensource.designpatterns.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestInfo {
    private String apiName;
    private Long startTimestamp;
    private Long responseTime;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append('[')
                .append("apiName=")
                .append(apiName)
                .append(",startTimestamp=")
                .append(startTimestamp)
                .append(",responseTime=")
                .append(responseTime)
                .append(']');
        return sb.toString();
    }
}
