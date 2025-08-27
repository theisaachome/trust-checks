package com.highway.trustchecks.service;

import com.highway.trustchecks.dto.ProfileDto;
import com.highway.trustchecks.entity.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> findProfileByProfileIdentifier(ProfileDto profileDto);
}
