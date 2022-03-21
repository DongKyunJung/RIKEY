package com.ssafy.rikey.api.controller;

import com.ssafy.rikey.api.request.CreateReviewRequestDto;
import com.ssafy.rikey.api.request.DeleteReviewRequestDto;
import com.ssafy.rikey.api.request.UpdateReviewRequestDto;
import com.ssafy.rikey.api.service.ReviewService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "Review", value = "리뷰 API")
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @ApiOperation(value = "자전거길 리뷰 등록", notes = "특정 자전거 길에 대한 리뷰를 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 400, message = "실패")
    })
    public ResponseEntity<Map<String, Object>> createReview(
            @RequestBody @ApiParam(value = "리뷰 정보") CreateReviewRequestDto reviewInfo) {

        Map<String, Object> result = new HashMap<>();
        HttpStatus httpStatus = null;

        try {
            reviewService.createReview(reviewInfo, reviewInfo.getUserId());
            httpStatus = HttpStatus.CREATED;
            result.put("status", "SUCCESS");
        } catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
            result.put("status", "BAD REQUEST");
        }

        return new ResponseEntity<Map<String, Object>>(result, httpStatus);
    }

    @PutMapping
    @ApiOperation(value = "자전거길 리뷰 수정", notes = "등록된 특정 자전거 길에 대한 리뷰를 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 400, message = "실패"),
    })
    public ResponseEntity<Map<String, Object>> updateReview(
            @RequestBody @ApiParam(value="리뷰 정보") UpdateReviewRequestDto reviewInfo,
            @PathVariable("reviewId") @ApiParam(value="리뷰 ID", required = true) Long reviewId) {

        Map<String, Object> result = new HashMap<>();
        HttpStatus httpStatus = null;

        try {
            // 유저확인 로직 필요
            reviewService.updateReview(reviewInfo, reviewId);
            httpStatus = HttpStatus.OK;
            result.put("status", "SUCCESS");
        } catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
            result.put("status", "BAD REQUEST");
        }

        return new ResponseEntity<Map<String, Object>>(result, httpStatus);
    }

    @DeleteMapping
    @ApiOperation(value = "자전거길 리뷰 삭제", notes = "등록된 특정 자전거 길에 대한 리뷰를 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 400, message = "실패"),
    })
    public ResponseEntity<Map<String, Object>> deleteReview(
            @RequestBody @ApiParam(value="리뷰 정보") DeleteReviewRequestDto reviewInfo,
            @PathVariable("reviewId") @ApiParam(value="리뷰 ID", required = true) Long reviewId) {

        Map<String, Object> result = new HashMap<>();
        HttpStatus httpStatus = null;

        try {
            // 유저확인 로직 필요
            reviewService.deleteReview(reviewId);
            httpStatus = HttpStatus.OK;
            result.put("status", "SUCCESS");
        } catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
            result.put("status", "BAD REQUEST");
        }

        return new ResponseEntity<Map<String, Object>>(result, httpStatus);
    }

}
