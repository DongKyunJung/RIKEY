package com.ssafy.rikey.api.service;

import com.ssafy.rikey.api.request.RidingInfoRequestDto;
import com.ssafy.rikey.api.response.RidingInfoResponseDto;
import com.ssafy.rikey.db.entity.RidingInfo;
import com.ssafy.rikey.db.entity.User;

import java.util.List;

public interface RidingInfoService {

    List<RidingInfoResponseDto> getRidingInfos(User user);
    void createRidingInfo(User user, RidingInfoRequestDto ridingInfoRequestDto);
}
