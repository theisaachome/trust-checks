package com.highway.trustchecks.dto;

import java.util.List;

public record CaseEvidenceDTO(
        List<AttachmentDTO> attachments,
        String link
) {
}
