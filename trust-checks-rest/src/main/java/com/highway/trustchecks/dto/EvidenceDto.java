package com.highway.trustchecks.dto;

import java.util.List;

public record EvidenceDto(
        List<AttachmentDto> attachments,
        String link
) {
}
