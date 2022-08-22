package com.sparta.matchgi.util.converter;

import com.sparta.matchgi.dto.CreatePostResponseDto;
import com.sparta.matchgi.dto.ReviewListResponseDto;
import com.sparta.matchgi.dto.ParticipationResponseDto;
import com.sparta.matchgi.dto.PostFilterDto;
import com.sparta.matchgi.dto.RequestResponseDto;
import com.sparta.matchgi.model.ImgUrl;
import com.sparta.matchgi.model.Post;
import com.sparta.matchgi.model.Review;
import com.sparta.matchgi.model.ReviewImgUrl;

import java.util.List;
import java.util.stream.Collectors;

public class DtoConverter {

    public static CreatePostResponseDto PostToCreateResponseDto(Post post,int owner) {

        CreatePostResponseDto createPostResponseDto = CreatePostResponseDto.builder()
                .postId(post.getId())
                .address(post.getAddress())
                .content(post.getContent())
                .lat(post.getLat())
                .lng(post.getLng())
                .matchDeadline(post.getMatchDeadline())
                .matchStatus(post.getMatchStatus())
                .subject(post.getSubject())
                .title(post.getTitle())
                .imgpaths(post.getImageList().stream().map(ImgUrl::getImagePathDto).collect(Collectors.toList()))
                .imgurls(post.getImageList().stream().map(ImgUrl::getImageUrlDto).collect(Collectors.toList()))
                .owner(owner)
                .build();

        return createPostResponseDto;
    }


    public static List<ReviewListResponseDto> reviewListToReviewListResponseDto(List<Review> reviewList){
        List<ReviewListResponseDto> reviewListResponseDtoList = reviewList.stream().map(r->
                ReviewListResponseDto.builder()
                        .reviewId(r.getId())
                        .imgUrlList(r.getReviewImageList().stream().map(ReviewImgUrl::getPath).collect(Collectors.toList()))
                        .nickname(r.getUser().getNickname())
                        .star(r.getStar())
                        .title(r.getTitle())
                        .content(r.getContent())
                        .build()
                ).collect(Collectors.toList());

        return reviewListResponseDtoList;
    }

    public static PostFilterDto ofSummary(Post post)
    {
        PostFilterDto postFilterDto = PostFilterDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .subject(post.getSubject())
                .viewCount(post.getViewCount())
                .createdAt(post.getCreatedAt())
                .matchDeadline(post.getMatchDeadline())
                .requestCount(post.getRequestCount())
                .build();

        return postFilterDto;
    }
}
