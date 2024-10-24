package com.example.promotionpage.domain.views.api;

import com.example.promotionpage.domain.menu.domain.MenuTitle;
import com.example.promotionpage.domain.project.domain.ArtworkCategory;
import com.example.promotionpage.domain.views.application.ViewsService;
import com.example.promotionpage.domain.views.dao.ViewsSummary;
import com.example.promotionpage.domain.views.domain.Views;
import com.example.promotionpage.domain.views.dto.request.CreateViewsRequestDto;
import com.example.promotionpage.domain.views.dto.request.UpdateViewsRequestDto;
import com.example.promotionpage.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "조회수 API", description = "조회수 등록 / 수정  / 조회")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ViewsController {
    private final ViewsService viewsService;

    @Operation(summary = "조회수 등록 API")
    @PostMapping("/views")
    public ApiResponse<Views> createViews(@Valid @RequestBody CreateViewsRequestDto dto) {
        return viewsService.createViews(dto.toServiceViews());
    }

    @Operation(summary = "조회수 전체 조회 API")
    @GetMapping("/views")
    public ApiResponse<List<Views>> retrieveAllViews(){
        return viewsService.retrieveAllViews();
    }

    @Operation(summary = "id로 조회수 상세 조회 API")
    @GetMapping("/views/id/{viewsId}")
    public ApiResponse<Views> retrieveViewsById(@PathVariable Long viewsId){
        return viewsService.retrieveViewsById(viewsId);
    }

    @Operation(summary = "해당 연도 조회수 전체 조회 API")
    @GetMapping("/views/{year}")
    public ApiResponse<List<Views>> retrieveViewsByYear(@PathVariable Integer year){
        return viewsService.retrieveViewsByYear(year);
    }

    @Operation(summary = "연도, 월로 조회수 상세 조회 API")
    @GetMapping("/views/{year}/{month}")
    public ApiResponse<Views> retrieveViewsByYearMonth(@PathVariable Integer year, @PathVariable Integer month){
        return viewsService.retrieveViewsByYearMonth(year, month);
    }

    @Operation(summary = "기간(시작점(연도,월), 종료점(연도,월))으로 전체 조회수 조회 API")
    @GetMapping("/views/{startYear}/{startMonth}/{endYear}/{endMonth}")
    public ApiResponse<List<ViewsSummary>> retrieveAllViewsByPeriod(@PathVariable Integer startYear, @PathVariable Integer startMonth,
                                                                 @PathVariable Integer endYear, @PathVariable Integer endMonth){
        return viewsService.retrieveAllViewsByPeriod(startYear, startMonth, endYear, endMonth);
    }

    @Operation(summary = "기간(시작점(연도,월), 종료점(연도,월))으로 메뉴별 전체 조회수 조회 API")
    @GetMapping("/views/{startYear}/{startMonth}/{endYear}/{endMonth}/{menu}")
    public ApiResponse<List<ViewsSummary>> retrieveAllMenuViewsByPeriod(@PathVariable Integer startYear, @PathVariable Integer startMonth,
                                                                 @PathVariable Integer endYear, @PathVariable Integer endMonth,
                                                                 @PathVariable MenuTitle menu){
        return viewsService.retrieveAllMenuViewsByPeriod(startYear, startMonth, endYear, endMonth, menu);
    }

    @Operation(summary = "메뉴가 아트워크일 경우, 기간(시작점(연도,월), 종료점(연도,월))으로 카테고리별 전체 조회수 조회 API")
    @GetMapping("/views/{startYear}/{startMonth}/{endYear}/{endMonth}/ARTWORK/{category}")
    public ApiResponse<List<ViewsSummary>> retrieveAllCategoryViewsByPeriod(@PathVariable Integer startYear, @PathVariable Integer startMonth,
                                                                                @PathVariable Integer endYear, @PathVariable Integer endMonth,
                                                                                @PathVariable ArtworkCategory category){
        return viewsService.retrieveAllCategoryViewsByPeriod(startYear, startMonth, endYear, endMonth, category);
    }

    @Operation(summary = "기간(시작점(연도,월), 종료점(연도,월))으로 카테고리별, 메뉴별 전체 조회수 조회 API")
    @GetMapping("/views/{startYear}/{startMonth}/{endYear}/{endMonth}/{menu}/{category}")
    public ApiResponse<List<ViewsSummary>> retrieveAllMenuCategoryViewsByPeriod(@PathVariable Integer startYear, @PathVariable Integer startMonth,
                                                                                @PathVariable Integer endYear, @PathVariable Integer endMonth,
                                                                                @PathVariable MenuTitle menu, @PathVariable ArtworkCategory category){
        return viewsService.retrieveAllMenuCategoryViewsByPeriod(startYear, startMonth, endYear, endMonth, menu, category);
    }

    @Operation(summary = "id로 특정 월 조회수 1 상승 API")
    @PutMapping("/views/increase/{viewsId}")
    public ApiResponse<Views> updateViewsById(@PathVariable Long viewsId){
        return viewsService.updateViewsById(viewsId);
    }

    @Operation(summary = "연도, 월, 메뉴, 카테고리로 특정 월 조회수 1 상승 API")
    @PutMapping("/views/increase/{year}/{month}")
    public ApiResponse<Views> updateViewsByYearMonth(@PathVariable Integer year, @PathVariable Integer month,
                                                     @RequestBody UpdateViewsRequestDto dto){
        return viewsService.updateViewsByYearMonth(year, month, dto.toServiceRequest());
    }

    @Operation(summary = "이번 월 조회수 1 상승 API (해당 월이 존재하지 않을 경우에는 생성)")
    @PutMapping("/views/increase")
    public ApiResponse<Views> updateThisMonthViews(@CookieValue(name = "main_viewed_cookie", required = false) String mainViewedCookie,
                                                   @CookieValue(name = "about_viewed_cookie", required = false) String aboutViewedCookie,
                                                   @CookieValue(name = "faq_viewed_cookie", required = false) String faqViewedCookie,
                                                   @CookieValue(name = "contact_viewed_cookie", required = false) String contactViewedCookie,
                                                   @CookieValue(name = "news_viewed_cookie", required = false) String newsViewedCookie,
                                                   @CookieValue(name = "recruitment_viewed_cookie", required = false) String recruitmentViewedCookie,
                                                   @CookieValue(name = "artwork_entertainment_viewed_cookie", required = false) String artworkEntertainmentViewedCookie,
                                                   @CookieValue(name = "artwork_drama_viewed_cookie", required = false) String artworkDramaViewedCookie,
                                                   @CookieValue(name = "artwork_documentary_viewed_cookie", required = false) String artworkDocumentaryViewedCookie,
                                                   @CookieValue(name = "artwork_channel_operating_viewed_cookie", required = false) String artworkChannelOperatingViewedCookie,
                                                   @CookieValue(name = "artwork_branded_viewed_cookie", required = false) String artworkBrandedViewedCookie,
                                                   @CookieValue(name = "artwork_motion_graphic_viewed_cookie", required = false) String artworkMotionGraphicViewedCookie,
                                                   @CookieValue(name = "artwork_animation_viewed_cookie", required = false) String artworkAnimationViewedCookie,
                                                   @CookieValue(name = "artwork_live_commerce_viewed_cookie", required = false) String artworkLiveCommerceViewedCookie,
                                                   @RequestBody UpdateViewsRequestDto dto) {

        return viewsService.updateThisMonthViews(mainViewedCookie, aboutViewedCookie, faqViewedCookie,
                                                contactViewedCookie, newsViewedCookie, recruitmentViewedCookie,
                                                artworkEntertainmentViewedCookie, artworkDramaViewedCookie,
                                                artworkDocumentaryViewedCookie, artworkChannelOperatingViewedCookie,
                                                artworkBrandedViewedCookie, artworkMotionGraphicViewedCookie,
                                                artworkAnimationViewedCookie, artworkLiveCommerceViewedCookie,
                                                dto.toServiceRequest());
    }
}
