package com.shspring.board.model;

import com.shspring.board.dto.BoardRequestDto;
import com.shspring.board.dto.BoardResponseDto;
import com.shspring.board.entity.Board;
import com.shspring.board.entity.BoardRepository;
import com.shspring.exception.CustomException;
import com.shspring.exception.ErrorCode;
import com.shspring.paging.CommonParams;
import com.shspring.paging.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    // 게시글 저장
    @Transactional
    public Long save(final BoardRequestDto dto) {
        Board entity = boardRepository.save(dto.toEntity());
        return entity.getId();
    }

    //게시글 전체 조회
    public List<BoardResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }


    //게시글 삭제여부 포함한 전체 조회
    public List<BoardResponseDto> findAllByDeleteYn(final char deleteYn){
        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAllByDeleteYn(deleteYn, sort);

        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());

    }

    //게시글 페이징 적용 전체 조회
    public Map<String, Object> findAll(CommonParams params) {

        // 게시글 수 조회
        int count = boardMapper.selcount(params);

        // 등록된 게시글이 없는 경우, 로직 종료
        if (count < 1) {
            return Collections.emptyMap();
        }

        // 페이지네이션 정보 계산
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 게시글 리스트 조회
        List<BoardResponseDto> list = boardMapper.findAll(params);

        // 데이터 반환
        Map<String, Object> response = new HashMap<>();
        response.put("params", params);
        response.put("list", list);
        return response;
    }

    //게시글 수정
    @Transactional
    public Long update(final Long id, final BoardRequestDto dto) {
        Board entity = boardRepository.findById(id).orElseThrow(() ->
                new CustomException(ErrorCode.POSTS_NOT_FOUND));

        System.out.println("dto content = " + dto.getContent());

        entity.update(dto.getTitle(), dto.getContent(), dto.getWriter());
        return id;
    }

    //게시글 상세정보 조회
    @Transactional
    public BoardResponseDto findById(final Long id){
        Board entity = boardRepository.findById(id).orElseThrow(()->
                new CustomException(ErrorCode.POSTS_NOT_FOUND));

        entity.increaseHits();
        return new BoardResponseDto(entity);

    }

    //게시글 삭제
    @Transactional
    public Long delete(final Long id){
        Board entity = boardRepository.findById(id).orElseThrow(()->
                new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.delete();
        return id;
    }





}
