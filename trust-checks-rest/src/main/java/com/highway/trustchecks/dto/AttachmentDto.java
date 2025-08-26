package com.highway.trustchecks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AttachmentDto(
        @JsonProperty("file_name") String fileName,
        @JsonProperty("file_url") String fileUrl,
        @JsonProperty("file_type") String fileType
) {
}
